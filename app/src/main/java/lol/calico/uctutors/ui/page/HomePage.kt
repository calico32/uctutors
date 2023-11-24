package lol.calico.uctutors.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import lol.calico.uctutors.ui.theme.UCTutorsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(onSignOut: suspend () -> Unit) {
  val scope = rememberCoroutineScope()
  var loggingOut by remember { mutableStateOf(false) }
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    Scaffold(
      topBar = {
        TopAppBar(
          title = { Text("UCTutors") },
          navigationIcon = {
            IconButton(onClick = {

            }) {
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
          .padding(16.dp)
      ) {
        Text("Hello World")
        if (loggingOut) {
          CircularProgressIndicator(
            modifier = Modifier
              .padding(4.dp, top = 16.dp)
              .width(36.dp)
              .height(36.dp),
            color = MaterialTheme.colorScheme.surfaceVariant,
            trackColor = MaterialTheme.colorScheme.secondary,
          )
        } else {
          OutlinedButton(
            onClick = {
              scope.launch {
                loggingOut = true
                onSignOut()
                loggingOut = false
              }
            },
            modifier = Modifier.padding(top = 16.dp)
          ) {

            Text("Log out")
          }
        }
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