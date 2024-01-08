import { createEnv } from '@t3-oss/env-core'
import { z } from 'zod'

const env = createEnv({
  server: {
    SERVER_CLIENT_ID: z.string(),
    APP_DEBUG_CLIENT_ID: z.string(),
    APP_RELEASE_CLIENT_ID: z.string(),

    TLS_KEY_PATH: z.string(),
    TLS_CERT_PATH: z.string(),

    SESSION_SECRET: z.string(),

    LOG_LEVEL: z.string().default('debug'),
  },
  runtimeEnv: process.env,
})

export default env
