import env from '@/env'
import { logger, prisma } from '@/providers'
import fs from 'fs'
import https from 'https'

const html = (strings: TemplateStringsArray, ...values: any[]) =>
  String.raw({ raw: strings }, ...values)

const page = (content: string) => {
  return html`
    <html>
      <head>
        <title>UCTutors</title>
        <style>
          body {
            font-family: monospace;
            background-color: #0a0a0c;
            color: #444;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100%;
            margin: 0;
          }
        </style>
      </head>
      <body>
        ${content}
      </body>
    </html>
  `
}

export const contentServer = https.createServer(
  {
    key: fs.readFileSync(env.TLS_KEY_PATH),
    cert: fs.readFileSync(env.TLS_CERT_PATH),
  },
  async (req, res) => {
    const url = new URL(req.url!, `http://${req.headers.host}`)
    const id = url.pathname.slice(1).trim()
    if (url.pathname === '/' || !id) {
      res.statusCode = 400
      res.end(page(html`<p>Nothing to see here.</p>`))

      logger.debug(`🖼️  ${url.pathname} -> 400`)
      return
    }

    const file = await prisma.storage.findUnique({ where: { id } })
    if (!file) {
      res.statusCode = 404
      res.end(page(html`<p>File not found.</p>`))

      logger.debug(`🖼️  ${url.pathname} -> 404`)
      return
    }

    res.setHeader('Content-Type', file.type)
    res.setHeader('Content-Disposition', `inline; filename="${file.name}"`)
    res.setHeader('Last-Modified', file.updated.toUTCString())
    res.setHeader('Cache-Control', 'public, max-age=31536000, immutable')

    logger.debug(`🖼️  ${url.pathname} -> OK (${file.name}, ${file.type})`)

    res.end(file.data)
  }
)
