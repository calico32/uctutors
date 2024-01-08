// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/messages.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf type {@code api.v1.GetChannelsResponse}
 */
public final class GetChannelsResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.v1.GetChannelsResponse)
    GetChannelsResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetChannelsResponse.newBuilder() to construct.
  private GetChannelsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetChannelsResponse() {
    channels_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetChannelsResponse();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_GetChannelsResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_GetChannelsResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            lol.calico.uctutors.generated.api.v1.GetChannelsResponse.class, lol.calico.uctutors.generated.api.v1.GetChannelsResponse.Builder.class);
  }

  public static final int CHANNELS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub> channels_;
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  @java.lang.Override
  public java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub> getChannelsList() {
    return channels_;
  }
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  @java.lang.Override
  public java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder> 
      getChannelsOrBuilderList() {
    return channels_;
  }
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  @java.lang.Override
  public int getChannelsCount() {
    return channels_.size();
  }
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.MessageChannelStub getChannels(int index) {
    return channels_.get(index);
  }
  /**
   * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
   */
  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder getChannelsOrBuilder(
      int index) {
    return channels_.get(index);
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
    for (int i = 0; i < channels_.size(); i++) {
      output.writeMessage(1, channels_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < channels_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, channels_.get(i));
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
    if (!(obj instanceof lol.calico.uctutors.generated.api.v1.GetChannelsResponse)) {
      return super.equals(obj);
    }
    lol.calico.uctutors.generated.api.v1.GetChannelsResponse other = (lol.calico.uctutors.generated.api.v1.GetChannelsResponse) obj;

    if (!getChannelsList()
        .equals(other.getChannelsList())) return false;
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
    if (getChannelsCount() > 0) {
      hash = (37 * hash) + CHANNELS_FIELD_NUMBER;
      hash = (53 * hash) + getChannelsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse parseFrom(
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
  public static Builder newBuilder(lol.calico.uctutors.generated.api.v1.GetChannelsResponse prototype) {
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
   * Protobuf type {@code api.v1.GetChannelsResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.v1.GetChannelsResponse)
      lol.calico.uctutors.generated.api.v1.GetChannelsResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_GetChannelsResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_GetChannelsResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              lol.calico.uctutors.generated.api.v1.GetChannelsResponse.class, lol.calico.uctutors.generated.api.v1.GetChannelsResponse.Builder.class);
    }

    // Construct using lol.calico.uctutors.generated.api.v1.GetChannelsResponse.newBuilder()
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
      if (channelsBuilder_ == null) {
        channels_ = java.util.Collections.emptyList();
      } else {
        channels_ = null;
        channelsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_GetChannelsResponse_descriptor;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.GetChannelsResponse getDefaultInstanceForType() {
      return lol.calico.uctutors.generated.api.v1.GetChannelsResponse.getDefaultInstance();
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.GetChannelsResponse build() {
      lol.calico.uctutors.generated.api.v1.GetChannelsResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.GetChannelsResponse buildPartial() {
      lol.calico.uctutors.generated.api.v1.GetChannelsResponse result = new lol.calico.uctutors.generated.api.v1.GetChannelsResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(lol.calico.uctutors.generated.api.v1.GetChannelsResponse result) {
      if (channelsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          channels_ = java.util.Collections.unmodifiableList(channels_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.channels_ = channels_;
      } else {
        result.channels_ = channelsBuilder_.build();
      }
    }

    private void buildPartial0(lol.calico.uctutors.generated.api.v1.GetChannelsResponse result) {
      int from_bitField0_ = bitField0_;
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
      if (other instanceof lol.calico.uctutors.generated.api.v1.GetChannelsResponse) {
        return mergeFrom((lol.calico.uctutors.generated.api.v1.GetChannelsResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(lol.calico.uctutors.generated.api.v1.GetChannelsResponse other) {
      if (other == lol.calico.uctutors.generated.api.v1.GetChannelsResponse.getDefaultInstance()) return this;
      if (channelsBuilder_ == null) {
        if (!other.channels_.isEmpty()) {
          if (channels_.isEmpty()) {
            channels_ = other.channels_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureChannelsIsMutable();
            channels_.addAll(other.channels_);
          }
          onChanged();
        }
      } else {
        if (!other.channels_.isEmpty()) {
          if (channelsBuilder_.isEmpty()) {
            channelsBuilder_.dispose();
            channelsBuilder_ = null;
            channels_ = other.channels_;
            bitField0_ = (bitField0_ & ~0x00000001);
            channelsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getChannelsFieldBuilder() : null;
          } else {
            channelsBuilder_.addAllMessages(other.channels_);
          }
        }
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
            case 10: {
              lol.calico.uctutors.generated.api.v1.MessageChannelStub m =
                  input.readMessage(
                      lol.calico.uctutors.generated.api.v1.MessageChannelStub.parser(),
                      extensionRegistry);
              if (channelsBuilder_ == null) {
                ensureChannelsIsMutable();
                channels_.add(m);
              } else {
                channelsBuilder_.addMessage(m);
              }
              break;
            } // case 10
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

    private java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub> channels_ =
      java.util.Collections.emptyList();
    private void ensureChannelsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        channels_ = new java.util.ArrayList<lol.calico.uctutors.generated.api.v1.MessageChannelStub>(channels_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        lol.calico.uctutors.generated.api.v1.MessageChannelStub, lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder, lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder> channelsBuilder_;

    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub> getChannelsList() {
      if (channelsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(channels_);
      } else {
        return channelsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public int getChannelsCount() {
      if (channelsBuilder_ == null) {
        return channels_.size();
      } else {
        return channelsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageChannelStub getChannels(int index) {
      if (channelsBuilder_ == null) {
        return channels_.get(index);
      } else {
        return channelsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder setChannels(
        int index, lol.calico.uctutors.generated.api.v1.MessageChannelStub value) {
      if (channelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChannelsIsMutable();
        channels_.set(index, value);
        onChanged();
      } else {
        channelsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder setChannels(
        int index, lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder builderForValue) {
      if (channelsBuilder_ == null) {
        ensureChannelsIsMutable();
        channels_.set(index, builderForValue.build());
        onChanged();
      } else {
        channelsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder addChannels(lol.calico.uctutors.generated.api.v1.MessageChannelStub value) {
      if (channelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChannelsIsMutable();
        channels_.add(value);
        onChanged();
      } else {
        channelsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder addChannels(
        int index, lol.calico.uctutors.generated.api.v1.MessageChannelStub value) {
      if (channelsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureChannelsIsMutable();
        channels_.add(index, value);
        onChanged();
      } else {
        channelsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder addChannels(
        lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder builderForValue) {
      if (channelsBuilder_ == null) {
        ensureChannelsIsMutable();
        channels_.add(builderForValue.build());
        onChanged();
      } else {
        channelsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder addChannels(
        int index, lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder builderForValue) {
      if (channelsBuilder_ == null) {
        ensureChannelsIsMutable();
        channels_.add(index, builderForValue.build());
        onChanged();
      } else {
        channelsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder addAllChannels(
        java.lang.Iterable<? extends lol.calico.uctutors.generated.api.v1.MessageChannelStub> values) {
      if (channelsBuilder_ == null) {
        ensureChannelsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, channels_);
        onChanged();
      } else {
        channelsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder clearChannels() {
      if (channelsBuilder_ == null) {
        channels_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        channelsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public Builder removeChannels(int index) {
      if (channelsBuilder_ == null) {
        ensureChannelsIsMutable();
        channels_.remove(index);
        onChanged();
      } else {
        channelsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder getChannelsBuilder(
        int index) {
      return getChannelsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder getChannelsOrBuilder(
        int index) {
      if (channelsBuilder_ == null) {
        return channels_.get(index);  } else {
        return channelsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder> 
         getChannelsOrBuilderList() {
      if (channelsBuilder_ != null) {
        return channelsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(channels_);
      }
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder addChannelsBuilder() {
      return getChannelsFieldBuilder().addBuilder(
          lol.calico.uctutors.generated.api.v1.MessageChannelStub.getDefaultInstance());
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder addChannelsBuilder(
        int index) {
      return getChannelsFieldBuilder().addBuilder(
          index, lol.calico.uctutors.generated.api.v1.MessageChannelStub.getDefaultInstance());
    }
    /**
     * <code>repeated .api.v1.MessageChannelStub channels = 1 [json_name = "channels"];</code>
     */
    public java.util.List<lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder> 
         getChannelsBuilderList() {
      return getChannelsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        lol.calico.uctutors.generated.api.v1.MessageChannelStub, lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder, lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder> 
        getChannelsFieldBuilder() {
      if (channelsBuilder_ == null) {
        channelsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            lol.calico.uctutors.generated.api.v1.MessageChannelStub, lol.calico.uctutors.generated.api.v1.MessageChannelStub.Builder, lol.calico.uctutors.generated.api.v1.MessageChannelStubOrBuilder>(
                channels_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        channels_ = null;
      }
      return channelsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:api.v1.GetChannelsResponse)
  }

  // @@protoc_insertion_point(class_scope:api.v1.GetChannelsResponse)
  private static final lol.calico.uctutors.generated.api.v1.GetChannelsResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new lol.calico.uctutors.generated.api.v1.GetChannelsResponse();
  }

  public static lol.calico.uctutors.generated.api.v1.GetChannelsResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetChannelsResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetChannelsResponse>() {
    @java.lang.Override
    public GetChannelsResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetChannelsResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetChannelsResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.GetChannelsResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
