// export interface TokenInfo {
//   iss: string
//   azp: string
//   aud: string
//   sub: string
//   hd: string
//   email: string
//   email_verified: string
//   at_hash: string
//   iat: string
//   exp: string
//   alg: string
//   kid: string
//   typ: string
//   nonce?: string
// }

// Generated by https://quicktype.io

export interface TokenInfo {
  iss: string
  azp: string
  aud: string
  sub: string
  hd: string
  email: string
  email_verified: boolean
  nonce?: string
  name: string
  picture: string
  given_name: string
  family_name: string
  locale: string
  iat: number
  exp: number
}
