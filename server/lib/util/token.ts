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

export interface DetailedTokenInfo {
  /**
   * The issuer of the token, like `accounts.google.com` or `login.microsoftonline.com`.
   *
   * Original name: `iss`
   */
  issuer: string
  /**
   * The client ID of the authorized party, like `1234567890.apps.googleusercontent.com`.
   *
   * This is the Android client ID for Google Sign-In.
   *
   * Original name: `azp`
   */
  authorizedParty: string
  /**
   * The client ID of the audience, like `1234567890.apps.googleusercontent.com`.
   *
   * This is an alias for `authorizedParty`.
   *
   * Original name: `azp`
   */
  androidClientId: string
  /**
   * The audience of the token, like `1234567890.apps.googleusercontent.com`.
   *
   * This is the web client ID for Google Sign-In.
   *
   * Original name: `aud`
   */
  audience: string
  /**
   * The client ID of the audience, like `1234567890.apps.googleusercontent.com`.
   *
   * This is an alias for `audience`.
   */
  webClientId: string
  /**
   * The subject (user ID) of the user.
   *
   * Original name: `sub`
   */
  subject: string
  /**
   * The userId of the user.
   *
   * This is an alias for `subject`.
   *
   * Original name: `sub`
   */
  userId: string
  /**
   * The hosted G Suite domain of the user, if applicable.
   *
   * Original name: `hd`
   */
  hostedDomain: string
  /**
   * The email address of the user.
   *
   * Original name: `email`
   */
  email: string
  /**
   * Whether the email address of the user has been verified.
   *
   * Original name: `email_verified`
   */
  emailVerified: boolean
  /**
   * The nonce of the token, if applicable. Should match the nonce from the Android client.
   *
   * Original name: `nonce`
   */
  nonce?: string
  /**
   * The full name of the user.
   *
   * Original name: `name`
   */
  name: string
  /**
   * The URL of the user's profile picture.
   *
   * Original name: `picture`
   */
  picture: string
  /**
   * The given name of the user.
   *
   * Original name: `given_name`
   */
  givenName: string
  /**
   * The family name of the user.
   *
   * Original name: `family_name`
   */
  familyName: string
  /**
   * The locale of the user, like `en`.
   *
   * Original name: `locale`
   */
  locale: string
  /**
   * The time at which the token was issued, in seconds since the Unix epoch.
   *
   * Original name: `iat`
   */
  issuedAt: number
  /**
   * The time at which the token expires, in seconds since the Unix epoch.
   *
   * Original name: `exp`
   */
  expiresAt: number
  /**
   * The app variant used to generate the token. Either `debug` or `release`.
   */
  variant: 'debug' | 'release'
}

export function expandTokenInfo(
  tokenInfo: TokenInfo & { variant: 'debug' | 'release' }
): DetailedTokenInfo {
  return {
    issuer: tokenInfo.iss,
    authorizedParty: tokenInfo.azp,
    webClientId: tokenInfo.azp,
    audience: tokenInfo.aud,
    androidClientId: tokenInfo.aud,
    subject: tokenInfo.sub,
    userId: tokenInfo.sub,
    hostedDomain: tokenInfo.hd,
    email: tokenInfo.email,
    emailVerified: tokenInfo.email_verified,
    nonce: tokenInfo.nonce,
    name: tokenInfo.name,
    picture: tokenInfo.picture,
    givenName: tokenInfo.given_name,
    familyName: tokenInfo.family_name,
    locale: tokenInfo.locale,
    issuedAt: tokenInfo.iat,
    expiresAt: tokenInfo.exp,
    variant: tokenInfo.variant,
  }
}
