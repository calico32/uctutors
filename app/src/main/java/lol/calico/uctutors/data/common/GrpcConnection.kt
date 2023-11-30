package lol.calico.uctutors.data.common

import android.net.Uri
import android.util.Log
import io.grpc.CallCredentials
import io.grpc.CallOptions
import io.grpc.ManagedChannelBuilder
import io.grpc.Metadata
import io.grpc.Status
import io.grpc.kotlin.AbstractCoroutineStub
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asExecutor
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.generated.api.ApiInfoServiceGrpcKt.ApiInfoServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.AuthServiceGrpcKt.AuthServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.StatusServiceGrpcKt.StatusServiceCoroutineStub
import lol.calico.uctutors.generated.api.v1.UserServiceGrpcKt.UserServiceCoroutineStub
import java.io.Closeable
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class GrpcConnection @Inject constructor() : Closeable {
  private val uri = Uri.parse(BuildConfig.SERVER_URL)

  companion object {
    private const val TAG = "GrpcConnection"
  }

  private val channel = let {
    Log.d(TAG, "Connecting to ${uri.host}:${uri.port}")

    val builder =
      ManagedChannelBuilder.forAddress(uri.host, uri.port)
    if (uri.scheme == "https") {
      builder.useTransportSecurity()
    } else {
      builder.usePlaintext()
    }

    val channel = builder.executor(Dispatchers.IO.asExecutor()).build()

    Log.d(TAG, "Connected channel #${channel.hashCode()}")

    channel
  }

  private var sessionToken: String? = null

  fun authenticate(token: String) {
    Log.d(TAG, "Authenticating with token $token")
    sessionToken = token
  }

  fun deauthenticate() {
    Log.d(TAG, "Deauthenticating")
    sessionToken = null
  }

  private val callCredentials = object : CallCredentials() {
    override fun applyRequestMetadata(
      requestInfo: RequestInfo,
      appExecutor: Executor,
      applier: MetadataApplier,
    ) {
      Log.d(TAG, "\uD83E\uDD19 ${requestInfo.methodDescriptor.fullMethodName}")
      if (sessionToken == null) {
        applier.apply(Metadata())
        return
      }
      appExecutor.execute {
        try {
          val headers = Metadata()
          val authKey = Metadata.Key.of("session", Metadata.ASCII_STRING_MARSHALLER)
          headers.put(authKey, sessionToken)
          applier.apply(headers)
        } catch (e: Throwable) {
          applier.fail(Status.UNAUTHENTICATED.withCause(e))
        }
      }
    }
  }

  private fun <T : AbstractCoroutineStub<T>> service(stub: KClass<T>): T {
    return stub.constructors.first().call(channel, CallOptions.DEFAULT)
      .withCallCredentials(callCredentials) as T
  }

  val apiInfo = service(ApiInfoServiceCoroutineStub::class)
  val status = service(StatusServiceCoroutineStub::class)
  val auth = service(AuthServiceCoroutineStub::class)
  val user = service(UserServiceCoroutineStub::class)

  override fun close() {
    channel.shutdownNow()
  }
}