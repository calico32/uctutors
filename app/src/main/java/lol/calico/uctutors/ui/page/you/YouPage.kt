package lol.calico.uctutors.ui.page.you

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.generated.api.v1.School
import lol.calico.uctutors.generated.api.v1.User
import lol.calico.uctutors.generated.api.v1.getUserRequest
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.util.modifier
import lol.calico.uctutors.util.schoolToString

@Composable
fun YouPage(contentPadding: PaddingValues) {
  val grpc = LocalGrpcConnection.current
  val scrollState = rememberScrollState()
  var user by remember { mutableStateOf<User?>(null) }
  val scope = rememberCoroutineScope()

  LaunchedEffect(Unit) { scope.launch { user = grpc.user.getUser(getUserRequest {}).user } }

  Column(
    modifier =
      modifier {
        fillMaxSize()
        padding(contentPadding)
        padding(16.dp)
        verticalScroll(scrollState)
      }
  ) {
    Row {
      if (user != null) {
        AsyncImage(
          model = "${BuildConfig.CONTENT_URL}/${user!!.avatarId}", // URL of the image
          contentDescription = "Image description",
          modifier =
            modifier {
              size(150.dp)
              border(BorderStroke(2.dp, Color.White), CircleShape)
              padding(4.dp)
              clip(CircleShape)
            },
          contentScale = ContentScale.Crop
        )
        Text(
          user!!.firstName + " " + user!!.lastName,
          style = MaterialTheme.typography.titleMedium,
          modifier = modifier { padding(top = 60.dp, start = 30.dp) }
        )
        Text(
          schoolToString(user!!.school ?: School.SCHOOL_UNSPECIFIED) +
            " '" +
            (user!!.classOf).toString().substring(2, 4),
          style = MaterialTheme.typography.labelLarge,
          modifier = modifier { padding(top = 65.dp, start = 10.dp) }
        )
      }
    }
  }
}
