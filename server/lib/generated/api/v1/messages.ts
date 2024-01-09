/* eslint-disable */
import Long from "long";
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";
import { Empty } from "../../google/protobuf/empty";
import { UserStub } from "./user";

export const protobufPackage = "api.v1";

export interface GetChannelsResponse {
  channels: MessageChannelStub[];
}

export interface MessageChannelStub {
  id: string;
  name: string;
  description: string;
  userIds: string[];
  latestMessage: string;
  pinnedMessageId: string;
}

export interface Message {
  id: string;
  channelId: string;
  userId: string;
  text: string;
  timestamp: number;
  user: UserStub | undefined;
}

export interface MessageList {
  count: number;
  nextPage: number;
  messages: Message[];
}

export interface ChannelMemberUpdate {
  channelId: string;
  members: UserStub[];
}

export interface OpenChannelRequest {
  channelId: string;
}

export interface CloseChannelRequest {
  channelId: string;
}

export interface OpenChannelResponse {
  messageList?: MessageList | undefined;
  message?: Message | undefined;
  members?: ChannelMemberUpdate | undefined;
}

export interface SendMessageRequest {
  channelId: string;
  text: string;
}

export interface SendMessageResponse {
  message: Message | undefined;
}

export interface JoinChannelRequest {
  channelId: string;
}

export interface LeaveChannelRequest {
  channelId: string;
}

export interface GetMessagesRequest {
  channelId: string;
  page: number;
}

export interface GetMessagesResponse {
  messageList: MessageList | undefined;
}

export interface AddChannelMemberRequest {
  channelId: string;
  userId: string;
}

export interface GetChannelInfoRequest {
  channelId: string;
}

export interface GetChannelInfoResponse {
  channel: MessageChannelStub | undefined;
}

function createBaseGetChannelsResponse(): GetChannelsResponse {
  return { channels: [] };
}

