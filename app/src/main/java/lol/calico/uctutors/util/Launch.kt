package lol.calico.uctutors.util

import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import lol.calico.uctutors.ui.components.ErrorSurfaceController
import lol.calico.uctutors.ui.compose.LocalErrorSurfaceController
import lol.calico.uctutors.ui.compose.LocalSnackbarHostState
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.tryLaunch(
  onError: suspend (Throwable) -> Unit = {},
  finally: () -> Unit = {},
  context: CoroutineContext = EmptyCoroutineContext,
  start: CoroutineStart = CoroutineStart.DEFAULT,
  block: suspend CoroutineScope.() -> Unit
): Job {
  return launch(context, start) {
    runCatching { block() }.onFailure { onError(it) }.also { finally() }
  }
}

data class ContextualCoroutineScope(
  val coroutineScope: CoroutineScope,
  val errorSurfaceController: ErrorSurfaceController,
  val snackbarHostState: SnackbarHostState,
) {
  fun tryLaunch(
    errorMessage: String,
    finally: () -> Unit = {},
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
  ): Job {
    return coroutineScope.launch(context, start) {
      runCatching { block() }
        .onFailure {
          val result =
            snackbarHostState.showSnackbar(
              message = errorMessage + ": " + it.message,
              actionLabel = "Details"
            )
          if (result == SnackbarResult.ActionPerformed) {
            errorSurfaceController.showDialog(it)
          }
        }
        .also { finally() }
    }
  }
}

@Composable
fun rememberContextualCoroutineScope(): ContextualCoroutineScope {
  val scope = rememberCoroutineScope()
  val errorSurfaceController = LocalErrorSurfaceController.current
  val snackbarHostState = LocalSnackbarHostState.current

  return remember(scope, errorSurfaceController, snackbarHostState) {
    ContextualCoroutineScope(scope, errorSurfaceController, snackbarHostState)
  }
}
