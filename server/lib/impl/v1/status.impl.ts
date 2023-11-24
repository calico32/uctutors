import {
  DeepPartial,
  GetStatusResponse,
  StatusServiceImplementation,
} from '@/generated/api/v1/status'
import { Session } from '@/session'
import { CallContext } from 'nice-grpc'

export const StatusService: StatusServiceImplementation = {
  async getStatus(request: never, ctx: CallContext): Promise<DeepPartial<GetStatusResponse>> {
    const session = await Session.get(ctx.metadata)

    return {
      status: 'ok',
      authInfo: {
        authenticated: session.ok,
      },
    }
  },
}