export const GetChannelsResponse = {
  encode(message: GetChannelsResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    for (const v of message.channels) {
      MessageChannelStub.encode(v!, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetChannelsResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetChannelsResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channels.push(MessageChannelStub.decode(reader, reader.uint32()));
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetChannelsResponse {
    return {
      channels: globalThis.Array.isArray(object?.channels)
        ? object.channels.map((e: any) => MessageChannelStub.fromJSON(e))
        : [],
    };
  },

  toJSON(message: GetChannelsResponse): unknown {
    const obj: any = {};
    if (message.channels?.length) {
      obj.channels = message.channels.map((e) => MessageChannelStub.toJSON(e));
    }
    return obj;
  },

  create(base?: DeepPartial<GetChannelsResponse>): GetChannelsResponse {
    return GetChannelsResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetChannelsResponse>): GetChannelsResponse {
    const message = createBaseGetChannelsResponse();
    message.channels = object.channels?.map((e) => MessageChannelStub.fromPartial(e)) || [];
    return message;
  },
};

function createBaseMessageChannelStub(): MessageChannelStub {
  return { id: "", name: "", description: "", userIds: [], latestMessage: "", pinnedMessageId: "" };
}

export const MessageChannelStub = {
  encode(message: MessageChannelStub, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.name !== "") {
      writer.uint32(18).string(message.name);
    }
    if (message.description !== "") {
      writer.uint32(26).string(message.description);
    }
    for (const v of message.userIds) {
      writer.uint32(34).string(v!);
    }
    if (message.latestMessage !== "") {
      writer.uint32(42).string(message.latestMessage);
    }
    if (message.pinnedMessageId !== "") {
      writer.uint32(50).string(message.pinnedMessageId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): MessageChannelStub {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseMessageChannelStub();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.id = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.name = reader.string();
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.description = reader.string();
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.userIds.push(reader.string());
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          message.latestMessage = reader.string();
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.pinnedMessageId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): MessageChannelStub {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      name: isSet(object.name) ? globalThis.String(object.name) : "",
      description: isSet(object.description) ? globalThis.String(object.description) : "",
      userIds: globalThis.Array.isArray(object?.userIds) ? object.userIds.map((e: any) => globalThis.String(e)) : [],
      latestMessage: isSet(object.latestMessage) ? globalThis.String(object.latestMessage) : "",
      pinnedMessageId: isSet(object.pinnedMessageId) ? globalThis.String(object.pinnedMessageId) : "",
    };
  },

  toJSON(message: MessageChannelStub): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    if (message.name !== "") {
      obj.name = message.name;
    }
    if (message.description !== "") {
      obj.description = message.description;
    }
    if (message.userIds?.length) {
      obj.userIds = message.userIds;
    }
    if (message.latestMessage !== "") {
      obj.latestMessage = message.latestMessage;
    }
    if (message.pinnedMessageId !== "") {
      obj.pinnedMessageId = message.pinnedMessageId;
    }
    return obj;
  },

  create(base?: DeepPartial<MessageChannelStub>): MessageChannelStub {
    return MessageChannelStub.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<MessageChannelStub>): MessageChannelStub {
    const message = createBaseMessageChannelStub();
    message.id = object.id ?? "";
    message.name = object.name ?? "";
    message.description = object.description ?? "";
    message.userIds = object.userIds?.map((e) => e) || [];
    message.latestMessage = object.latestMessage ?? "";
    message.pinnedMessageId = object.pinnedMessageId ?? "";
    return message;
  },
};

function createBaseMessage(): Message {
  return { id: "", channelId: "", userId: "", text: "", timestamp: 0, user: undefined };
}

export const Message = {
  encode(message: Message, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.channelId !== "") {
      writer.uint32(18).string(message.channelId);
    }
    if (message.userId !== "") {
      writer.uint32(26).string(message.userId);
    }
    if (message.text !== "") {
      writer.uint32(34).string(message.text);
    }
    if (message.timestamp !== 0) {
      writer.uint32(40).uint64(message.timestamp);
    }
    if (message.user !== undefined) {
      UserStub.encode(message.user, writer.uint32(50).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): Message {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseMessage();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.id = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.channelId = reader.string();
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.userId = reader.string();
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.text = reader.string();
          continue;
        case 5:
          if (tag !== 40) {
            break;
          }

          message.timestamp = longToNumber(reader.uint64() as Long);
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.user = UserStub.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): Message {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "",
      userId: isSet(object.userId) ? globalThis.String(object.userId) : "",
      text: isSet(object.text) ? globalThis.String(object.text) : "",
      timestamp: isSet(object.timestamp) ? globalThis.Number(object.timestamp) : 0,
      user: isSet(object.user) ? UserStub.fromJSON(object.user) : undefined,
    };
  },

  toJSON(message: Message): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    if (message.userId !== "") {
      obj.userId = message.userId;
    }
    if (message.text !== "") {
      obj.text = message.text;
    }
    if (message.timestamp !== 0) {
      obj.timestamp = Math.round(message.timestamp);
    }
    if (message.user !== undefined) {
      obj.user = UserStub.toJSON(message.user);
    }
    return obj;
  },

  create(base?: DeepPartial<Message>): Message {
    return Message.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<Message>): Message {
    const message = createBaseMessage();
    message.id = object.id ?? "";
    message.channelId = object.channelId ?? "";
    message.userId = object.userId ?? "";
    message.text = object.text ?? "";
    message.timestamp = object.timestamp ?? 0;
    message.user = (object.user !== undefined && object.user !== null) ? UserStub.fromPartial(object.user) : undefined;
    return message;
  },
};

function createBaseMessageList(): MessageList {
  return { count: 0, nextPage: 0, messages: [] };
}

export const MessageList = {
  encode(message: MessageList, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.count !== 0) {
      writer.uint32(8).uint32(message.count);
    }
    if (message.nextPage !== 0) {
      writer.uint32(16).uint64(message.nextPage);
    }
    for (const v of message.messages) {
      Message.encode(v!, writer.uint32(26).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): MessageList {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseMessageList();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.count = reader.uint32();
          continue;
        case 2:
          if (tag !== 16) {
            break;
          }

          message.nextPage = longToNumber(reader.uint64() as Long);
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.messages.push(Message.decode(reader, reader.uint32()));
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): MessageList {
    return {
      count: isSet(object.count) ? globalThis.Number(object.count) : 0,
      nextPage: isSet(object.nextPage) ? globalThis.Number(object.nextPage) : 0,
      messages: globalThis.Array.isArray(object?.messages) ? object.messages.map((e: any) => Message.fromJSON(e)) : [],
    };
  },

  toJSON(message: MessageList): unknown {
    const obj: any = {};
    if (message.count !== 0) {
      obj.count = Math.round(message.count);
    }
    if (message.nextPage !== 0) {
      obj.nextPage = Math.round(message.nextPage);
    }
    if (message.messages?.length) {
      obj.messages = message.messages.map((e) => Message.toJSON(e));
    }
    return obj;
  },

  create(base?: DeepPartial<MessageList>): MessageList {
    return MessageList.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<MessageList>): MessageList {
    const message = createBaseMessageList();
    message.count = object.count ?? 0;
    message.nextPage = object.nextPage ?? 0;
    message.messages = object.messages?.map((e) => Message.fromPartial(e)) || [];
    return message;
  },
};

function createBaseChannelMemberUpdate(): ChannelMemberUpdate {
  return { channelId: "", members: [] };
}

export const ChannelMemberUpdate = {
  encode(message: ChannelMemberUpdate, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    for (const v of message.members) {
      UserStub.encode(v!, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): ChannelMemberUpdate {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseChannelMemberUpdate();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.members.push(UserStub.decode(reader, reader.uint32()));
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): ChannelMemberUpdate {
    return {
      channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "",
      members: globalThis.Array.isArray(object?.members) ? object.members.map((e: any) => UserStub.fromJSON(e)) : [],
    };
  },

  toJSON(message: ChannelMemberUpdate): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    if (message.members?.length) {
      obj.members = message.members.map((e) => UserStub.toJSON(e));
    }
    return obj;
  },

  create(base?: DeepPartial<ChannelMemberUpdate>): ChannelMemberUpdate {
    return ChannelMemberUpdate.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<ChannelMemberUpdate>): ChannelMemberUpdate {
    const message = createBaseChannelMemberUpdate();
    message.channelId = object.channelId ?? "";
    message.members = object.members?.map((e) => UserStub.fromPartial(e)) || [];
    return message;
  },
};

function createBaseOpenChannelRequest(): OpenChannelRequest {
  return { channelId: "" };
}

export const OpenChannelRequest = {
  encode(message: OpenChannelRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): OpenChannelRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseOpenChannelRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): OpenChannelRequest {
    return { channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "" };
  },

  toJSON(message: OpenChannelRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    return obj;
  },

  create(base?: DeepPartial<OpenChannelRequest>): OpenChannelRequest {
    return OpenChannelRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<OpenChannelRequest>): OpenChannelRequest {
    const message = createBaseOpenChannelRequest();
    message.channelId = object.channelId ?? "";
    return message;
  },
};

function createBaseCloseChannelRequest(): CloseChannelRequest {
  return { channelId: "" };
}

export const CloseChannelRequest = {
  encode(message: CloseChannelRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): CloseChannelRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseCloseChannelRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): CloseChannelRequest {
    return { channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "" };
  },

  toJSON(message: CloseChannelRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    return obj;
  },

  create(base?: DeepPartial<CloseChannelRequest>): CloseChannelRequest {
    return CloseChannelRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<CloseChannelRequest>): CloseChannelRequest {
    const message = createBaseCloseChannelRequest();
    message.channelId = object.channelId ?? "";
    return message;
  },
};

function createBaseOpenChannelResponse(): OpenChannelResponse {
  return { messageList: undefined, message: undefined, members: undefined };
}

export const OpenChannelResponse = {
  encode(message: OpenChannelResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.messageList !== undefined) {
      MessageList.encode(message.messageList, writer.uint32(10).fork()).ldelim();
    }
    if (message.message !== undefined) {
      Message.encode(message.message, writer.uint32(18).fork()).ldelim();
    }
    if (message.members !== undefined) {
      ChannelMemberUpdate.encode(message.members, writer.uint32(26).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): OpenChannelResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseOpenChannelResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.messageList = MessageList.decode(reader, reader.uint32());
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.message = Message.decode(reader, reader.uint32());
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.members = ChannelMemberUpdate.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): OpenChannelResponse {
    return {
      messageList: isSet(object.messageList) ? MessageList.fromJSON(object.messageList) : undefined,
      message: isSet(object.message) ? Message.fromJSON(object.message) : undefined,
      members: isSet(object.members) ? ChannelMemberUpdate.fromJSON(object.members) : undefined,
    };
  },

  toJSON(message: OpenChannelResponse): unknown {
    const obj: any = {};
    if (message.messageList !== undefined) {
      obj.messageList = MessageList.toJSON(message.messageList);
    }
    if (message.message !== undefined) {
      obj.message = Message.toJSON(message.message);
    }
    if (message.members !== undefined) {
      obj.members = ChannelMemberUpdate.toJSON(message.members);
    }
    return obj;
  },

  create(base?: DeepPartial<OpenChannelResponse>): OpenChannelResponse {
    return OpenChannelResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<OpenChannelResponse>): OpenChannelResponse {
    const message = createBaseOpenChannelResponse();
    message.messageList = (object.messageList !== undefined && object.messageList !== null)
      ? MessageList.fromPartial(object.messageList)
      : undefined;
    message.message = (object.message !== undefined && object.message !== null)
      ? Message.fromPartial(object.message)
      : undefined;
    message.members = (object.members !== undefined && object.members !== null)
      ? ChannelMemberUpdate.fromPartial(object.members)
      : undefined;
    return message;
  },
};

function createBaseSendMessageRequest(): SendMessageRequest {
  return { channelId: "", text: "" };
}

export const SendMessageRequest = {
  encode(message: SendMessageRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    if (message.text !== "") {
      writer.uint32(18).string(message.text);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): SendMessageRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseSendMessageRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.text = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): SendMessageRequest {
    return {
      channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "",
      text: isSet(object.text) ? globalThis.String(object.text) : "",
    };
  },

  toJSON(message: SendMessageRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    if (message.text !== "") {
      obj.text = message.text;
    }
    return obj;
  },

  create(base?: DeepPartial<SendMessageRequest>): SendMessageRequest {
    return SendMessageRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<SendMessageRequest>): SendMessageRequest {
    const message = createBaseSendMessageRequest();
    message.channelId = object.channelId ?? "";
    message.text = object.text ?? "";
    return message;
  },
};

function createBaseSendMessageResponse(): SendMessageResponse {
  return { message: undefined };
}

export const SendMessageResponse = {
  encode(message: SendMessageResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.message !== undefined) {
      Message.encode(message.message, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): SendMessageResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseSendMessageResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.message = Message.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): SendMessageResponse {
    return { message: isSet(object.message) ? Message.fromJSON(object.message) : undefined };
  },

  toJSON(message: SendMessageResponse): unknown {
    const obj: any = {};
    if (message.message !== undefined) {
      obj.message = Message.toJSON(message.message);
    }
    return obj;
  },

  create(base?: DeepPartial<SendMessageResponse>): SendMessageResponse {
    return SendMessageResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<SendMessageResponse>): SendMessageResponse {
    const message = createBaseSendMessageResponse();
    message.message = (object.message !== undefined && object.message !== null)
      ? Message.fromPartial(object.message)
      : undefined;
    return message;
  },
};

function createBaseJoinChannelRequest(): JoinChannelRequest {
  return { channelId: "" };
}

export const JoinChannelRequest = {
  encode(message: JoinChannelRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): JoinChannelRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseJoinChannelRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): JoinChannelRequest {
    return { channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "" };
  },

  toJSON(message: JoinChannelRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    return obj;
  },

  create(base?: DeepPartial<JoinChannelRequest>): JoinChannelRequest {
    return JoinChannelRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<JoinChannelRequest>): JoinChannelRequest {
    const message = createBaseJoinChannelRequest();
    message.channelId = object.channelId ?? "";
    return message;
  },
};

