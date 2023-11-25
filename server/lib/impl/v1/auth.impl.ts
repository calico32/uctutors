import {
  AuthServiceImplementation,
  LoginRequest,
  LoginResponse,
  LoginStatus,
} from '@/generated/api/v1/auth'
import { DeepPartial } from '@/generated/api/v1/status'
import { validateIdToken } from '@/google'
import { logger, prisma } from '@/providers'
import { AuthSession, Session, expires } from '@/session'
import { CallContext, ServerError, Status } from 'nice-grpc'

const imageExtensions: Record<string, string> = {
  'image/jpeg': 'jpg',
  'image/png': 'png',
  'image/gif': 'gif',
  'image/bmp': 'bmp',
  'image/webp': 'webp',
  'image/svg+xml': 'svg',
  'image/tiff': 'tiff',
}

export const AuthService: AuthServiceImplementation = {
  async login(request: LoginRequest, ctx: CallContext): Promise<DeepPartial<LoginResponse>> {
    if (!request.idToken) {
      throw new ServerError(Status.INVALID_ARGUMENT, 'no id token provided')
    }

    let tokenInfo = await validateIdToken(request.idToken)

    logger.$inspect(tokenInfo)

    const userId = tokenInfo.sub

    const session = Session.create(
      {
        userId: userId,
        tokenInfo,
      } satisfies AuthSession,
      [expires(60 * 60 * 24 * 7)]
    )
    const token = await Session.encrypt(session)

    const user = await prisma.user.findUnique({ where: { id: userId } })
    if (!user) {
      logger.debug('new user')
      return {
        status: LoginStatus.LOGIN_STATUS_NEW_USER,
        newUser: {
          userId: userId,
          token,
        },
      }
    }

    logger.debug('existing user')
    return {
      status: LoginStatus.LOGIN_STATUS_EXISTING_USER,
      existingUser: {
        userId: userId,
        token,
      },
    }
  },

  async logout(request, context) {
    return {}
  },

  async register(request, context) {
    return {}
  },
}
