package lol.calico.uctutors.util

import com.google.protobuf.Timestamp

fun Timestamp.toDate(): java.util.Date {
  return java.util.Date(seconds * 1000 + nanos / 1000000)
}
