package lol.calico.uctutors.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.common.GrpcConnectionStub
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.ui.layout.AppLayout
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import okhttp3.OkHttpClient

val LocalGrpcConnection = compositionLocalOf<GrpcConnection> { error("No GrpcConnection provided") }

val LocalAccountHandler = compositionLocalOf<AccountHandler> { error("No AccountHandler provided") }

val LocalTokenStorage = compositionLocalOf<TokenStorage> { error("No TokenStorage provided") }

val LocalAppController =
  compositionLocalOf<NavController> { error("No app-level NavController provided") }

val LocalPageController =
  compositionLocalOf<NavController> { error("No page-level NavController provided") }

val LocalHttpClient = compositionLocalOf { OkHttpClient() }

@Composable
fun BaselineLayout(
  title: @Composable () -> Unit = {},
  floatingActionButton: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) {
  Baseline {
    AppLayout(title = { title() }, floatingActionButton = { floatingActionButton() }) {
      content(it)
    }
  }
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

  CompositionLocalProvider(
    LocalGrpcConnection provides grpc,
    LocalAccountHandler provides accountHandler,
    LocalTokenStorage provides tokenStorage,
    LocalAppController provides appController,
    LocalPageController provides pageController,
  ) {
    UCTutorsTheme { content() }
  }
}
