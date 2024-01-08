package lol.calico.uctutors.data.common

import java.io.Closeable
import lol.calico.uctutors.generated.api.ApiInfoServiceGrpcKt.ApiInfoServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.AuthServiceGrpcKt.AuthServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.MessageServiceGrpcKt.MessageServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.StatusServiceGrpcKt.StatusServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.UserServiceGrpcKt.UserServiceCoroutineStub

interface GrpcConnection : Closeable {
  fun authenticate(token: String)

  fun deauthenticate()

  val apiInfo: ApiInfoServiceCoroutineStub
  val auth: AuthServiceCoroutineStub
  val status: StatusServiceCoroutineStub
  val user: UserServiceCoroutineStub
  val message: MessageServiceCoroutineStub
}
