import {
  AuthServiceImplementation,
  GetNonceResponse,
  LoginResponse,
  LoginStatus,
} from '@/generated/api/v1/auth'
import { validateIdToken } from '@/google'
import { logger, prisma } from '@/providers'
import { AuthSession, Session, expires } from '@/session'
import { protoSchoolToPrismaSchool } from '@/util/school'
import { webcrypto } from 'crypto'
import { ServerError, Status } from 'nice-grpc'

const imageExtensions: Record<string, string> = {
  'image/jpeg': 'jpg',
  'image/png': 'png',
  'image/gif': 'gif',
  'image/bmp': 'bmp',
  'image/webp': 'webp',
  'image/svg+xml': 'svg',
  'image/tiff': 'tiff',
}

async function generateNonce() {
  const array = new Uint8Array(32)
  webcrypto.getRandomValues(array)
  return Buffer.from(array).toString('base64')
}

export const AuthService: AuthServiceImplementation = {
  async getNonce(request): Promise<GetNonceResponse> {
    const nonce = await prisma.nonce.create({
      data: {
        created: new Date(),
        expires: new Date(Date.now() + 1000 * 60 * 5),
        nonce: await generateNonce(),
      },
    })
    return {
      nonce: nonce.nonce,
    }
  },
  async login(request, ctx): Promise<LoginResponse> {
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
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.data?.school) {
      throw new ServerError(Status.INVALID_ARGUMENT, 'no school provided')
    }

    if (!request.data?.classOf) {
      throw new ServerError(Status.INVALID_ARGUMENT, 'no class year provided')
    }

    const tokenInfo = session.value.tokenInfo

    const user = await prisma.user.findUnique({ where: { id: tokenInfo.sub } })

    if (user) {
      throw new ServerError(Status.ALREADY_EXISTS, 'user already exists')
    }

    const photoData = await fetch(tokenInfo.picture)
    const photoBuffer = Buffer.from(await photoData.arrayBuffer())
    const photoType = photoData.headers.get('content-type')
    if (!photoType) {
      throw new ServerError(Status.INTERNAL, 'no photo content type')
    }
    const photoExtension = imageExtensions[photoType]
    if (!photoExtension) {
      throw new ServerError(Status.INTERNAL, 'invalid photo content type')
    }

    const newUser = await prisma.user.create({
      data: {
        id: tokenInfo.sub,
        email: tokenInfo.email,
        firstName: tokenInfo.given_name,
        lastName: tokenInfo.family_name,
        school: protoSchoolToPrismaSchool(request.data.school),
        classOf: request.data.classOf,
        campusAvailability: request.data.campusAvailability,
        virtualAvailability: request.data.virtualAvailability,
        avatar: {
          create: {
            name: 'avatar.' + photoExtension,
            type: photoType,
            data: photoBuffer,
          },
        },
      },
    })
  },
}
