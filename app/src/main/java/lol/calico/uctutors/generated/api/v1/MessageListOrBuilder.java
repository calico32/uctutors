// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/messages.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

public interface MessageListOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.v1.MessageList)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 count = 1 [json_name = "count"];</code>
   * @return The count.
   */
  int getCount();

  /**
   * <code>uint64 next_page = 2 [json_name = "nextPage"];</code>
   * @return The nextPage.
   */
  long getNextPage();

  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  java.util.List<lol.calico.uctutors.generated.api.v1.Message> 
      getMessagesList();
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  lol.calico.uctutors.generated.api.v1.Message getMessages(int index);
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  int getMessagesCount();
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageOrBuilder> 
      getMessagesOrBuilderList();
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  lol.calico.uctutors.generated.api.v1.MessageOrBuilder getMessagesOrBuilder(
      int index);
}