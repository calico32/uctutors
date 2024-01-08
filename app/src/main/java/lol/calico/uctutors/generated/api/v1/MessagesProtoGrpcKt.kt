package lol.calico.uctutors.generated.api.v1

import com.google.protobuf.Empty
import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls.serverStreamingRpc
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls.serverStreamingServerMethodDefinition
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import kotlinx.coroutines.flow.Flow
import lol.calico.uctutors.generated.api.v1.MessageServiceGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for api.v1.MessageService.
 */
public object MessageServiceGrpcKt {
  public const val SERVICE_NAME: String = MessageServiceGrpc.SERVICE_NAME

  @JvmStatic
  public val serviceDescriptor: ServiceDescriptor
    get() = getServiceDescriptor()

  public val getChannelsMethod: MethodDescriptor<Empty, GetChannelsResponse>
    @JvmStatic
    get() = MessageServiceGrpc.getGetChannelsMethod()

  public val openChannelMethod: MethodDescriptor<OpenChannelRequest, OpenChannelResponse>
    @JvmStatic
    get() = MessageServiceGrpc.getOpenChannelMethod()

  public val closeChannelMethod: MethodDescriptor<CloseChannelRequest, Empty>
    @JvmStatic
    get() = MessageServiceGrpc.getCloseChannelMethod()

  public val sendMessageMethod: MethodDescriptor<SendMessageRequest, SendMessageResponse>
    @JvmStatic
    get() = MessageServiceGrpc.getSendMessageMethod()

  public val joinChannelMethod: MethodDescriptor<JoinChannelRequest, Empty>
    @JvmStatic
    get() = MessageServiceGrpc.getJoinChannelMethod()

  public val leaveChannelMethod: MethodDescriptor<LeaveChannelRequest, Empty>
    @JvmStatic
    get() = MessageServiceGrpc.getLeaveChannelMethod()

  public val getMessagesMethod: MethodDescriptor<GetMessagesRequest, GetMessagesResponse>
    @JvmStatic
    get() = MessageServiceGrpc.getGetMessagesMethod()

  public val addChannelMemberMethod: MethodDescriptor<AddChannelMemberRequest, Empty>
    @JvmStatic
    get() = MessageServiceGrpc.getAddChannelMemberMethod()

  /**
   * A stub for issuing RPCs to a(n) api.v1.MessageService service as suspending coroutines.
   */
  @StubFor(MessageServiceGrpc::class)
  public class MessageServiceCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT,
  ) : AbstractCoroutineStub<MessageServiceCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): MessageServiceCoroutineStub =
        MessageServiceCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getChannels(request: Empty, headers: Metadata = Metadata()):
        GetChannelsResponse = unaryRpc(
      channel,
      MessageServiceGrpc.getGetChannelsMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Returns a [Flow] that, when collected, executes this RPC and emits responses from the
     * server as they arrive.  That flow finishes normally if the server closes its response with
     * [`Status.OK`][io.grpc.Status], and fails by throwing a [StatusException] otherwise.  If
     * collecting the flow downstream fails exceptionally (including via cancellation), the RPC
     * is cancelled with that exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return A flow that, when collected, emits the responses from the server.
     */
    public fun openChannel(request: OpenChannelRequest, headers: Metadata = Metadata()):
        Flow<OpenChannelResponse> = serverStreamingRpc(
      channel,
      MessageServiceGrpc.getOpenChannelMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun closeChannel(request: CloseChannelRequest, headers: Metadata = Metadata()):
        Empty = unaryRpc(
      channel,
      MessageServiceGrpc.getCloseChannelMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun sendMessage(request: SendMessageRequest, headers: Metadata = Metadata()):
        SendMessageResponse = unaryRpc(
      channel,
      MessageServiceGrpc.getSendMessageMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun joinChannel(request: JoinChannelRequest, headers: Metadata = Metadata()):
        Empty = unaryRpc(
      channel,
      MessageServiceGrpc.getJoinChannelMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun leaveChannel(request: LeaveChannelRequest, headers: Metadata = Metadata()):
        Empty = unaryRpc(
      channel,
      MessageServiceGrpc.getLeaveChannelMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun getMessages(request: GetMessagesRequest, headers: Metadata = Metadata()):
        GetMessagesResponse = unaryRpc(
      channel,
      MessageServiceGrpc.getGetMessagesMethod(),
      request,
      callOptions,
      headers
    )

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][io.grpc.Status].  If the RPC completes with another status, a
     * corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    public suspend fun addChannelMember(request: AddChannelMemberRequest, headers: Metadata =
        Metadata()): Empty = unaryRpc(
      channel,
      MessageServiceGrpc.getAddChannelMemberMethod(),
      request,
      callOptions,
      headers
    )
  }

  /**
   * Skeletal implementation of the api.v1.MessageService service based on Kotlin coroutines.
   */
  public abstract class MessageServiceCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for api.v1.MessageService.GetChannels.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getChannels(request: Empty): GetChannelsResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.GetChannels is unimplemented"))

    /**
     * Returns a [Flow] of responses to an RPC for api.v1.MessageService.OpenChannel.
     *
     * If creating or collecting the returned flow fails with a [StatusException], the RPC
     * will fail with the corresponding [io.grpc.Status].  If it fails with a
     * [java.util.concurrent.CancellationException], the RPC will fail with status
     * `Status.CANCELLED`.  If creating
     * or collecting the returned flow fails for any other reason, the RPC will fail with
     * `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open fun openChannel(request: OpenChannelRequest): Flow<OpenChannelResponse> = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.OpenChannel is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.CloseChannel.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun closeChannel(request: CloseChannelRequest): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.CloseChannel is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.SendMessage.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun sendMessage(request: SendMessageRequest): SendMessageResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.SendMessage is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.JoinChannel.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun joinChannel(request: JoinChannelRequest): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.JoinChannel is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.LeaveChannel.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun leaveChannel(request: LeaveChannelRequest): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.LeaveChannel is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.GetMessages.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun getMessages(request: GetMessagesRequest): GetMessagesResponse = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.GetMessages is unimplemented"))

    /**
     * Returns the response to an RPC for api.v1.MessageService.AddChannelMember.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [io.grpc.Status].  If this method fails with a [java.util.concurrent.CancellationException],
     * the RPC will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    public open suspend fun addChannelMember(request: AddChannelMemberRequest): Empty = throw
        StatusException(UNIMPLEMENTED.withDescription("Method api.v1.MessageService.AddChannelMember is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getGetChannelsMethod(),
      implementation = ::getChannels
    ))
      .addMethod(serverStreamingServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getOpenChannelMethod(),
      implementation = ::openChannel
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getCloseChannelMethod(),
      implementation = ::closeChannel
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getSendMessageMethod(),
      implementation = ::sendMessage
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getJoinChannelMethod(),
      implementation = ::joinChannel
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getLeaveChannelMethod(),
      implementation = ::leaveChannel
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getGetMessagesMethod(),
      implementation = ::getMessages
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = MessageServiceGrpc.getAddChannelMemberMethod(),
      implementation = ::addChannelMember
    )).build()
  }
}
