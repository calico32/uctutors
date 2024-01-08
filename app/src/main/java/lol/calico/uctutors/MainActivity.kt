package lol.calico.uctutors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import lol.calico.uctutors.data.common.GrpcNetworkConnection
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.domain.AccountHandler
import lol.calico.uctutors.ui.App
import lol.calico.uctutors.ui.compose.LocalAccountHandler
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalHttpClient
import lol.calico.uctutors.ui.compose.LocalTokenStorage
import okhttp3.OkHttpClient
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject lateinit var grpc: GrpcNetworkConnection
  @Inject lateinit var accountHandler: AccountHandler
  @Inject lateinit var tokenStorage: TokenStorage
  @Inject lateinit var httpClient: OkHttpClient

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
        LocalHttpClient provides httpClient,
      ) {
        App()
      }
    }
  }
}
