import env from '@/env'
import { PrismaClient } from '@prisma/client'
import { withAccelerate } from '@prisma/extension-accelerate'
import pino from 'pino'
import { inspect } from 'util'

export const prisma = new PrismaClient().$extends(withAccelerate()) as unknown as PrismaClient

export const logger: Logger = pino({
  level: env.LOG_LEVEL || 'debug',
  transport: {
    target: 'pino-pretty',
    options: {
      ignore: 'hostname,pid',
    },
  },
}) as any // we're adding the $inspect method below

logger.$inspect = (loc: any, obj?: any) => {
  if (obj) {
    logger.debug('%s: %s', loc, inspect(obj, false, 10, true))
  } else {
    logger.debug('%s', inspect(obj, false, 10, true))
  }
}

export type Logger = pino.Logger & {
  /**
   * Log an object with a source location. The location is usually automatically
   * inserted by a build plugin; you won't need to pass the location yourself.
   * Call this function with a single argument instead.
   */
  $inspect(loc: string, obj: any): void
  /**
   * Log an object with a source location. The source location is automatically
   * inserted by a build plugin.
   */
  $inspect(obj: any): void
}
