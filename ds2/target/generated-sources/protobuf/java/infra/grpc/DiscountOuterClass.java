// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: discount.proto

package infra.grpc;

public final class DiscountOuterClass {
  private DiscountOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Param_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Param_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Discount_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Discount_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016discount.proto\"*\n\005Param\022\016\n\006idUser\030\001 \001(" +
      "\t\022\021\n\tidProduct\030\002 \001(\t\"4\n\010Discount\022\022\n\nperc" +
      "entage\030\001 \001(\002\022\024\n\014valueInCents\030\002 \001(\00528\n\022Di" +
      "scountCalculator\022\"\n\013GetDiscount\022\006.Param\032" +
      "\t.Discount\"\000B/\n\ninfra.grpcP\001Z\037alexandrel" +
      "iberato.dev/descontosb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_Param_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Param_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Param_descriptor,
        new java.lang.String[] { "IdUser", "IdProduct", });
    internal_static_Discount_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_Discount_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Discount_descriptor,
        new java.lang.String[] { "Percentage", "ValueInCents", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}