/* eslint-disable */
import type { CallContext, CallOptions } from "nice-grpc-common";
import _m0 from "protobufjs/minimal";
import { Timestamp } from "../../google/protobuf/timestamp";
import { DayOfWeek, dayOfWeekFromJSON, dayOfWeekToJSON } from "../../google/type/dayofweek";
import { Interval } from "../../google/type/interval";

export const protobufPackage = "api.v1";

export enum School {
  SCHOOL_UNSPECIFIED = 0,
  SCHOOL_AAHS = 1,
  SCHOOL_AIT = 2,
  SCHOOL_APA = 3,
  SCHOOL_MHS = 4,
  SCHOOL_UCTECH = 5,
  UNRECOGNIZED = -1,
}

export function schoolFromJSON(object: any): School {
  switch (object) {
    case 0:
    case "SCHOOL_UNSPECIFIED":
      return School.SCHOOL_UNSPECIFIED;
    case 1:
    case "SCHOOL_AAHS":
      return School.SCHOOL_AAHS;
    case 2:
    case "SCHOOL_AIT":
      return School.SCHOOL_AIT;
    case 3:
    case "SCHOOL_APA":
      return School.SCHOOL_APA;
    case 4:
    case "SCHOOL_MHS":
      return School.SCHOOL_MHS;
    case 5:
    case "SCHOOL_UCTECH":
      return School.SCHOOL_UCTECH;
    case -1:
    case "UNRECOGNIZED":
    default:
      return School.UNRECOGNIZED;
  }
}

