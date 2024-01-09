package lol.calico.uctutors.ui.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import lol.calico.uctutors.ui.components.AppBar
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.compose.LocalSnackbarHostState
import lol.calico.uctutors.util.modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout(
  title: (@Composable () -> Unit)? = null,
  floatingActionButton: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) {
  val snackbarHostState = remember { SnackbarHostState() }

  CompositionLocalProvider(
      LocalSnackbarHostState provides snackbarHostState,
  ) {
    Surface(modifier = modifier { fillMaxSize() }, color = MaterialTheme.colorScheme.background) {
      Scaffold(
        snackbarHost = {
          SnackbarHost(
            hostState = snackbarHostState,
            //          modifier = modifier { fillMaxWidth() },
            //          snackbar = { data ->
            //            Snackbar(
            //              snackbarData = data,
            //              modifier = modifier { fillMaxWidth() },
            //              onDismiss = { snackbarHostState.currentSnackbarData?.dismiss() },
            //            )
            //          },
          )
        },
        topBar = {
          if (title != null) {
            val pageController = LocalPageController.current
            CenterAlignedTopAppBar(
              title = { title() },
              navigationIcon = {
                if (pageController.previousBackStackEntry != null) {
                  IconButton(onClick = { pageController.popBackStack() }) {
                    Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
                  }
                }
              },
            )
          }
        },
        floatingActionButton = { floatingActionButton() },
        bottomBar = { AppBar() },
      ) {
        content(it)
      }
    }
  }
}
