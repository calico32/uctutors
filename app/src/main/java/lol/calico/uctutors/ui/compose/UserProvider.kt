package lol.calico.uctutors.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import lol.calico.uctutors.generated.api.v1.User
import lol.calico.uctutors.generated.api.v1.getUserRequest
import lol.calico.uctutors.util.rememberContextualCoroutineScope

@Composable
fun UserProvider(content: @Composable () -> Unit) {
  var user by remember { mutableStateOf<User?>(null) }
  val scope = rememberContextualCoroutineScope()
  val grpc = LocalGrpcConnection.current

  LaunchedEffect(Unit) {
    scope.tryLaunch("Error getting user") { user = grpc.user.getUser(getUserRequest {}).user }
  }

  CompositionLocalProvider(LocalUser provides user) { content() }
}
