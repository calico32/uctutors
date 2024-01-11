package lol.calico.uctutors.util

import com.google.protobuf.Timestamp
import java.util.Date

fun Timestamp.toDate(): java.util.Date {
  return java.util.Date(seconds * 1000 + nanos / 1000000)
}

fun Date.toTimestamp(): Timestamp {
  val seconds = this.time / 1000
  val nanos = (this.time % 1000) * 1000000
  return Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos.toInt()).build()
}
