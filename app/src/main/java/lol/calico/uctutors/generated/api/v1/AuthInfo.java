// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/status.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf type {@code api.v1.AuthInfo}
 */
public final class AuthInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.v1.AuthInfo)
    AuthInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AuthInfo.newBuilder() to construct.
  private AuthInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AuthInfo() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AuthInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return lol.calico.uctutors.generated.api.v1.StatusProto.internal_static_api_v1_AuthInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return lol.calico.uctutors.generated.api.v1.StatusProto.internal_static_api_v1_AuthInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            lol.calico.uctutors.generated.api.v1.AuthInfo.class, lol.calico.uctutors.generated.api.v1.AuthInfo.Builder.class);
  }

  public static final int AUTHENTICATED_FIELD_NUMBER = 1;
  private boolean authenticated_ = false;
  /**
   * <code>bool authenticated = 1 [json_name = "authenticated"];</code>
   * @return The authenticated.
   */
  @java.lang.Override
  public boolean getAuthenticated() {
    return authenticated_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (authenticated_ != false) {
      output.writeBool(1, authenticated_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (authenticated_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(1, authenticated_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof lol.calico.uctutors.generated.api.v1.AuthInfo)) {
      return super.equals(obj);
    }
    lol.calico.uctutors.generated.api.v1.AuthInfo other = (lol.calico.uctutors.generated.api.v1.AuthInfo) obj;

    if (getAuthenticated()
        != other.getAuthenticated()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + AUTHENTICATED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAuthenticated());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.AuthInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(lol.calico.uctutors.generated.api.v1.AuthInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code api.v1.AuthInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.v1.AuthInfo)
      lol.calico.uctutors.generated.api.v1.AuthInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return lol.calico.uctutors.generated.api.v1.StatusProto.internal_static_api_v1_AuthInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return lol.calico.uctutors.generated.api.v1.StatusProto.internal_static_api_v1_AuthInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              lol.calico.uctutors.generated.api.v1.AuthInfo.class, lol.calico.uctutors.generated.api.v1.AuthInfo.Builder.class);
    }

    // Construct using lol.calico.uctutors.generated.api.v1.AuthInfo.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      authenticated_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return lol.calico.uctutors.generated.api.v1.StatusProto.internal_static_api_v1_AuthInfo_descriptor;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.AuthInfo getDefaultInstanceForType() {
      return lol.calico.uctutors.generated.api.v1.AuthInfo.getDefaultInstance();
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.AuthInfo build() {
      lol.calico.uctutors.generated.api.v1.AuthInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.AuthInfo buildPartial() {
      lol.calico.uctutors.generated.api.v1.AuthInfo result = new lol.calico.uctutors.generated.api.v1.AuthInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(lol.calico.uctutors.generated.api.v1.AuthInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.authenticated_ = authenticated_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof lol.calico.uctutors.generated.api.v1.AuthInfo) {
        return mergeFrom((lol.calico.uctutors.generated.api.v1.AuthInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(lol.calico.uctutors.generated.api.v1.AuthInfo other) {
      if (other == lol.calico.uctutors.generated.api.v1.AuthInfo.getDefaultInstance()) return this;
      if (other.getAuthenticated() != false) {
        setAuthenticated(other.getAuthenticated());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              authenticated_ = input.readBool();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private boolean authenticated_ ;
    /**
     * <code>bool authenticated = 1 [json_name = "authenticated"];</code>
     * @return The authenticated.
     */
    @java.lang.Override
    public boolean getAuthenticated() {
      return authenticated_;
    }
    /**
     * <code>bool authenticated = 1 [json_name = "authenticated"];</code>
     * @param value The authenticated to set.
     * @return This builder for chaining.
     */
    public Builder setAuthenticated(boolean value) {

      authenticated_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>bool authenticated = 1 [json_name = "authenticated"];</code>
     * @return This builder for chaining.
     */
    public Builder clearAuthenticated() {
      bitField0_ = (bitField0_ & ~0x00000001);
      authenticated_ = false;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:api.v1.AuthInfo)
  }

  // @@protoc_insertion_point(class_scope:api.v1.AuthInfo)
  private static final lol.calico.uctutors.generated.api.v1.AuthInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new lol.calico.uctutors.generated.api.v1.AuthInfo();
  }

  public static lol.calico.uctutors.generated.api.v1.AuthInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AuthInfo>
      PARSER = new com.google.protobuf.AbstractParser<AuthInfo>() {
    @java.lang.Override
    public AuthInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<AuthInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AuthInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.AuthInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

