package lol.calico.uctutors.util

import android.annotation.SuppressLint
import com.google.protobuf.timestamp
import com.google.type.DayOfWeek
import com.google.type.Interval
import lol.calico.uctutors.R
import lol.calico.uctutors.generated.api.v1.School
import lol.calico.uctutors.generated.api.v1.campusAvailability
import lol.calico.uctutors.generated.api.v1.experience
import lol.calico.uctutors.generated.api.v1.user
import lol.calico.uctutors.generated.api.v1.virtualAvailability
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
object TestData {
  private const val TEST_AVATAR_ID = "test_avatar_id"
  private val TEST_AVATAR = R.drawable.miku
  private const val TEST_BANNER_ID = "test_banner_id"
  private val TEST_BANNER = R.drawable.miku_banner
  private const val TEST_EXPERIENCE_IMAGE_ID = "test_experience_image_id"
  private val TEST_EXPERIENCE_IMAGE = R.drawable.miku_laptop
  val images =
    mapOf(
      TEST_AVATAR_ID to TEST_AVATAR,
      TEST_BANNER_ID to TEST_BANNER,
      TEST_EXPERIENCE_IMAGE_ID to TEST_EXPERIENCE_IMAGE,
    )

  val user = user {
    id = "hatsune_miku"
    email = "example@ucvts.org"
    school = School.SCHOOL_AIT
    classOf = 2024
    firstName = "Hatsune"
    lastName = "Miku"
    joined = SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01")!!.toTimestamp()
    updated = SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01")!!.toTimestamp()
    avatarId = TEST_AVATAR_ID
    bannerId = TEST_BANNER_ID
    bio =
      "Hi! I'm Hatsune Miku, and I'm a student at AIT. I like to play video games and watch anime. I'm also a big fan of the color blue."
    topics += listOf("Math", "Computer Science", "English", "History", "Science")
    experiences +=
      listOf(
        experience {
          id = "hatsune_miku_experience"
          title = "Self-taught programmer"
          description = "Wrote a lot of code, learned a lot of things."
          skills += listOf("Java", "Kotlin", "Python", "C++", "C#", "JavaScript", "HTML", "CSS")
          imageId = TEST_EXPERIENCE_IMAGE_ID
        },
      )
    campusAvailability +=
      listOf(
        campusAvailability {
          p5 = true
          p6 = true
        },
        campusAvailability {
          p5 = true
          p6 = true
        },
        campusAvailability {
          p5 = true
          p6 = true
        },
        campusAvailability {
          p5 = true
          p6 = true
        },
        campusAvailability {
          p5 = false
          p6 = false
        },
        campusAvailability {
          p5 = true
          p6 = true
        },
        campusAvailability {
          p5 = true
          p6 = false
        },
      )
    virtualAvailability +=
      listOf(
        virtualAvailability {
          day = DayOfWeek.SUNDAY
          interval =
            Interval.newBuilder()
              .setStartTime(timestamp { seconds = 12 * 60 })
              .setEndTime(timestamp { seconds = 13 * 60 })
              .build()
        },
        virtualAvailability {
          day = DayOfWeek.MONDAY
          interval =
            Interval.newBuilder()
              .setStartTime(timestamp { seconds = 16 * 60 })
              .setEndTime(timestamp { seconds = 20 * 60 })
              .build()
        },
        virtualAvailability {
          day = DayOfWeek.TUESDAY
          interval =
            Interval.newBuilder()
              .setStartTime(timestamp { seconds = 16 * 60 })
              .setEndTime(timestamp { seconds = 20 * 60 })
              .build()
        },
        virtualAvailability {
          day = DayOfWeek.WEDNESDAY
          interval =
            Interval.newBuilder()
              .setStartTime(timestamp { seconds = 16 * 60 })
              .setEndTime(timestamp { seconds = 20 * 60 })
              .build()
        },
      )
  }
}
