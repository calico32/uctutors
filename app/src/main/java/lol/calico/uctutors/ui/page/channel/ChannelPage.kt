package lol.calico.uctutors.ui.page.channel

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import lol.calico.uctutors.generated.api.v1.Message
import lol.calico.uctutors.generated.api.v1.MessageChannelStub
import lol.calico.uctutors.generated.api.v1.getChannelInfoRequest
import lol.calico.uctutors.generated.api.v1.getMessagesRequest
import lol.calico.uctutors.generated.api.v1.openChannelRequest
import lol.calico.uctutors.generated.api.v1.sendMessageRequest
import lol.calico.uctutors.ui.compose.LocalGrpcConnection
import lol.calico.uctutors.ui.compose.LocalPageController
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
  var messageInput by remember { mutableStateOf("") }
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
      lazyListState.animateScrollToItem(messages.size - 1)
    }
  }

  ChannelLayout(
    contentPadding = contentPadding,
    listState = lazyListState,
    channel = channel,
    messages = messages,
    onNavigateBack = { pageController.popBackStack() },
    onMessageInputChanged = { messageInput = it },
    onSendMessage = {
      if (it.isBlank()) {
        return@ChannelLayout
      }
      scope.tryLaunch("Failed to send message") {
        grpc.message.sendMessage(
          sendMessageRequest {
            this.channelId = channelId
            this.text = it
          }
        )
        messageInput = ""
        lazyListState.animateScrollToItem(messages.size - 1)
      }
    }
  )
}
