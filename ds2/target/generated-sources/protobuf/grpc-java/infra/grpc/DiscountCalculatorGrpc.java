package infra.grpc;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: discount.proto")
public final class DiscountCalculatorGrpc {

  private DiscountCalculatorGrpc() {}

  public static final String SERVICE_NAME = "DiscountCalculator";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<infra.grpc.Param,
      infra.grpc.Discount> METHOD_GET_DISCOUNT =
      io.grpc.MethodDescriptor.<infra.grpc.Param, infra.grpc.Discount>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "DiscountCalculator", "GetDiscount"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              infra.grpc.Param.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              infra.grpc.Discount.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiscountCalculatorStub newStub(io.grpc.Channel channel) {
    return new DiscountCalculatorStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiscountCalculatorBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DiscountCalculatorBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DiscountCalculatorFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DiscountCalculatorFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class DiscountCalculatorImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDiscount(infra.grpc.Param request,
        io.grpc.stub.StreamObserver<infra.grpc.Discount> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DISCOUNT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DISCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                infra.grpc.Param,
                infra.grpc.Discount>(
                  this, METHODID_GET_DISCOUNT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class DiscountCalculatorStub extends io.grpc.stub.AbstractStub<DiscountCalculatorStub> {
    private DiscountCalculatorStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountCalculatorStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountCalculatorStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountCalculatorStub(channel, callOptions);
    }

    /**
     */
    public void getDiscount(infra.grpc.Param request,
        io.grpc.stub.StreamObserver<infra.grpc.Discount> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DISCOUNT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class DiscountCalculatorBlockingStub extends io.grpc.stub.AbstractStub<DiscountCalculatorBlockingStub> {
    private DiscountCalculatorBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountCalculatorBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountCalculatorBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountCalculatorBlockingStub(channel, callOptions);
    }

    /**
     */
    public infra.grpc.Discount getDiscount(infra.grpc.Param request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DISCOUNT, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class DiscountCalculatorFutureStub extends io.grpc.stub.AbstractStub<DiscountCalculatorFutureStub> {
    private DiscountCalculatorFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountCalculatorFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountCalculatorFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountCalculatorFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<infra.grpc.Discount> getDiscount(
        infra.grpc.Param request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DISCOUNT, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DISCOUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DiscountCalculatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DiscountCalculatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DISCOUNT:
          serviceImpl.getDiscount((infra.grpc.Param) request,
              (io.grpc.stub.StreamObserver<infra.grpc.Discount>) responseObserver);
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

  private static final class DiscountCalculatorDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return infra.grpc.DiscountOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DiscountCalculatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiscountCalculatorDescriptorSupplier())
              .addMethod(METHOD_GET_DISCOUNT)
              .build();
        }
      }
    }
    return result;
  }
}
