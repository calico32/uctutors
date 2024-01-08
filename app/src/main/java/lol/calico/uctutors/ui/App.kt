package lol.calico.uctutors.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.getErrorOr
import lol.calico.uctutors.generated.api.v1.LoginStatus
import lol.calico.uctutors.ui.compose.Baseline
import lol.calico.uctutors.ui.compose.LocalAccountHandler
import lol.calico.uctutors.ui.compose.LocalAppController
import lol.calico.uctutors.ui.compose.LocalTokenStorage
import lol.calico.uctutors.ui.page.loading.LoadingPage
import lol.calico.uctutors.ui.page.login.LoginPage
import lol.calico.uctutors.ui.page.register.RegisterPage
import lol.calico.uctutors.ui.theme.UCTutorsTheme

private const val TAG = "@App"
private const val LOADING = "__loading__"

@Composable
fun App() {
  val appController = rememberNavController()
  val accountHandler = LocalAccountHandler.current
  val tokenStorage = LocalTokenStorage.current
  val token = tokenStorage.token.collectAsState(initial = LOADING)
  var shouldRegister by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

  LaunchedEffect(Unit) { tokenStorage.propagateToken(scope) }

  UCTutorsTheme {
    LaunchedEffect(token.value) {
      val navOptions = navOptions {
        popUpTo("loading") { inclusive = true }
        anim {
          enter = android.R.anim.fade_in
          exit = android.R.anim.fade_out
        }
      }
      if (token.value == LOADING) {
        return@LaunchedEffect
      }

      if (token.value != null) {
        if (shouldRegister) {
          appController.navigate("register", navOptions)
        } else {
          appController.navigate("pages", navOptions)
        }
      } else {
        appController.navigate("login", navOptions)
      }
    }

    CompositionLocalProvider(
      LocalAppController provides appController,
    ) {
      NavHost(appController, startDestination = "loading") {
        composable("loading") { LoadingPage() }

        composable("login") {
          LoginPage(
            onSignIn = {
              when (val result = accountHandler.signIn()) {
                is Ok -> {
                  when (result.value.status) {
                    LoginStatus.LOGIN_STATUS_EXISTING_USER -> {
                      // move to home
                      shouldRegister = false
                      tokenStorage.saveToken(result.value.token)
                    }
                    LoginStatus.LOGIN_STATUS_NEW_USER -> {
                      // move to registration instead of home
                      shouldRegister = true
                      tokenStorage.saveToken(result.value.token)
                    }
                    else -> {
                      // pass error back to login UI
                      Err(result.getErrorOr("Unknown error"))
                    }
                  }

                  Ok(Unit)
                }
                is Err -> {
                  // pass error back to login UI
                  result
                }
              }
            }
          )
        }
        composable("register") { RegisterPage(onRegister = accountHandler::register) }
        composable("pages") { Pages() }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
  Baseline { App() }
}
