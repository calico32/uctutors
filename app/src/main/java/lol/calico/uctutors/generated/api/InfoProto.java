// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/info.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api;

public final class InfoProto {
  private InfoProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_GetApiInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_GetApiInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_GetApiInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_GetApiInfoResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_ApiInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_ApiInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016api/info.proto\022\003api\032\033google/protobuf/e" +
      "mpty.proto\032\037google/protobuf/timestamp.pr" +
      "oto\"\023\n\021GetApiInfoRequest\"=\n\022GetApiInfoRe" +
      "sponse\022\'\n\010api_info\030\001 \001(\0132\014.api.ApiInfoR\007" +
      "apiInfo\"\265\001\n\007ApiInfo\022\030\n\007version\030\001 \001(\rR\007ve" +
      "rsion\022\026\n\006commit\030\002 \001(\tR\006commit\0229\n\nbuild_t" +
      "ime\030\003 \001(\0132\032.google.protobuf.TimestampR\tb" +
      "uildTime\022=\n\014current_time\030\004 \001(\0132\032.google." +
      "protobuf.TimestampR\013currentTime2Q\n\016ApiIn" +
      "foService\022?\n\nGetApiInfo\022\026.google.protobu" +
      "f.Empty\032\027.api.GetApiInfoResponse\"\000BZ\n!lo" +
      "l.calico.uctutors.generated.apiB\tInfoPro" +
      "toP\001\242\002\003AXX\252\002\003Api\312\002\003Api\342\002\017Api\\GPBMetadata" +
      "\352\002\003Apib\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_api_GetApiInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_api_GetApiInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_GetApiInfoRequest_descriptor,
        new java.lang.String[] { });
    internal_static_api_GetApiInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_api_GetApiInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_GetApiInfoResponse_descriptor,
        new java.lang.String[] { "ApiInfo", });
    internal_static_api_ApiInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_api_ApiInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_ApiInfo_descriptor,
        new java.lang.String[] { "Version", "Commit", "BuildTime", "CurrentTime", });
    com.google.protobuf.EmptyProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
