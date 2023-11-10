/* eslint-disable */
import _m0 from "protobufjs/minimal";
import { Duration } from "../../google/protobuf/duration";
import { Timestamp } from "../../google/protobuf/timestamp";
import { User } from "./user";

export const protobufPackage = "api.v1";

export enum SessionType {
  SESSION_TYPE_UNSPECIFIED = 0,
  SESSION_TYPE_CAMPUS = 1,
  SESSION_TYPE_VIRTUAL = 2,
  UNRECOGNIZED = -1,
}

export function sessionTypeFromJSON(object: any): SessionType {
  switch (object) {
    case 0:
    case "SESSION_TYPE_UNSPECIFIED":
      return SessionType.SESSION_TYPE_UNSPECIFIED;
    case 1:
    case "SESSION_TYPE_CAMPUS":
      return SessionType.SESSION_TYPE_CAMPUS;
    case 2:
    case "SESSION_TYPE_VIRTUAL":
      return SessionType.SESSION_TYPE_VIRTUAL;
    case -1:
    case "UNRECOGNIZED":
    default:
      return SessionType.UNRECOGNIZED;
  }
}

export function sessionTypeToJSON(object: SessionType): string {
  switch (object) {
    case SessionType.SESSION_TYPE_UNSPECIFIED:
      return "SESSION_TYPE_UNSPECIFIED";
    case SessionType.SESSION_TYPE_CAMPUS:
      return "SESSION_TYPE_CAMPUS";
    case SessionType.SESSION_TYPE_VIRTUAL:
      return "SESSION_TYPE_VIRTUAL";
    case SessionType.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export enum SessionStatus {
  SESSION_STATUS_UNSPECIFIED = 0,
  SESSION_STATUS_AWAITING_TUTOR_APPROVAL = 1,
  SESSION_STATUS_AWAITING_TUTEE_APPROVAL = 2,
  SESSION_STATUS_DECLINED = 3,
  SESSION_STATUS_CONFIRMED = 4,
  SESSION_STATUS_COMPLETED = 5,
  SESSION_STATUS_CANCELED = 6,
  UNRECOGNIZED = -1,
}

export function sessionStatusFromJSON(object: any): SessionStatus {
  switch (object) {
    case 0:
    case "SESSION_STATUS_UNSPECIFIED":
      return SessionStatus.SESSION_STATUS_UNSPECIFIED;
    case 1:
    case "SESSION_STATUS_AWAITING_TUTOR_APPROVAL":
      return SessionStatus.SESSION_STATUS_AWAITING_TUTOR_APPROVAL;
    case 2:
    case "SESSION_STATUS_AWAITING_TUTEE_APPROVAL":
      return SessionStatus.SESSION_STATUS_AWAITING_TUTEE_APPROVAL;
    case 3:
    case "SESSION_STATUS_DECLINED":
      return SessionStatus.SESSION_STATUS_DECLINED;
    case 4:
    case "SESSION_STATUS_CONFIRMED":
      return SessionStatus.SESSION_STATUS_CONFIRMED;
    case 5:
    case "SESSION_STATUS_COMPLETED":
      return SessionStatus.SESSION_STATUS_COMPLETED;
    case 6:
    case "SESSION_STATUS_CANCELED":
      return SessionStatus.SESSION_STATUS_CANCELED;
    case -1:
    case "UNRECOGNIZED":
    default:
      return SessionStatus.UNRECOGNIZED;
  }
}

export function sessionStatusToJSON(object: SessionStatus): string {
  switch (object) {
    case SessionStatus.SESSION_STATUS_UNSPECIFIED:
      return "SESSION_STATUS_UNSPECIFIED";
    case SessionStatus.SESSION_STATUS_AWAITING_TUTOR_APPROVAL:
      return "SESSION_STATUS_AWAITING_TUTOR_APPROVAL";
    case SessionStatus.SESSION_STATUS_AWAITING_TUTEE_APPROVAL:
      return "SESSION_STATUS_AWAITING_TUTEE_APPROVAL";
    case SessionStatus.SESSION_STATUS_DECLINED:
      return "SESSION_STATUS_DECLINED";
    case SessionStatus.SESSION_STATUS_CONFIRMED:
      return "SESSION_STATUS_CONFIRMED";
    case SessionStatus.SESSION_STATUS_COMPLETED:
      return "SESSION_STATUS_COMPLETED";
    case SessionStatus.SESSION_STATUS_CANCELED:
      return "SESSION_STATUS_CANCELED";
    case SessionStatus.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export enum Attendance {
  ATTENDANCE_UNSPECIFIED = 0,
  ATTENDANCE_PRESENT = 1,
  ATTENDANCE_LATE = 2,
  ATTENDANCE_EXCUSED = 3,
  ATTENDANCE_NOSHOW = 4,
  ATTENDANCE_CANCELED = 5,
  UNRECOGNIZED = -1,
}

export function attendanceFromJSON(object: any): Attendance {
  switch (object) {
    case 0:
    case "ATTENDANCE_UNSPECIFIED":
      return Attendance.ATTENDANCE_UNSPECIFIED;
    case 1:
    case "ATTENDANCE_PRESENT":
      return Attendance.ATTENDANCE_PRESENT;
    case 2:
    case "ATTENDANCE_LATE":
      return Attendance.ATTENDANCE_LATE;
    case 3:
    case "ATTENDANCE_EXCUSED":
      return Attendance.ATTENDANCE_EXCUSED;
    case 4:
    case "ATTENDANCE_NOSHOW":
      return Attendance.ATTENDANCE_NOSHOW;
    case 5:
    case "ATTENDANCE_CANCELED":
      return Attendance.ATTENDANCE_CANCELED;
    case -1:
    case "UNRECOGNIZED":
    default:
      return Attendance.UNRECOGNIZED;
  }
}

export function attendanceToJSON(object: Attendance): string {
  switch (object) {
    case Attendance.ATTENDANCE_UNSPECIFIED:
      return "ATTENDANCE_UNSPECIFIED";
    case Attendance.ATTENDANCE_PRESENT:
      return "ATTENDANCE_PRESENT";
    case Attendance.ATTENDANCE_LATE:
      return "ATTENDANCE_LATE";
    case Attendance.ATTENDANCE_EXCUSED:
      return "ATTENDANCE_EXCUSED";
    case Attendance.ATTENDANCE_NOSHOW:
      return "ATTENDANCE_NOSHOW";
    case Attendance.ATTENDANCE_CANCELED:
      return "ATTENDANCE_CANCELED";
    case Attendance.UNRECOGNIZED:
    default:
      return "UNRECOGNIZED";
  }
}

export interface Session {
  id: string;
  created: Date | undefined;
  updated: Date | undefined;
  type: SessionType;
  status: SessionStatus;
  location?: string | undefined;
  startTime: Date | undefined;
  duration: Duration | undefined;
  description?: string | undefined;
  tutorId: string;
  tutorAttendance: Attendance;
  tutorRating: number;
  tutorNotes?: string | undefined;
  tutor: User | undefined;
  tuteeId: string;
  tuteeAttendance: Attendance;
  tuteeRating: number;
  tuteeNotes?: string | undefined;
  tutee: User | undefined;
}

function createBaseSession(): Session {
  return {
    id: "",
    created: undefined,
    updated: undefined,
    type: 0,
    status: 0,
    location: undefined,
    startTime: undefined,
    duration: undefined,
    description: undefined,
    tutorId: "",
    tutorAttendance: 0,
    tutorRating: 0,
    tutorNotes: undefined,
    tutor: undefined,
    tuteeId: "",
    tuteeAttendance: 0,
    tuteeRating: 0,
    tuteeNotes: undefined,
    tutee: undefined,
  };
}

export const Session = {
  encode(message: Session, writer: _m0.Writer = _m0.Writer.create()): _m0.Writer {
    if (message.id !== "") {
      writer.uint32(10).string(message.id);
    }
    if (message.created !== undefined) {
      Timestamp.encode(toTimestamp(message.created), writer.uint32(18).fork()).ldelim();
    }
    if (message.updated !== undefined) {
      Timestamp.encode(toTimestamp(message.updated), writer.uint32(26).fork()).ldelim();
    }
    if (message.type !== 0) {
      writer.uint32(32).int32(message.type);
    }
    if (message.status !== 0) {
      writer.uint32(40).int32(message.status);
    }
    if (message.location !== undefined) {
      writer.uint32(50).string(message.location);
    }
    if (message.startTime !== undefined) {
      Timestamp.encode(toTimestamp(message.startTime), writer.uint32(58).fork()).ldelim();
    }
    if (message.duration !== undefined) {
      Duration.encode(message.duration, writer.uint32(66).fork()).ldelim();
    }
    if (message.description !== undefined) {
      writer.uint32(74).string(message.description);
    }
    if (message.tutorId !== "") {
      writer.uint32(82).string(message.tutorId);
    }
    if (message.tutorAttendance !== 0) {
      writer.uint32(88).int32(message.tutorAttendance);
    }
    if (message.tutorRating !== 0) {
      writer.uint32(96).uint32(message.tutorRating);
    }
    if (message.tutorNotes !== undefined) {
      writer.uint32(106).string(message.tutorNotes);
    }
    if (message.tutor !== undefined) {
      User.encode(message.tutor, writer.uint32(146).fork()).ldelim();
    }
    if (message.tuteeId !== "") {
      writer.uint32(114).string(message.tuteeId);
    }
    if (message.tuteeAttendance !== 0) {
      writer.uint32(120).int32(message.tuteeAttendance);
    }
    if (message.tuteeRating !== 0) {
      writer.uint32(128).uint32(message.tuteeRating);
    }
    if (message.tuteeNotes !== undefined) {
      writer.uint32(138).string(message.tuteeNotes);
    }
    if (message.tutee !== undefined) {
      User.encode(message.tutee, writer.uint32(154).fork()).ldelim();
    }
    return writer;
  },

  decode(input: _m0.Reader | Uint8Array, length?: number): Session {
    const reader = input instanceof _m0.Reader ? input : _m0.Reader.create(input);
    let end = length === undefined ? reader.len : reader.pos + length;
    const message = createBaseSession();
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
          if (tag !== 32) {
            break;
          }

          message.type = reader.int32() as any;
          continue;
        case 5:
          if (tag !== 40) {
            break;
          }

          message.status = reader.int32() as any;
          continue;
        case 6:
          if (tag !== 50) {
            break;
          }

          message.location = reader.string();
          continue;
        case 7:
          if (tag !== 58) {
            break;
          }

          message.startTime = fromTimestamp(Timestamp.decode(reader, reader.uint32()));
          continue;
        case 8:
          if (tag !== 66) {
            break;
          }

          message.duration = Duration.decode(reader, reader.uint32());
          continue;
        case 9:
          if (tag !== 74) {
            break;
          }

          message.description = reader.string();
          continue;
        case 10:
          if (tag !== 82) {
            break;
          }

          message.tutorId = reader.string();
          continue;
        case 11:
          if (tag !== 88) {
            break;
          }

          message.tutorAttendance = reader.int32() as any;
          continue;
        case 12:
          if (tag !== 96) {
            break;
          }

          message.tutorRating = reader.uint32();
          continue;
        case 13:
          if (tag !== 106) {
            break;
          }

          message.tutorNotes = reader.string();
          continue;
        case 18:
          if (tag !== 146) {
            break;
          }

          message.tutor = User.decode(reader, reader.uint32());
          continue;
        case 14:
          if (tag !== 114) {
            break;
          }

          message.tuteeId = reader.string();
          continue;
        case 15:
          if (tag !== 120) {
            break;
          }

          message.tuteeAttendance = reader.int32() as any;
          continue;
        case 16:
          if (tag !== 128) {
            break;
          }

          message.tuteeRating = reader.uint32();
          continue;
        case 17:
          if (tag !== 138) {
            break;
          }

          message.tuteeNotes = reader.string();
          continue;
        case 19:
          if (tag !== 154) {
            break;
          }

          message.tutee = User.decode(reader, reader.uint32());
          continue;
      }
      if ((tag & 7) === 4 || tag === 0) {
        break;
      }
      reader.skipType(tag & 7);
    }
    return message;
  },

  fromJSON(object: any): Session {
    return {
      id: isSet(object.id) ? globalThis.String(object.id) : "",
      created: isSet(object.created) ? fromJsonTimestamp(object.created) : undefined,
      updated: isSet(object.updated) ? fromJsonTimestamp(object.updated) : undefined,
      type: isSet(object.type) ? sessionTypeFromJSON(object.type) : 0,
      status: isSet(object.status) ? sessionStatusFromJSON(object.status) : 0,
      location: isSet(object.location) ? globalThis.String(object.location) : undefined,
      startTime: isSet(object.startTime) ? fromJsonTimestamp(object.startTime) : undefined,
      duration: isSet(object.duration) ? Duration.fromJSON(object.duration) : undefined,
      description: isSet(object.description) ? globalThis.String(object.description) : undefined,
      tutorId: isSet(object.tutorId) ? globalThis.String(object.tutorId) : "",
      tutorAttendance: isSet(object.tutorAttendance) ? attendanceFromJSON(object.tutorAttendance) : 0,
      tutorRating: isSet(object.tutorRating) ? globalThis.Number(object.tutorRating) : 0,
      tutorNotes: isSet(object.tutorNotes) ? globalThis.String(object.tutorNotes) : undefined,
      tutor: isSet(object.tutor) ? User.fromJSON(object.tutor) : undefined,
      tuteeId: isSet(object.tuteeId) ? globalThis.String(object.tuteeId) : "",
      tuteeAttendance: isSet(object.tuteeAttendance) ? attendanceFromJSON(object.tuteeAttendance) : 0,
      tuteeRating: isSet(object.tuteeRating) ? globalThis.Number(object.tuteeRating) : 0,
      tuteeNotes: isSet(object.tuteeNotes) ? globalThis.String(object.tuteeNotes) : undefined,
      tutee: isSet(object.tutee) ? User.fromJSON(object.tutee) : undefined,
    };
  },

  toJSON(message: Session): unknown {
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
    if (message.type !== 0) {
      obj.type = sessionTypeToJSON(message.type);
    }
    if (message.status !== 0) {
      obj.status = sessionStatusToJSON(message.status);
    }
    if (message.location !== undefined) {
      obj.location = message.location;
    }
    if (message.startTime !== undefined) {
      obj.startTime = message.startTime.toISOString();
    }
    if (message.duration !== undefined) {
      obj.duration = Duration.toJSON(message.duration);
    }
    if (message.description !== undefined) {
      obj.description = message.description;
    }
    if (message.tutorId !== "") {
      obj.tutorId = message.tutorId;
    }
    if (message.tutorAttendance !== 0) {
      obj.tutorAttendance = attendanceToJSON(message.tutorAttendance);
    }
    if (message.tutorRating !== 0) {
      obj.tutorRating = Math.round(message.tutorRating);
    }
    if (message.tutorNotes !== undefined) {
      obj.tutorNotes = message.tutorNotes;
    }
    if (message.tutor !== undefined) {
      obj.tutor = User.toJSON(message.tutor);
    }
    if (message.tuteeId !== "") {
      obj.tuteeId = message.tuteeId;
    }
    if (message.tuteeAttendance !== 0) {
      obj.tuteeAttendance = attendanceToJSON(message.tuteeAttendance);
    }
    if (message.tuteeRating !== 0) {
      obj.tuteeRating = Math.round(message.tuteeRating);
    }
    if (message.tuteeNotes !== undefined) {
      obj.tuteeNotes = message.tuteeNotes;
    }
    if (message.tutee !== undefined) {
      obj.tutee = User.toJSON(message.tutee);
    }
    return obj;
  },

  create(base?: DeepPartial<Session>): Session {
    return Session.fromPartial(base ?? {});
  },
  fromPartial(object: DeepPartial<Session>): Session {
    const message = createBaseSession();
    message.id = object.id ?? "";
    message.created = object.created ?? undefined;
    message.updated = object.updated ?? undefined;
    message.type = object.type ?? 0;
    message.status = object.status ?? 0;
    message.location = object.location ?? undefined;
    message.startTime = object.startTime ?? undefined;
    message.duration = (object.duration !== undefined && object.duration !== null)
      ? Duration.fromPartial(object.duration)
      : undefined;
    message.description = object.description ?? undefined;
    message.tutorId = object.tutorId ?? "";
    message.tutorAttendance = object.tutorAttendance ?? 0;
    message.tutorRating = object.tutorRating ?? 0;
    message.tutorNotes = object.tutorNotes ?? undefined;
    message.tutor = (object.tutor !== undefined && object.tutor !== null) ? User.fromPartial(object.tutor) : undefined;
    message.tuteeId = object.tuteeId ?? "";
    message.tuteeAttendance = object.tuteeAttendance ?? 0;
    message.tuteeRating = object.tuteeRating ?? 0;
    message.tuteeNotes = object.tuteeNotes ?? undefined;
    message.tutee = (object.tutee !== undefined && object.tutee !== null) ? User.fromPartial(object.tutee) : undefined;
    return message;
  },
};

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
