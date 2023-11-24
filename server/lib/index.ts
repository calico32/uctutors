import fs from 'fs'
import { createServer } from 'nice-grpc'
import { ServerReflection, ServerReflectionService } from 'nice-grpc-server-reflection'
import path from 'path'

import { ApiInfoServiceDefinition } from '@/generated/api/info'
import { AuthServiceDefinition } from '@/generated/api/v1/auth'
import { StatusServiceDefinition } from '@/generated/api/v1/status'
import { ApiInfoService } from '@/impl/info.impl'
import { AuthService } from '@/impl/v1/auth.impl'
import { StatusService } from '@/impl/v1/status.impl'
import { middleware } from '@/middleware'
import { logger, prisma } from '@/providers'

prisma.$connect()

const server = createServer().use(middleware)

const services = [
  [StatusServiceDefinition, StatusService],
  [ApiInfoServiceDefinition, ApiInfoService],
  [AuthServiceDefinition, AuthService],
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

const port = await server.listen('0.0.0.0:8000')

logger.info('🚀 gRPC started on port ' + port)

async function stop() {
  await server.shutdown()
  await prisma.$disconnect()
}

if (import.meta.hot) await import.meta.hot.data.stopping
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
