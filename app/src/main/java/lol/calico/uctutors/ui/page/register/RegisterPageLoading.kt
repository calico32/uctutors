package lol.calico.uctutors.ui.page.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.michaelbull.result.Ok
import lol.calico.uctutors.ui.theme.UCTutorsTheme
import lol.calico.uctutors.util.modifier

@Composable
fun ColumnScope.RegisterPageLoading() {
  Text(
    "Creating your account...",
    style = MaterialTheme.typography.titleMedium,
    color = MaterialTheme.colorScheme.onBackground,
    textAlign = TextAlign.Center,
    modifier =
      modifier {
        padding(top = 24.dp)
        fillMaxWidth()
      }
  )

  CircularProgressIndicator(
    modifier =
      modifier {
        padding(vertical = 16.dp)
        width(48.dp)
        height(48.dp)
        align(Alignment.CenterHorizontally)
      },
    color = MaterialTheme.colorScheme.surfaceVariant,
    trackColor = MaterialTheme.colorScheme.secondary,
  )
}

@Preview(showSystemUi = true)
@Composable
fun RegisterPageLoadingPreview() {
  UCTutorsTheme {
    RegisterPage(onRegister = { Ok(Unit) }) {
      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier { fillMaxWidth() }
      ) {
        RegisterPageLoading()
      }
    }
  }
}