export function schoolToJSON(object: School): string {
  switch (object) {
    case School.SCHOOL_UNSPECIFIED:
      return "SCHOOL_UNSPECIFIED";
    case School.SCHOOL_AAHS:
      return "SCHOOL_AAHS";
    case School.SCHOOL_AIT:
      return "SCHOOL_AIT";
    case School.SCHOOL_APA:
      return "SCHOOL_APA";
    case School.SCHOOL_MHS:
      return "SCHOOL_MHS";
    case School.SCHOOL_UCTECH:
      return "SCHOOL_UCTECH";
    case School.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export interface User {
  id: string;
  joined: Date | undefined;
  updated: Date | undefined;
  email: string;
  firstName: string;
  lastName: string;
  school: School;
  classOf: number;
  bio: string;
  avatarId: string;
  bannerId: string;
  campusAvailability: CampusAvailability[];
  virtualAvailability: VirtualAvailability[];
  topics: string[];
  tutorScore: number;
  tuteeScore: number;
  experiences: Experience[];
}

export interface UserStub {
  id: string;
  joined: Date | undefined;
  updated: Date | undefined;
  firstName: string;
  lastName: string;
  school: School;
  classOf: number;
  bio: string;
  avatarId: string;
  bannerId: string;
  tutorScore: number;
  tuteeScore: number;
}

export interface CampusAvailability {
  p5: boolean;
  p6: boolean;
}

export interface VirtualAvailability {
  day: DayOfWeek;
  interval: Interval | undefined;
}

export interface Experience {
  id: string;
  created: Date | undefined;
  updated: Date | undefined;
  title: string;
  description: string;
  skills: string[];
  imageId: string;
}

export interface GetUserRequest {
  id: string;
}

export interface GetUserResponse {
  user: User | undefined;
}

function createBaseUser(): User {
  return {
    id: "",
    joined: undefined,
    updated: undefined,
    email: "",
    firstName: "",
    lastName: "",
    school: 0,
    classOf: 0,
    bio: "",
    avatarId: "",
    bannerId: "",
    campusAvailability: [],
    virtualAvailability: [],
    topics: [],
    tutorScore: 0,
    tuteeScore: 0,
    experiences: [],
  };
}

export const User = {
  encode(message: User, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.joined !== undefined) {
      Timestamp.encode(toTimestamp(message.joined), writer.uint32(18).fork()).ldelim();
    }
    if (message.updated !== undefined) {
      Timestamp.encode(toTimestamp(message.updated), writer.uint32(26).fork()).ldelim();
    }
    if (message.email !== "") {
      writer.uint32(34).string(message.email);
    }
    if (message.firstName !== "") {
      writer.uint32(42).string(message.firstName);
    }
    if (message.lastName !== "") {
      writer.uint32(50).string(message.lastName);
    }
    if (message.school !== 0) {
      writer.uint32(56).int32(message.school);
    }
    if (message.classOf !== 0) {
      writer.uint32(64).uint32(message.classOf);
    }
    if (message.bio !== "") {
      writer.uint32(74).string(message.bio);
    }
    if (message.avatarId !== "") {
      writer.uint32(82).string(message.avatarId);
    }
    if (message.bannerId !== "") {
      writer.uint32(90).string(message.bannerId);
    }
    for (const v of message.campusAvailability) {
      CampusAvailability.encode(v!, writer.uint32(98).fork()).ldelim();
    }
    for (const v of message.virtualAvailability) {
      VirtualAvailability.encode(v!, writer.uint32(106).fork()).ldelim();
    }
    for (const v of message.topics) {
      writer.uint32(114).string(v!);
    }
    if (message.tutorScore !== 0) {
      writer.uint32(120).uint32(message.tutorScore);
    }
    if (message.tuteeScore !== 0) {
      writer.uint32(128).uint32(message.tuteeScore);
    }
    for (const v of message.experiences) {
      Experience.encode(v!, writer.uint32(138).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): User {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseUser();
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

          message.joined = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.updated = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.email = reader.string();
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          message.firstName = reader.string();
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.lastName = reader.string();
          continue;
        case 7:
          if (tag !== 56) {
            break;
          }

          message.school = reader.int32() as any;
          continue;
        case 8:
          if (tag !== 64) {
            break;
          }

          message.classOf = reader.uint32();
          continue;
        case 9:
          if (tag !== 74) {
            break;
          }

          message.bio = reader.string();
          continue;
        case 10:
          if (tag !== 82) {
            break;
          }

          message.avatarId = reader.string();
          continue;
        case 11:
          if (tag !== 90) {
            break;
          }

          message.bannerId = reader.string();
          continue;
        case 12:
          if (tag !== 98) {
            break;
          }

          message.campusAvailability.push(CampusAvailability.decode(reader, reader.uint32()));
          continue;
        case 13:
          if (tag !== 106) {
            break;
          }

          message.virtualAvailability.push(VirtualAvailability.decode(reader, reader.uint32()));
          continue;
        case 14:
          if (tag !== 114) {
            break;
          }

          message.topics.push(reader.string());
          continue;
        case 15:
          if (tag !== 120) {
            break;
          }

          message.tutorScore = reader.uint32();
          continue;
        case 16:
          if (tag !== 128) {
            break;
          }

          message.tuteeScore = reader.uint32();
          continue;
        case 17:
          if (tag !== 138) {
            break;
          }

          message.experiences.push(Experience.decode(reader, reader.uint32()));
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): User {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      joined: isSet(object.joined) ? fromJsonTimestamp(object.joined) : undefined,
      updated: isSet(object.updated) ? fromJsonTimestamp(object.updated) : undefined,
      email: isSet(object.email) ? globalThis.String(object.email) : "",
      firstName: isSet(object.firstName) ? globalThis.String(object.firstName) : "",
      lastName: isSet(object.lastName) ? globalThis.String(object.lastName) : "",
      school: isSet(object.school) ? schoolFromJSON(object.school) : 0,
      classOf: isSet(object.classOf) ? globalThis.Number(object.classOf) : 0,
      bio: isSet(object.bio) ? globalThis.String(object.bio) : "",
      avatarId: isSet(object.avatarId) ? globalThis.String(object.avatarId) : "",
      bannerId: isSet(object.bannerId) ? globalThis.String(object.bannerId) : "",
      campusAvailability: globalThis.Array.isArray(object?.campusAvailability)
        ? object.campusAvailability.map((e: any) => CampusAvailability.fromJSON(e))
        : [],
      virtualAvailability: globalThis.Array.isArray(object?.virtualAvailability)
        ? object.virtualAvailability.map((e: any) => VirtualAvailability.fromJSON(e))
        : [],
      topics: globalThis.Array.isArray(object?.topics) ? object.topics.map((e: any) => globalThis.String(e)) : [],
      tutorScore: isSet(object.tutorScore) ? globalThis.Number(object.tutorScore) : 0,
      tuteeScore: isSet(object.tuteeScore) ? globalThis.Number(object.tuteeScore) : 0,
      experiences: globalThis.Array.isArray(object?.experiences)
        ? object.experiences.map((e: any) => Experience.fromJSON(e))
        : [],
    };
  },

  toJSON(message: User): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    if (message.joined !== undefined) {
      obj.joined = message.joined.toISOString();
    }
    if (message.updated !== undefined) {
      obj.updated = message.updated.toISOString();
    }
    if (message.email !== "") {
      obj.email = message.email;
    }
    if (message.firstName !== "") {
      obj.firstName = message.firstName;
    }
    if (message.lastName !== "") {
      obj.lastName = message.lastName;
    }
    if (message.school !== 0) {
      obj.school = schoolToJSON(message.school);
    }
    if (message.classOf !== 0) {
      obj.classOf = Math.round(message.classOf);
    }
    if (message.bio !== "") {
      obj.bio = message.bio;
    }
    if (message.avatarId !== "") {
      obj.avatarId = message.avatarId;
    }
    if (message.bannerId !== "") {
      obj.bannerId = message.bannerId;
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
    if (message.tutorScore !== 0) {
      obj.tutorScore = Math.round(message.tutorScore);
    }
    if (message.tuteeScore !== 0) {
      obj.tuteeScore = Math.round(message.tuteeScore);
    }
    if (message.experiences?.length) {
      obj.experiences = message.experiences.map((e) => Experience.toJSON(e));
    }
    return obj;
  },

  create(base?: DeepPartial<User>): User {
    return User.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<User>): User {
    const message = createBaseUser();
    message.id = object.id ?? "";
    message.joined = object.joined ?? undefined;
    message.updated = object.updated ?? undefined;
    message.email = object.email ?? "";
    message.firstName = object.firstName ?? "";
    message.lastName = object.lastName ?? "";
    message.school = object.school ?? 0;
    message.classOf = object.classOf ?? 0;
    message.bio = object.bio ?? "";
    message.avatarId = object.avatarId ?? "";
    message.bannerId = object.bannerId ?? "";
    message.campusAvailability = object.campusAvailability?.map((e) => CampusAvailability.fromPartial(e)) || [];
    message.virtualAvailability = object.virtualAvailability?.map((e) => VirtualAvailability.fromPartial(e)) || [];
    message.topics = object.topics?.map((e) => e) || [];
    message.tutorScore = object.tutorScore ?? 0;
    message.tuteeScore = object.tuteeScore ?? 0;
    message.experiences = object.experiences?.map((e) => Experience.fromPartial(e)) || [];
    return message;
  },
};

function createBaseUserStub(): UserStub {
  return {
    id: "",
    joined: undefined,
    updated: undefined,
    firstName: "",
    lastName: "",
    school: 0,
    classOf: 0,
    bio: "",
    avatarId: "",
    bannerId: "",
    tutorScore: 0,
    tuteeScore: 0,
  };
}

export const UserStub = {
  encode(message: UserStub, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.joined !== undefined) {
      Timestamp.encode(toTimestamp(message.joined), writer.uint32(18).fork()).ldelim();
    }
    if (message.updated !== undefined) {
      Timestamp.encode(toTimestamp(message.updated), writer.uint32(26).fork()).ldelim();
    }
    if (message.firstName !== "") {
      writer.uint32(34).string(message.firstName);
    }
    if (message.lastName !== "") {
      writer.uint32(42).string(message.lastName);
    }
    if (message.school !== 0) {
      writer.uint32(48).int32(message.school);
    }
    if (message.classOf !== 0) {
      writer.uint32(56).uint32(message.classOf);
    }
    if (message.bio !== "") {
      writer.uint32(66).string(message.bio);
    }
    if (message.avatarId !== "") {
      writer.uint32(74).string(message.avatarId);
    }
    if (message.bannerId !== "") {
      writer.uint32(82).string(message.bannerId);
    }
    if (message.tutorScore !== 0) {
      writer.uint32(112).uint32(message.tutorScore);
    }
    if (message.tuteeScore !== 0) {
      writer.uint32(120).uint32(message.tuteeScore);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): UserStub {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseUserStub();
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

          message.joined = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.updated = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.firstName = reader.string();
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          message.lastName = reader.string();
          continue;
        case 6:
          if (tag !== 48) {
            break;
          }

          message.school = reader.int32() as any;
          continue;
        case 7:
          if (tag !== 56) {
            break;
          }

          message.classOf = reader.uint32();
          continue;
        case 8:
          if (tag !== 66) {
            break;
          }

          message.bio = reader.string();
          continue;
        case 9:
          if (tag !== 74) {
            break;
          }

          message.avatarId = reader.string();
          continue;
        case 10:
          if (tag !== 82) {
            break;
          }

          message.bannerId = reader.string();
          continue;
        case 14:
          if (tag !== 112) {
            break;
          }

          message.tutorScore = reader.uint32();
          continue;
        case 15:
          if (tag !== 120) {
            break;
          }

          message.tuteeScore = reader.uint32();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): UserStub {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      joined: isSet(object.joined) ? fromJsonTimestamp(object.joined) : undefined,
      updated: isSet(object.updated) ? fromJsonTimestamp(object.updated) : undefined,
      firstName: isSet(object.firstName) ? globalThis.String(object.firstName) : "",
      lastName: isSet(object.lastName) ? globalThis.String(object.lastName) : "",
      school: isSet(object.school) ? schoolFromJSON(object.school) : 0,
      classOf: isSet(object.classOf) ? globalThis.Number(object.classOf) : 0,
      bio: isSet(object.bio) ? globalThis.String(object.bio) : "",
      avatarId: isSet(object.avatarId) ? globalThis.String(object.avatarId) : "",
      bannerId: isSet(object.bannerId) ? globalThis.String(object.bannerId) : "",
      tutorScore: isSet(object.tutorScore) ? globalThis.Number(object.tutorScore) : 0,
      tuteeScore: isSet(object.tuteeScore) ? globalThis.Number(object.tuteeScore) : 0,
    };
  },

  toJSON(message: UserStub): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    if (message.joined !== undefined) {
      obj.joined = message.joined.toISOString();
    }
    if (message.updated !== undefined) {
      obj.updated = message.updated.toISOString();
    }
    if (message.firstName !== "") {
      obj.firstName = message.firstName;
    }
    if (message.lastName !== "") {
      obj.lastName = message.lastName;
    }
    if (message.school !== 0) {
      obj.school = schoolToJSON(message.school);
    }
    if (message.classOf !== 0) {
      obj.classOf = Math.round(message.classOf);
    }
    if (message.bio !== "") {
      obj.bio = message.bio;
    }
    if (message.avatarId !== "") {
      obj.avatarId = message.avatarId;
    }
    if (message.bannerId !== "") {
      obj.bannerId = message.bannerId;
    }
    if (message.tutorScore !== 0) {
      obj.tutorScore = Math.round(message.tutorScore);
    }
    if (message.tuteeScore !== 0) {
      obj.tuteeScore = Math.round(message.tuteeScore);
    }
    return obj;
  },

  create(base?: DeepPartial<UserStub>): UserStub {
    return UserStub.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<UserStub>): UserStub {
    const message = createBaseUserStub();
    message.id = object.id ?? "";
    message.joined = object.joined ?? undefined;
    message.updated = object.updated ?? undefined;
    message.firstName = object.firstName ?? "";
    message.lastName = object.lastName ?? "";
    message.school = object.school ?? 0;
    message.classOf = object.classOf ?? 0;
    message.bio = object.bio ?? "";
    message.avatarId = object.avatarId ?? "";
    message.bannerId = object.bannerId ?? "";
    message.tutorScore = object.tutorScore ?? 0;
    message.tuteeScore = object.tuteeScore ?? 0;
    return message;
  },
};

