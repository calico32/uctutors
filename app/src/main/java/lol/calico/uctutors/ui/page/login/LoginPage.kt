package lol.calico.uctutors.ui.page.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.getErrorOr
import kotlinx.coroutines.launch
import lol.calico.uctutors.R
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier

@Composable
fun LoginPage(onSignIn: suspend () -> Result<Unit, String>) {
  val view = LocalView.current
  var loading by remember { mutableStateOf(false) }
  var error by remember { mutableStateOf("") }
  val scope = rememberCoroutineScope()

  Surface(color = Colors.Primary40, modifier = modifier { fillMaxSize() }) {
    Column(
      modifier =
        modifier {
          fillMaxSize()
          padding(30.dp)
        },
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      if (error.isNotEmpty()) {
        Box(
          modifier =
            modifier {
              padding(bottom = 12.dp)
              composed { clip(MaterialTheme.shapes.medium) }
              shadow(12.dp)
              composed { background(MaterialTheme.colorScheme.errorContainer) }
              fillMaxWidth()
              padding(20.dp)
            }
        ) {
          Row {
            Icon(
              Icons.Outlined.ErrorOutline,
              tint = MaterialTheme.colorScheme.onErrorContainer,
              contentDescription = null,
              modifier = modifier { padding(end = 12.dp) }
            )
            Text(
              error,
              color = MaterialTheme.colorScheme.onErrorContainer,
              style = MaterialTheme.typography.bodyMedium,
            )
          }
        }
      }
      Box(
        modifier =
          modifier {
            composed { clip(MaterialTheme.shapes.medium) }
            shadow(10.dp)
            composed { background(MaterialTheme.colorScheme.background) }
            fillMaxWidth()
            padding(30.dp)
          }
      ) {
        Column(
          modifier = modifier { fillMaxWidth() },
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
            modifier = modifier { padding(bottom = 5.dp) }
          )
          OutlinedButton(
            onClick = {
              if (view.isInEditMode) return@OutlinedButton
              scope.launch {
                error = ""
                loading = true
                error = onSignIn().getErrorOr("")
                loading = false
              }
            },
            modifier = modifier { padding(10.dp) },
            shape = RoundedCornerShape(12.dp),
          ) {
            if (loading) {
              CircularProgressIndicator(
                modifier =
                  modifier {
                    padding(end = 10.dp)
                    width(25.dp)
                    height(25.dp)
                    align(Alignment.CenterVertically)
                  }
              )
            } else {
              Image(
                painterResource(id = R.drawable.google),
                contentDescription = null,
                modifier =
                  modifier {
                    padding(end = 10.dp)
                    width(25.dp)
                    height(25.dp)
                    align(Alignment.CenterVertically)
                  }
              )
            }
            Text(
              "Sign in with Google",
              style = MaterialTheme.typography.bodyLarge,
              modifier = modifier { align(Alignment.CenterVertically) }
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

@Preview(showSystemUi = true)
@Composable
fun LoginPagePreview() {
  UCTutorsTheme { LoginPage(onSignIn = { Ok(Unit) }) }
}
