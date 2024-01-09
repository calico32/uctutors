package lol.calico.uctutors.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Suppress("NAME_SHADOWING")
@Composable
fun ReverseColumn(
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit,
) {
  Layout(modifier = modifier, content = content) { measurables, constraints ->
    val measurables = measurables.reversed()
    layout(constraints.maxWidth, constraints.maxHeight) {
      var yPosition = constraints.maxHeight
      measurables.forEach {
        val placeable = it.measure(constraints.copy(minHeight = 0, maxHeight = yPosition))
        yPosition -= placeable.height
        placeable.place(0, yPosition)
      }
    }
  }
}
