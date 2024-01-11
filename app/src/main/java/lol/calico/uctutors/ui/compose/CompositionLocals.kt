package lol.calico.uctutors.ui.compose

import android.annotation.SuppressLint
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.generated.api.v1.User
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

@SuppressLint("SimpleDateFormat") val LocalUser = compositionLocalOf<User?> { null }
