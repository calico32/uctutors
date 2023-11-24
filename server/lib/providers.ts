import { PrismaClient } from '@prisma/client'
import { withAccelerate } from '@prisma/extension-accelerate'
import pino from 'pino'

export const prisma = new PrismaClient().$extends(withAccelerate())

export const logger = pino({
  level: process.env.LOG_LEVEL || 'debug',
})
