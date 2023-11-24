package lol.calico.uctutors.data.state

import lol.calico.uctutors.generated.api.v1.School

data class RegisterData(
  val school: School,
  val classYear: Int,
  val bio: String,
)