function createBaseLeaveChannelRequest(): LeaveChannelRequest {
  return { channelId: "" };
}

export const LeaveChannelRequest = {
  encode(message: LeaveChannelRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): LeaveChannelRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseLeaveChannelRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): LeaveChannelRequest {
    return { channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "" };
  },

  toJSON(message: LeaveChannelRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    return obj;
  },

  create(base?: DeepPartial<LeaveChannelRequest>): LeaveChannelRequest {
    return LeaveChannelRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<LeaveChannelRequest>): LeaveChannelRequest {
    const message = createBaseLeaveChannelRequest();
    message.channelId = object.channelId ?? "";
    return message;
  },
};

function createBaseGetMessagesRequest(): GetMessagesRequest {
  return { channelId: "", page: 0 };
}

export const GetMessagesRequest = {
  encode(message: GetMessagesRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    if (message.page !== 0) {
      writer.uint32(16).uint64(message.page);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetMessagesRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetMessagesRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
        case 2:
          if (tag !== 16) {
            break;
          }

          message.page = longToNumber(reader.uint64() as Long);
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetMessagesRequest {
    return {
      channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "",
      page: isSet(object.page) ? globalThis.Number(object.page) : 0,
    };
  },

  toJSON(message: GetMessagesRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    if (message.page !== 0) {
      obj.page = Math.round(message.page);
    }
    return obj;
  },

  create(base?: DeepPartial<GetMessagesRequest>): GetMessagesRequest {
    return GetMessagesRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetMessagesRequest>): GetMessagesRequest {
    const message = createBaseGetMessagesRequest();
    message.channelId = object.channelId ?? "";
    message.page = object.page ?? 0;
    return message;
  },
};

function createBaseGetMessagesResponse(): GetMessagesResponse {
  return { messageList: undefined };
}

export const GetMessagesResponse = {
  encode(message: GetMessagesResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.messageList !== undefined) {
      MessageList.encode(message.messageList, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetMessagesResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetMessagesResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.messageList = MessageList.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetMessagesResponse {
    return { messageList: isSet(object.messageList) ? MessageList.fromJSON(object.messageList) : undefined };
  },

  toJSON(message: GetMessagesResponse): unknown {
    const obj: any = {};
    if (message.messageList !== undefined) {
      obj.messageList = MessageList.toJSON(message.messageList);
    }
    return obj;
  },

  create(base?: DeepPartial<GetMessagesResponse>): GetMessagesResponse {
    return GetMessagesResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetMessagesResponse>): GetMessagesResponse {
    const message = createBaseGetMessagesResponse();
    message.messageList = (object.messageList !== undefined && object.messageList !== null)
      ? MessageList.fromPartial(object.messageList)
      : undefined;
    return message;
  },
};

function createBaseAddChannelMemberRequest(): AddChannelMemberRequest {
  return { channelId: "", userId: "" };
}

export const AddChannelMemberRequest = {
  encode(message: AddChannelMemberRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    if (message.userId !== "") {
      writer.uint32(18).string(message.userId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): AddChannelMemberRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseAddChannelMemberRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
        case 2:
          if (tag !== 18) {
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

  fromJSON(object: any): AddChannelMemberRequest {
    return {
      channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "",
      userId: isSet(object.userId) ? globalThis.String(object.userId) : "",
    };
  },

  toJSON(message: AddChannelMemberRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    if (message.userId !== "") {
      obj.userId = message.userId;
    }
    return obj;
  },

  create(base?: DeepPartial<AddChannelMemberRequest>): AddChannelMemberRequest {
    return AddChannelMemberRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<AddChannelMemberRequest>): AddChannelMemberRequest {
    const message = createBaseAddChannelMemberRequest();
    message.channelId = object.channelId ?? "";
    message.userId = object.userId ?? "";
    return message;
  },
};

function createBaseGetChannelInfoRequest(): GetChannelInfoRequest {
  return { channelId: "" };
}

export const GetChannelInfoRequest = {
  encode(message: GetChannelInfoRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channelId !== "") {
      writer.uint32(10).string(message.channelId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetChannelInfoRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetChannelInfoRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channelId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetChannelInfoRequest {
    return { channelId: isSet(object.channelId) ? globalThis.String(object.channelId) : "" };
  },

  toJSON(message: GetChannelInfoRequest): unknown {
    const obj: any = {};
    if (message.channelId !== "") {
      obj.channelId = message.channelId;
    }
    return obj;
  },

  create(base?: DeepPartial<GetChannelInfoRequest>): GetChannelInfoRequest {
    return GetChannelInfoRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetChannelInfoRequest>): GetChannelInfoRequest {
    const message = createBaseGetChannelInfoRequest();
    message.channelId = object.channelId ?? "";
    return message;
  },
};

function createBaseGetChannelInfoResponse(): GetChannelInfoResponse {
  return { channel: undefined };
}

export const GetChannelInfoResponse = {
  encode(message: GetChannelInfoResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.channel !== undefined) {
      MessageChannelStub.encode(message.channel, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetChannelInfoResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetChannelInfoResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.channel = MessageChannelStub.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetChannelInfoResponse {
    return { channel: isSet(object.channel) ? MessageChannelStub.fromJSON(object.channel) : undefined };
  },

  toJSON(message: GetChannelInfoResponse): unknown {
    const obj: any = {};
    if (message.channel !== undefined) {
      obj.channel = MessageChannelStub.toJSON(message.channel);
    }
    return obj;
  },

  create(base?: DeepPartial<GetChannelInfoResponse>): GetChannelInfoResponse {
    return GetChannelInfoResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetChannelInfoResponse>): GetChannelInfoResponse {
    const message = createBaseGetChannelInfoResponse();
    message.channel = (object.channel !== undefined && object.channel !== null)
      ? MessageChannelStub.fromPartial(object.channel)
      : undefined;
    return message;
  },
};

export type MessageServiceDefinition = typeof MessageServiceDefinition;
export const MessageServiceDefinition = {
  name: "MessageService",
  fullName: "api.v1.MessageService",
  methods: {
    getChannels: {
      name: "GetChannels",
      requestType: Empty,
      requestStream: false,
      responseType: GetChannelsResponse,
      responseStream: false,
      options: {},
    },
    openChannel: {
      name: "OpenChannel",
      requestType: OpenChannelRequest,
      requestStream: false,
      responseType: OpenChannelResponse,
      responseStream: true,
      options: {},
    },
    closeChannel: {
      name: "CloseChannel",
      requestType: CloseChannelRequest,
      requestStream: false,
      responseType: Empty,
      responseStream: false,
      options: {},
    },
    sendMessage: {
      name: "SendMessage",
      requestType: SendMessageRequest,
      requestStream: false,
      responseType: SendMessageResponse,
      responseStream: false,
      options: {},
    },
    joinChannel: {
      name: "JoinChannel",
      requestType: JoinChannelRequest,
      requestStream: false,
      responseType: Empty,
      responseStream: false,
      options: {},
    },
    leaveChannel: {
      name: "LeaveChannel",
      requestType: LeaveChannelRequest,
      requestStream: false,
      responseType: Empty,
      responseStream: false,
      options: {},
    },
    getMessages: {
      name: "GetMessages",
      requestType: GetMessagesRequest,
      requestStream: false,
      responseType: GetMessagesResponse,
      responseStream: false,
      options: {},
    },
    addChannelMember: {
      name: "AddChannelMember",
      requestType: AddChannelMemberRequest,
      requestStream: false,
      responseType: Empty,
      responseStream: false,
      options: {},
    },
    getChannelInfo: {
      name: "GetChannelInfo",
      requestType: GetChannelInfoRequest,
      requestStream: false,
      responseType: GetChannelInfoResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface MessageServiceImplementation<CallContextExt = {}> {
  getChannels(request: Empty, context: CallContext & CallContextExt): Promise<DeepPartial<GetChannelsResponse>>;
  openChannel(
    request: OpenChannelRequest,
    context: CallContext & CallContextExt,
  ): ServerStreamingMethodResult<DeepPartial<OpenChannelResponse>>;
  closeChannel(request: CloseChannelRequest, context: CallContext & CallContextExt): Promise<DeepPartial<Empty>>;
  sendMessage(
    request: SendMessageRequest,
    context: CallContext & CallContextExt,
  ): Promise<DeepPartial<SendMessageResponse>>;
  joinChannel(request: JoinChannelRequest, context: CallContext & CallContextExt): Promise<DeepPartial<Empty>>;
  leaveChannel(request: LeaveChannelRequest, context: CallContext & CallContextExt): Promise<DeepPartial<Empty>>;
  getMessages(
    request: GetMessagesRequest,
    context: CallContext & CallContextExt,
  ): Promise<DeepPartial<GetMessagesResponse>>;
  addChannelMember(
    request: AddChannelMemberRequest,
    context: CallContext & CallContextExt,
  ): Promise<DeepPartial<Empty>>;
  getChannelInfo(
    request: GetChannelInfoRequest,
    context: CallContext & CallContextExt,
  ): Promise<DeepPartial<GetChannelInfoResponse>>;
}

export interface MessageServiceClient<CallOptionsExt = {}> {
  getChannels(request: DeepPartial<Empty>, options?: CallOptions & CallOptionsExt): Promise<GetChannelsResponse>;
  openChannel(
    request: DeepPartial<OpenChannelRequest>,
    options?: CallOptions & CallOptionsExt,
  ): AsyncIterable<OpenChannelResponse>;
  closeChannel(request: DeepPartial<CloseChannelRequest>, options?: CallOptions & CallOptionsExt): Promise<Empty>;
  sendMessage(
    request: DeepPartial<SendMessageRequest>,
    options?: CallOptions & CallOptionsExt,
  ): Promise<SendMessageResponse>;
  joinChannel(request: DeepPartial<JoinChannelRequest>, options?: CallOptions & CallOptionsExt): Promise<Empty>;
  leaveChannel(request: DeepPartial<LeaveChannelRequest>, options?: CallOptions & CallOptionsExt): Promise<Empty>;
  getMessages(
    request: DeepPartial<GetMessagesRequest>,
    options?: CallOptions & CallOptionsExt,
  ): Promise<GetMessagesResponse>;
  addChannelMember(
    request: DeepPartial<AddChannelMemberRequest>,
    options?: CallOptions & CallOptionsExt,
  ): Promise<Empty>;
  getChannelInfo(
    request: DeepPartial<GetChannelInfoRequest>,
    options?: CallOptions & CallOptionsExt,
  ): Promise<GetChannelInfoResponse>;
}

type Builtin = Date | Function | Uint8Array | string | number | boolean | undefined;

export type DeepPartial<T> = T extends Builtin ? T
  : T extends globalThis.Array<infer U> ? globalThis.Array<DeepPartial<U>>
  : T extends ReadonlyArray<infer U> ? ReadonlyArray<DeepPartial<U>>
  : T extends {} ? { [K in keyof T]?: DeepPartial<T[K]> }
  : Partial<T>;

function longToNumber(long: Long): number {
  if (long.gt(globalThis.Number.MAX_SAFE_INTEGER)) {
    throw new globalThis.Error("Value is larger than Number.MAX_SAFE_INTEGER");
  }
  return long.toNumber();
}

if (_m0.util.Long !== Long) {
  _m0.util.Long = Long as any;
  _m0.configure();
}

function isSet(value: any): boolean {
  return value !== null && value !== undefined;
}

export type ServerStreamingMethodResult<Response> = { [Symbol.asyncIterator](): AsyncIterator<Response, void> };
