// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/messages.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

public interface GetChannelsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.v1.GetChannelsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub> 
      getChannelsList();
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  lol.calico.uctutors.generated.api.v1.MessageChannelStub getChannels(int index);
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  int getChannelsCount();
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder> 
      getChannelsOrBuilderList();
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder getChannelsOrBuilder(
      int index);
}
