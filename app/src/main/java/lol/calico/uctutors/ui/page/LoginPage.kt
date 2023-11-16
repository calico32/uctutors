package lol.calico.uctutors.ui.page

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ErrorOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes
import com.google.android.gms.common.api.ApiException
import kotlinx.coroutines.launch
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.MainActivity
import lol.calico.uctutors.R
import lol.calico.uctutors.generated.api.v1.loginRequest
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme

@Composable
fun LoginPage(onSignIn: (account: GoogleSignInAccount) -> Unit) {
  val view = LocalView.current
  var loading by remember { mutableStateOf(false) }
  var error by remember { mutableStateOf("") }
  val scope = rememberCoroutineScope()
  val grpc = LocalGrpcConnection.current

  Surface(
    color = Colors.Primary40, modifier = Modifier.fillMaxSize()
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(30.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      if (error.isNotEmpty()) {
        Box(
          modifier = Modifier
            .padding(bottom = 12.dp)
        ) {
          Box(
            modifier = Modifier
              .clip(MaterialTheme.shapes.medium)
              .shadow(12.dp)
              .background(MaterialTheme.colorScheme.errorContainer)
              .fillMaxWidth()
              .padding(20.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
            ) {
              Icon(
                Icons.Outlined.ErrorOutline,
                tint = MaterialTheme.colorScheme.onErrorContainer,
                contentDescription = null,
                modifier = Modifier.padding(end = 8.dp)
              )
              Text(
                error,
                color = MaterialTheme.colorScheme.onErrorContainer,
                style = MaterialTheme.typography.bodyMedium,
              )
            }
          }
        }
      }
      Box(
        modifier = Modifier
          .clip(MaterialTheme.shapes.medium)
          .shadow(10.dp)
          .background(MaterialTheme.colorScheme.background)
          .fillMaxWidth()
          .padding(30.dp),
      ) {
        Column(
          modifier = Modifier.fillMaxWidth(),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            "UCTutors",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displayLarge,
          )
          Text(
            "Sign in",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.displaySmall,
            modifier = Modifier
              .padding(bottom = 5.dp)
          )
          OutlinedButton(
            onClick = {
              if (view.isInEditMode) return@OutlinedButton
              loading = true

              val activity = view.context as ComponentActivity
              val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .setHostedDomain("ucvts.org")
                .requestProfile()
                .requestEmail()
                .requestIdToken(BuildConfig.WEB_CLIENT_ID)
                .build()
              val googleSignInClient = GoogleSignIn.getClient(view.context, gso)
              val signInIntent = googleSignInClient.signInIntent
              val signIn = activity.registerForActivityResult(SignInContract()) {
                if (it.error != null) {
                  error = it.error
                  return@registerForActivityResult
                }

                if (it.account == null || it.account.idToken == null) {
                  error = "Sign in failed: no account or id token"
                  return@registerForActivityResult
                }

                scope.launch {
                  val result = grpc.auth.login(loginRequest {
                    idToken = it.account.idToken!!
                  })
                }
              }
              signIn.launch(signInIntent)
            }, modifier = Modifier
              .padding(10.dp),
            shape = RoundedCornerShape(12.dp)
          ) {
            if (loading) {
              CircularProgressIndicator(
                modifier = Modifier
                  .width(30.dp)
                  .padding(end = 10.dp)
              )
            } else {
              Image(
                painterResource(id = R.drawable.google),
                contentDescription = null,
                Modifier
                  .width(30.dp)
                  .padding(end = 10.dp)

              )
            }
            Text(
              "Sign in with Google",
              style = MaterialTheme.typography.bodyLarge,
            )
          }
          Text(
            "Please sign in with Google to continue.",
            color = MaterialTheme.colorScheme.onBackground,
            style = MaterialTheme.typography.bodyMedium
          )
        }
      }
    }
  }
}

data class SignInResult(
  val account: GoogleSignInAccount?,
  val error: String?,
)

class SignInContract : ActivityResultContract<Intent, SignInResult>() {
  override fun createIntent(context: Context, input: Intent): Intent {
    return input
  }

  override fun parseResult(resultCode: Int, intent: Intent?): SignInResult {
    if (resultCode != Activity.RESULT_OK) {
      return SignInResult(account = null, error = "Error: code $resultCode")
    }

    val task = GoogleSignIn.getSignedInAccountFromIntent(intent)

    return try {
      val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
      Log.d(MainActivity.TAG, "sign in success (${account.email ?: "<no email>"})")

      SignInResult(account, error = null)
    } catch (e: ApiException) {
      val errorMessage =
        "Sign in failed: " + GoogleSignInStatusCodes.getStatusCodeString(e.statusCode)
      Log.w(MainActivity.TAG, errorMessage)

      SignInResult(account = null, error = errorMessage)
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun LoginPagePreview() {
  UCTutorsTheme {
    LoginPage(onSignIn = {})
  }
}
