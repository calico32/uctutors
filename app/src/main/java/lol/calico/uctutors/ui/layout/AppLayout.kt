package lol.calico.uctutors.ui.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import lol.calico.uctutors.ui.components.AppBar
import lol.calico.uctutors.ui.compose.LocalAppController
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalPageController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout(
  title: String = "UCTutors",
  content: @Composable (PaddingValues) -> Unit,
) {
  val scope = rememberCoroutineScope()
  val grpc = LocalGrpcConnection.current
  val appController = LocalAppController.current
  val pageController = LocalPageController.current
  Surface(
    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
  ) {
    Scaffold(
      topBar = {
        CenterAlignedTopAppBar(
          title = {
            Text(
              title,
              style = MaterialTheme.typography.titleLarge,
            )
          },
        )
      },
      bottomBar = {
        AppBar()
      },
    ) {
      content(it)
    }
  }
}