// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/user.proto

// Protobuf Java Version: 3.25.0
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf type {@code api.v1.VirtualAvailability}
 */
public final class VirtualAvailability extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:api.v1.VirtualAvailability)
    VirtualAvailabilityOrBuilder {
private static final long serialVersionUID = 0L;
  // Use VirtualAvailability.newBuilder() to construct.
  private VirtualAvailability(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private VirtualAvailability() {
    day_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new VirtualAvailability();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return lol.calico.uctutors.generated.api.v1.UserProto.internal_static_api_v1_VirtualAvailability_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return lol.calico.uctutors.generated.api.v1.UserProto.internal_static_api_v1_VirtualAvailability_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            lol.calico.uctutors.generated.api.v1.VirtualAvailability.class, lol.calico.uctutors.generated.api.v1.VirtualAvailability.Builder.class);
  }

  private int bitField0_;
  public static final int DAY_FIELD_NUMBER = 1;
  private int day_ = 0;
  /**
   * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
   * @return The enum numeric value on the wire for day.
   */
  @java.lang.Override public int getDayValue() {
    return day_;
  }
  /**
   * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
   * @return The day.
   */
  @java.lang.Override public com.google.type.DayOfWeek getDay() {
    com.google.type.DayOfWeek result = com.google.type.DayOfWeek.forNumber(day_);
    return result == null ? com.google.type.DayOfWeek.UNRECOGNIZED : result;
  }

  public static final int INTERVAL_FIELD_NUMBER = 2;
  private com.google.type.Interval interval_;
  /**
   * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
   * @return Whether the interval field is set.
   */
  @java.lang.Override
  public boolean hasInterval() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
   * @return The interval.
   */
  @java.lang.Override
  public com.google.type.Interval getInterval() {
    return interval_ == null ? com.google.type.Interval.getDefaultInstance() : interval_;
  }
  /**
   * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
   */
  @java.lang.Override
  public com.google.type.IntervalOrBuilder getIntervalOrBuilder() {
    return interval_ == null ? com.google.type.Interval.getDefaultInstance() : interval_;
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
    if (day_ != com.google.type.DayOfWeek.DAY_OF_WEEK_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, day_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getInterval());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (day_ != com.google.type.DayOfWeek.DAY_OF_WEEK_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, day_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getInterval());
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
    if (!(obj instanceof lol.calico.uctutors.generated.api.v1.VirtualAvailability)) {
      return super.equals(obj);
    }
    lol.calico.uctutors.generated.api.v1.VirtualAvailability other = (lol.calico.uctutors.generated.api.v1.VirtualAvailability) obj;

    if (day_ != other.day_) return false;
    if (hasInterval() != other.hasInterval()) return false;
    if (hasInterval()) {
      if (!getInterval()
          .equals(other.getInterval())) return false;
    }
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
    hash = (37 * hash) + DAY_FIELD_NUMBER;
    hash = (53 * hash) + day_;
    if (hasInterval()) {
      hash = (37 * hash) + INTERVAL_FIELD_NUMBER;
      hash = (53 * hash) + getInterval().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability parseFrom(
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
  public static Builder newBuilder(lol.calico.uctutors.generated.api.v1.VirtualAvailability prototype) {
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
   * Protobuf type {@code api.v1.VirtualAvailability}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:api.v1.VirtualAvailability)
      lol.calico.uctutors.generated.api.v1.VirtualAvailabilityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return lol.calico.uctutors.generated.api.v1.UserProto.internal_static_api_v1_VirtualAvailability_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return lol.calico.uctutors.generated.api.v1.UserProto.internal_static_api_v1_VirtualAvailability_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              lol.calico.uctutors.generated.api.v1.VirtualAvailability.class, lol.calico.uctutors.generated.api.v1.VirtualAvailability.Builder.class);
    }

    // Construct using lol.calico.uctutors.generated.api.v1.VirtualAvailability.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getIntervalFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      day_ = 0;
      interval_ = null;
      if (intervalBuilder_ != null) {
        intervalBuilder_.dispose();
        intervalBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return lol.calico.uctutors.generated.api.v1.UserProto.internal_static_api_v1_VirtualAvailability_descriptor;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.VirtualAvailability getDefaultInstanceForType() {
      return lol.calico.uctutors.generated.api.v1.VirtualAvailability.getDefaultInstance();
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.VirtualAvailability build() {
      lol.calico.uctutors.generated.api.v1.VirtualAvailability result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public lol.calico.uctutors.generated.api.v1.VirtualAvailability buildPartial() {
      lol.calico.uctutors.generated.api.v1.VirtualAvailability result = new lol.calico.uctutors.generated.api.v1.VirtualAvailability(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(lol.calico.uctutors.generated.api.v1.VirtualAvailability result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.day_ = day_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.interval_ = intervalBuilder_ == null
            ? interval_
            : intervalBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof lol.calico.uctutors.generated.api.v1.VirtualAvailability) {
        return mergeFrom((lol.calico.uctutors.generated.api.v1.VirtualAvailability)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(lol.calico.uctutors.generated.api.v1.VirtualAvailability other) {
      if (other == lol.calico.uctutors.generated.api.v1.VirtualAvailability.getDefaultInstance()) return this;
      if (other.day_ != 0) {
        setDayValue(other.getDayValue());
      }
      if (other.hasInterval()) {
        mergeInterval(other.getInterval());
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
              day_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 18: {
              input.readMessage(
                  getIntervalFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
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

    private int day_ = 0;
    /**
     * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
     * @return The enum numeric value on the wire for day.
     */
    @java.lang.Override public int getDayValue() {
      return day_;
    }
    /**
     * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
     * @param value The enum numeric value on the wire for day to set.
     * @return This builder for chaining.
     */
    public Builder setDayValue(int value) {
      day_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
     * @return The day.
     */
    @java.lang.Override
    public com.google.type.DayOfWeek getDay() {
      com.google.type.DayOfWeek result = com.google.type.DayOfWeek.forNumber(day_);
      return result == null ? com.google.type.DayOfWeek.UNRECOGNIZED : result;
    }
    /**
     * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
     * @param value The day to set.
     * @return This builder for chaining.
     */
    public Builder setDay(com.google.type.DayOfWeek value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      day_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.google.type.DayOfWeek day = 1 [json_name = "day"];</code>
     * @return This builder for chaining.
     */
    public Builder clearDay() {
      bitField0_ = (bitField0_ & ~0x00000001);
      day_ = 0;
      onChanged();
      return this;
    }

    private com.google.type.Interval interval_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.type.Interval, com.google.type.Interval.Builder, com.google.type.IntervalOrBuilder> intervalBuilder_;
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     * @return Whether the interval field is set.
     */
    public boolean hasInterval() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     * @return The interval.
     */
    public com.google.type.Interval getInterval() {
      if (intervalBuilder_ == null) {
        return interval_ == null ? com.google.type.Interval.getDefaultInstance() : interval_;
      } else {
        return intervalBuilder_.getMessage();
      }
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public Builder setInterval(com.google.type.Interval value) {
      if (intervalBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        interval_ = value;
      } else {
        intervalBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public Builder setInterval(
        com.google.type.Interval.Builder builderForValue) {
      if (intervalBuilder_ == null) {
        interval_ = builderForValue.build();
      } else {
        intervalBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public Builder mergeInterval(com.google.type.Interval value) {
      if (intervalBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          interval_ != null &&
          interval_ != com.google.type.Interval.getDefaultInstance()) {
          getIntervalBuilder().mergeFrom(value);
        } else {
          interval_ = value;
        }
      } else {
        intervalBuilder_.mergeFrom(value);
      }
      if (interval_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public Builder clearInterval() {
      bitField0_ = (bitField0_ & ~0x00000002);
      interval_ = null;
      if (intervalBuilder_ != null) {
        intervalBuilder_.dispose();
        intervalBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public com.google.type.Interval.Builder getIntervalBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getIntervalFieldBuilder().getBuilder();
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    public com.google.type.IntervalOrBuilder getIntervalOrBuilder() {
      if (intervalBuilder_ != null) {
        return intervalBuilder_.getMessageOrBuilder();
      } else {
        return interval_ == null ?
            com.google.type.Interval.getDefaultInstance() : interval_;
      }
    }
    /**
     * <code>.google.type.Interval interval = 2 [json_name = "interval"];</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.type.Interval, com.google.type.Interval.Builder, com.google.type.IntervalOrBuilder> 
        getIntervalFieldBuilder() {
      if (intervalBuilder_ == null) {
        intervalBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.type.Interval, com.google.type.Interval.Builder, com.google.type.IntervalOrBuilder>(
                getInterval(),
                getParentForChildren(),
                isClean());
        interval_ = null;
      }
      return intervalBuilder_;
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


    // @@protoc_insertion_point(builder_scope:api.v1.VirtualAvailability)
  }

  // @@protoc_insertion_point(class_scope:api.v1.VirtualAvailability)
  private static final lol.calico.uctutors.generated.api.v1.VirtualAvailability DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new lol.calico.uctutors.generated.api.v1.VirtualAvailability();
  }

  public static lol.calico.uctutors.generated.api.v1.VirtualAvailability getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<VirtualAvailability>
      PARSER = new com.google.protobuf.AbstractParser<VirtualAvailability>() {
    @java.lang.Override
    public VirtualAvailability parsePartialFrom(
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

  public static com.google.protobuf.Parser<VirtualAvailability> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<VirtualAvailability> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public lol.calico.uctutors.generated.api.v1.VirtualAvailability getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

