/* eslint-disable */

export const protobufPackage = "api.v1";

export enum AuthSessionError {
  AUTH_SESSION_ERROR_UNSPECIFIED = 0,
  AUTH_SESSION_ERROR_NO_SESSION = 1,
  AUTH_SESSION_ERROR_INVALID = 2,
  AUTH_SESSION_ERROR_VALIDATION_FAILED = 3,
  UNRECOGNIZED = -1,
}

export function authSessionErrorFromJSON(object: any): AuthSessionError {
  switch (object) {
    case 0:
    case "AUTH_SESSION_ERROR_UNSPECIFIED":
      return AuthSessionError.AUTH_SESSION_ERROR_UNSPECIFIED;
    case 1:
    case "AUTH_SESSION_ERROR_NO_SESSION":
      return AuthSessionError.AUTH_SESSION_ERROR_NO_SESSION;
    case 2:
    case "AUTH_SESSION_ERROR_INVALID":
      return AuthSessionError.AUTH_SESSION_ERROR_INVALID;
    case 3:
    case "AUTH_SESSION_ERROR_VALIDATION_FAILED":
      return AuthSessionError.AUTH_SESSION_ERROR_VALIDATION_FAILED;
    case -1:
    case "UNRECOGNIZED":
    default:
      return AuthSessionError.UNRECOGNIZED;
  }
}

export function authSessionErrorToJSON(object: AuthSessionError): string {
  switch (object) {
    case AuthSessionError.AUTH_SESSION_ERROR_UNSPECIFIED:
      return "AUTH_SESSION_ERROR_UNSPECIFIED";
    case AuthSessionError.AUTH_SESSION_ERROR_NO_SESSION:
      return "AUTH_SESSION_ERROR_NO_SESSION";
    case AuthSessionError.AUTH_SESSION_ERROR_INVALID:
      return "AUTH_SESSION_ERROR_INVALID";
    case AuthSessionError.AUTH_SESSION_ERROR_VALIDATION_FAILED:
      return "AUTH_SESSION_ERROR_VALIDATION_FAILED";
    case AuthSessionError.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}
