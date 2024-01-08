package lol.calico.uctutors.generated.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: api/v1/messages.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessageServiceGrpc {

  private MessageServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "api.v1.MessageService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.v1.GetChannelsResponse> getGetChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannels",
      requestType = com.google.protobuf.Empty.class,
      responseType = lol.calico.uctutors.generated.api.v1.GetChannelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.v1.GetChannelsResponse> getGetChannelsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.v1.GetChannelsResponse> getGetChannelsMethod;
    if ((getGetChannelsMethod = MessageServiceGrpc.getGetChannelsMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getGetChannelsMethod = MessageServiceGrpc.getGetChannelsMethod) == null) {
          MessageServiceGrpc.getGetChannelsMethod = getGetChannelsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.v1.GetChannelsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.GetChannelsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("GetChannels"))
              .build();
        }
      }
    }
    return getGetChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.OpenChannelRequest,
      lol.calico.uctutors.generated.api.v1.OpenChannelResponse> getOpenChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "OpenChannel",
      requestType = lol.calico.uctutors.generated.api.v1.OpenChannelRequest.class,
      responseType = lol.calico.uctutors.generated.api.v1.OpenChannelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.OpenChannelRequest,
      lol.calico.uctutors.generated.api.v1.OpenChannelResponse> getOpenChannelMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.OpenChannelRequest, lol.calico.uctutors.generated.api.v1.OpenChannelResponse> getOpenChannelMethod;
    if ((getOpenChannelMethod = MessageServiceGrpc.getOpenChannelMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getOpenChannelMethod = MessageServiceGrpc.getOpenChannelMethod) == null) {
          MessageServiceGrpc.getOpenChannelMethod = getOpenChannelMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.OpenChannelRequest, lol.calico.uctutors.generated.api.v1.OpenChannelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "OpenChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.OpenChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.OpenChannelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("OpenChannel"))
              .build();
        }
      }
    }
    return getOpenChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.CloseChannelRequest,
      com.google.protobuf.Empty> getCloseChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CloseChannel",
      requestType = lol.calico.uctutors.generated.api.v1.CloseChannelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.CloseChannelRequest,
      com.google.protobuf.Empty> getCloseChannelMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.CloseChannelRequest, com.google.protobuf.Empty> getCloseChannelMethod;
    if ((getCloseChannelMethod = MessageServiceGrpc.getCloseChannelMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getCloseChannelMethod = MessageServiceGrpc.getCloseChannelMethod) == null) {
          MessageServiceGrpc.getCloseChannelMethod = getCloseChannelMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.CloseChannelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CloseChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.CloseChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("CloseChannel"))
              .build();
        }
      }
    }
    return getCloseChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.SendMessageRequest,
      lol.calico.uctutors.generated.api.v1.SendMessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = lol.calico.uctutors.generated.api.v1.SendMessageRequest.class,
      responseType = lol.calico.uctutors.generated.api.v1.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.SendMessageRequest,
      lol.calico.uctutors.generated.api.v1.SendMessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.SendMessageRequest, lol.calico.uctutors.generated.api.v1.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = MessageServiceGrpc.getSendMessageMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getSendMessageMethod = MessageServiceGrpc.getSendMessageMethod) == null) {
          MessageServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.SendMessageRequest, lol.calico.uctutors.generated.api.v1.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.SendMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.JoinChannelRequest,
      com.google.protobuf.Empty> getJoinChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinChannel",
      requestType = lol.calico.uctutors.generated.api.v1.JoinChannelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.JoinChannelRequest,
      com.google.protobuf.Empty> getJoinChannelMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.JoinChannelRequest, com.google.protobuf.Empty> getJoinChannelMethod;
    if ((getJoinChannelMethod = MessageServiceGrpc.getJoinChannelMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getJoinChannelMethod = MessageServiceGrpc.getJoinChannelMethod) == null) {
          MessageServiceGrpc.getJoinChannelMethod = getJoinChannelMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.JoinChannelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.JoinChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("JoinChannel"))
              .build();
        }
      }
    }
    return getJoinChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.LeaveChannelRequest,
      com.google.protobuf.Empty> getLeaveChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveChannel",
      requestType = lol.calico.uctutors.generated.api.v1.LeaveChannelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.LeaveChannelRequest,
      com.google.protobuf.Empty> getLeaveChannelMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.LeaveChannelRequest, com.google.protobuf.Empty> getLeaveChannelMethod;
    if ((getLeaveChannelMethod = MessageServiceGrpc.getLeaveChannelMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getLeaveChannelMethod = MessageServiceGrpc.getLeaveChannelMethod) == null) {
          MessageServiceGrpc.getLeaveChannelMethod = getLeaveChannelMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.LeaveChannelRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LeaveChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.LeaveChannelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("LeaveChannel"))
              .build();
        }
      }
    }
    return getLeaveChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.GetMessagesRequest,
      lol.calico.uctutors.generated.api.v1.GetMessagesResponse> getGetMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessages",
      requestType = lol.calico.uctutors.generated.api.v1.GetMessagesRequest.class,
      responseType = lol.calico.uctutors.generated.api.v1.GetMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.GetMessagesRequest,
      lol.calico.uctutors.generated.api.v1.GetMessagesResponse> getGetMessagesMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.GetMessagesRequest, lol.calico.uctutors.generated.api.v1.GetMessagesResponse> getGetMessagesMethod;
    if ((getGetMessagesMethod = MessageServiceGrpc.getGetMessagesMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getGetMessagesMethod = MessageServiceGrpc.getGetMessagesMethod) == null) {
          MessageServiceGrpc.getGetMessagesMethod = getGetMessagesMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.GetMessagesRequest, lol.calico.uctutors.generated.api.v1.GetMessagesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.GetMessagesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.GetMessagesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("GetMessages"))
              .build();
        }
      }
    }
    return getGetMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest,
      com.google.protobuf.Empty> getAddChannelMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddChannelMember",
      requestType = lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest,
      com.google.protobuf.Empty> getAddChannelMemberMethod() {
    io.grpc.MethodDescriptor<lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest, com.google.protobuf.Empty> getAddChannelMemberMethod;
    if ((getAddChannelMemberMethod = MessageServiceGrpc.getAddChannelMemberMethod) == null) {
      synchronized (MessageServiceGrpc.class) {
        if ((getAddChannelMemberMethod = MessageServiceGrpc.getAddChannelMemberMethod) == null) {
          MessageServiceGrpc.getAddChannelMemberMethod = getAddChannelMemberMethod =
              io.grpc.MethodDescriptor.<lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddChannelMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new MessageServiceMethodDescriptorSupplier("AddChannelMember"))
              .build();
        }
      }
    }
    return getAddChannelMemberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceStub>() {
        @java.lang.Override
        public MessageServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceStub(channel, callOptions);
        }
      };
    return MessageServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceBlockingStub>() {
        @java.lang.Override
        public MessageServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceBlockingStub(channel, callOptions);
        }
      };
    return MessageServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageServiceFutureStub>() {
        @java.lang.Override
        public MessageServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageServiceFutureStub(channel, callOptions);
        }
      };
    return MessageServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getChannels(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetChannelsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetChannelsMethod(), responseObserver);
    }

    /**
     */
    default void openChannel(lol.calico.uctutors.generated.api.v1.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.OpenChannelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getOpenChannelMethod(), responseObserver);
    }

    /**
     */
    default void closeChannel(lol.calico.uctutors.generated.api.v1.CloseChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCloseChannelMethod(), responseObserver);
    }

    /**
     */
    default void sendMessage(lol.calico.uctutors.generated.api.v1.SendMessageRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.SendMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     */
    default void joinChannel(lol.calico.uctutors.generated.api.v1.JoinChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinChannelMethod(), responseObserver);
    }

    /**
     */
    default void leaveChannel(lol.calico.uctutors.generated.api.v1.LeaveChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLeaveChannelMethod(), responseObserver);
    }

    /**
     */
    default void getMessages(lol.calico.uctutors.generated.api.v1.GetMessagesRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetMessagesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessagesMethod(), responseObserver);
    }

    /**
     */
    default void addChannelMember(lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddChannelMemberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MessageService.
   */
  public static abstract class MessageServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MessageServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MessageService.
   */
  public static final class MessageServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MessageServiceStub> {
    private MessageServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceStub(channel, callOptions);
    }

    /**
     */
    public void getChannels(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetChannelsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void openChannel(lol.calico.uctutors.generated.api.v1.OpenChannelRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.OpenChannelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getOpenChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void closeChannel(lol.calico.uctutors.generated.api.v1.CloseChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCloseChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMessage(lol.calico.uctutors.generated.api.v1.SendMessageRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.SendMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void joinChannel(lol.calico.uctutors.generated.api.v1.JoinChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void leaveChannel(lol.calico.uctutors.generated.api.v1.LeaveChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaveChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getMessages(lol.calico.uctutors.generated.api.v1.GetMessagesRequest request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetMessagesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addChannelMember(lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddChannelMemberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MessageService.
   */
  public static final class MessageServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessageServiceBlockingStub> {
    private MessageServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public lol.calico.uctutors.generated.api.v1.GetChannelsResponse getChannels(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChannelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<lol.calico.uctutors.generated.api.v1.OpenChannelResponse> openChannel(
        lol.calico.uctutors.generated.api.v1.OpenChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getOpenChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty closeChannel(lol.calico.uctutors.generated.api.v1.CloseChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCloseChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public lol.calico.uctutors.generated.api.v1.SendMessageResponse sendMessage(lol.calico.uctutors.generated.api.v1.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty joinChannel(lol.calico.uctutors.generated.api.v1.JoinChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty leaveChannel(lol.calico.uctutors.generated.api.v1.LeaveChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaveChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public lol.calico.uctutors.generated.api.v1.GetMessagesResponse getMessages(lol.calico.uctutors.generated.api.v1.GetMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.google.protobuf.Empty addChannelMember(lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddChannelMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MessageService.
   */
  public static final class MessageServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MessageServiceFutureStub> {
    private MessageServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lol.calico.uctutors.generated.api.v1.GetChannelsResponse> getChannels(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChannelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> closeChannel(
        lol.calico.uctutors.generated.api.v1.CloseChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCloseChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lol.calico.uctutors.generated.api.v1.SendMessageResponse> sendMessage(
        lol.calico.uctutors.generated.api.v1.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> joinChannel(
        lol.calico.uctutors.generated.api.v1.JoinChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> leaveChannel(
        lol.calico.uctutors.generated.api.v1.LeaveChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaveChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lol.calico.uctutors.generated.api.v1.GetMessagesResponse> getMessages(
        lol.calico.uctutors.generated.api.v1.GetMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> addChannelMember(
        lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddChannelMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CHANNELS = 0;
  private static final int METHODID_OPEN_CHANNEL = 1;
  private static final int METHODID_CLOSE_CHANNEL = 2;
  private static final int METHODID_SEND_MESSAGE = 3;
  private static final int METHODID_JOIN_CHANNEL = 4;
  private static final int METHODID_LEAVE_CHANNEL = 5;
  private static final int METHODID_GET_MESSAGES = 6;
  private static final int METHODID_ADD_CHANNEL_MEMBER = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CHANNELS:
          serviceImpl.getChannels((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetChannelsResponse>) responseObserver);
          break;
        case METHODID_OPEN_CHANNEL:
          serviceImpl.openChannel((lol.calico.uctutors.generated.api.v1.OpenChannelRequest) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.OpenChannelResponse>) responseObserver);
          break;
        case METHODID_CLOSE_CHANNEL:
          serviceImpl.closeChannel((lol.calico.uctutors.generated.api.v1.CloseChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((lol.calico.uctutors.generated.api.v1.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.SendMessageResponse>) responseObserver);
          break;
        case METHODID_JOIN_CHANNEL:
          serviceImpl.joinChannel((lol.calico.uctutors.generated.api.v1.JoinChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LEAVE_CHANNEL:
          serviceImpl.leaveChannel((lol.calico.uctutors.generated.api.v1.LeaveChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_MESSAGES:
          serviceImpl.getMessages((lol.calico.uctutors.generated.api.v1.GetMessagesRequest) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetMessagesResponse>) responseObserver);
          break;
        case METHODID_ADD_CHANNEL_MEMBER:
          serviceImpl.addChannelMember((lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetChannelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              lol.calico.uctutors.generated.api.v1.GetChannelsResponse>(
                service, METHODID_GET_CHANNELS)))
        .addMethod(
          getOpenChannelMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.OpenChannelRequest,
              lol.calico.uctutors.generated.api.v1.OpenChannelResponse>(
                service, METHODID_OPEN_CHANNEL)))
        .addMethod(
          getCloseChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.CloseChannelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_CLOSE_CHANNEL)))
        .addMethod(
          getSendMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.SendMessageRequest,
              lol.calico.uctutors.generated.api.v1.SendMessageResponse>(
                service, METHODID_SEND_MESSAGE)))
        .addMethod(
          getJoinChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.JoinChannelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_JOIN_CHANNEL)))
        .addMethod(
          getLeaveChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.LeaveChannelRequest,
              com.google.protobuf.Empty>(
                service, METHODID_LEAVE_CHANNEL)))
        .addMethod(
          getGetMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.GetMessagesRequest,
              lol.calico.uctutors.generated.api.v1.GetMessagesResponse>(
                service, METHODID_GET_MESSAGES)))
        .addMethod(
          getAddChannelMemberMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              lol.calico.uctutors.generated.api.v1.AddChannelMemberRequest,
              com.google.protobuf.Empty>(
                service, METHODID_ADD_CHANNEL_MEMBER)))
        .build();
  }

  private static abstract class MessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessageService");
    }
  }

  private static final class MessageServiceFileDescriptorSupplier
      extends MessageServiceBaseDescriptorSupplier {
    MessageServiceFileDescriptorSupplier() {}
  }

  private static final class MessageServiceMethodDescriptorSupplier
      extends MessageServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MessageServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessageServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageServiceFileDescriptorSupplier())
              .addMethod(getGetChannelsMethod())
              .addMethod(getOpenChannelMethod())
              .addMethod(getCloseChannelMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getJoinChannelMethod())
              .addMethod(getLeaveChannelMethod())
              .addMethod(getGetMessagesMethod())
              .addMethod(getAddChannelMemberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
