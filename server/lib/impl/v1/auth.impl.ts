import { AuthServiceImplementation, LoginRequest, LoginResponse } from '@/generated/api/v1/auth'
import { DeepPartial } from '@/generated/api/v1/status'
import google from '@googleapis/oauth2'
import { CallContext } from 'nice-grpc'
export const AuthService: AuthServiceImplementation = {
  async login(request: LoginRequest, ctx: CallContext): Promise<DeepPartial<LoginResponse>> {
    const tokeninfo = google.oauth2('v2').tokeninfo({ id_token: request.idToken })

    console.log(tokeninfo)

    return {}
  },
}
