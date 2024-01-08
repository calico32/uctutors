package lol.calico.uctutors.generated.api;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.1)",
    comments = "Source: api/info.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiInfoServiceGrpc {

  private ApiInfoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "api.ApiInfoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.GetApiInfoResponse> getGetApiInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiInfo",
      requestType = com.google.protobuf.Empty.class,
      responseType = lol.calico.uctutors.generated.api.GetApiInfoResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      lol.calico.uctutors.generated.api.GetApiInfoResponse> getGetApiInfoMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.GetApiInfoResponse> getGetApiInfoMethod;
    if ((getGetApiInfoMethod = ApiInfoServiceGrpc.getGetApiInfoMethod) == null) {
      synchronized (ApiInfoServiceGrpc.class) {
        if ((getGetApiInfoMethod = ApiInfoServiceGrpc.getGetApiInfoMethod) == null) {
          ApiInfoServiceGrpc.getGetApiInfoMethod = getGetApiInfoMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, lol.calico.uctutors.generated.api.GetApiInfoResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiInfo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  lol.calico.uctutors.generated.api.GetApiInfoResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiInfoServiceMethodDescriptorSupplier("GetApiInfo"))
              .build();
        }
      }
    }
    return getGetApiInfoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ApiInfoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceStub>() {
        @java.lang.Override
        public ApiInfoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiInfoServiceStub(channel, callOptions);
        }
      };
    return ApiInfoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiInfoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceBlockingStub>() {
        @java.lang.Override
        public ApiInfoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiInfoServiceBlockingStub(channel, callOptions);
        }
      };
    return ApiInfoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ApiInfoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiInfoServiceFutureStub>() {
        @java.lang.Override
        public ApiInfoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiInfoServiceFutureStub(channel, callOptions);
        }
      };
    return ApiInfoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getApiInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.GetApiInfoResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiInfoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ApiInfoService.
   */
  public static abstract class ApiInfoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ApiInfoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ApiInfoService.
   */
  public static final class ApiInfoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ApiInfoServiceStub> {
    private ApiInfoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiInfoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiInfoServiceStub(channel, callOptions);
    }

    /**
     */
    public void getApiInfo(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.GetApiInfoResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiInfoMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ApiInfoService.
   */
  public static final class ApiInfoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ApiInfoServiceBlockingStub> {
    private ApiInfoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiInfoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiInfoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public lol.calico.uctutors.generated.api.GetApiInfoResponse getApiInfo(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiInfoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ApiInfoService.
   */
  public static final class ApiInfoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ApiInfoServiceFutureStub> {
    private ApiInfoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiInfoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiInfoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<lol.calico.uctutors.generated.api.GetApiInfoResponse> getApiInfo(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiInfoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_API_INFO = 0;

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
        case METHODID_GET_API_INFO:
          serviceImpl.getApiInfo((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<lol.calico.uctutors.generated.api.GetApiInfoResponse>) responseObserver);
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
          getGetApiInfoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              lol.calico.uctutors.generated.api.GetApiInfoResponse>(
                service, METHODID_GET_API_INFO)))
        .build();
  }

  private static abstract class ApiInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiInfoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return lol.calico.uctutors.generated.api.InfoProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiInfoService");
    }
  }

  private static final class ApiInfoServiceFileDescriptorSupplier
      extends ApiInfoServiceBaseDescriptorSupplier {
    ApiInfoServiceFileDescriptorSupplier() {}
  }

  private static final class ApiInfoServiceMethodDescriptorSupplier
      extends ApiInfoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ApiInfoServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ApiInfoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ApiInfoServiceFileDescriptorSupplier())
              .addMethod(getGetApiInfoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
