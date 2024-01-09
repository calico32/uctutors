package lol.calico.uctutors.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import lol.calico.uctutors.data.common.GrpcConnectionStub
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.ui.layout.AppLayout
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import okhttp3.OkHttpClient

@Composable
fun BaselineLayout(
  title: (@Composable () -> Unit)? = null,
  floatingActionButton: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) {
  Baseline { AppLayout(title = title, floatingActionButton = floatingActionButton) { content(it) } }
}

@Composable
fun Baseline(
  content: @Composable () -> Unit,
) {
  val context = LocalContext.current
  val grpc = remember { GrpcConnectionStub() }
  val tokenStorage = remember { TokenStorage(context, grpc) }
  val accountHandler = remember { AccountHandler(context, grpc, tokenStorage) }
  val appController = remember { NavController(context) }
  val pageController = remember { NavController(context) }
  val httpClient = remember { OkHttpClient() }

  CompositionLocalProvider(
    LocalGrpcConnection provides grpc,
    LocalAccountHandler provides accountHandler,
    LocalTokenStorage provides tokenStorage,
    LocalAppController provides appController,
    LocalPageController provides pageController,
    LocalHttpClient provides httpClient,
  ) {
    UCTutorsTheme { content() }
  }
}
