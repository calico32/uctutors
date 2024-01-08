package lol.calico.uctutors.data.source

import javax.inject.Inject
import lol.calico.uctutors.data.common.GrpcNetworkConnection

class UserRemoteDataSource @Inject constructor(private val grpcConnection: GrpcNetworkConnection) {}
