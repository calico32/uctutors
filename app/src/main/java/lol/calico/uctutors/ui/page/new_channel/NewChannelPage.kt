package lol.calico.uctutors.ui.page.new_channel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import lol.calico.uctutors.ui.theme.Colors
import lol.calico.uctutors.util.modifier

@Composable
fun NewChannelPage(contentPadding: PaddingValues) {
  Box(
    modifier =
      modifier {
        fillMaxSize()
        background(Colors.Neutral90)
      }
  )
}
