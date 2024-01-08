package lol.calico.uctutors.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

data class Event(
  val title: String,
  val name: String,
  val type: String,
  val location: String,
  val time: String
)

@Composable
fun CurrentEventBox(event: Event) {
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
        text = event.title,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.titleMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = event.name,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = event.type,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = event.location,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
      Text(
        text = event.time,
        modifier = modifier { fillMaxWidth() },
        style = MaterialTheme.typography.bodyMedium,
        textAlign = TextAlign.Center
      )
    }
  }
}
