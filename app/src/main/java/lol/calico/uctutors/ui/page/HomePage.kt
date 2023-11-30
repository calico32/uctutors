package lol.calico.uctutors.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.navOptions
import kotlinx.coroutines.launch
import lol.calico.uctutors.ui.compose.LocalAppController
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.layout.AppLayout
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme

@Composable
fun HomePage(contentPadding: PaddingValues, onSignOut: suspend () -> Unit) {
  val scope = rememberCoroutineScope()
  val grpc = LocalGrpcConnection.current
  val navController = LocalAppController.current
  val scrollState = rememberScrollState()

  var loggingOut by remember { mutableStateOf(false) }


  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(contentPadding)
      .padding(16.dp)
      .verticalScroll(scrollState),
  ) {

    Text("Hello World")
    if (loggingOut) {
      CircularProgressIndicator(
        modifier = Modifier
          .padding(4.dp, top = 16.dp)
          .width(36.dp)
          .height(36.dp),
        color = MaterialTheme.colorScheme.surfaceVariant,
        trackColor = MaterialTheme.colorScheme.secondary,
      )
    } else {
      OutlinedButton(
        onClick = {
          scope.launch {
            loggingOut = true
            onSignOut()
            loggingOut = false
          }
        }, modifier = Modifier.padding(top = 16.dp)
      ) {
        Text("Log out")
      }
    }

    OutlinedButton(onClick = {
      navController.navigate("register", navOptions {
        popUpTo("home") { inclusive = true }
      })
    }) {
      Text("Navigate to register")
    }

    Box(
      modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .border(
          width = 3.dp, color = Colors.Primary40, shape = RoundedCornerShape(size = 8.dp)
        )
        .background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
        .padding(24.dp)
    ) {
      Text("Hello World")
    }
  }
}


@Preview(showSystemUi = true)
@Composable
fun HomePagePreview() {
  UCTutorsTheme {
    AppLayout {
      HomePage(it, onSignOut = {})
    }
  }
}