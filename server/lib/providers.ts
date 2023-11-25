import { PrismaClient } from '@prisma/client'
import { withAccelerate } from '@prisma/extension-accelerate'
import pino from 'pino'
import { inspect } from 'util'

export const prisma = new PrismaClient().$extends(withAccelerate())

export const logger: Logger = pino({
  level: process.env.LOG_LEVEL || 'debug',
  transport: {
    target: 'pino-pretty',
    options: {
      ignore: 'hostname,pid',
    },
  },
}) as any

logger.$inspect = (loc: any, obj?: any) => {
  if (obj) {
    logger.debug('%s: %s', loc, inspect(obj, false, 10, true))
  } else {
    logger.debug('%s', inspect(obj, false, 10, true))
  }
}

export type Logger = pino.Logger & {
  $inspect(loc: any, obj: any): void
  $inspect(obj: any): void
}
