// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: api/v1/auth_session.proto

// Protobuf Java Version: 3.25.1
package lol.calico.uctutors.generated.api.v1;

/**
 * Protobuf enum {@code api.v1.AuthSessionError}
 */
public enum AuthSessionError
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>AUTH_SESSION_ERROR_UNSPECIFIED = 0;</code>
   */
  AUTH_SESSION_ERROR_UNSPECIFIED(0),
  /**
   * <code>AUTH_SESSION_ERROR_NO_SESSION = 1;</code>
   */
  AUTH_SESSION_ERROR_NO_SESSION(1),
  /**
   * <code>AUTH_SESSION_ERROR_INVALID = 2;</code>
   */
  AUTH_SESSION_ERROR_INVALID(2),
  /**
   * <code>AUTH_SESSION_ERROR_VALIDATION_FAILED = 3;</code>
   */
  AUTH_SESSION_ERROR_VALIDATION_FAILED(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>AUTH_SESSION_ERROR_UNSPECIFIED = 0;</code>
   */
  public static final int AUTH_SESSION_ERROR_UNSPECIFIED_VALUE = 0;
  /**
   * <code>AUTH_SESSION_ERROR_NO_SESSION = 1;</code>
   */
  public static final int AUTH_SESSION_ERROR_NO_SESSION_VALUE = 1;
  /**
   * <code>AUTH_SESSION_ERROR_INVALID = 2;</code>
   */
  public static final int AUTH_SESSION_ERROR_INVALID_VALUE = 2;
  /**
   * <code>AUTH_SESSION_ERROR_VALIDATION_FAILED = 3;</code>
   */
  public static final int AUTH_SESSION_ERROR_VALIDATION_FAILED_VALUE = 3;


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
  public static AuthSessionError valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static AuthSessionError forNumber(int value) {
    switch (value) {
      case 0: return AUTH_SESSION_ERROR_UNSPECIFIED;
      case 1: return AUTH_SESSION_ERROR_NO_SESSION;
      case 2: return AUTH_SESSION_ERROR_INVALID;
      case 3: return AUTH_SESSION_ERROR_VALIDATION_FAILED;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<AuthSessionError>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      AuthSessionError> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<AuthSessionError>() {
          public AuthSessionError findValueByNumber(int number) {
            return AuthSessionError.forNumber(number);
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
    return lol.calico.uctutors.generated.api.v1.AuthSessionProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final AuthSessionError[] VALUES = values();

  public static AuthSessionError valueOf(
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

  private AuthSessionError(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:api.v1.AuthSessionError)
}

