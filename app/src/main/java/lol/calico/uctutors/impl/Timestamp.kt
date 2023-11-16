package lol.calico.uctutors.impl

import com.google.protobuf.Timestamp

fun Timestamp.toDate(): java.util.Date {
  return java.util.Date(seconds * 1000 + nanos / 1000000)
}