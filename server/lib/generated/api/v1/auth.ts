/* eslint-disable */
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";
import { Empty } from "../../google/protobuf/empty";
import { Error } from "./error";
import { CampusAvailability, School, schoolFromJSON, schoolToJSON, VirtualAvailability } from "./user";

export const protobufPackage = "api.v1";

export enum LoginStatus {
  LOGIN_STATUS_UNSPECIFIED = 0,
  LOGIN_STATUS_NEW_USER = 1,
  LOGIN_STATUS_EXISTING_USER = 2,
  UNRECOGNIZED = -1,
}

export function loginStatusFromJSON(object: any): LoginStatus {
  switch (object) {
    case 0:
    case "LOGIN_STATUS_UNSPECIFIED":
      return LoginStatus.LOGIN_STATUS_UNSPECIFIED;
    case 1:
    case "LOGIN_STATUS_NEW_USER":
      return LoginStatus.LOGIN_STATUS_NEW_USER;
    case 2:
    case "LOGIN_STATUS_EXISTING_USER":
      return LoginStatus.LOGIN_STATUS_EXISTING_USER;
    case -1:
    case "UNRECOGNIZED":
    default:
      return LoginStatus.UNRECOGNIZED;
  }
}

export function loginStatusToJSON(object: LoginStatus): string {
  switch (object) {
    case LoginStatus.LOGIN_STATUS_UNSPECIFIED:
      return "LOGIN_STATUS_UNSPECIFIED";
    case LoginStatus.LOGIN_STATUS_NEW_USER:
      return "LOGIN_STATUS_NEW_USER";
    case LoginStatus.LOGIN_STATUS_EXISTING_USER:
      return "LOGIN_STATUS_EXISTING_USER";
    case LoginStatus.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export enum RegisterStatus {
  REGISTER_STATUS_UNSPECIFIED = 0,
  REGISTER_STATUS_SUCCESS = 1,
  REGISTER_STATUS_ERROR = 2,
  UNRECOGNIZED = -1,
}

export function registerStatusFromJSON(object: any): RegisterStatus {
  switch (object) {
    case 0:
    case "REGISTER_STATUS_UNSPECIFIED":
      return RegisterStatus.REGISTER_STATUS_UNSPECIFIED;
    case 1:
    case "REGISTER_STATUS_SUCCESS":
      return RegisterStatus.REGISTER_STATUS_SUCCESS;
    case 2:
    case "REGISTER_STATUS_ERROR":
      return RegisterStatus.REGISTER_STATUS_ERROR;
    case -1:
    case "UNRECOGNIZED":
    default:
      return RegisterStatus.UNRECOGNIZED;
  }
}

export function registerStatusToJSON(object: RegisterStatus): string {
  switch (object) {
    case RegisterStatus.REGISTER_STATUS_UNSPECIFIED:
      return "REGISTER_STATUS_UNSPECIFIED";
    case RegisterStatus.REGISTER_STATUS_SUCCESS:
      return "REGISTER_STATUS_SUCCESS";
    case RegisterStatus.REGISTER_STATUS_ERROR:
      return "REGISTER_STATUS_ERROR";
    case RegisterStatus.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export interface GetNonceResponse {
  nonce: string;
}

export interface LoginRequest {
  idToken: string;
  nonce: string;
}

export interface LoginResponse {
  status: LoginStatus;
  newUser?: LoginResponseNewUser | undefined;
  existingUser?: LoginResponseExistingUser | undefined;
}

export interface LoginResponseNewUser {
  userId: string;
  token: string;
}

export interface LoginResponseExistingUser {
  userId: string;
  token: string;
}

export interface RegisterRequest {
  data: RegisterData | undefined;
}

export interface RegisterData {
  school: School;
  classOf: number;
  bio: string;
  campusAvailability: CampusAvailability[];
  virtualAvailability: VirtualAvailability[];
  topics: string[];
}

export interface RegisterResponse {
  status: RegisterStatus;
  success?: RegisterResponseSuccess | undefined;
  error?: Error | undefined;
}

export interface RegisterResponseSuccess {
  userId: string;
}

function createBaseGetNonceResponse(): GetNonceResponse {
  return { nonce: "" };
}

export const GetNonceResponse = {
  encode(message: GetNonceResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.nonce !== "") {
      writer.uint32(10).string(message.nonce);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetNonceResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetNonceResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.nonce = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetNonceResponse {
    return { nonce: isSet(object.nonce) ? globalThis.String(object.nonce) : "" };
  },

  toJSON(message: GetNonceResponse): unknown {
    const obj: any = {};
    if (message.nonce !== "") {
      obj.nonce = message.nonce;
    }
    return obj;
  },

  create(base?: DeepPartial<GetNonceResponse>): GetNonceResponse {
    return GetNonceResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetNonceResponse>): GetNonceResponse {
    const message = createBaseGetNonceResponse();
    message.nonce = object.nonce ?? "";
    return message;
  },
};

function createBaseLoginRequest(): LoginRequest {
  return { idToken: "", nonce: "" };
}

export const LoginRequest = {
  encode(message: LoginRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.idToken !== "") {
      writer.uint32(10).string(message.idToken);
    }
    if (message.nonce !== "") {
      writer.uint32(18).string(message.nonce);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LoginRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLoginRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.idToken = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.nonce = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): LoginRequest {
    return {
      idToken: isSet(object.idToken) ? globalThis.String(object.idToken) : "",
      nonce: isSet(object.nonce) ? globalThis.String(object.nonce) : "",
    };
  },

  toJSON(message: LoginRequest): unknown {
    const obj: any = {};
    if (message.idToken !== "") {
      obj.idToken = message.idToken;
    }
    if (message.nonce !== "") {
      obj.nonce = message.nonce;
    }
    return obj;
  },

  create(base?: DeepPartial<LoginRequest>): LoginRequest {
    return LoginRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LoginRequest>): LoginRequest {
    const message = createBaseLoginRequest();
    message.idToken = object.idToken ?? "";
    message.nonce = object.nonce ?? "";
    return message;
  },
};

function createBaseLoginResponse(): LoginResponse {
  return { status: 0, newUser: undefined, existingUser: undefined };
}

export const LoginResponse = {
  encode(message: LoginResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.status !== 0) {
      writer.uint32(8).int32(message.status);
    }
    if (message.newUser !== undefined) {
      LoginResponseNewUser.encode(message.newUser, writer.uint32(18).fork()).ldelim();
    }
    if (message.existingUser !== undefined) {
      LoginResponseExistingUser.encode(message.existingUser, writer.uint32(26).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LoginResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLoginResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.status = reader.int32() as any;
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.newUser = LoginResponseNewUser.decode(reader, reader.uint32());
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.existingUser = LoginResponseExistingUser.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): LoginResponse {
    return {
      status: isSet(object.status) ? loginStatusFromJSON(object.status) : 0,
      newUser: isSet(object.newUser) ? LoginResponseNewUser.fromJSON(object.newUser) : undefined,
      existingUser: isSet(object.existingUser) ? LoginResponseExistingUser.fromJSON(object.existingUser) : undefined,
    };
  },

  toJSON(message: LoginResponse): unknown {
    const obj: any = {};
    if (message.status !== 0) {
      obj.status = loginStatusToJSON(message.status);
    }
    if (message.newUser !== undefined) {
      obj.newUser = LoginResponseNewUser.toJSON(message.newUser);
    }
    if (message.existingUser !== undefined) {
      obj.existingUser = LoginResponseExistingUser.toJSON(message.existingUser);
    }
    return obj;
  },

  create(base?: DeepPartial<LoginResponse>): LoginResponse {
    return LoginResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LoginResponse>): LoginResponse {
    const message = createBaseLoginResponse();
    message.status = object.status ?? 0;
    message.newUser = (object.newUser !== undefined && object.newUser !== null)
      ? LoginResponseNewUser.fromPartial(object.newUser)
      : undefined;
    message.existingUser = (object.existingUser !== undefined && object.existingUser !== null)
      ? LoginResponseExistingUser.fromPartial(object.existingUser)
      : undefined;
    return message;
  },
};

function createBaseLoginResponseNewUser(): LoginResponseNewUser {
  return { userId: "", token: "" };
}

export const LoginResponseNewUser = {
  encode(message: LoginResponseNewUser, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.userId !== "") {
      writer.uint32(10).string(message.userId);
    }
    if (message.token !== "") {
      writer.uint32(18).string(message.token);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LoginResponseNewUser {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLoginResponseNewUser();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.userId = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.token = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): LoginResponseNewUser {
    return {
      userId: isSet(object.userId) ? globalThis.String(object.userId) : "",
      token: isSet(object.token) ? globalThis.String(object.token) : "",
    };
  },

  toJSON(message: LoginResponseNewUser): unknown {
    const obj: any = {};
    if (message.userId !== "") {
      obj.userId = message.userId;
    }
    if (message.token !== "") {
      obj.token = message.token;
    }
    return obj;
  },

  create(base?: DeepPartial<LoginResponseNewUser>): LoginResponseNewUser {
    return LoginResponseNewUser.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LoginResponseNewUser>): LoginResponseNewUser {
    const message = createBaseLoginResponseNewUser();
    message.userId = object.userId ?? "";
    message.token = object.token ?? "";
    return message;
  },
};

function createBaseLoginResponseExistingUser(): LoginResponseExistingUser {
  return { userId: "", token: "" };
}

export const LoginResponseExistingUser = {
  encode(message: LoginResponseExistingUser, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.userId !== "") {
      writer.uint32(10).string(message.userId);
    }
    if (message.token !== "") {
      writer.uint32(18).string(message.token);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LoginResponseExistingUser {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLoginResponseExistingUser();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.userId = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.token = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): LoginResponseExistingUser {
    return {
      userId: isSet(object.userId) ? globalThis.String(object.userId) : "",
      token: isSet(object.token) ? globalThis.String(object.token) : "",
    };
  },

  toJSON(message: LoginResponseExistingUser): unknown {
    const obj: any = {};
    if (message.userId !== "") {
      obj.userId = message.userId;
    }
    if (message.token !== "") {
      obj.token = message.token;
    }
    return obj;
  },

  create(base?: DeepPartial<LoginResponseExistingUser>): LoginResponseExistingUser {
    return LoginResponseExistingUser.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LoginResponseExistingUser>): LoginResponseExistingUser {
    const message = createBaseLoginResponseExistingUser();
    message.userId = object.userId ?? "";
    message.token = object.token ?? "";
    return message;
  },
};

function createBaseRegisterRequest(): RegisterRequest {
  return { data: undefined };
}

export const RegisterRequest = {
  encode(message: RegisterRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.data !== undefined) {
      RegisterData.encode(message.data, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): RegisterRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseRegisterRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.data = RegisterData.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): RegisterRequest {
    return { data: isSet(object.data) ? RegisterData.fromJSON(object.data) : undefined };
  },

  toJSON(message: RegisterRequest): unknown {
    const obj: any = {};
    if (message.data !== undefined) {
      obj.data = RegisterData.toJSON(message.data);
    }
    return obj;
  },

  create(base?: DeepPartial<RegisterRequest>): RegisterRequest {
    return RegisterRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<RegisterRequest>): RegisterRequest {
    const message = createBaseRegisterRequest();
    message.data = (object.data !== undefined && object.data !== null)
      ? RegisterData.fromPartial(object.data)
      : undefined;
    return message;
  },
};

function createBaseRegisterData(): RegisterData {
  return { school: 0, classOf: 0, bio: "", campusAvailability: [], virtualAvailability: [], topics: [] };
}

export const RegisterData = {
  encode(message: RegisterData, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.school !== 0) {
      writer.uint32(16).int32(message.school);
    }
    if (message.classOf !== 0) {
      writer.uint32(24).uint32(message.classOf);
    }
    if (message.bio !== "") {
      writer.uint32(34).string(message.bio);
    }
    for (const v of message.campusAvailability) {
      CampusAvailability.encode(v!, writer.uint32(42).fork()).ldelim();
    }
    for (const v of message.virtualAvailability) {
      VirtualAvailability.encode(v!, writer.uint32(50).fork()).ldelim();
    }
    for (const v of message.topics) {
      writer.uint32(58).string(v!);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): RegisterData {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseRegisterData();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 2:
          if (tag !== 16) {
            break;
          }

          message.school = reader.int32() as any;
          continue;
        case 3:
          if (tag !== 24) {
            break;
          }

          message.classOf = reader.uint32();
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.bio = reader.string();
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          message.campusAvailability.push(CampusAvailability.decode(reader, reader.uint32()));
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.virtualAvailability.push(VirtualAvailability.decode(reader, reader.uint32()));
          continue;
        case 7:
          if (tag !== 58) {
            break;
          }

          message.topics.push(reader.string());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): RegisterData {
    return {
      school: isSet(object.school) ? schoolFromJSON(object.school) : 0,
      classOf: isSet(object.classOf) ? globalThis.Number(object.classOf) : 0,
      bio: isSet(object.bio) ? globalThis.String(object.bio) : "",
      campusAvailability: globalThis.Array.isArray(object?.campusAvailability)
        ? object.campusAvailability.map((e: any) => CampusAvailability.fromJSON(e))
        : [],
      virtualAvailability: globalThis.Array.isArray(object?.virtualAvailability)
        ? object.virtualAvailability.map((e: any) => VirtualAvailability.fromJSON(e))
        : [],
      topics: globalThis.Array.isArray(object?.topics) ? object.topics.map((e: any) => globalThis.String(e)) : [],
    };
  },

  toJSON(message: RegisterData): unknown {
    const obj: any = {};
    if (message.school !== 0) {
      obj.school = schoolToJSON(message.school);
    }
    if (message.classOf !== 0) {
      obj.classOf = Math.round(message.classOf);
    }
    if (message.bio !== "") {
      obj.bio = message.bio;
    }
    if (message.campusAvailability?.length) {
      obj.campusAvailability = message.campusAvailability.map((e) => CampusAvailability.toJSON(e));
    }
    if (message.virtualAvailability?.length) {
      obj.virtualAvailability = message.virtualAvailability.map((e) => VirtualAvailability.toJSON(e));
    }
    if (message.topics?.length) {
      obj.topics = message.topics;
    }
    return obj;
  },

  create(base?: DeepPartial<RegisterData>): RegisterData {
    return RegisterData.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<RegisterData>): RegisterData {
    const message = createBaseRegisterData();
    message.school = object.school ?? 0;
    message.classOf = object.classOf ?? 0;
    message.bio = object.bio ?? "";
    message.campusAvailability = object.campusAvailability?.map((e) => CampusAvailability.fromPartial(e)) || [];
    message.virtualAvailability = object.virtualAvailability?.map((e) => VirtualAvailability.fromPartial(e)) || [];
    message.topics = object.topics?.map((e) => e) || [];
    return message;
  },
};

function createBaseRegisterResponse(): RegisterResponse {
  return { status: 0, success: undefined, error: undefined };
}

export const RegisterResponse = {
  encode(message: RegisterResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.status !== 0) {
      writer.uint32(8).int32(message.status);
    }
    if (message.success !== undefined) {
      RegisterResponseSuccess.encode(message.success, writer.uint32(18).fork()).ldelim();
    }
    if (message.error !== undefined) {
      Error.encode(message.error, writer.uint32(26).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): RegisterResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseRegisterResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.status = reader.int32() as any;
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.success = RegisterResponseSuccess.decode(reader, reader.uint32());
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.error = Error.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): RegisterResponse {
    return {
      status: isSet(object.status) ? registerStatusFromJSON(object.status) : 0,
      success: isSet(object.success) ? RegisterResponseSuccess.fromJSON(object.success) : undefined,
      error: isSet(object.error) ? Error.fromJSON(object.error) : undefined,
    };
  },

  toJSON(message: RegisterResponse): unknown {
    const obj: any = {};
    if (message.status !== 0) {
      obj.status = registerStatusToJSON(message.status);
    }
    if (message.success !== undefined) {
      obj.success = RegisterResponseSuccess.toJSON(message.success);
    }
    if (message.error !== undefined) {
      obj.error = Error.toJSON(message.error);
    }
    return obj;
  },

  create(base?: DeepPartial<RegisterResponse>): RegisterResponse {
    return RegisterResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<RegisterResponse>): RegisterResponse {
    const message = createBaseRegisterResponse();
    message.status = object.status ?? 0;
    message.success = (object.success !== undefined && object.success !== null)
      ? RegisterResponseSuccess.fromPartial(object.success)
      : undefined;
    message.error = (object.error !== undefined && object.error !== null) ? Error.fromPartial(object.error) : undefined;
    return message;
  },
};

function createBaseRegisterResponseSuccess(): RegisterResponseSuccess {
  return { userId: "" };
}

export const RegisterResponseSuccess = {
  encode(message: RegisterResponseSuccess, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.userId !== "") {
      writer.uint32(10).string(message.userId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): RegisterResponseSuccess {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseRegisterResponseSuccess();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.userId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): RegisterResponseSuccess {
    return { userId: isSet(object.userId) ? globalThis.String(object.userId) : "" };
  },

  toJSON(message: RegisterResponseSuccess): unknown {
    const obj: any = {};
    if (message.userId !== "") {
      obj.userId = message.userId;
    }
    return obj;
  },

  create(base?: DeepPartial<RegisterResponseSuccess>): RegisterResponseSuccess {
    return RegisterResponseSuccess.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<RegisterResponseSuccess>): RegisterResponseSuccess {
    const message = createBaseRegisterResponseSuccess();
    message.userId = object.userId ?? "";
    return message;
  },
};

export type AuthServiceDefinition = typeof AuthServiceDefinition;
export const AuthServiceDefinition = {
  name: "AuthService",
  fullName: "api.v1.AuthService",
  methods: {
    getNonce: {
      name: "GetNonce",
      requestType: Empty,
      requestStream: false,
      responseType: GetNonceResponse,
      responseStream: false,
      options: {},
    },
    login: {
      name: "Login",
      requestType: LoginRequest,
      requestStream: false,
      responseType: LoginResponse,
      responseStream: false,
      options: {},
    },
    logout: {
      name: "Logout",
      requestType: Empty,
      requestStream: false,
      responseType: Empty,
      responseStream: false,
      options: {},
    },
    register: {
      name: "Register",
      requestType: RegisterRequest,
      requestStream: false,
      responseType: RegisterResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface AuthServiceImplementation<CallContextExt = {}> {
  getNonce(request: Empty, context: CallContext & CallContextExt): Promise<DeepPartial<GetNonceResponse>>;
  login(request: LoginRequest, context: CallContext & CallContextExt): Promise<DeepPartial<LoginResponse>>;
  logout(request: Empty, context: CallContext & CallContextExt): Promise<DeepPartial<Empty>>;
  register(request: RegisterRequest, context: CallContext & CallContextExt): Promise<DeepPartial<RegisterResponse>>;
}

export interface AuthServiceClient<CallOptionsExt = {}> {
  getNonce(request: DeepPartial<Empty>, options?: CallOptions & CallOptionsExt): Promise<GetNonceResponse>;
  login(request: DeepPartial<LoginRequest>, options?: CallOptions & CallOptionsExt): Promise<LoginResponse>;
  logout(request: DeepPartial<Empty>, options?: CallOptions & CallOptionsExt): Promise<Empty>;
  register(request: DeepPartial<RegisterRequest>, options?: CallOptions & CallOptionsExt): Promise<RegisterResponse>;
}

type Builtin = Date | Function | Uint8Array | string | number | boolean | undefined;

export type DeepPartial<T> = T extends Builtin ? T
  : T extends globalThis.Array<infer U> ? globalThis.Array<DeepPartial<U>>
  : T extends ReadonlyArray<infer U> ? ReadonlyArray<DeepPartial<U>>
  : T extends {} ? { [K in keyof T]?: DeepPartial<T[K]> }
  : Partial<T>;

function isSet(value: any): boolean {
  return value !== null && value !== undefined;
}
