import { parse } from '@typescript-eslint/typescript-estree'
import { exec as _exec } from 'child_process'
import type ESTree from 'estree'
import { walk } from 'estree-walker'
import MagicString from 'magic-string'
import path from 'path'
import { fileURLToPath } from 'url'
import { promisify } from 'util'
import { defineConfig } from 'vite'

const exec = promisify(_exec)

const __filename = fileURLToPath(new URL(import.meta.url))
const __dirname = path.dirname(__filename)
function relativePath(path: string) {
  return path.replace(__dirname, '.')
}

export default defineConfig({
  // map @/* to ./lib/*
  resolve: {
    alias: {
      '@': '/lib',
    },
  },
  plugins: [
    {
      name: 'generate',
      enforce: 'pre',
      async buildStart() {
        await exec('bun ./scripts/generate.ts')
      },
    },
    {
      name: 'logger-inspect-source-location',
      enforce: 'pre',
      transform(code, id) {
        if (!id.startsWith(__dirname)) return

        const ast = parse(code, {
          loc: true,
          range: true,
        })
        const magicString = new MagicString(code)

        walk(ast as ESTree.Program, {
          enter(node) {
            if (node.type === 'CallExpression') {
              if (node.callee.type === 'MemberExpression') {
                if (
                  node.callee.object.type === 'Identifier' &&
                  node.callee.object.name === 'logger' &&
                  node.callee.property.type === 'Identifier' &&
                  node.callee.property.name === '$inspect'
                ) {
                  if (node.arguments.length === 1) {
                    const { line, column } = node.loc!.start
                    const debugString = `'${relativePath(id)}:${line}:${column + 1}'`
                    const insertLocation = node.arguments[0].range![0]

                    magicString.prependLeft(insertLocation, debugString + ', ')
                  }
                }
              }
            }
          },
        })

        return {
          code: magicString.toString(),
          map: magicString.generateMap(),
        }
      },
    },
  ],
})
