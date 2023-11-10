/* eslint-disable */
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";
import { Timestamp } from "../google/protobuf/timestamp";

export const protobufPackage = "api";

export interface GetApiInfoRequest {
}

export interface GetApiInfoResponse {
  apiInfo: ApiInfo | undefined;
}

export interface ApiInfo {
  version: number;
  commit: string;
  buildTime: Date | undefined;
}

function createBaseGetApiInfoRequest(): GetApiInfoRequest {
  return {};
}

export const GetApiInfoRequest = {
  encode(_: GetApiInfoRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetApiInfoRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetApiInfoRequest();
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

  fromJSON(_: any): GetApiInfoRequest {
    return {};
  },

  toJSON(_: GetApiInfoRequest): unknown {
    const obj: any = {};
    return obj;
  },

  create(base?: DeepPartial<GetApiInfoRequest>): GetApiInfoRequest {
    return GetApiInfoRequest.fromPartial(base ?? {});
  },
  fromPartial(_: DeepPartial<GetApiInfoRequest>): GetApiInfoRequest {
    const message = createBaseGetApiInfoRequest();
    return message;
  },
};

function createBaseGetApiInfoResponse(): GetApiInfoResponse {
  return { apiInfo: undefined };
}

export const GetApiInfoResponse = {
  encode(message: GetApiInfoResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.apiInfo !== undefined) {
      ApiInfo.encode(message.apiInfo, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetApiInfoResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetApiInfoResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.apiInfo = ApiInfo.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetApiInfoResponse {
    return { apiInfo: isSet(object.apiInfo) ? ApiInfo.fromJSON(object.apiInfo) : undefined };
  },

  toJSON(message: GetApiInfoResponse): unknown {
    const obj: any = {};
    if (message.apiInfo !== undefined) {
      obj.apiInfo = ApiInfo.toJSON(message.apiInfo);
    }
    return obj;
  },

  create(base?: DeepPartial<GetApiInfoResponse>): GetApiInfoResponse {
    return GetApiInfoResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetApiInfoResponse>): GetApiInfoResponse {
    const message = createBaseGetApiInfoResponse();
    message.apiInfo = (object.apiInfo !== undefined && object.apiInfo !== null)
      ? ApiInfo.fromPartial(object.apiInfo)
      : undefined;
    return message;
  },
};

function createBaseApiInfo(): ApiInfo {
  return { version: 0, commit: "", buildTime: undefined };
}

export const ApiInfo = {
  encode(message: ApiInfo, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.version !== 0) {
      writer.uint32(8).uint32(message.version);
    }
    if (message.commit !== "") {
      writer.uint32(18).string(message.commit);
    }
    if (message.buildTime !== undefined) {
      Timestamp.encode(toTimestamp(message.buildTime), writer.uint32(26).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ApiInfo {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseApiInfo();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.version = reader.uint32();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.commit = reader.string();
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.buildTime = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): ApiInfo {
    return {
      version: isSet(object.version) ? globalThis.Number(object.version) : 0,
      commit: isSet(object.commit) ? globalThis.String(object.commit) : "",
      buildTime: isSet(object.buildTime) ? fromJsonTimestamp(object.buildTime) : undefined,
    };
  },

  toJSON(message: ApiInfo): unknown {
    const obj: any = {};
    if (message.version !== 0) {
      obj.version = Math.round(message.version);
    }
    if (message.commit !== "") {
      obj.commit = message.commit;
    }
    if (message.buildTime !== undefined) {
      obj.buildTime = message.buildTime.toISOString();
    }
    return obj;
  },

  create(base?: DeepPartial<ApiInfo>): ApiInfo {
    return ApiInfo.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<ApiInfo>): ApiInfo {
    const message = createBaseApiInfo();
    message.version = object.version ?? 0;
    message.commit = object.commit ?? "";
    message.buildTime = object.buildTime ?? undefined;
    return message;
  },
};

export type ApiInfoServiceDefinition = typeof ApiInfoServiceDefinition;
export const ApiInfoServiceDefinition = {
  name: "ApiInfoService",
  fullName: "api.ApiInfoService",
  methods: {
    getApiInfo: {
      name: "GetApiInfo",
      requestType: GetApiInfoRequest,
      requestStream: false,
      responseType: GetApiInfoResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface ApiInfoServiceImplementation<CallContextExt = {}> {
  getApiInfo(
    request: GetApiInfoRequest,
    context: CallContext & CallContextExt,
  ): Promise<DeepPartial<GetApiInfoResponse>>;
}

export interface ApiInfoServiceClient<CallOptionsExt = {}> {
  getApiInfo(
    request: DeepPartial<GetApiInfoRequest>,
    options?: CallOptions & CallOptionsExt,
  ): Promise<GetApiInfoResponse>;
}

type Builtin = Date | Function | Uint8Array | string | number | boolean | undefined;

export type DeepPartial<T> = T extends Builtin ? T
  : T extends globalThis.Array<infer U> ? globalThis.Array<DeepPartial<U>>
  : T extends ReadonlyArray<infer U> ? ReadonlyArray<DeepPartial<U>>
  : T extends {} ? { [K in keyof T]?: DeepPartial<T[K]> }
  : Partial<T>;

function toTimestamp(date: Date): Timestamp {
  const seconds = date.getTime() / 1_000;
  const nanos = (date.getTime() % 1_000) * 1_000_000;
  return { seconds, nanos };
}

function fromTimestamp(t: Timestamp): Date {
  let millis = (t.seconds || 0) * 1_000;
  millis += (t.nanos || 0) / 1_000_000;
  return new globalThis.Date(millis);
}

function fromJsonTimestamp(o: any): Date {
  if (o instanceof globalThis.Date) {
    return o;
  } else if (typeof o === "string") {
    return new globalThis.Date(o);
  } else {
    return fromTimestamp(Timestamp.fromJSON(o));
  }
}

function isSet(value: any): boolean {
  return value !== null && value !== undefined;
}
