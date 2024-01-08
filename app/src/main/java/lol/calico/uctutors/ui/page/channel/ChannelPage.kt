package lol.calico.uctutors.ui.page.channel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import lol.calico.uctutors.generated.api.v1.Message
import lol.calico.uctutors.generated.api.v1.getMessagesRequest
import lol.calico.uctutors.generated.api.v1.openChannelRequest
import lol.calico.uctutors.generated.api.v1.sendMessageRequest
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalPageController
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

@Composable
fun ChannelPage(contentPadding: PaddingValues) {
  val channelId =
    LocalPageController.current.currentBackStackEntry?.arguments?.getString("channelId")
      ?: error("No channelId in arguments")
  val grpc = LocalGrpcConnection.current
  var messages by remember { mutableStateOf(emptyList<Message>()) }
  var newMessage by remember { mutableStateOf("") }
  val scope = rememberCoroutineScope()

  LaunchedEffect(Unit) {
    val existing = grpc.message.getMessages(getMessagesRequest { this.channelId = channelId })
    messages += existing.messageList.messagesList
    grpc.message.openChannel(openChannelRequest { this.channelId = channelId }).collect {
      messages += it.message
    }
  }

  Column(
    modifier =
      modifier {
        padding(contentPadding)
        fillMaxHeight()
      }
  ) {
    Column(
      modifier =
        modifier {
          fillMaxHeight()
          composed { verticalScroll(rememberScrollState()) }
        }
    ) {
      messages.forEachIndexed { i, it ->
        Column(
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
          Row {
            Text(it.user.firstName)
            Text(it.user.lastName)
          }
          Text(it.text)
        }
      }

      Row(
        modifier =
          modifier {
            apply(Modifier.imePadding())
            background(Colors.Neutral95)
            padding(16.dp)
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
            scope.launch {
              grpc.message.sendMessage(
                sendMessageRequest {
                  this.channelId = channelId
                  this.text = newMessage
                }
              )
              newMessage = ""
            }
          }
        ) {
          Text("Send")
        }
      }
    }
  }
}
