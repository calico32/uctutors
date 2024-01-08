package lol.calico.uctutors.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

data class AvailableEvent(
  val title: String,
  val name: String,
  val type: String,
  val location: String,
  val time: String,
  val contact: String
)

@Composable
fun AvailableEventBox(availableEvent: AvailableEvent) {

  Box(
    modifier =
      modifier {
        padding(20.dp)
        border(width = 1.dp, color = Colors.Primary40, shape = RoundedCornerShape(size = 8.dp))
        background(color = Color.White, shape = RoundedCornerShape(size = 8.dp))
        fillMaxWidth()
        padding(top = 10.dp, bottom = 10.dp)
        padding(horizontal = 15.dp)
      }
  ) {
    Column(
      modifier = modifier { fillMaxWidth() },
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = availableEvent.title,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = availableEvent.name,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = availableEvent.type,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = availableEvent.location,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = availableEvent.time,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      ContactButton()
    }
  }
}

@Composable
fun ContactButton() {
  val pageController = LocalPageController.current
  OutlinedButton(
      onClick = {
        pageController.navigate(
            "messages",
            navOptions {
              val target =
                  try {
                    pageController.graph.findStartDestination().route!!
                  } catch (e: Throwable) {
                    "login"
                  }

              popUpTo(target) {
                inclusive = true
                saveState = true
              }
              restoreState = true
              launchSingleTop = true
              anim {
                enter = android.R.anim.slide_in_left
                exit = android.R.anim.slide_out_right
              }
            }
        )
      }
  ) {
    Text("Contact")
  }
}
