import { logger, prisma } from '@/providers'
import { createServer } from 'nice-grpc'

import { ApiInfoServiceDefinition } from '@/generated/api/info'
import { StatusServiceDefinition } from '@/generated/api/v1/status'
import { ApiInfoService } from '@/impl/info.impl'
import { StatusService } from '@/impl/v1/status.impl'

prisma.$connect()

const server = createServer()

const services = [
  [StatusServiceDefinition, StatusService],
  [ApiInfoServiceDefinition, ApiInfoService],
] as const

logger.info('🚀 Registering gRPC services')
for (const [def, impl] of services) {
  server.add(def, impl)
  for (const [, methodDef] of Object.entries(def.methods)) {
    logger.info(`| ${def.fullName.padEnd(25)} | ${(methodDef as any).name}`)
  }
}

const port = await server.listen('0.0.0.0:8000')

logger.info('🚀 gRPC started on port ' + port)

async function stop() {
  await server.shutdown()
  await prisma.$disconnect()
}

if (import.meta.hot) await import.meta.hot.data.stopping
if (import.meta.hot) {
  let reload = () => (logger.info('Performing an HMR reload...'), stop())
  import.meta.hot.on('vite:beforeFullReload', () => {
    const stopping = reload()
    reload = () => Promise.resolve()
    if (import.meta.hot) import.meta.hot.data.stopping = stopping
  })
}
