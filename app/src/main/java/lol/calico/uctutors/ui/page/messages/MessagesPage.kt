package lol.calico.uctutors.ui.page.messages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Message
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.protobuf.empty
import kotlin.random.Random
import kotlinx.coroutines.launch
import lol.calico.uctutors.generated.api.v1.MessageChannelStub
import lol.calico.uctutors.generated.api.v1.messageChannelStub
import lol.calico.uctutors.ui.Route
import lol.calico.uctutors.ui.compose.BaselineLayout
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.navigate
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

@Composable
fun MessagesPage(contentPadding: PaddingValues) {
  val scope = rememberCoroutineScope()
  val grpc = LocalGrpcConnection.current
  var channels by remember { mutableStateOf(listOf<MessageChannelStub>()) }

  LaunchedEffect(Unit) {
    scope.launch { channels = grpc.message.getChannels(empty {}).channelsList }
  }

  ChannelList(
    modifier = modifier { padding(contentPadding) },
    channels = channels,
  )
}

@Composable
fun MessagesPageFab() {
  val pageController = LocalPageController.current

  ExtendedFloatingActionButton(
    icon = { Icon(Icons.Outlined.Message, contentDescription = "New Channel") },
    text = { Text("New Channel") },
    onClick = { pageController.navigate(Route.NewChannel) },
  )
}

@Composable
fun ChannelList(channels: List<MessageChannelStub>, modifier: Modifier = Modifier) {
  Column(
    modifier =
      modifier {
        apply(modifier)
        fillMaxSize()
        composed { verticalScroll(rememberScrollState()) }
      },
  ) {
    channels.forEachIndexed { i, channel ->
      val pageController = LocalPageController.current
      Row(
        modifier {
          fillMaxWidth()
          drawWithContent {
            drawContent()
            drawLine(
              color = Colors.Neutral20,
              start = Offset(0f, 1f),
              end = Offset(size.width, 1f),
              strokeWidth = 1f,
            )
            if (i == channels.lastIndex) {
              drawLine(
                color = Colors.Neutral20,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = 1f,
              )
            }
          }

          clickable { pageController.navigate(Route.Channel with ("channelId" to channel.id)) }

          padding(16.dp)
        }
      ) {
        ChannelIcon(channel)
        Column {
          Text(
            text = channel.name,
            fontWeight = FontWeight.Medium,
          )
          Text(
            text = channel.latestMessage.ifBlank { "No messages yet" },
            color = Colors.Neutral70,
            fontSize = 12.sp,
          )
        }
      }
    }
  }
}

@Composable
fun ChannelIcon(channel: MessageChannelStub) {
  val random by remember {
    derivedStateOf { Random(channel.id.hashCode() + channel.name.hashCode()) }
  }
  val r = random.nextInt(100, 150)
  val g = random.nextInt(100, 150)
  val b = random.nextInt(100, 150)
  val color = Color(r, g, b)
  val initials by remember {
    derivedStateOf { channel.name.split(" ").map { it.first() }.joinToString("") }
  }

  Box(
    modifier =
      modifier {
        padding(end = 16.dp)
        width(36.dp)
        height(36.dp)
        background(color = color, shape = CircleShape)
      }
  ) {
    Text(
      text = initials,
      color = Color.White,
      textAlign = TextAlign.Center,
      modifier = modifier { align(Alignment.Center) }
    )
  }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MessagesPagePreview() {
  BaselineLayout(
    title = { Text("Messages") },
    floatingActionButton = {
      FloatingActionButton(onClick = {}) { Icon(Icons.Filled.Add, contentDescription = "Add") }
    },
  ) {
    ChannelList(
      modifier = modifier { padding(it) },
      channels =
        listOf(
          messageChannelStub {
            id = "global"
            name = "Global"
            latestMessage = "Jack Greenwald: I am a very cool person"
          },
          messageChannelStub {
            id = "1231231231"
            name = "Jack Greenwald"
            latestMessage = "Jack Greenwald: Hi Caleb"
          },
          messageChannelStub {
            id = "1231231231213123"
            name = "Alex Cheng"
            latestMessage = "Alex Cheng: WHAT IS ANDROID"
          }
        )
    )
  }
}
