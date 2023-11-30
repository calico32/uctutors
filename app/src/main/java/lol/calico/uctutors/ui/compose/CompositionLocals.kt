package lol.calico.uctutors.ui.compose

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler

val LocalGrpcConnection = compositionLocalOf<GrpcConnection> {
  error("No GrpcConnection provided")
}

val LocalAccountHandler = compositionLocalOf<AccountHandler> {
  error("No AccountHandler provided")
}

val LocalTokenStorage = compositionLocalOf<TokenStorage> {
  error("No TokenStorage provided")
}

val LocalAppController = compositionLocalOf<NavController> {
  error("No app NavController provided")
}

val LocalPageController = compositionLocalOf<NavController> {
  error("No page NavController provided")
}