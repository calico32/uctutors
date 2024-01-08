import { DeepPartial, Message, MessageServiceImplementation } from '@/generated/api/v1/messages'
import { schoolFromJSON } from '@/generated/api/v1/user'
import { prisma } from '@/providers'
import { AuthSession, Session } from '@/session'
import { ServerError, Status } from 'nice-grpc'
import { v4 as uuidv4 } from 'uuid'

const sockets = new Map<string, EventTarget>()

class MessageEvent extends Event {
  constructor(public data: DeepPartial<Message>) {
    super('message')
  }
}

function socketKey(userId: string, channelId: string) {
  return `${userId}:${channelId}`
}

export const MessageService: MessageServiceImplementation = {
  async getChannels(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    const channels = await prisma.messageChannel.findMany({
      where: {
        OR: [
          {
            public: true,
          },
          {
            users: { some: { id: session.value.userId } },
          },
        ],
      },
      include: {
        messages: {
          orderBy: { created: 'desc' },
          take: 1,
          include: { user: { select: { firstName: true, lastName: true } } },
        },
        pins: { orderBy: { created: 'desc' }, take: 1 },
        users: { select: { id: true, firstName: true } },
      },
    })

    // move global channel to front
    const globalIndex = channels.findIndex((channel) => channel.id === 'global')
    if (globalIndex !== -1) {
      channels.splice(0, 0, channels.splice(globalIndex, 1)[0])
    }

    return {
      channels: channels.map((channel) => {
        const m = channel.messages[0]
        return {
          id: channel.id,
          name:
            channel.name ??
            (channel.users.map((user) => user.firstName).join(', ') || 'Unnamed Channel'),
          description: channel.description ?? undefined,
          public: channel.public,
          latestMessage: m
            ? `${m.user.firstName} ${m.user.lastName}: ${m.content}`
            : `No messages yet`,
          pinnedMessageId: channel.pins[0]?.id,
          userIds: channel.users.map((user) => user.id),
        }
      }),
    }
  },

  openChannel(request, context) {
    return (async function* () {
      const session = await Session.get<AuthSession>(context.metadata)
      if (!session.ok) {
        throw new ServerError(Status.UNAUTHENTICATED, '')
      }

      if (!request.channelId) {
        throw new ServerError(Status.INVALID_ARGUMENT, '')
      }

      const channel = await prisma.messageChannel.findUnique({
        where: {
          id: request.channelId,
        },
        include: {
          users: { select: { id: true } },
          messages: { orderBy: { created: 'desc' }, take: 50 },
        },
      })

      if (
        !channel ||
        (!channel.public && !channel.users.some((user) => user.id === session.value.userId))
      ) {
        throw new ServerError(Status.NOT_FOUND, '')
      }

      yield {
        messageList: {
          messages: channel.messages,
          count: channel.messages.length,
          nextPage: channel.messages[channel.messages.length - 1]?.created.getTime() ?? null,
        },
      }

      let resolve: (value: DeepPartial<Message> | null | PromiseLike<DeepPartial<Message>>) => void
      let next = new Promise<DeepPartial<Message> | null>((r) => (resolve = r))

      sockets.set(
        socketKey(session.value.userId, request.channelId),
        new (class extends EventTarget {
          constructor() {
            super()
            this.addEventListener('message', (event) => {
              if (!(event instanceof MessageEvent)) return
              resolve(event.data)
            })
            this.addEventListener('close', () => {
              resolve(null)
            })
          }
        })()
      )

      while (true) {
        const message = await next
        next = new Promise<DeepPartial<Message> | null>((r) => (resolve = r))
        if (!message) break
        yield { message }
      }
    })()
  },

  async closeChannel(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const socket = sockets.get(socketKey(session.value.userId, request.channelId))

    if (!socket) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    socket.dispatchEvent(new Event('close'))
    sockets.delete(socketKey(session.value.userId, request.channelId))

    return {}
  },

  async getMessages(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const channel = await prisma.messageChannel.findUnique({
      where: {
        id: request.channelId,
      },
      include: {
        users: { select: { id: true } },
        messages: { orderBy: { created: 'desc' }, take: 50 },
      },
    })

    if (
      !channel ||
      (!channel.public && !channel.users.some((user) => user.id === session.value.userId))
    ) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    return {
      messageList: {
        messages: channel.messages.map((m) => ({
          channelId: m.channelId,
          id: m.id,
          text: m.content,
          timestamp: m.created.getTime(),
          userId: m.userId,
        })),
        count: channel.messages.length,
        nextPage: channel.messages[channel.messages.length - 1]?.created.getTime() ?? null,
      },
    }
  },

  async sendMessage(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const channel = await prisma.messageChannel.findUnique({
      where: {
        id: request.channelId,
      },
      include: {
        users: { select: { id: true } },
      },
    })

    const user = await prisma.user.findUnique({
      where: {
        id: session.value.userId,
      },
    })

    if (
      !user ||
      !channel ||
      (!channel.public && !channel.users.some((user) => user.id === session.value.userId))
    ) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    // dispatch message to all sockets
    const targets = [...sockets.entries()].filter(([key]) => key.endsWith(`:${request.channelId}`))

    const message = {
      id: uuidv4(),
      channelId: request.channelId,
      userId: session.value.userId,
      text: request.text,
      timestamp: new Date().getTime(),
      user: {
        avatarId: user.avatarId ?? undefined,
        firstName: user.firstName ?? undefined,
        lastName: user.lastName ?? undefined,
        bannerId: user.bannerId ?? undefined,
        bio: user.bio ?? undefined,
        classOf: user.classOf,
        school: schoolFromJSON(user.school),
        id: user.id,
        joined: user.created,
        tuteeScore: user.tuteeScore ?? undefined,
        tutorScore: user.tutorScore ?? undefined,
        updated: user.updated,
      },
    } satisfies DeepPartial<Message>

    for (const [key, socket] of targets) {
      socket.dispatchEvent(new MessageEvent(message))
    }

    await prisma.message.create({
      data: {
        id: message.id,
        channelId: message.channelId,
        userId: message.userId,
        content: message.text,
        created: new Date(message.timestamp),
      },
    })

    return {}
  },

  async joinChannel(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const channel = await prisma.messageChannel.findUnique({
      where: {
        id: request.channelId,
      },
      include: {
        users: { select: { id: true } },
      },
    })

    if (!channel) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    if (channel.public) {
      await prisma.messageChannel.update({
        where: {
          id: request.channelId,
        },
        data: {
          users: {
            connect: {
              id: session.value.userId,
            },
          },
        },
      })
    } else {
      throw new ServerError(Status.PERMISSION_DENIED, '')
    }

    return {}
  },

  async leaveChannel(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const channel = await prisma.messageChannel.findUnique({
      where: {
        id: request.channelId,
      },
      include: {
        users: { select: { id: true } },
      },
    })

    if (!channel || !channel.users.some((user) => user.id === session.value.userId)) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    await prisma.messageChannel.update({
      where: {
        id: request.channelId,
      },
      data: {
        users: {
          disconnect: {
            id: session.value.userId,
          },
        },
      },
    })

    return {}
  },

  async addChannelMember(request, context) {
    const session = await Session.get<AuthSession>(context.metadata)
    if (!session.ok) {
      throw new ServerError(Status.UNAUTHENTICATED, '')
    }

    if (!request.channelId || !request.userId) {
      throw new ServerError(Status.INVALID_ARGUMENT, '')
    }

    const channel = await prisma.messageChannel.findUnique({
      where: {
        id: request.channelId,
      },
      include: {
        users: { select: { id: true } },
      },
    })

    const actor = await prisma.user.findUnique({
      where: {
        id: session.value.userId,
      },
    })

    const target = await prisma.user.findUnique({
      where: {
        id: request.userId,
      },
    })

    if (
      !channel ||
      !actor ||
      !target ||
      !channel.users.some((user) => user.id === session.value.userId)
    ) {
      throw new ServerError(Status.NOT_FOUND, '')
    }

    await prisma.messageChannel.update({
      where: {
        id: request.channelId,
      },
      data: {
        users: {
          connect: {
            id: request.userId,
          },
        },
      },
    })

    const message = {
      id: uuidv4(),
      channelId: request.channelId,
      userId: 'system',
      text: `${actor.firstName} ${actor.lastName} added ${target.firstName} ${target.lastName} to the channel.`,
      timestamp: new Date().getTime(),
    } satisfies DeepPartial<Message>

    // dispatch message to all sockets
    const targets = [...sockets.entries()].filter(([key]) => key.endsWith(`:${request.channelId}`))

    for (const [key, socket] of targets) {
      socket.dispatchEvent(new MessageEvent(message))
    }

    await prisma.message.create({
      data: {
        id: message.id,
        channelId: message.channelId,
        userId: message.userId,
        content: message.text,
        created: new Date(message.timestamp),
      },
    })

    return {}
  },
}
