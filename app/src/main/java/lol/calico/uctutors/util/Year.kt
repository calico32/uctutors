package lol.calico.uctutors.util

import java.util.Calendar

// calculate the current class year, and the next three
// If it's after June, we're in the next class year
fun classYears(): List<Int> {
  val year = Calendar.getInstance().get(Calendar.YEAR)
  val month = Calendar.getInstance().get(Calendar.MONTH)
  return if (month >= 6) {
    listOf(year + 1, year + 2, year + 3, year + 4)
  } else {
    listOf(year, year + 1, year + 2, year + 3)
  }
}

