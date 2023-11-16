package lol.calico.uctutors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.google.android.gms.auth.api.signin.GoogleSignIn
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import lol.calico.uctutors.data.common.GrpcConnection
import lol.calico.uctutors.generated.api.ApiInfo
import lol.calico.uctutors.generated.api.getApiInfoRequest
import lol.calico.uctutors.impl.toDate
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.page.HomePage
import lol.calico.uctutors.ui.page.LoginPage
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  @Inject
  lateinit var grpc: GrpcConnection

  companion object {
    const val TAG = "UCTutors/MainActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CompositionLocalProvider(LocalGrpcConnection provides grpc) {
        App()
      }
    }
  }


}

@Composable
fun App() {
  val navController = rememberNavController()
  val view = LocalView.current
  var account by remember { mutableStateOf(GoogleSignIn.getLastSignedInAccount(view.context)) }

  UCTutorsTheme {
    LaunchedEffect(account) {
      val navOptions = navOptions {
        popUpTo("loading") { inclusive = true }
        anim {
          enter = android.R.anim.fade_in
          exit = android.R.anim.fade_out
        }
      }
      if (account == null) {
        navController.navigate("login", navOptions)
      } else {
        navController.navigate("home", navOptions)
      }
    }
    NavHost(navController, startDestination = "loading") {
      composable("loading") {
        Surface(
          modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
          ) {
            CircularProgressIndicator(
              modifier = Modifier.width(64.dp),
              color = MaterialTheme.colorScheme.surfaceVariant,
              trackColor = MaterialTheme.colorScheme.secondary,
            )
          }
        }
      }
      composable("home") {
        HomePage(onSignOut = {

        })
      }
      composable("login") {
        LoginPage(onSignIn = {
          account = it
        })
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  UCTutorsTheme {
    Surface(
      modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
      Greeting()
    }
  }
}

@Composable
fun Greeting() {
  var apiInfo by remember { mutableStateOf<ApiInfo?>(null) }
  val scope = rememberCoroutineScope()
  val grpc = LocalGrpcConnection.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight(),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Button({
      scope.launch {
        try {
          val request = getApiInfoRequest {}
          val response = grpc.apiInfo.getApiInfo(request)
          apiInfo = response.apiInfo
        } catch (e: Exception) {
          e.printStackTrace()
        }
      }
    }, Modifier.padding(10.dp)) {
      Text("Get API Info")
    }

    if (apiInfo != null) {
      Text("Commit " + apiInfo!!.commit, modifier = Modifier.padding(top = 10.dp))
      Text("Built at " + apiInfo!!.buildTime.toDate().toString())
      Text("Version v" + apiInfo!!.version.toString())
      Text("Current time: " + apiInfo!!.currentTime.toDate().toString())
    }
  }
}