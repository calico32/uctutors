import { ServerCredentials } from '@grpc/grpc-js'
import fs from 'fs'
import { createServer } from 'nice-grpc'
import { ServerReflection, ServerReflectionService } from 'nice-grpc-server-reflection'
import path from 'path'

import { contentServer } from '@/content'
import env from '@/env'
import { ApiInfoServiceDefinition } from '@/generated/api/info'
import { AuthServiceDefinition } from '@/generated/api/v1/auth'
import { MessageServiceDefinition } from '@/generated/api/v1/messages'
import { StatusServiceDefinition } from '@/generated/api/v1/status'
import { UserServiceDefinition } from '@/generated/api/v1/user'
import { ApiInfoService } from '@/impl/info.impl'
import { AuthService } from '@/impl/v1/auth.impl'
import { MessageService } from '@/impl/v1/message.impl'
import { StatusService } from '@/impl/v1/status.impl'
import { UserService } from '@/impl/v1/user.impl'
import { middleware } from '@/middleware'
import { logger, prisma } from '@/providers'

if (import.meta.hot) await import.meta.hot.data.stopping

prisma.$connect()

const server = createServer().use(middleware)

const services = [
  [StatusServiceDefinition, StatusService],
  [ApiInfoServiceDefinition, ApiInfoService],
  [AuthServiceDefinition, AuthService],
  [MessageServiceDefinition, MessageService],
  [UserServiceDefinition, UserService],
] as const

const logo = String.raw`
   __  ______________      __
  / / / / ____/_  __/_  __/ /_____  __________
 / / / / /     / / / / / / __/ __ \/ ___/ ___/
/ /_/ / /___  / / / /_/ / /_/ /_/ / /  (__  )
\____/\____/ /_/  \____/\__/\____/_/  /____/   v1.0.0`

if (import.meta.hot) {
  console.log('\x1b[36m' + logo + '\x1b[0m\n')
} else {
  logger.info(logo + '\n')
}

logger.info('UCTutors server starting...')

logger.info('🚀 Registering gRPC services')

logger.info('')
for (const [def, impl] of services) {
  server.add(def, impl)
  logger.info(`  ${def.fullName}`)
  const methods = Object.entries(def.methods)
  for (const [i, [, methodDef]] of methods.entries()) {
    const char = i === methods.length - 1 ? '└' : '├'
    logger.info(`    ${char}─ ${(methodDef as any).name}`)
  }
  logger.info('')
}

server.add(
  ServerReflectionService,
  ServerReflection(
    fs.readFileSync(path.join('./api/descriptor.bin')),
    services.map(([def]) => def.fullName)
  )
)
logger.info('🚀 Reflection enabled')

const credentials = ServerCredentials.createSsl(null, [
  {
    private_key: fs.readFileSync(env.TLS_KEY_PATH),
    cert_chain: fs.readFileSync(env.TLS_CERT_PATH),
  },
])

const port = await server.listen('0.0.0.0:8000', credentials)

logger.info(`🚀 gRPC started on port ${port}`)

contentServer.listen(8001, () => {
  logger.info(`🚀 Content server started on port ${8001}`)
})

async function stop() {
  await Promise.all([
    new Promise<void>((resolve) => {
      contentServer.close(() => {
        resolve()
      })
      setTimeout(() => {
        resolve()
      }, 500)
    }),
    server.shutdown(),
  ])

  await prisma.$disconnect()
}

if (import.meta.hot) {
  let reload = () => {
    logger.info('Performing an HMR reload...')
    console.log('\x1b[2J')
    return stop()
  }

  import.meta.hot.on('vite:beforeFullReload', () => {
    const stopping = reload()
    reload = () => Promise.resolve()
    if (import.meta.hot) import.meta.hot.data.stopping = stopping
  })
}
