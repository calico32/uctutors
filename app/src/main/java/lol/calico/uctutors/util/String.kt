package lol.calico.uctutors.util

fun String.titlecase(): String =
  split(" ").joinToString(" ") { it.lowercase().replaceFirstChar(Char::uppercase) }
