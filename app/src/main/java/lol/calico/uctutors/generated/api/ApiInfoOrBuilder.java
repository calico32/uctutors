// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/info.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api;

public interface ApiInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:api.ApiInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint32 version = 1 [json_name = "version"];</code>
   * @return The version.
   */
  int getVersion();

  /**
   * <code>string commit = 2 [json_name = "commit"];</code>
   * @return The commit.
   */
  java.lang.String getCommit();
  /**
   * <code>string commit = 2 [json_name = "commit"];</code>
   * @return The bytes for commit.
   */
  com.google.protobuf.ByteString
      getCommitBytes();

  /**
   * <code>.google.protobuf.Timestamp build_time = 3 [json_name = "buildTime"];</code>
   * @return Whether the buildTime field is set.
   */
  boolean hasBuildTime();
  /**
   * <code>.google.protobuf.Timestamp build_time = 3 [json_name = "buildTime"];</code>
   * @return The buildTime.
   */
  com.google.protobuf.Timestamp getBuildTime();
  /**
   * <code>.google.protobuf.Timestamp build_time = 3 [json_name = "buildTime"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getBuildTimeOrBuilder();

  /**
   * <code>.google.protobuf.Timestamp current_time = 4 [json_name = "currentTime"];</code>
   * @return Whether the currentTime field is set.
   */
  boolean hasCurrentTime();
  /**
   * <code>.google.protobuf.Timestamp current_time = 4 [json_name = "currentTime"];</code>
   * @return The currentTime.
   */
  com.google.protobuf.Timestamp getCurrentTime();
  /**
   * <code>.google.protobuf.Timestamp current_time = 4 [json_name = "currentTime"];</code>
   */
  com.google.protobuf.TimestampOrBuilder getCurrentTimeOrBuilder();
}
