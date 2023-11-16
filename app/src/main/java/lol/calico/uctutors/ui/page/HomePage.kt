package lol.calico.uctutors.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lol.calico.uctutors.ui.theme.UCTutorsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(onSignOut: () -> Unit) {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("UCTutors") },
          navigationIcon = {
            IconButton(onClick = onSignOut) {
              Icon(Icons.Outlined.Menu, "Menu")
            }
          },
          actions = {
            IconButton(onClick = {

            }) {
              Icon(Icons.Outlined.AccountCircle, "Account")
            }
          }
        )
      }
    ) {
      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(it)
      ) {
        Text("Hello World")
      }

    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun HomePagePreview() {
  UCTutorsTheme {
    HomePage(onSignOut = {})
  }
}