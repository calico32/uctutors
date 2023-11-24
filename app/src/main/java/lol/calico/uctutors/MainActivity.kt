package lol.calico.uctutors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import dagger.hilt.android.AndroidEntryPoint
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.ui.App
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject
  lateinit var grpc: GrpcConnection

  private lateinit var accountHandler: AccountHandler

  companion object {
    private const val TAG = "MainActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    accountHandler = AccountHandler(this, grpc)
    setContent {
      CompositionLocalProvider(LocalGrpcConnection provides grpc) {
        App(accountHandler)
      }
    }
  }
}