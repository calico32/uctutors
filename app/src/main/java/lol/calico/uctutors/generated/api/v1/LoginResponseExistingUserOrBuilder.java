// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/auth.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

public interface LoginResponseExistingUserOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.v1.LoginResponseExistingUser)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string user_id = 1 [json_name = "userId"];</code>
   * @return The userId.
   */
  java.lang.String getUserId();
  /**
   * <code>string user_id = 1 [json_name = "userId"];</code>
   * @return The bytes for userId.
   */
  com.google.protobuf.ByteString
      getUserIdBytes();

  /**
   * <code>string token = 2 [json_name = "token"];</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <code>string token = 2 [json_name = "token"];</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();
}
