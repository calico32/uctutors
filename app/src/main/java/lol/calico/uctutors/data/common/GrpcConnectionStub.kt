package lol.calico.uctutors.data.common

class GrpcConnectionStub : GrpcConnection {
  override fun authenticate(token: String) {}

  override fun deauthenticate() {}

  override fun close() {}

  override val apiInfo
    get() = error("Cannot access network from preview")

  override val auth
    get() = error("Cannot access network from preview")

  override val status
    get() = error("Cannot access network from preview")

  override val user
    get() = error("Cannot access network from preview")

  override val message
    get() = error("Cannot access network from preview")
}
