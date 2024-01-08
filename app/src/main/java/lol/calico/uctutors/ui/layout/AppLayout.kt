package lol.calico.uctutors.ui.layout

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import lol.calico.uctutors.ui.components.AppBar
import lol.calico.uctutors.util.modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppLayout(
  title: @Composable () -> Unit = {},
  floatingActionButton: @Composable () -> Unit = {},
  content: @Composable (PaddingValues) -> Unit,
) {
  Surface(modifier = modifier { fillMaxSize() }, color = MaterialTheme.colorScheme.background) {
    Scaffold(
      topBar = {
        CenterAlignedTopAppBar(
          title = { title() },
        )
      },
      floatingActionButton = { floatingActionButton() },
      bottomBar = { AppBar() },
    ) {
      content(it)
    }
  }
}
