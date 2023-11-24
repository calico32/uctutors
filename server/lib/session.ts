import { AuthSessionError } from '@/generated/api/v1/auth_session'
import { Result } from '@/result'
import { webcrypto } from 'crypto'
import * as Iron from 'iron-webcrypto'
import { nanoid } from 'nanoid'

const sessionName = 'session'

let sessionSecret = process.env.SESSION_SECRET

/**
 * Sets the session secret.
 */
export function setSessionSecret(pw: string): void {
  sessionSecret = pw
}

type Intersect<U> = (U extends any ? (k: U) => void : never) extends (k: infer I) => void
  ? I
  : never

/**
 * Any valid session data.
 */
export type SessionData = { [key: string]: any }

export type AuthSession = {
  userId: string
}

/**
 * A session. The `id` property is always present, and is a unique identifier
 * for the session.
 */
export type Session<T extends SessionData> = T & {
  id: string
}

export type GetMetadataStore = {
  get(key: typeof sessionName): string | undefined
}

export type SetMetadataStore = {
  set(key: typeof sessionName, value: string): void
  delete(key: typeof sessionName): void
}

/**
 * A session plugin. Plugins can be used to add additional data to a session, or
 * to add validation logic.
 */
export type SessionPlugin<T extends SessionData = SessionData> = {
  create?(session: Session<T>): Session<T>
  validate?(session: Session<T>): boolean
  touch?(session: Session<T>): Session<T>
}

/**
 * The session module. Contains functions for creating, validating, and
 * manipulating sessions.
 */
export const Session = {
  _validators: new Map<string, (session: Session<any>) => boolean>(),
  _touchListeners: new Map<string, (session: Session<any>) => Session<any>>(),
  crypto: webcrypto,

  /**
   * Generates a new session id.
   */
  id() {
    return nanoid()
  },

  /**
   * Get a session from a cookie store. Returns an error if the cookie is
   * missing, invalid, or fails validation.
   *
   * `$SESSION_SECRET` must be set, or `setSessionSecret` must be called
   * before calling this function.
   */
  async get<T extends SessionData>(
    metadata: GetMetadataStore
  ): Result.Async<Session<T>, AuthSessionError> {
    if (!sessionSecret) throw new Error('Session: session secret is not set')

    const cookie = metadata.get(sessionName)
    if (!cookie) return Result.error(AuthSessionError.AUTH_SESSION_ERROR_NO_SESSION)

    try {
      const session = await this.decrypt<T>(cookie)
      if (!Session.validate(session)) {
        return Result.error(AuthSessionError.AUTH_SESSION_ERROR_VALIDATION_FAILED)
      }
      return Result.ok(session)
    } catch {
      return Result.error(AuthSessionError.AUTH_SESSION_ERROR_INVALID)
    }
  },

  /**
   * Saves a session to a metadata store.
   *
   * `$SESSION_SECRET` must be set, or `setSessionSecret` must be called
   * before calling this function.
   */
  async save<T extends SessionData>(session: Session<T>, cookieStore: SetMetadataStore) {
    if (!sessionSecret) throw new Error('Session: session secret is not set')

    const sealed = await this.encrypt(session)
    cookieStore.set(sessionName, sealed)
  },

  /**
   * Encrypts a session into a string.
   *
   * `$SESSION_SECRET` must be set, or `setSessionSecret` must be called
   * before calling this function.
   */
  async encrypt<T extends SessionData>(session: Session<T>): Promise<string> {
    if (!sessionSecret) throw new Error('Session: session secret is not set')

    return await Iron.seal(this.crypto, session, sessionSecret, Iron.defaults)
  },

  /**
   * Decrypts a session from a string.
   *
   * `$SESSION_SECRET` must be set, or `setSessionSecret` must be called
   * before calling this function.
   */
  async decrypt<T extends SessionData>(sealed: string): Promise<Session<T>> {
    if (!sessionSecret) throw new Error('Session: session secret is not set')

    return (await Iron.unseal(this.crypto, sealed, sessionSecret, Iron.defaults)) as Session<T>
  },

  /**
   * Destroys a session by deleting its cookie.
   */
  destroy(cookieStore: SetMetadataStore) {
    cookieStore.delete(sessionName)
  },

  /**
   * Creates a new session from the given data and plugins.
   */
  create<
    T extends SessionData,
    E extends SessionPlugin = never,
    C = T & Intersect<E extends SessionPlugin<infer U> ? U : never>
  >(sessionData: T, extensions: E[] = []): Session<{ [K in keyof C]: C[K] }> {
    let session: Session<any> = {
      id: Session.id(),
      ...sessionData,
    }

    for (const extension of extensions) {
      if (extension.create) session = extension.create(session)
    }

    return session
  },

  /**
   * Validates a session by running it through all registered validators.
   */
  validate<T extends SessionData>(session: Session<T>): boolean {
    for (const validator of Session._validators.values()) {
      if (!validator(session)) return false
    }
    return true
  },

  /**
   * Touches a session by running it through all registered updaters.
   */
  touch<T extends SessionData>(session: Session<T>): Session<T> {
    for (const toucher of Session._touchListeners.values()) {
      toucher(session)
    }
    return session
  },

  /**
   * Registers a validator function. Validator functions are run when a session
   * is validated.
   *
   * @returns A unique ID for the validator, which can be used to remove it
   * later.
   */
  onValidate<T extends SessionData>(fn: (session: Session<T>) => boolean): string {
    const id = nanoid()
    Session._validators.set(id, fn)
    return 'v,' + id
  },

  /**
   * Registers a touch listener function. Touch listeners are run when
   * `Session.touch` is called.
   *
   * @returns A unique ID for the touch listener, which can be used to remove it
   * later.
   */
  onTouch<T extends SessionData>(fn: (session: Session<T>) => Session<T>): string {
    const id = nanoid()
    Session._touchListeners.set(id, fn)
    return 't,' + id
  },

  /**
   * Removes a validator or touch listener.
   */
  removeListener(id: string) {
    if (id.startsWith('v,')) {
      Session._validators.delete(id.slice(2))
    } else if (id.startsWith('t,')) {
      Session._touchListeners.delete(id.slice(2))
    }
  },

  /**
   * Sets the crypto implementation used for encryption.
   *
   * @param crypto A webcrypto compatible implementation.
   */
  setCrypto(crypto: webcrypto.Crypto) {
    this.crypto = crypto
  },
}

export function expires(seconds: number): SessionPlugin<{ expires: number }> {
  return {
    create(session) {
      session.expires = Date.now() + seconds * 1000
      return session
    },
    validate(session) {
      return session.expires > Date.now()
    },
  }
}

export function idle(seconds: number): SessionPlugin<{ lastActive: number }> {
  return {
    create(session) {
      session.lastActive = Date.now()
      return session
    },
    validate(session) {
      return session.lastActive + seconds * 1000 > Date.now()
    },
    touch(session) {
      session.lastActive = Date.now()
      return session
    },
  }
}
