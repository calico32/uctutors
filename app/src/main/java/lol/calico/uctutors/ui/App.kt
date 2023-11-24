package lol.calico.uctutors.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalView
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.getErrorOr
import kotlinx.coroutines.launch
import lol.calico.uctutors.AccountHandler
import lol.calico.uctutors.data.storage.TokenStorage
import lol.calico.uctutors.generated.api.v1.LoginStatus
import lol.calico.uctutors.ui.page.HomePage
import lol.calico.uctutors.ui.page.LoadingPage
import lol.calico.uctutors.ui.page.LoginPage
import lol.calico.uctutors.ui.page.RegisterPage
import lol.calico.uctutors.ui.theme.UCTutorsTheme

private const val TAG = "@App"
private const val LOADING = "__loading__"

@Composable
fun App(accountHandler: AccountHandler) {
  val navController = rememberNavController()
  val view = LocalView.current
  val tokenStorage = remember { TokenStorage(view.context) }
  val token = tokenStorage.getToken.collectAsState(initial = LOADING)
  var shouldRegister by remember { mutableStateOf(false) }
  val scope = rememberCoroutineScope()

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

      if (token.value.isNotEmpty()) {
        if (shouldRegister) {
          navController.navigate("register", navOptions)
        } else {
          navController.navigate("home", navOptions)
        }
      } else {
        scope.launch {
          accountHandler.tryImmediateSignIn(view)
        }
        navController.navigate("login", navOptions)
      }
    }
    NavHost(navController, startDestination = "loading") {
      composable("loading") {
        LoadingPage()
      }
      composable("home") {
        HomePage(onSignOut = {
          accountHandler.signOut(view)
        })
      }
      composable("login") {
        LoginPage(onSignIn = {
          when (val result = accountHandler.signIn(view)) {
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
        })
      }
      composable("register") {
        RegisterPage(onRegister = {
          return@RegisterPage accountHandler.register(view, it)
        })
      }
    }
  }
}