function createBaseCampusAvailability(): CampusAvailability {
  return { p5: false, p6: false };
}

export const CampusAvailability = {
  encode(message: CampusAvailability, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.p5 === true) {
      writer.uint32(8).bool(message.p5);
    }
    if (message.p6 === true) {
      writer.uint32(16).bool(message.p6);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): CampusAvailability {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseCampusAvailability();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.p5 = reader.bool();
          continue;
        case 2:
          if (tag !== 16) {
            break;
          }

          message.p6 = reader.bool();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): CampusAvailability {
    return {
      p5: isSet(object.p5) ? globalThis.Boolean(object.p5) : false,
      p6: isSet(object.p6) ? globalThis.Boolean(object.p6) : false,
    };
  },

  toJSON(message: CampusAvailability): unknown {
    const obj: any = {};
    if (message.p5 === true) {
      obj.p5 = message.p5;
    }
    if (message.p6 === true) {
      obj.p6 = message.p6;
    }
    return obj;
  },

  create(base?: DeepPartial<CampusAvailability>): CampusAvailability {
    return CampusAvailability.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<CampusAvailability>): CampusAvailability {
    const message = createBaseCampusAvailability();
    message.p5 = object.p5 ?? false;
    message.p6 = object.p6 ?? false;
    return message;
  },
};

