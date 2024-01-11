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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import lol.calico.uctutors.generated.api.v1.Message
import lol.calico.uctutors.generated.api.v1.MessageChannelStub
import lol.calico.uctutors.generated.api.v1.message
import lol.calico.uctutors.generated.api.v1.messageChannelStub
import lol.calico.uctutors.generated.api.v1.userStub
import lol.calico.uctutors.ui.components.RemoteImage
import lol.calico.uctutors.ui.compose.BaselineLayout
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChannelLayout(
  contentPadding: PaddingValues,
  listState: LazyListState,
  channel: MessageChannelStub?,
  messages: List<Message>,
  messageInput: String = "",
  onMessageInputChanged: (String) -> Unit,
  onNavigateBack: () -> Unit,
  onSendMessage: (String) -> Unit,
) {
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
        IconButton(onClick = onNavigateBack) {
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
      state = listState,
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
          background(Colors.Primary95)
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
        value = messageInput,
        onValueChange = onMessageInputChanged,
        modifier =
          modifier {
            weight(1f)
            padding(end = 8.dp)
          }
      )
      Button(onClick = { onSendMessage(messageInput) }) {
        Icon(Icons.Outlined.Send, contentDescription = "Send")
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun ChannelLayoutPreviewEmpty() {
  BaselineLayout {
    ChannelLayout(
      contentPadding = PaddingValues(),
      listState = LazyListState(),
      channel = null,
      messages = listOf(),
      messageInput = "",
      onMessageInputChanged = {},
      onNavigateBack = {},
      onSendMessage = {},
    )
  }
}

@Preview(showSystemUi = true)
@Composable
fun ChannelLayoutPreviewFull() {
  BaselineLayout {
    ChannelLayout(
      contentPadding = PaddingValues(),
      listState = LazyListState(),
      channel =
        messageChannelStub {
          name = "Test Channel"
          description = "This is a test channel"
          id = "test-channel"
        },
      messages =
        listOf(
          message {
            id = "test-message-1"
            text = "This is a test message"
            timestamp = 0
            user = userStub {
              id = "test-user-1"
              firstName = "Test"
              lastName = "User"
              avatarId = ""
            }
          }
        ),
      messageInput = "",
      onMessageInputChanged = {},
      onNavigateBack = {},
      onSendMessage = {},
    )
  }
}
