// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/user.proto

// Protobuf Java Version: 3.25.0
package lol.calico.uctutors.generated.api.v1;

public final class UserProto {
  private UserProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_User_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_User_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_CampusAvailability_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_CampusAvailability_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_VirtualAvailability_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_VirtualAvailability_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_Experience_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_Experience_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021api/v1/user.proto\022\006api.v1\032\037google/prot" +
      "obuf/timestamp.proto\032\033google/type/dayofw" +
      "eek.proto\032\032google/type/interval.proto\"\216\005" +
      "\n\004User\022\016\n\002id\030\001 \001(\tR\002id\0222\n\006joined\030\002 \001(\0132\032" +
      ".google.protobuf.TimestampR\006joined\0224\n\007up" +
      "dated\030\003 \001(\0132\032.google.protobuf.TimestampR" +
      "\007updated\022\024\n\005email\030\004 \001(\tR\005email\022\035\n\nfirst_" +
      "name\030\005 \001(\tR\tfirstName\022\033\n\tlast_name\030\006 \001(\t" +
      "R\010lastName\022&\n\006school\030\007 \001(\0162\016.api.v1.Scho" +
      "olR\006school\022\031\n\010class_of\030\010 \001(\rR\007classOf\022\020\n" +
      "\003bio\030\t \001(\tR\003bio\022\033\n\tavatar_id\030\n \001(\tR\010avat" +
      "arId\022\033\n\tbanner_id\030\013 \001(\tR\010bannerId\022K\n\023cam" +
      "pus_availability\030\014 \003(\0132\032.api.v1.CampusAv" +
      "ailabilityR\022campusAvailability\022N\n\024virtua" +
      "l_availability\030\r \003(\0132\033.api.v1.VirtualAva" +
      "ilabilityR\023virtualAvailability\022\026\n\006topics" +
      "\030\016 \003(\tR\006topics\022\037\n\013tutor_score\030\017 \001(\rR\ntut" +
      "orScore\022\037\n\013tutee_score\030\020 \001(\rR\ntuteeScore" +
      "\0224\n\013experiences\030\021 \003(\0132\022.api.v1.Experienc" +
      "eR\013experiences\"4\n\022CampusAvailability\022\016\n\002" +
      "p5\030\001 \001(\010R\002p5\022\016\n\002p6\030\002 \001(\010R\002p6\"r\n\023VirtualA" +
      "vailability\022(\n\003day\030\001 \001(\0162\026.google.type.D" +
      "ayOfWeekR\003day\0221\n\010interval\030\002 \001(\0132\025.google" +
      ".type.IntervalR\010interval\"\363\001\n\nExperience\022" +
      "\016\n\002id\030\001 \001(\tR\002id\0224\n\007created\030\002 \001(\0132\032.googl" +
      "e.protobuf.TimestampR\007created\0224\n\007updated" +
      "\030\003 \001(\0132\032.google.protobuf.TimestampR\007upda" +
      "ted\022\024\n\005title\030\004 \001(\tR\005title\022 \n\013description" +
      "\030\005 \001(\tR\013description\022\026\n\006skills\030\006 \003(\tR\006ski" +
      "lls\022\031\n\010image_id\030\007 \001(\tR\007imageId*t\n\006School" +
      "\022\026\n\022SCHOOL_UNSPECIFIED\020\000\022\016\n\nSCHOOL_MHS\020\001" +
      "\022\017\n\013SCHOOL_AAHS\020\002\022\016\n\nSCHOOL_AIT\020\003\022\016\n\nSCH" +
      "OOL_APA\020\004\022\021\n\rSCHOOL_UCTECH\020\0052\r\n\013UserServ" +
      "iceBj\n$lol.calico.uctutors.generated.api" +
      ".v1B\tUserProtoP\001\242\002\003AXX\252\002\006Api.V1\312\002\006Api\\V1" +
      "\342\002\022Api\\V1\\GPBMetadata\352\002\007Api::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
          lol.calico.uctutors.generated.google.type.DayofweekProto.getDescriptor(),
          lol.calico.uctutors.generated.google.type.IntervalProto.getDescriptor(),
        });
    internal_static_api_v1_User_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_api_v1_User_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_User_descriptor,
        new java.lang.String[] { "Id", "Joined", "Updated", "Email", "FirstName", "LastName", "School", "ClassOf", "Bio", "AvatarId", "BannerId", "CampusAvailability", "VirtualAvailability", "Topics", "TutorScore", "TuteeScore", "Experiences", });
    internal_static_api_v1_CampusAvailability_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_api_v1_CampusAvailability_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_CampusAvailability_descriptor,
        new java.lang.String[] { "P5", "P6", });
    internal_static_api_v1_VirtualAvailability_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_api_v1_VirtualAvailability_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_VirtualAvailability_descriptor,
        new java.lang.String[] { "Day", "Interval", });
    internal_static_api_v1_Experience_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_api_v1_Experience_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_Experience_descriptor,
        new java.lang.String[] { "Id", "Created", "Updated", "Title", "Description", "Skills", "ImageId", });
    com.google.protobuf.TimestampProto.getDescriptor();
    lol.calico.uctutors.generated.google.type.DayofweekProto.getDescriptor();
    lol.calico.uctutors.generated.google.type.IntervalProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