function createBaseVirtualAvailability(): VirtualAvailability {
  return { day: 0, interval: undefined };
}

export const VirtualAvailability = {
  encode(message: VirtualAvailability, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.day !== 0) {
      writer.uint32(8).int32(message.day);
    }
    if (message.interval !== undefined) {
      Interval.encode(message.interval, writer.uint32(18).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): VirtualAvailability {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseVirtualAvailability();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 8) {
            break;
          }

          message.day = reader.int32() as any;
          continue;
        case 2:
          if (tag !== 18) {
            break;
          }

          message.interval = Interval.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): VirtualAvailability {
    return {
      day: isSet(object.day) ? dayOfWeekFromJSON(object.day) : 0,
      interval: isSet(object.interval) ? Interval.fromJSON(object.interval) : undefined,
    };
  },

  toJSON(message: VirtualAvailability): unknown {
    const obj: any = {};
    if (message.day !== 0) {
      obj.day = dayOfWeekToJSON(message.day);
    }
    if (message.interval !== undefined) {
      obj.interval = Interval.toJSON(message.interval);
    }
    return obj;
  },

  create(base?: DeepPartial<VirtualAvailability>): VirtualAvailability {
    return VirtualAvailability.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<VirtualAvailability>): VirtualAvailability {
    const message = createBaseVirtualAvailability();
    message.day = object.day ?? 0;
    message.interval = (object.interval !== undefined && object.interval !== null)
      ? Interval.fromPartial(object.interval)
      : undefined;
    return message;
  },
};

