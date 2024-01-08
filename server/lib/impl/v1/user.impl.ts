import { UserServiceImplementation } from '@/generated/api/v1/user'
import { prisma } from '@/providers'
import { AuthSession, Session } from '@/session'
import Translator from '@/util/translator'
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
      user: Translator.prismaToProto.user(user),
    }
  },
}
