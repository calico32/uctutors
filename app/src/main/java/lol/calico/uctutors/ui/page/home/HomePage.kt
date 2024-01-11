package lol.calico.uctutors.ui.page.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.navOptions
import kotlinx.coroutines.launch
import lol.calico.uctutors.ui.components.AvailableEvent
import lol.calico.uctutors.ui.components.AvailableEventBox
import lol.calico.uctutors.ui.components.CurrentEventBox
import lol.calico.uctutors.ui.components.Event
import lol.calico.uctutors.ui.compose.BaselineLayout
import lol.calico.uctutors.ui.compose.LocalAccountHandler
import lol.calico.uctutors.ui.compose.LocalAppController
import lol.calico.uctutors.ui.compose.LocalUser
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

@Composable
fun HomePage(contentPadding: PaddingValues) {
  val scope = rememberCoroutineScope()
  val navController = LocalAppController.current
  val scrollState = rememberScrollState()
  val accountHandler = LocalAccountHandler.current
  val user = LocalUser.current

  var loggingOut by remember { mutableStateOf(false) }

  Column(
    modifier =
      modifier {
        fillMaxSize()
        padding(contentPadding)
        padding(16.dp)
        verticalScroll(scrollState)
      },
  ) {
    Text("Welcome back, ${user?.firstName ?: "User"}!")
    if (loggingOut) {
      CircularProgressIndicator(
        modifier =
          modifier {
            padding(4.dp, top = 16.dp)
            width(36.dp)
            height(36.dp)
          },
        color = MaterialTheme.colorScheme.surfaceVariant,
        trackColor = MaterialTheme.colorScheme.secondary,
      )
    } else {
      OutlinedButton(
        onClick = {
          scope.launch {
            loggingOut = true
            accountHandler.signOut()
            loggingOut = false
          }
        },
        modifier = modifier { padding(top = 16.dp) }
      ) {
        Text("Log out")
      }
    }

    OutlinedButton(
      onClick = {
        navController.navigate("register", navOptions { popUpTo("home") { inclusive = true } })
      }
    ) {
      Text("Navigate to register")
    }

    Box(
      modifier =
        modifier {
          align(Alignment.CenterHorizontally)
          padding(20.dp)
          border(width = 2.dp, color = Colors.Primary40, shape = RoundedCornerShape(size = 8.dp))
          background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
          fillMaxWidth()
          padding(30.dp)
        }
    ) {
      Column {
        Text(
          "Upcoming Events",
          modifier =
            modifier {
              fillMaxWidth()
              padding(bottom = 10.dp)
            },
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.titleMedium,
        )
        val scroll = rememberScrollState()
        Box(
          modifier =
            modifier {
              clip(RoundedCornerShape(8.dp))
              shadow(0.1.dp, shape = RoundedCornerShape(0.dp))
              innerShadow(
                color = Color.Black.copy(alpha = 0.25f),
                cornersRadius = 8.dp,
                blur = 3.dp,
                spread = 0.dp,
                offsetY = 2.dp,
                offsetX = 0.dp
              )
              background(Colors.Neutral98)
            }
        ) {
          Row(modifier = modifier { horizontalScroll(scroll) }) {
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
            CurrentEventBox(
              event =
                Event(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30"
                )
            )
          }
        }
      }
    }
    Box(
      modifier =
        modifier {
          align(Alignment.CenterHorizontally)
          padding(20.dp)
          border(width = 2.dp, color = Colors.Primary40, shape = RoundedCornerShape(size = 8.dp))
          background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
          fillMaxWidth()
          padding(30.dp)
        }
    ) {
      Column {
        Text(
          "Available Events",
          modifier =
            modifier {
              fillMaxWidth()
              padding(bottom = 10.dp)
            },
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.titleMedium,
        )
        val scroll = rememberScrollState()
        Box(
          modifier =
            modifier {
              clip(RoundedCornerShape(8.dp))
              shadow(0.1.dp, shape = RoundedCornerShape(0.dp))
              innerShadow(
                color = Color.Black.copy(alpha = 0.25f),
                cornersRadius = 8.dp,
                blur = 3.dp,
                spread = 0.dp,
                offsetY = 2.dp,
                offsetX = 0.dp
              )
              background(Colors.Neutral98)
            }
        ) {
          Row(modifier = modifier { horizontalScroll(scroll) }) {
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
            AvailableEventBox(
              availableEvent =
                AvailableEvent(
                  title = "Tutoring",
                  name = "Jack",
                  type = "Calculus",
                  location = "MMC",
                  time = "3:30",
                  contact = "number"
                )
            )
          }
        }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun HomePagePreview() {
  BaselineLayout { HomePage(it) }
}
