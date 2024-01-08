import { Message, MessageChannelStub } from '@/generated/api/v1/messages'
import { Experience, User, schoolFromJSON } from '@/generated/api/v1/user'
import { prisma } from '@/providers'
import type * as Prisma from '@prisma/client'

type FilterKeysByValue<T, U> = { [K in keyof T]: T[K] extends U | null ? K : never }[keyof T]

type Mapping<
  K extends keyof MappingTypes,
  T extends { proto: unknown; prisma: unknown } = MappingTypes[K],
  ProtoType = T['proto'],
  PrismaType = T['prisma']
> = {
  [K in keyof ProtoType]:
    | FilterKeysByValue<PrismaType, ProtoType[K]>
    | ((t: PrismaType) => ProtoType[K] | Promise<ProtoType[K]>)
}

const defaultCampusAvailability = JSON.stringify([
  { p5: false, p6: false },
  { p5: false, p6: false },
  { p5: false, p6: false },
  { p5: false, p6: false },
  { p5: false, p6: false },
  { p5: true, p6: true },
  { p5: true, p6: true },
])

interface MappingTypes {
  user: {
    proto: User
    prisma: Prisma.User & {
      experiences?: Prisma.Experience[]
    }
  }
  experience: { proto: Experience; prisma: Prisma.Experience }
  message: { proto: Message; prisma: Prisma.Message & { user: Prisma.User } }
  channel: {
    proto: MessageChannelStub
    prisma: Prisma.MessageChannel & {
      messages: (Prisma.Message & { user: Prisma.User })[]
      pins: (Prisma.Message & { user: Prisma.User })[]
      users: Pick<Prisma.User, 'id' | 'firstName'>[]
    }
  }
}

const mappings = {
  user: {
    avatarId: 'avatarId',
    bannerId: 'bannerId',
    bio: 'bio',
    campusAvailability: (user) => {
      return JSON.parse(
        user.campusAvailability
          ? JSON.stringify(user.campusAvailability)
          : defaultCampusAvailability
      )
    },
    classOf: 'classOf',
    email: 'email',
    experiences: async (user) => {
      const experiences =
        user.experiences ??
        (await prisma.experience.findMany({
          where: {
            userId: user.id,
          },
        }))
      return Promise.all(
        experiences.map((experience) => Translator.prismaToProto.experience(experience))
      )
    },
    firstName: 'firstName',
    id: 'id',
    joined: 'created',
    lastName: 'lastName',
    school: (user) => schoolFromJSON(user.school),
    topics: 'topics',
    tuteeScore: 'tuteeScore',
    tutorScore: 'tutorScore',
    updated: 'updated',
    virtualAvailability: (user) => {
      return JSON.parse(user.virtualAvailability ? JSON.stringify(user.virtualAvailability) : '[]')
    },
  } as const,
  experience: {
    created: 'created',
    description: 'description',
    id: 'id',
    imageId: 'imageId',
    title: 'title',
    skills: 'skills',
    updated: 'updated',
  },
  message: {
    id: 'id',
    channelId: 'channelId',
    text: 'content',
    timestamp: (message) => message.created.getTime(),
    userId: 'userId',
    user: (message) => {
      return Translator.prismaToProto.user(message.user)
    },
  },
  channel: {
    id: 'id',
    name: (channel) =>
      channel.name ?? (channel.users.map((user) => user.firstName).join(', ') || 'Unnamed Channel'),
    description: 'description',
    latestMessage: async (channel) => {
      const message = channel.messages[0]
      if (!message) {
        return 'No messages yet'
      }

      return `${message.user.firstName} ${message.user.lastName}: ${message.content}`
    },
    pinnedMessageId: (channel) => channel.pins[0]?.id ?? null,
    userIds: (channel) => channel.users.map((user) => user.id),
  },
} as const satisfies { [K in keyof MappingTypes]: Mapping<K> }

interface Translator {
  prismaToProto: {
    [K in keyof MappingTypes]: (
      prismaObject: MappingTypes[K]['prisma']
    ) => Promise<MappingTypes[K]['proto']>
  }
  // protoToPrisma: {
  //   [K in keyof MappingTypes]: (protoObject: MappingTypes[K]['proto']) => MappingTypes[K]['prisma']
  // }
}

type Entries<T> = { [K in keyof T]: [K, T[K]] }[keyof T][]

const mappingEntries = Object.entries(mappings) as Entries<typeof mappings>

const Translator: Translator = {
  prismaToProto: Object.fromEntries(
    mappingEntries.map(([key, mapping]) => {
      return [
        key,
        async (prismaObject: MappingTypes[typeof key]['prisma']) => {
          const protoObject = {} as MappingTypes[typeof key]['proto']
          const map = Object.entries(mapping) as Entries<typeof mapping>
          for (const [proto, prisma] of map) {
            if (typeof prisma === 'string') {
              protoObject[proto] = prismaObject[prisma] ?? null
            } else {
              protoObject[proto] = (await (prisma as any)(prismaObject)) ?? null
            }
          }
          return protoObject
        },
      ]
    })
  ) as any,
  // protoToPrisma: {},
}

export default Translator