function createBaseExperience(): Experience {
  return { id: "", created: undefined, updated: undefined, title: "", description: "", skills: [], imageId: "" };
}

export const Experience = {
  encode(message: Experience, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.created !== undefined) {
      Timestamp.encode(toTimestamp(message.created), writer.uint32(18).fork()).ldelim();
    }
    if (message.updated !== undefined) {
      Timestamp.encode(toTimestamp(message.updated), writer.uint32(26).fork()).ldelim();
    }
    if (message.title !== "") {
      writer.uint32(34).string(message.title);
    }
    if (message.description !== "") {
      writer.uint32(42).string(message.description);
    }
    for (const v of message.skills) {
      writer.uint32(50).string(v!);
    }
    if (message.imageId !== "") {
      writer.uint32(58).string(message.imageId);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): Experience {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseExperience();
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

          message.created = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 3:
          if (tag !== 26) {
            break;
          }

          message.updated = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 4:
          if (tag !== 34) {
            break;
          }

          message.title = reader.string();
          continue;
        case 5:
          if (tag !== 42) {
            break;
          }

          message.description = reader.string();
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.skills.push(reader.string());
          continue;
        case 7:
          if (tag !== 58) {
            break;
          }

          message.imageId = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): Experience {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      created: isSet(object.created) ? fromJsonTimestamp(object.created) : undefined,
      updated: isSet(object.updated) ? fromJsonTimestamp(object.updated) : undefined,
      title: isSet(object.title) ? globalThis.String(object.title) : "",
      description: isSet(object.description) ? globalThis.String(object.description) : "",
      skills: globalThis.Array.isArray(object?.skills) ? object.skills.map((e: any) => globalThis.String(e)) : [],
      imageId: isSet(object.imageId) ? globalThis.String(object.imageId) : "",
    };
  },

  toJSON(message: Experience): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    if (message.created !== undefined) {
      obj.created = message.created.toISOString();
    }
    if (message.updated !== undefined) {
      obj.updated = message.updated.toISOString();
    }
    if (message.title !== "") {
      obj.title = message.title;
    }
    if (message.description !== "") {
      obj.description = message.description;
    }
    if (message.skills?.length) {
      obj.skills = message.skills;
    }
    if (message.imageId !== "") {
      obj.imageId = message.imageId;
    }
    return obj;
  },

  create(base?: DeepPartial<Experience>): Experience {
    return Experience.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<Experience>): Experience {
    const message = createBaseExperience();
    message.id = object.id ?? "";
    message.created = object.created ?? undefined;
    message.updated = object.updated ?? undefined;
    message.title = object.title ?? "";
    message.description = object.description ?? "";
    message.skills = object.skills?.map((e) => e) || [];
    message.imageId = object.imageId ?? "";
    return message;
  },
};

