package lol.calico.uctutors.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontFamily
import lol.calico.uctutors.util.modifier

@Composable
fun ErrorSurface(controller: ErrorSurfaceController) {
  val error = controller.error
  if (error != null) {

    AlertDialog(
      onDismissRequest = { controller.closeDialog() },
      title = { Text("Error Details") },
      text = {
        Column {
          Text(error.message ?: "An unknown error occurred.")
          Text(
            error.stackTraceToString(),
            fontFamily = FontFamily.Monospace,
            modifier = modifier { composed { horizontalScroll(rememberScrollState()) } }
          )
        }
      },
      confirmButton = {
        Button(
          onClick = { controller.closeDialog() },
        ) {
          Text("OK")
        }
      },
    )
  }
}

class ErrorSurfaceController {
  var error by mutableStateOf<Throwable?>(null)
    private set

  fun closeDialog() {
    error = null
  }

  fun showDialog(error: Throwable) {
    this.error = error
  }
}
