import { BUILD_TIME, COMMIT_HASH } from '@/buildinfo'
import { ApiInfoServiceImplementation, DeepPartial, GetApiInfoResponse } from '@/generated/api/info'

export const ApiInfoService: ApiInfoServiceImplementation = {
  async getApiInfo(): Promise<DeepPartial<GetApiInfoResponse>> {
    return {
      apiInfo: {
        version: 1,
        commit: COMMIT_HASH,
        buildTime: BUILD_TIME,
      },
    }
  },
}
