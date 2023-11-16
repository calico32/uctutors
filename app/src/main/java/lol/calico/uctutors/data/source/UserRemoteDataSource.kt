package lol.calico.uctutors.data.source

import lol.calico.uctutors.data.common.GrpcConnection
import javax.inject.Inject

class UserRemoteDataSource @Inject constructor(
  private val grpcConnection: GrpcConnection
) {
}