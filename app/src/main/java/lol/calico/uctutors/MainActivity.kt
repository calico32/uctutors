package lol.calico.uctutors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.ui.App
import lol.calico.uctutors.ui.compose.LocalAccountHandler
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalTokenStorage
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject
  lateinit var grpc: GrpcConnection

  @Inject
  lateinit var accountHandler: AccountHandler

  @Inject
  lateinit var tokenStorage: TokenStorage

  companion object {
    private const val TAG = "MainActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CompositionLocalProvider(
        LocalGrpcConnection provides grpc,
        LocalAccountHandler provides accountHandler,
        LocalTokenStorage provides tokenStorage,
      ) {
        App()
      }
    }
  }
}