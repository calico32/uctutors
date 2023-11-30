import { SchoolDay, getSchoolDay } from '@/util/days'
import { describe, expect, it } from 'bun:test'

describe('getDay', () => {
  const knownDays = [
    [new Date('2023-11-28'), SchoolDay.B],
    [new Date('2023-11-29'), SchoolDay.A],
    [new Date('2023-11-06'), SchoolDay.B],
    [new Date('2023-10-13'), SchoolDay.B],
    [new Date('2023-12-8'), SchoolDay.B],
    [new Date('2023-12-18'), SchoolDay.B],
  ] as const

  knownDays.forEach(([date, day]) => {
    it(`should return ${day} for ${date}`, () => {
      expect(getSchoolDay(date)).toBe(day)
    })
  })
})
