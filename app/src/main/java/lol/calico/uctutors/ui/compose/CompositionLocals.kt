package lol.calico.uctutors.ui.compose

import android.annotation.SuppressLint
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import com.google.protobuf.timestamp
import com.google.type.DayOfWeek
import com.google.type.Interval
import java.text.SimpleDateFormat
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.generated.api.v1.School
import lol.calico.uctutors.generated.api.v1.campusAvailability
import lol.calico.uctutors.generated.api.v1.user
import lol.calico.uctutors.generated.api.v1.virtualAvailability
import lol.calico.uctutors.ui.components.ErrorSurfaceController
import okhttp3.OkHttpClient

val LocalGrpcConnection = compositionLocalOf<GrpcConnection> { error("No GrpcConnection provided") }

val LocalAccountHandler = compositionLocalOf<AccountHandler> { error("No AccountHandler provided") }

val LocalTokenStorage = compositionLocalOf<TokenStorage> { error("No TokenStorage provided") }

val LocalAppController =
  compositionLocalOf<NavController> { error("No app-level NavController provided") }

val LocalPageController =
  compositionLocalOf<NavController> { error("No page-level NavController provided") }

val LocalSnackbarHostState =
  compositionLocalOf<SnackbarHostState> { error("No SnackbarHostState provided") }

val LocalHttpClient = compositionLocalOf { OkHttpClient() }

val LocalErrorSurfaceController = compositionLocalOf { ErrorSurfaceController() }

@SuppressLint("SimpleDateFormat")
val LocalUser = compositionLocalOf {
  user {
    id = "123123123132"
    firstName = "John"
    lastName = "Doe"
    email = "johndoe@example.com"
    school = School.SCHOOL_AIT
    classOf = 2024
    avatarId = "1572a8e7-dc4b-4041-b4bc-7f2c80524a83"
    bio =
      "I'm a student at AIT! I like to play video games and watch anime. I'm also a big fan of the color blue."

    val iso = SimpleDateFormat("yyyy-MM-dd")
    joined = timestamp { seconds = iso.parse("2021-09-01")!!.time / 1000 }
    updated = timestamp { seconds = iso.parse("2021-09-04")!!.time / 1000 }
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
