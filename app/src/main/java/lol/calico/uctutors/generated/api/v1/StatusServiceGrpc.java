package lol.calico.uctutors.generated.api.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: api/v1/status.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StatusServiceGrpc {

  private StatusServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "api.v1.StatusService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.v1.GetStatusResponse> getGetStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStatus",
      requestType = com.google.protobuf.Empty.class,
      responseType = lol.calico.uctutors.generated.api.v1.GetStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.v1.GetStatusResponse> getGetStatusMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.v1.GetStatusResponse> getGetStatusMethod;
    if ((getGetStatusMethod = StatusServiceGrpc.getGetStatusMethod) == null) {
      synchronized (StatusServiceGrpc.class) {
        if ((getGetStatusMethod = StatusServiceGrpc.getGetStatusMethod) == null) {
          StatusServiceGrpc.getGetStatusMethod = getGetStatusMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.v1.GetStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.v1.GetStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new StatusServiceMethodDescriptorSupplier("GetStatus"))
              .build();
        }
      }
    }
    return getGetStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StatusServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StatusServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StatusServiceStub>() {
        @java.lang.Override
        public StatusServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StatusServiceStub(channel, callOptions);
        }
      };
    return StatusServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StatusServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StatusServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StatusServiceBlockingStub>() {
        @java.lang.Override
        public StatusServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StatusServiceBlockingStub(channel, callOptions);
        }
      };
    return StatusServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StatusServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StatusServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StatusServiceFutureStub>() {
        @java.lang.Override
        public StatusServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StatusServiceFutureStub(channel, callOptions);
        }
      };
    return StatusServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StatusService.
   */
  public static abstract class StatusServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return StatusServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StatusService.
   */
  public static final class StatusServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StatusServiceStub> {
    private StatusServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatusServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StatusServiceStub(channel, callOptions);
    }

    /**
     */
    public void getStatus(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StatusService.
   */
  public static final class StatusServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StatusServiceBlockingStub> {
    private StatusServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatusServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StatusServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public lol.calico.uctutors.generated.api.v1.GetStatusResponse getStatus(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StatusService.
   */
  public static final class StatusServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StatusServiceFutureStub> {
    private StatusServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StatusServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StatusServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lol.calico.uctutors.generated.api.v1.GetStatusResponse> getStatus(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_STATUS = 0;

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
        case METHODID_GET_STATUS:
          serviceImpl.getStatus((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.v1.GetStatusResponse>) responseObserver);
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
          getGetStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              lol.calico.uctutors.generated.api.v1.GetStatusResponse>(
                service, METHODID_GET_STATUS)))
        .build();
  }

  private static abstract class StatusServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StatusServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lol.calico.uctutors.generated.api.v1.StatusProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StatusService");
    }
  }

  private static final class StatusServiceFileDescriptorSupplier
      extends StatusServiceBaseDescriptorSupplier {
    StatusServiceFileDescriptorSupplier() {}
  }

  private static final class StatusServiceMethodDescriptorSupplier
      extends StatusServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StatusServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StatusServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StatusServiceFileDescriptorSupplier())
              .addMethod(getGetStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
