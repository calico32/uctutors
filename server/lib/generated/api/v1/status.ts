/* eslint-disable */
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";
import { Empty } from "../../google/protobuf/empty";

export const protobufPackage = "api.v1";

export interface GetStatusResponse {
  status: string;
  authInfo: AuthInfo | undefined;
}

export interface AuthInfo {
  authenticated: boolean;
}

function createBaseGetStatusResponse(): GetStatusResponse {
  return { status: "", authInfo: undefined };
}

export const GetStatusResponse = {
  encode(message: GetStatusResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.status !== "") {
      writer.uint32(10).string(message.status);
    }
    if (message.authInfo !== undefined) {
      AuthInfo.encode(message.authInfo, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetStatusResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetStatusResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.status = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.authInfo = AuthInfo.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetStatusResponse {
    return {
      status: isSet(object.status) ? globalThis.String(object.status) : "",
      authInfo: isSet(object.authInfo) ? AuthInfo.fromJSON(object.authInfo) : undefined,
    };
  },

  toJSON(message: GetStatusResponse): unknown {
    const obj: any = {};
    if (message.status !== "") {
      obj.status = message.status;
    }
    if (message.authInfo !== undefined) {
      obj.authInfo = AuthInfo.toJSON(message.authInfo);
    }
    return obj;
  },

  create(base?: DeepPartial<GetStatusResponse>): GetStatusResponse {
    return GetStatusResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetStatusResponse>): GetStatusResponse {
    const message = createBaseGetStatusResponse();
    message.status = object.status ?? "";
    message.authInfo = (object.authInfo !== undefined && object.authInfo !== null)
      ? AuthInfo.fromPartial(object.authInfo)
      : undefined;
    return message;
  },
};

function createBaseAuthInfo(): AuthInfo {
  return { authenticated: false };
}

export const AuthInfo = {
  encode(message: AuthInfo, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.authenticated === true) {
      writer.uint32(8).bool(message.authenticated);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): AuthInfo {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseAuthInfo();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.authenticated = reader.bool();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): AuthInfo {
    return { authenticated: isSet(object.authenticated) ? globalThis.Boolean(object.authenticated) : false };
  },

  toJSON(message: AuthInfo): unknown {
    const obj: any = {};
    if (message.authenticated === true) {
      obj.authenticated = message.authenticated;
    }
    return obj;
  },

  create(base?: DeepPartial<AuthInfo>): AuthInfo {
    return AuthInfo.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<AuthInfo>): AuthInfo {
    const message = createBaseAuthInfo();
    message.authenticated = object.authenticated ?? false;
    return message;
  },
};

export type StatusServiceDefinition = typeof StatusServiceDefinition;
export const StatusServiceDefinition = {
  name: "StatusService",
  fullName: "api.v1.StatusService",
  methods: {
    getStatus: {
      name: "GetStatus",
      requestType: Empty,
      requestStream: false,
      responseType: GetStatusResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface StatusServiceImplementation<CallContextExt = {}> {
  getStatus(request: Empty, context: CallContext & CallContextExt): Promise<DeepPartial<GetStatusResponse>>;
}

export interface StatusServiceClient<CallOptionsExt = {}> {
  getStatus(request: DeepPartial<Empty>, options?: CallOptions & CallOptionsExt): Promise<GetStatusResponse>;
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
