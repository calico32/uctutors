package lol.calico.uctutors.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

enum class SchoolDay {
  A,
  B;

  companion object {
    fun from(day: String): SchoolDay =
        when (day) {
          "A" -> A
          "B" -> B
          else -> throw IllegalArgumentException("Invalid school day $day")
        }

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)

    private fun String.toDate() = dateFormat.parse(this)!!

    private val holidays =
        hashSetOf(
                "2023-09-25",
                "2023-11-09",
                "2023-11-10",
                "2023-11-23",
                "2023-11-24",
                "2023-12-25",
                "2023-12-26",
                "2023-12-27",
                "2023-12-28",
                "2023-12-29",
                "2024-01-01",
                "2024-01-15",
                "2024-02-16",
                "2024-02-19",
                "2024-03-29",
                "2024-04-01",
                "2024-04-02",
                "2024-04-03",
                "2024-04-04",
                "2024-04-05",
                "2024-05-27",
            )
            .map { it.toDate().toISOString() }

    private val dates = HashMap<String, SchoolDay>()

    init {
      val startDate = "2023-09-06".toDate()
      val startDay = B
      val end = "2024-06-17".toDate()

      var current = startDate
      var day = startDay
      while (current <= end) {
        if (current.day != 0 && current.day != 6 && !holidays.contains(current.toISOString())) {
          dates[current.toISOString()] = day
          day = if (day == A) B else A
        }

        current = current.apply { date += 1 }
      }
    }

    fun getForDate(date: Date): SchoolDay {
      val normalized = Date(date.year, date.month, date.day)
      return dates[normalized.toISOString()] ?: throw IllegalArgumentException("Invalid date $date")
    }
  }
}

private val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US)

private fun Date.toISOString() = isoFormat.format(this)
