package lol.calico.uctutors.util

import lol.calico.uctutors.generated.api.v1.School

fun schoolFrom(school: String): School =
  when (school) {
    "AAHS" -> School.SCHOOL_AAHS
    "AIT" -> School.SCHOOL_AIT
    "APA" -> School.SCHOOL_APA
    "MHS" -> School.SCHOOL_MHS
    "UCTECH",
    "UCT" -> School.SCHOOL_UCTECH
    else -> throw IllegalArgumentException("Invalid school $school")
  }

fun schoolToString(school: School): String =
  when (school) {
    School.SCHOOL_AAHS -> "AAHS"
    School.SCHOOL_AIT -> "AIT"
    School.SCHOOL_APA -> "APA"
    School.SCHOOL_MHS -> "MHS"
    School.SCHOOL_UCTECH -> "UCTECH"
    else -> ""
  }