function createBaseGetUserRequest(): GetUserRequest {
  return { id: "" };
}

export const GetUserRequest = {
  encode(message: GetUserRequest, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetUserRequest {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetUserRequest();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.id = reader.string();
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetUserRequest {
    return { id: isSet(object.id) ? globalThis.String(object.id) : "" };
  },

  toJSON(message: GetUserRequest): unknown {
    const obj: any = {};
    if (message.id !== "") {
      obj.id = message.id;
    }
    return obj;
  },

  create(base?: DeepPartial<GetUserRequest>): GetUserRequest {
    return GetUserRequest.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetUserRequest>): GetUserRequest {
    const message = createBaseGetUserRequest();
    message.id = object.id ?? "";
    return message;
  },
};

function createBaseGetUserResponse(): GetUserResponse {
  return { user: undefined };
}

export const GetUserResponse = {
  encode(message: GetUserResponse, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.user !== undefined) {
      User.encode(message.user, writer.uint32(10).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): GetUserResponse {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseGetUserResponse();
    while (reader.pos < end) {
      const tag = reader.uint32();
      switch (tag >>> 3) {
        case 1:
          if (tag !== 10) {
            break;
          }

          message.user = User.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): GetUserResponse {
    return { user: isSet(object.user) ? User.fromJSON(object.user) : undefined };
  },

  toJSON(message: GetUserResponse): unknown {
    const obj: any = {};
    if (message.user !== undefined) {
      obj.user = User.toJSON(message.user);
    }
    return obj;
  },

  create(base?: DeepPartial<GetUserResponse>): GetUserResponse {
    return GetUserResponse.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<GetUserResponse>): GetUserResponse {
    const message = createBaseGetUserResponse();
    message.user = (object.user !== undefined && object.user !== null) ? User.fromPartial(object.user) : undefined;
    return message;
  },
};

export type UserServiceDefinition = typeof UserServiceDefinition;
export const UserServiceDefinition = {
  name: "UserService",
  fullName: "api.v1.UserService",
  methods: {
    getUser: {
      name: "GetUser",
      requestType: GetUserRequest,
      requestStream: false,
      responseType: GetUserResponse,
      responseStream: false,
      options: {},
    },
  },
} as const;

export interface UserServiceImplementation<CallContextExt = {}> {
  getUser(request: GetUserRequest, context: CallContext & CallContextExt): Promise<DeepPartial<GetUserResponse>>;
}

export interface UserServiceClient<CallOptionsExt = {}> {
  getUser(request: DeepPartial<GetUserRequest>, options?: CallOptions & CallOptionsExt): Promise<GetUserResponse>;
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
