import { CampusAvailability, VirtualAvailability } from '@/generated/api/v1/user'

export const enum SchoolDay {
  A = 'A',
  B = 'B',
}

export const holidays = new Set(
  [
    '2023-09-25',
    '2023-11-09',
    '2023-11-10',
    '2023-11-23',
    '2023-11-24',
    '2023-12-25',
    '2023-12-26',
    '2023-12-27',
    '2023-12-28',
    '2023-12-29',
    '2024-01-01',
    '2024-01-15',
    '2024-02-16',
    '2024-02-19',
    '2024-03-29',
    '2024-04-01',
    '2024-04-02',
    '2024-04-03',
    '2024-04-04',
    '2024-04-05',
    '2024-05-27',
  ].map((date) => new Date(date).toISOString())
)

const dates: Record<string, SchoolDay> = {}

;(function generateDates() {
  const startDate = new Date('2023-09-06')
  const startDay = SchoolDay.B
  const endDay = new Date('2024-06-17')

  let current = startDate
  let day = startDay
  while (current <= endDay) {
    if (current.getDay() !== 0 && current.getDay() !== 6 && !holidays.has(current.toISOString())) {
      dates[current.toISOString()] = day
      day = day === SchoolDay.A ? SchoolDay.B : SchoolDay.A
    }

    current = new Date(current.getTime() + 1000 * 60 * 60 * 24)
  }
})()

export function getSchoolDay(date: Date): SchoolDay {
  const normalized = new Date(`${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()}`)
  const key = normalized.toISOString()
  if (key in dates) {
    return dates[key]
  }

  throw new Error('Date out of range')
}

export function isAvailableOnCampus(
  availability: CampusAvailability[],
  date: Date,
  period: 5 | 6
): boolean {
  const day = getSchoolDay(date)
  const weekdayAvailability = availability[date.getDay() - 1]
  const dayAvailability = availability[day === SchoolDay.A ? 5 : 6]

  const key = `p${period}` as const

  return weekdayAvailability[key] && dayAvailability[key]
}

export function isAvailableVirtually(availability: VirtualAvailability[], date: Date): boolean {
  const weekday = date.getDay()
  const spans = availability.filter(
    (span) => span.day === weekday || (span.day === 7 && weekday === 0)
  )

  for (const span of spans) {
    const start = new Date(span.interval?.startTime!)
    const end = new Date(span.interval?.endTime!)
    if (date >= start && date <= end) {
      return true
    }
  }

  return false
}
