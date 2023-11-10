/* eslint-disable */
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";

export const protobufPackage = "api.v1";

export interface LoginRequest {
}

export interface LoginResponse {
  url: string;
}

function createBaseLoginRequest(): LoginRequest {
  return {};
}

export const LoginRequest = {
  encode(_: LoginRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LoginRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLoginRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(_: any): LoginRequest {
    return {};
  },

  toJSON(_: LoginRequest): unknown {
    const obj: any = {};
    return obj;
  },

  create(base?: DeepPartial<LoginRequest>): LoginRequest {
    return LoginRequest.fromPartial(base ?? {});
  },
  fromPartial(_: DeepPartial<LoginRequest>): LoginRequest {
    const message = createBaseLoginRequest();
    return message;
  },
};

function createBaseLoginResponse(): LoginResponse {
  return { url: "" };
}

export const LoginResponse = {
  encode(message: LoginResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.url !== "") {
      writer.uint32(10).string(message.url);
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
          if (tag !== 10) {
            break;
          }

          message.url = reader.string();
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
    return { url: isSet(object.url) ? globalThis.String(object.url) : "" };
  },

  toJSON(message: LoginResponse): unknown {
    const obj: any = {};
    if (message.url !== "") {
      obj.url = message.url;
    }
    return obj;
  },

  create(base?: DeepPartial<LoginResponse>): LoginResponse {
    return LoginResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LoginResponse>): LoginResponse {
    const message = createBaseLoginResponse();
    message.url = object.url ?? "";
    return message;
  },
};

export type AuthServiceDefinition = typeof AuthServiceDefinition;
export const AuthServiceDefinition = {
  name: "AuthService",
  fullName: "api.v1.AuthService",
  methods: {
    login: {
      name: "Login",
      requestType: LoginRequest,
      requestStream: false,
      responseType: LoginResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface AuthServiceImplementation<CallContextExt = {}> {
  login(request: LoginRequest, context: CallContext & CallContextExt): Promise<DeepPartial<LoginResponse>>;
}

export interface AuthServiceClient<CallOptionsExt = {}> {
  login(request: DeepPartial<LoginRequest>, options?: CallOptions & CallOptionsExt): Promise<LoginResponse>;
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
