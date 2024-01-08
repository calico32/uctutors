import { PrismaClient, School } from '@prisma/client'

const prisma = new PrismaClient()

await prisma.$connect()

await prisma.messageChannel.upsert({
  where: {
    id: 'global',
  },
  update: {},
  create: {
    id: 'global',
    name: 'Global Chat',
    public: true,
  },
})

await prisma.user.create({
  data: {
    id: 'test_user',
    email: 'cchan1@ucvts.org',
    campusAvailability: [
      { p5: true, p6: true }, // monday
      { p5: true, p6: true }, // tuesday
      { p5: true, p6: true }, // wednesday
      { p5: true, p6: true }, // thursday
      { p5: true, p6: true }, // friday
      { p5: true, p6: true }, // a days
      { p5: true, p6: true }, // b days
    ],
    classOf: 2021,
    school: School.AIT,
    firstName: 'Caleb',
    lastName: 'Chan',
    virtualAvailability: [],
  },
})

await prisma.user.create({
  data: {
    id: 'test_user2',
    email: 'jgreenwald@ucvts.org',
    campusAvailability: [
      { p5: true, p6: true }, // monday
      { p5: true, p6: true }, // tuesday
      { p5: true, p6: true }, // wednesday
      { p5: true, p6: true }, // thursday
      { p5: true, p6: true }, // friday
      { p5: true, p6: true }, // a days
      { p5: true, p6: true }, // b days
    ],
    classOf: 2021,
    school: School.AIT,
    firstName: 'Jack',
    lastName: 'Greenwald',
    virtualAvailability: [
      {
        times: [
          {
            start: '10:00',
            end: '12:00',
          },
        ],
      }, // sunday
      { times: [] }, // monday
      { times: [] }, // tuesday
      { times: [] }, // wednesday
      { times: [] }, // thursday
      { times: [] }, // friday
      { times: [] }, // saturday
    ],
  },
})
