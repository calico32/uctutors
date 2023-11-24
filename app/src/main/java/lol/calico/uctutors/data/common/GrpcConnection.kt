package lol.calico.uctutors.data.common

import android.net.Uri
import android.util.Log
import io.grpc.Context
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.generated.api.ApiInfoServiceGrpcKt
import lol.calico.uctutors.generated.api.v1.AuthServiceGrpcKt
import lol.calico.uctutors.generated.api.v1.StatusServiceGrpcKt
import lol.calico.uctutors.generated.api.v1.UserServiceGrpcKt
import java.io.Closeable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GrpcConnection @Inject constructor() : Closeable {
  private val uri = Uri.parse(BuildConfig.SERVER_URL)

  companion object {
    private const val TAG = "GrpcConnection"
    val sessionHeader: Metadata.Key<String> =
      Metadata.Key.of("session", Metadata.ASCII_STRING_MARSHALLER)
    val sessionKey: Context.Key<String> = Context.key("session")
  }

  val sessionHeader = Companion.sessionHeader
  val sessionKey = Companion.sessionKey

  private val channel = let {
    Log.d(TAG, "Connecting to ${uri.host}:${uri.port}")

    val builder =
      ManagedChannelBuilder.forAddress(uri.host, uri.port).intercept(HeaderInterceptor())
    if (uri.scheme == "https") {
      builder.useTransportSecurity()
    } else {
      builder.usePlaintext()
    }

    val channel = builder.executor(Dispatchers.IO.asExecutor()).build()

    Log.d(TAG, "Connected channel #${channel.hashCode()}")

    channel
  }

  val apiInfo = ApiInfoServiceGrpcKt.ApiInfoServiceCoroutineStub(channel)
  val status = StatusServiceGrpcKt.StatusServiceCoroutineStub(channel)
  val auth = AuthServiceGrpcKt.AuthServiceCoroutineStub(channel)
  val user = UserServiceGrpcKt.UserServiceCoroutineStub(channel)

  override fun close() {
    channel.shutdownNow()
  }
}