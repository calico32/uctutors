import { UserServiceImplementation, schoolFromJSON } from '@/generated/api/v1/user'
import { prisma } from '@/providers'
import { AuthSession, Session } from '@/session'
import { ServerError, Status } from 'nice-grpc'

export const UserService: UserServiceImplementation = {
  async getUser(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    const tokenInfo = session.value.tokenInfo
    const user = await prisma.user.findUnique({ where: { id: tokenInfo.userId } })

    if (!user) {
      throw new ServerError(Status.NOT_FOUND, 'user not found')
    }

    return {
      user: {
        id: user.id,
        firstName: user.firstName ?? '',
        lastName: user.lastName ?? '',
        email: user.email ?? '',
        school: schoolFromJSON(user.school),
        classOf: user.classOf,
        avatarId: user.avatarId ?? '',
        bannerId: user.bannerId ?? '',
        joined: user.created,
        updated: user.updated,
        bio: user.bio ?? '',
        pictureUrl: tokenInfo.picture,
      },
    }
  },
}
