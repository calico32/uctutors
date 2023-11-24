package lol.calico.uctutors.data.common

import android.annotation.SuppressLint
import io.grpc.CallOptions
import io.grpc.Channel
import io.grpc.ClientCall
import io.grpc.ClientInterceptor
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener
import io.grpc.Metadata
import io.grpc.MethodDescriptor

class HeaderInterceptor : ClientInterceptor {
  companion object {
    const val TAG = "UCTutors/HeaderInterceptor"

  }

  override fun <ReqT, RespT> interceptCall(
    method: MethodDescriptor<ReqT, RespT>?,
    callOptions: CallOptions?, next: Channel
  ): ClientCall<ReqT, RespT> {
    return object : SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
      override fun start(responseListener: Listener<RespT>?, headers: Metadata) {
        super.start(
          object : SimpleForwardingClientCallListener<RespT>(responseListener) {
            @SuppressLint("CheckResult")
            override fun onHeaders(headers: Metadata) {
//              Log.d(TAG, "header received from server:$headers")
              super.onHeaders(headers)
//              val sessionToken = headers.get(GrpcConnection.sessionHeader)
//              if (sessionToken != null) {
//                Log.d(TAG, "session token received from server:$sessionToken")
//                Context.current().withValue(GrpcConnection.sessionKey, sessionToken).attach()
//              }
            }
          }, headers
        )

      }
    }
  }
}

