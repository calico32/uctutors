import { logger } from '@/providers'
import { TokenInfo } from '@/types/google'
import { webcrypto } from 'crypto'
import { ServerError, Status } from 'nice-grpc'
const DISCOVERY_URL = 'https://accounts.google.com/.well-known/openid-configuration'

export const GoogleOpenIDConfiguration = {
  discoveryDocument: null as any as GoogleOpenIDConfiguration,
  expires: 0,

  async get<K extends keyof GoogleOpenIDConfiguration>(
    key: K
  ): Promise<GoogleOpenIDConfiguration[K]> {
    await GoogleOpenIDConfiguration.refresh()
    return this.discoveryDocument![key]
  },
  async refresh() {
    if (this.expires > Date.now()) return
    const response = await fetch(DISCOVERY_URL)
    this.discoveryDocument = await response.json()
    this.expires =
      Date.now() +
      1000 * +(response.headers.get('cache-control')?.match(/max-age=(\d+)/)?.[1] ?? '3600')
  },
}

export const GoogleJWKs = {
  jwks: null as any as JwksResponse,
  expires: 0,

  async getKeys() {
    await GoogleOpenIDConfiguration.refresh()
    return this.jwks.keys
  },
  async refresh() {
    if (this.expires > Date.now()) return
    const uri = await GoogleOpenIDConfiguration.get('jwks_uri')
    const response = await fetch(uri)
    this.jwks = await response.json()
    this.expires =
      Date.now() +
      1000 * +(response.headers.get('cache-control')?.match(/max-age=(\d+)/)?.[1] ?? '24000')
  },
}
;(async () => {
  await GoogleOpenIDConfiguration.refresh()
  logger.info('Google OpenID Configuration loaded')
  await GoogleJWKs.refresh()
  logger.info('Google JWKs loaded')
})()

export interface GoogleOpenIDConfiguration {
  issuer: string
  authorization_endpoint: string
  device_authorization_endpoint: string
  token_endpoint: string
  userinfo_endpoint: string
  revocation_endpoint: string
  jwks_uri: string
  response_types_supported: string[]
  subject_types_supported: string[]
  id_token_signing_alg_values_supported: string[]
  scopes_supported: string[]
  token_endpoint_auth_methods_supported: string[]
  claims_supported: string[]
  code_challenge_methods_supported: string[]
  grant_types_supported: string[]
}

export interface JwksResponse {
  keys: Key[]
}

export interface Key {
  use: string
  e: string
  kid: string
  alg: string
  n: string
  kty: string
}

export interface JWTHeader {
  alg: string
  kid: string
  typ: 'JWT'
}

export async function importKey(key: Key) {
  const algorithms: Record<
    string,
    | AlgorithmIdentifier
    | RsaHashedImportParams
    | EcKeyImportParams
    | HmacImportParams
    | AesKeyAlgorithm
  > = {
    RS256: {
      name: 'RSASSA-PKCS1-v1_5',
      hash: { name: 'SHA-256' },
    },
  }
  return webcrypto.subtle.importKey('jwk', key, algorithms[key.alg] ?? key.alg, true, ['verify'])
}

export async function validateIdToken(idToken: string): Promise<TokenInfo> {
  const jwks = await GoogleJWKs.getKeys()
  const keys = await Promise.all(jwks.map(importKey))

  const [b64Header, b64Payload, b64Signature] = idToken.split('.')

  const [header, payload] = [b64Header, b64Payload].map((b64) =>
    JSON.parse(Buffer.from(b64, 'base64').toString('utf-8'))
  ) as [JWTHeader, TokenInfo]

  const keyIndex = jwks.findIndex((key) => key.kid === header.kid)
  if (keyIndex === -1) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'cannot find matching key for id token')
  }
  const key = keys[keyIndex]

  const signature = Buffer.from(b64Signature, 'base64')
  const data = Buffer.from(`${b64Header}.${b64Payload}`, 'utf-8')
  const verified = await webcrypto.subtle.verify(key.algorithm, key, signature, data)

  if (!verified) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'invalid signature')
  }

  const expectedIssuer = await GoogleOpenIDConfiguration.get('issuer')
  const expectedAudience = process.env.GOOGLE_CLIENT_ID
  const expectedAuthorizedParty = process.env.APP_CLIENT_ID
  const expectedHostedDomain = 'ucvts.org'

  if (payload.iss !== expectedIssuer) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'invalid issuer')
  }

  if (payload.aud !== expectedAudience) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'invalid audience')
  }

  if (payload.azp !== expectedAuthorizedParty) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'invalid authorized party')
  }

  if (payload.hd !== expectedHostedDomain) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'you must use a UCVTS account to log in.')
  }

  if (!payload.sub) {
    throw new ServerError(Status.INVALID_ARGUMENT, 'invalid id token')
  }

  return payload
}
