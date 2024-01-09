package lol.calico.uctutors.ui.page.channel

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import java.util.Date
import lol.calico.uctutors.generated.api.v1.Message
import lol.calico.uctutors.generated.api.v1.MessageChannelStub
import lol.calico.uctutors.generated.api.v1.getChannelInfoRequest
import lol.calico.uctutors.generated.api.v1.getMessagesRequest
import lol.calico.uctutors.generated.api.v1.openChannelRequest
import lol.calico.uctutors.generated.api.v1.sendMessageRequest
import lol.calico.uctutors.ui.components.RemoteImage
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier
import lol.calico.uctutors.util.rememberContextualCoroutineScope

@OptIn(
  ExperimentalMaterial3Api::class,
)
@Composable
fun ChannelPage(contentPadding: PaddingValues) {
  val channelId =
    LocalPageController.current.currentBackStackEntry?.arguments?.getString("channelId")
      ?: error("No channelId in arguments")
  val grpc = LocalGrpcConnection.current
  var messages by remember { mutableStateOf(emptyList<Message>()) }
  var newMessage by remember { mutableStateOf("") }
  val scope = rememberContextualCoroutineScope()
  val pageController = LocalPageController.current
  var channel by remember { mutableStateOf<MessageChannelStub?>(null) }
  val lazyListState = remember { LazyListState() }

  LaunchedEffect(Unit) {
    scope.tryLaunch("Failed to load channel messages") {
      channel =
        grpc.message.getChannelInfo(getChannelInfoRequest { this.channelId = channelId }).channel

      messages +=
        grpc.message
          .getMessages(getMessagesRequest { this.channelId = channelId })
          .messageList
          .messagesList
    }
    grpc.message.openChannel(openChannelRequest { this.channelId = channelId }).collect {
      messages += it.message
    }
  }

  ConstraintLayout(
    modifier =
      modifier {
        fillMaxSize()
        padding(contentPadding)
      }
  ) {
    val (appBar, list, input) = createRefs()

    TopAppBar(
      title = { Text(channel?.name ?: "Loading...") },
      navigationIcon = {
        IconButton(onClick = { pageController.popBackStack() }) {
          Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
        }
      },
      modifier =
        modifier {
          shadow(4.dp)
          constrainAs(appBar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(list.top)
          }
        }
    )

    LazyColumn(
      state = lazyListState,
      modifier =
        modifier {
          apply(Modifier.imePadding())
          constrainAs(list) {
            top.linkTo(appBar.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(input.top)
            height = Dimension.fillToConstraints
          }
        }
    ) {
      itemsIndexed(messages) { i, it ->
        Row(
          horizontalArrangement = Arrangement.spacedBy(16.dp),
          modifier =
            modifier {
              fillMaxWidth()
              background(
                if (i % 2 == 0) {
                  Colors.Primary99
                } else {
                  Colors.Primary98
                }
              )
              padding(16.dp)
            }
        ) {
          RemoteImage(
            id = it.user.avatarId,
            modifier =
              modifier {
                size(48.dp)
                clip(CircleShape)
              }
          )
          Column {
            Row(
              horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
              Text(
                "${it.user.firstName} ${it.user.lastName}",
                fontWeight = FontWeight.SemiBold,
                modifier = modifier { alignByBaseline() },
              )
              Text(
                Date(it.timestamp).toString(),
                color = Colors.Neutral50,
                fontSize = 10.sp,
                modifier = modifier { alignByBaseline() },
              )
            }
            Text(it.text)
          }
        }
      }
    }

    Row(
      modifier =
        modifier {
          apply(Modifier.imePadding())
          fillMaxWidth()
          background(Colors.Neutral95)
          padding(16.dp)
          constrainAs(input) {
            top.linkTo(list.bottom)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
          }
        }
    ) {
      TextField(
        value = newMessage,
        onValueChange = { newMessage = it },
        modifier =
          modifier {
            weight(1f)
            padding(end = 8.dp)
          }
      )
      Button(
        onClick = {
          if (newMessage.isBlank()) {
            return@Button
          }
          scope.tryLaunch("Failed to send message") {
            grpc.message.sendMessage(
              sendMessageRequest {
                this.channelId = channelId
                this.text = newMessage
              }
            )
            newMessage = ""
            lazyListState.animateScrollToItem(messages.size - 1)
          }
        }
      ) {
        Icon(Icons.Outlined.Send, contentDescription = "Send")
      }
    }
  }
}
