// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/messages.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

public final class MessagesProto {
  private MessagesProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_GetChannelsResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_GetChannelsResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_MessageChannelStub_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_MessageChannelStub_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_MessageList_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_MessageList_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_ChannelMemberUpdate_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_ChannelMemberUpdate_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_OpenChannelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_OpenChannelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_CloseChannelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_CloseChannelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_OpenChannelResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_OpenChannelResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_SendMessageRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_SendMessageRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_SendMessageResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_SendMessageResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_JoinChannelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_JoinChannelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_LeaveChannelRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_LeaveChannelRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_GetMessagesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_GetMessagesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_GetMessagesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_GetMessagesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_AddChannelMemberRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_AddChannelMemberRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_GetChannelInfoRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_GetChannelInfoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_api_v1_GetChannelInfoResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_api_v1_GetChannelInfoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\025api/v1/messages.proto\022\006api.v1\032\033google/" +
      "protobuf/empty.proto\032\021api/v1/user.proto\"" +
      "M\n\023GetChannelsResponse\0226\n\010channels\030\001 \003(\013" +
      "2\032.api.v1.MessageChannelStubR\010channels\"\310" +
      "\001\n\022MessageChannelStub\022\016\n\002id\030\001 \001(\tR\002id\022\022\n" +
      "\004name\030\002 \001(\tR\004name\022 \n\013description\030\003 \001(\tR\013" +
      "description\022\031\n\010user_ids\030\004 \003(\tR\007userIds\022%" +
      "\n\016latest_message\030\005 \001(\tR\rlatestMessage\022*\n" +
      "\021pinned_message_id\030\006 \001(\tR\017pinnedMessageI" +
      "d\"\251\001\n\007Message\022\016\n\002id\030\001 \001(\tR\002id\022\035\n\nchannel" +
      "_id\030\002 \001(\tR\tchannelId\022\027\n\007user_id\030\003 \001(\tR\006u" +
      "serId\022\022\n\004text\030\004 \001(\tR\004text\022\034\n\ttimestamp\030\005" +
      " \001(\004R\ttimestamp\022$\n\004user\030\006 \001(\0132\020.api.v1.U" +
      "serStubR\004user\"m\n\013MessageList\022\024\n\005count\030\001 " +
      "\001(\rR\005count\022\033\n\tnext_page\030\002 \001(\004R\010nextPage\022" +
      "+\n\010messages\030\003 \003(\0132\017.api.v1.MessageR\010mess" +
      "ages\"`\n\023ChannelMemberUpdate\022\035\n\nchannel_i" +
      "d\030\001 \001(\tR\tchannelId\022*\n\007members\030\002 \003(\0132\020.ap" +
      "i.v1.UserStubR\007members\"3\n\022OpenChannelReq" +
      "uest\022\035\n\nchannel_id\030\001 \001(\tR\tchannelId\"4\n\023C" +
      "loseChannelRequest\022\035\n\nchannel_id\030\001 \001(\tR\t" +
      "channelId\"\276\001\n\023OpenChannelResponse\0228\n\014mes" +
      "sage_list\030\001 \001(\0132\023.api.v1.MessageListH\000R\013" +
      "messageList\022+\n\007message\030\002 \001(\0132\017.api.v1.Me" +
      "ssageH\000R\007message\0227\n\007members\030\003 \001(\0132\033.api." +
      "v1.ChannelMemberUpdateH\000R\007membersB\007\n\005eve" +
      "nt\"G\n\022SendMessageRequest\022\035\n\nchannel_id\030\001" +
      " \001(\tR\tchannelId\022\022\n\004text\030\002 \001(\tR\004text\"@\n\023S" +
      "endMessageResponse\022)\n\007message\030\001 \001(\0132\017.ap" +
      "i.v1.MessageR\007message\"3\n\022JoinChannelRequ" +
      "est\022\035\n\nchannel_id\030\001 \001(\tR\tchannelId\"4\n\023Le" +
      "aveChannelRequest\022\035\n\nchannel_id\030\001 \001(\tR\tc" +
      "hannelId\"G\n\022GetMessagesRequest\022\035\n\nchanne" +
      "l_id\030\001 \001(\tR\tchannelId\022\022\n\004page\030\002 \001(\004R\004pag" +
      "e\"M\n\023GetMessagesResponse\0226\n\014message_list" +
      "\030\001 \001(\0132\023.api.v1.MessageListR\013messageList" +
      "\"Q\n\027AddChannelMemberRequest\022\035\n\nchannel_i" +
      "d\030\001 \001(\tR\tchannelId\022\027\n\007user_id\030\002 \001(\tR\006use" +
      "rId\"6\n\025GetChannelInfoRequest\022\035\n\nchannel_" +
      "id\030\001 \001(\tR\tchannelId\"N\n\026GetChannelInfoRes" +
      "ponse\0224\n\007channel\030\001 \001(\0132\032.api.v1.MessageC" +
      "hannelStubR\007channel2\231\005\n\016MessageService\022B" +
      "\n\013GetChannels\022\026.google.protobuf.Empty\032\033." +
      "api.v1.GetChannelsResponse\022H\n\013OpenChanne" +
      "l\022\032.api.v1.OpenChannelRequest\032\033.api.v1.O" +
      "penChannelResponse0\001\022C\n\014CloseChannel\022\033.a" +
      "pi.v1.CloseChannelRequest\032\026.google.proto" +
      "buf.Empty\022F\n\013SendMessage\022\032.api.v1.SendMe" +
      "ssageRequest\032\033.api.v1.SendMessageRespons" +
      "e\022A\n\013JoinChannel\022\032.api.v1.JoinChannelReq" +
      "uest\032\026.google.protobuf.Empty\022C\n\014LeaveCha" +
      "nnel\022\033.api.v1.LeaveChannelRequest\032\026.goog" +
      "le.protobuf.Empty\022F\n\013GetMessages\022\032.api.v" +
      "1.GetMessagesRequest\032\033.api.v1.GetMessage" +
      "sResponse\022K\n\020AddChannelMember\022\037.api.v1.A" +
      "ddChannelMemberRequest\032\026.google.protobuf" +
      ".Empty\022O\n\016GetChannelInfo\022\035.api.v1.GetCha" +
      "nnelInfoRequest\032\036.api.v1.GetChannelInfoR" +
      "esponseBn\n$lol.calico.uctutors.generated" +
      ".api.v1B\rMessagesProtoP\001\242\002\003AXX\252\002\006Api.V1\312" +
      "\002\006Api\\V1\342\002\022Api\\V1\\GPBMetadata\352\002\007Api::V1b" +
      "\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.EmptyProto.getDescriptor(),
          lol.calico.uctutors.generated.api.v1.UserProto.getDescriptor(),
        });
    internal_static_api_v1_GetChannelsResponse_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_api_v1_GetChannelsResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_GetChannelsResponse_descriptor,
        new java.lang.String[] { "Channels", });
    internal_static_api_v1_MessageChannelStub_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_api_v1_MessageChannelStub_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_MessageChannelStub_descriptor,
        new java.lang.String[] { "Id", "Name", "Description", "UserIds", "LatestMessage", "PinnedMessageId", });
    internal_static_api_v1_Message_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_api_v1_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_Message_descriptor,
        new java.lang.String[] { "Id", "ChannelId", "UserId", "Text", "Timestamp", "User", });
    internal_static_api_v1_MessageList_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_api_v1_MessageList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_MessageList_descriptor,
        new java.lang.String[] { "Count", "NextPage", "Messages", });
    internal_static_api_v1_ChannelMemberUpdate_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_api_v1_ChannelMemberUpdate_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_ChannelMemberUpdate_descriptor,
        new java.lang.String[] { "ChannelId", "Members", });
    internal_static_api_v1_OpenChannelRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_api_v1_OpenChannelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_OpenChannelRequest_descriptor,
        new java.lang.String[] { "ChannelId", });
    internal_static_api_v1_CloseChannelRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_api_v1_CloseChannelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_CloseChannelRequest_descriptor,
        new java.lang.String[] { "ChannelId", });
    internal_static_api_v1_OpenChannelResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_api_v1_OpenChannelResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_OpenChannelResponse_descriptor,
        new java.lang.String[] { "MessageList", "Message", "Members", "Event", });
    internal_static_api_v1_SendMessageRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_api_v1_SendMessageRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_SendMessageRequest_descriptor,
        new java.lang.String[] { "ChannelId", "Text", });
    internal_static_api_v1_SendMessageResponse_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_api_v1_SendMessageResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_SendMessageResponse_descriptor,
        new java.lang.String[] { "Message", });
    internal_static_api_v1_JoinChannelRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_api_v1_JoinChannelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_JoinChannelRequest_descriptor,
        new java.lang.String[] { "ChannelId", });
    internal_static_api_v1_LeaveChannelRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_api_v1_LeaveChannelRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_LeaveChannelRequest_descriptor,
        new java.lang.String[] { "ChannelId", });
    internal_static_api_v1_GetMessagesRequest_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_api_v1_GetMessagesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_GetMessagesRequest_descriptor,
        new java.lang.String[] { "ChannelId", "Page", });
    internal_static_api_v1_GetMessagesResponse_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_api_v1_GetMessagesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_GetMessagesResponse_descriptor,
        new java.lang.String[] { "MessageList", });
    internal_static_api_v1_AddChannelMemberRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_api_v1_AddChannelMemberRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_AddChannelMemberRequest_descriptor,
        new java.lang.String[] { "ChannelId", "UserId", });
    internal_static_api_v1_GetChannelInfoRequest_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_api_v1_GetChannelInfoRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_GetChannelInfoRequest_descriptor,
        new java.lang.String[] { "ChannelId", });
    internal_static_api_v1_GetChannelInfoResponse_descriptor =
      getDescriptor().getMessageTypes().get(16);
    internal_static_api_v1_GetChannelInfoResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_api_v1_GetChannelInfoResponse_descriptor,
        new java.lang.String[] { "Channel", });
    com.google.protobuf.EmptyProto.getDescriptor();
    lol.calico.uctutors.generated.api.v1.UserProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
