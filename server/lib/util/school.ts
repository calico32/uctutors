import { School } from '@/generated/api/v1/user'
import { School as PrismaSchool } from '@prisma/client'

export function protoSchoolToPrismaSchool(school: School): PrismaSchool {
  const map = {
    [School.SCHOOL_AAHS]: PrismaSchool.AAHS,
    [School.SCHOOL_AIT]: PrismaSchool.AIT,
    [School.SCHOOL_APA]: PrismaSchool.APA,
    [School.SCHOOL_MHS]: PrismaSchool.MHS,
    [School.SCHOOL_UCTECH]: PrismaSchool.UCTECH,
  } satisfies Partial<Record<School, PrismaSchool>>

  if (school in map) {
    return map[school as keyof typeof map]
  }

  throw new Error(`Invalid school: ${school}`)
}
