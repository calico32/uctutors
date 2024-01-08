// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/messages.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf type {@code api.v1.MessageList}
 */
public final class MessageList extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.v1.MessageList)
    MessageListOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageList.newBuilder() to construct.
  private MessageList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageList() {
    messages_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_MessageList_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_MessageList_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            lol.calico.uctutors.generated.api.v1.MessageList.class, lol.calico.uctutors.generated.api.v1.MessageList.Builder.class);
  }

  public static final int COUNT_FIELD_NUMBER = 1;
  private int count_ = 0;
  /**
   * <code>uint32 count = 1 [json_name = "count"];</code>
   * @return The count.
   */
  @java.lang.Override
  public int getCount() {
    return count_;
  }

  public static final int NEXT_PAGE_FIELD_NUMBER = 2;
  private long nextPage_ = 0L;
  /**
   * <code>uint64 next_page = 2 [json_name = "nextPage"];</code>
   * @return The nextPage.
   */
  @java.lang.Override
  public long getNextPage() {
    return nextPage_;
  }

  public static final int MESSAGES_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private java.util.List<lol.calico.uctutors.generated.api.v1.Message> messages_;
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  @java.lang.Override
  public java.util.List<lol.calico.uctutors.generated.api.v1.Message> getMessagesList() {
    return messages_;
  }
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  @java.lang.Override
  public java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageOrBuilder> 
      getMessagesOrBuilderList() {
    return messages_;
  }
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  @java.lang.Override
  public int getMessagesCount() {
    return messages_.size();
  }
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.Message getMessages(int index) {
    return messages_.get(index);
  }
  /**
   * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
   */
  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.MessageOrBuilder getMessagesOrBuilder(
      int index) {
    return messages_.get(index);
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
    if (count_ != 0) {
      output.writeUInt32(1, count_);
    }
    if (nextPage_ != 0L) {
      output.writeUInt64(2, nextPage_);
    }
    for (int i = 0; i < messages_.size(); i++) {
      output.writeMessage(3, messages_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (count_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt32Size(1, count_);
    }
    if (nextPage_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeUInt64Size(2, nextPage_);
    }
    for (int i = 0; i < messages_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, messages_.get(i));
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
    if (!(obj instanceof lol.calico.uctutors.generated.api.v1.MessageList)) {
      return super.equals(obj);
    }
    lol.calico.uctutors.generated.api.v1.MessageList other = (lol.calico.uctutors.generated.api.v1.MessageList) obj;

    if (getCount()
        != other.getCount()) return false;
    if (getNextPage()
        != other.getNextPage()) return false;
    if (!getMessagesList()
        .equals(other.getMessagesList())) return false;
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
    hash = (37 * hash) + COUNT_FIELD_NUMBER;
    hash = (53 * hash) + getCount();
    hash = (37 * hash) + NEXT_PAGE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getNextPage());
    if (getMessagesCount() > 0) {
      hash = (37 * hash) + MESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getMessagesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static lol.calico.uctutors.generated.api.v1.MessageList parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static lol.calico.uctutors.generated.api.v1.MessageList parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.MessageList parseFrom(
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
  public static Builder newBuilder(lol.calico.uctutors.generated.api.v1.MessageList prototype) {
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
   * Protobuf type {@code api.v1.MessageList}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.v1.MessageList)
      lol.calico.uctutors.generated.api.v1.MessageListOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_MessageList_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_MessageList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              lol.calico.uctutors.generated.api.v1.MessageList.class, lol.calico.uctutors.generated.api.v1.MessageList.Builder.class);
    }

    // Construct using lol.calico.uctutors.generated.api.v1.MessageList.newBuilder()
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
      count_ = 0;
      nextPage_ = 0L;
      if (messagesBuilder_ == null) {
        messages_ = java.util.Collections.emptyList();
      } else {
        messages_ = null;
        messagesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return lol.calico.uctutors.generated.api.v1.MessagesProto.internal_static_api_v1_MessageList_descriptor;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.MessageList getDefaultInstanceForType() {
      return lol.calico.uctutors.generated.api.v1.MessageList.getDefaultInstance();
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.MessageList build() {
      lol.calico.uctutors.generated.api.v1.MessageList result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.MessageList buildPartial() {
      lol.calico.uctutors.generated.api.v1.MessageList result = new lol.calico.uctutors.generated.api.v1.MessageList(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(lol.calico.uctutors.generated.api.v1.MessageList result) {
      if (messagesBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          messages_ = java.util.Collections.unmodifiableList(messages_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.messages_ = messages_;
      } else {
        result.messages_ = messagesBuilder_.build();
      }
    }

    private void buildPartial0(lol.calico.uctutors.generated.api.v1.MessageList result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.count_ = count_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.nextPage_ = nextPage_;
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
      if (other instanceof lol.calico.uctutors.generated.api.v1.MessageList) {
        return mergeFrom((lol.calico.uctutors.generated.api.v1.MessageList)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(lol.calico.uctutors.generated.api.v1.MessageList other) {
      if (other == lol.calico.uctutors.generated.api.v1.MessageList.getDefaultInstance()) return this;
      if (other.getCount() != 0) {
        setCount(other.getCount());
      }
      if (other.getNextPage() != 0L) {
        setNextPage(other.getNextPage());
      }
      if (messagesBuilder_ == null) {
        if (!other.messages_.isEmpty()) {
          if (messages_.isEmpty()) {
            messages_ = other.messages_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureMessagesIsMutable();
            messages_.addAll(other.messages_);
          }
          onChanged();
        }
      } else {
        if (!other.messages_.isEmpty()) {
          if (messagesBuilder_.isEmpty()) {
            messagesBuilder_.dispose();
            messagesBuilder_ = null;
            messages_ = other.messages_;
            bitField0_ = (bitField0_ & ~0x00000004);
            messagesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMessagesFieldBuilder() : null;
          } else {
            messagesBuilder_.addAllMessages(other.messages_);
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
            case 8: {
              count_ = input.readUInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              nextPage_ = input.readUInt64();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              lol.calico.uctutors.generated.api.v1.Message m =
                  input.readMessage(
                      lol.calico.uctutors.generated.api.v1.Message.parser(),
                      extensionRegistry);
              if (messagesBuilder_ == null) {
                ensureMessagesIsMutable();
                messages_.add(m);
              } else {
                messagesBuilder_.addMessage(m);
              }
              break;
            } // case 26
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

    private int count_ ;
    /**
     * <code>uint32 count = 1 [json_name = "count"];</code>
     * @return The count.
     */
    @java.lang.Override
    public int getCount() {
      return count_;
    }
    /**
     * <code>uint32 count = 1 [json_name = "count"];</code>
     * @param value The count to set.
     * @return This builder for chaining.
     */
    public Builder setCount(int value) {

      count_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 count = 1 [json_name = "count"];</code>
     * @return This builder for chaining.
     */
    public Builder clearCount() {
      bitField0_ = (bitField0_ & ~0x00000001);
      count_ = 0;
      onChanged();
      return this;
    }

    private long nextPage_ ;
    /**
     * <code>uint64 next_page = 2 [json_name = "nextPage"];</code>
     * @return The nextPage.
     */
    @java.lang.Override
    public long getNextPage() {
      return nextPage_;
    }
    /**
     * <code>uint64 next_page = 2 [json_name = "nextPage"];</code>
     * @param value The nextPage to set.
     * @return This builder for chaining.
     */
    public Builder setNextPage(long value) {

      nextPage_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 next_page = 2 [json_name = "nextPage"];</code>
     * @return This builder for chaining.
     */
    public Builder clearNextPage() {
      bitField0_ = (bitField0_ & ~0x00000002);
      nextPage_ = 0L;
      onChanged();
      return this;
    }

    private java.util.List<lol.calico.uctutors.generated.api.v1.Message> messages_ =
      java.util.Collections.emptyList();
    private void ensureMessagesIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        messages_ = new java.util.ArrayList<lol.calico.uctutors.generated.api.v1.Message>(messages_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        lol.calico.uctutors.generated.api.v1.Message, lol.calico.uctutors.generated.api.v1.Message.Builder, lol.calico.uctutors.generated.api.v1.MessageOrBuilder> messagesBuilder_;

    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public java.util.List<lol.calico.uctutors.generated.api.v1.Message> getMessagesList() {
      if (messagesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(messages_);
      } else {
        return messagesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public int getMessagesCount() {
      if (messagesBuilder_ == null) {
        return messages_.size();
      } else {
        return messagesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.Message getMessages(int index) {
      if (messagesBuilder_ == null) {
        return messages_.get(index);
      } else {
        return messagesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder setMessages(
        int index, lol.calico.uctutors.generated.api.v1.Message value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.set(index, value);
        onChanged();
      } else {
        messagesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder setMessages(
        int index, lol.calico.uctutors.generated.api.v1.Message.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.set(index, builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder addMessages(lol.calico.uctutors.generated.api.v1.Message value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.add(value);
        onChanged();
      } else {
        messagesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder addMessages(
        int index, lol.calico.uctutors.generated.api.v1.Message value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.add(index, value);
        onChanged();
      } else {
        messagesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder addMessages(
        lol.calico.uctutors.generated.api.v1.Message.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.add(builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder addMessages(
        int index, lol.calico.uctutors.generated.api.v1.Message.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.add(index, builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder addAllMessages(
        java.lang.Iterable<? extends lol.calico.uctutors.generated.api.v1.Message> values) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, messages_);
        onChanged();
      } else {
        messagesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder clearMessages() {
      if (messagesBuilder_ == null) {
        messages_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        messagesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public Builder removeMessages(int index) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.remove(index);
        onChanged();
      } else {
        messagesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.Message.Builder getMessagesBuilder(
        int index) {
      return getMessagesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.MessageOrBuilder getMessagesOrBuilder(
        int index) {
      if (messagesBuilder_ == null) {
        return messages_.get(index);  } else {
        return messagesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public java.util.List<? extends lol.calico.uctutors.generated.api.v1.MessageOrBuilder> 
         getMessagesOrBuilderList() {
      if (messagesBuilder_ != null) {
        return messagesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(messages_);
      }
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.Message.Builder addMessagesBuilder() {
      return getMessagesFieldBuilder().addBuilder(
          lol.calico.uctutors.generated.api.v1.Message.getDefaultInstance());
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public lol.calico.uctutors.generated.api.v1.Message.Builder addMessagesBuilder(
        int index) {
      return getMessagesFieldBuilder().addBuilder(
          index, lol.calico.uctutors.generated.api.v1.Message.getDefaultInstance());
    }
    /**
     * <code>repeated .api.v1.Message messages = 3 [json_name = "messages"];</code>
     */
    public java.util.List<lol.calico.uctutors.generated.api.v1.Message.Builder> 
         getMessagesBuilderList() {
      return getMessagesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        lol.calico.uctutors.generated.api.v1.Message, lol.calico.uctutors.generated.api.v1.Message.Builder, lol.calico.uctutors.generated.api.v1.MessageOrBuilder> 
        getMessagesFieldBuilder() {
      if (messagesBuilder_ == null) {
        messagesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            lol.calico.uctutors.generated.api.v1.Message, lol.calico.uctutors.generated.api.v1.Message.Builder, lol.calico.uctutors.generated.api.v1.MessageOrBuilder>(
                messages_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        messages_ = null;
      }
      return messagesBuilder_;
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


    // @@protoc_insertion_point(builder_scope:api.v1.MessageList)
  }

  // @@protoc_insertion_point(class_scope:api.v1.MessageList)
  private static final lol.calico.uctutors.generated.api.v1.MessageList DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new lol.calico.uctutors.generated.api.v1.MessageList();
  }

  public static lol.calico.uctutors.generated.api.v1.MessageList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageList>
      PARSER = new com.google.protobuf.AbstractParser<MessageList>() {
    @java.lang.Override
    public MessageList parsePartialFrom(
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

  public static com.google.protobuf.Parser<MessageList> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageList> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.MessageList getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
