// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/session.proto

// Protobuf Java Version: 3.25.0
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf enum {@code api.v1.SessionStatus}
 */
public enum SessionStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SESSION_STATUS_UNSPECIFIED = 0;</code>
   */
  SESSION_STATUS_UNSPECIFIED(0),
  /**
   * <code>SESSION_STATUS_AWAITING_TUTOR_APPROVAL = 1;</code>
   */
  SESSION_STATUS_AWAITING_TUTOR_APPROVAL(1),
  /**
   * <code>SESSION_STATUS_AWAITING_TUTEE_APPROVAL = 2;</code>
   */
  SESSION_STATUS_AWAITING_TUTEE_APPROVAL(2),
  /**
   * <code>SESSION_STATUS_DECLINED = 3;</code>
   */
  SESSION_STATUS_DECLINED(3),
  /**
   * <code>SESSION_STATUS_CONFIRMED = 4;</code>
   */
  SESSION_STATUS_CONFIRMED(4),
  /**
   * <code>SESSION_STATUS_COMPLETED = 5;</code>
   */
  SESSION_STATUS_COMPLETED(5),
  /**
   * <code>SESSION_STATUS_CANCELED = 6;</code>
   */
  SESSION_STATUS_CANCELED(6),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SESSION_STATUS_UNSPECIFIED = 0;</code>
   */
  public static final int SESSION_STATUS_UNSPECIFIED_VALUE = 0;
  /**
   * <code>SESSION_STATUS_AWAITING_TUTOR_APPROVAL = 1;</code>
   */
  public static final int SESSION_STATUS_AWAITING_TUTOR_APPROVAL_VALUE = 1;
  /**
   * <code>SESSION_STATUS_AWAITING_TUTEE_APPROVAL = 2;</code>
   */
  public static final int SESSION_STATUS_AWAITING_TUTEE_APPROVAL_VALUE = 2;
  /**
   * <code>SESSION_STATUS_DECLINED = 3;</code>
   */
  public static final int SESSION_STATUS_DECLINED_VALUE = 3;
  /**
   * <code>SESSION_STATUS_CONFIRMED = 4;</code>
   */
  public static final int SESSION_STATUS_CONFIRMED_VALUE = 4;
  /**
   * <code>SESSION_STATUS_COMPLETED = 5;</code>
   */
  public static final int SESSION_STATUS_COMPLETED_VALUE = 5;
  /**
   * <code>SESSION_STATUS_CANCELED = 6;</code>
   */
  public static final int SESSION_STATUS_CANCELED_VALUE = 6;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static SessionStatus valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static SessionStatus forNumber(int value) {
    switch (value) {
      case 0: return SESSION_STATUS_UNSPECIFIED;
      case 1: return SESSION_STATUS_AWAITING_TUTOR_APPROVAL;
      case 2: return SESSION_STATUS_AWAITING_TUTEE_APPROVAL;
      case 3: return SESSION_STATUS_DECLINED;
      case 4: return SESSION_STATUS_CONFIRMED;
      case 5: return SESSION_STATUS_COMPLETED;
      case 6: return SESSION_STATUS_CANCELED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<SessionStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      SessionStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<SessionStatus>() {
          public SessionStatus findValueByNumber(int number) {
            return SessionStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return lol.calico.uctutors.generated.api.v1.SessionProto.getDescriptor().getEnumTypes().get(1);
  }

  private static final SessionStatus[] VALUES = values();

  public static SessionStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private SessionStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:api.v1.SessionStatus)
}

