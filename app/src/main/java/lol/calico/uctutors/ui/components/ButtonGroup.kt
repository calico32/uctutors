package lol.calico.uctutors.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import lol.calico.uctutors.ui.theme.Colors

enum class ColorPalette {
  Primary, Secondary, Tertiary,
}

enum class RoundingType {
  None, Top, Bottom, Both,
}

enum class BorderType {
  None, Top, Horizontal, Both,
}

@Composable
fun <T> ButtonGroup(
  items: List<T>,
  modifier: Modifier = Modifier,
  colorPalette: ColorPalette = ColorPalette.Primary,
  onClick: (T, Int) -> Unit,
  active: (T, Int) -> Boolean = { _, _ -> false },
  weight: (T, Int) -> Float = { _, _ -> 1f },
  content: @Composable RowScope.(T, Int) -> Unit,
) {
  ButtonRow(
    items = items,
    modifier = modifier,
    colorPalette = colorPalette,
    onClick = onClick,
    active = active,
    content = content,
    weight = weight,
    roundingType = RoundingType.Both,
    borderType = BorderType.Horizontal,
  )
}

@Composable
fun <T> ButtonGroup(
  items: List<T>,
  modifier: Modifier = Modifier,
  colorPalette: ColorPalette = ColorPalette.Primary,
  onClick: (T) -> Unit,
  active: (T) -> Boolean = { false },
  weight: (T) -> Float = { 1f },
  content: @Composable RowScope.(T) -> Unit,
) {
  ButtonRow(
    items = items,
    modifier = modifier,
    colorPalette = colorPalette,
    onClick = { it, _ -> onClick(it) },
    active = { it, _ -> active(it) },
    roundingType = RoundingType.Both,
    content = { it, _ -> content(it) },
    weight = { it, _ -> weight(it) },
    borderType = BorderType.Horizontal,
  )
}

@SuppressLint("ModifierParameter")
@Composable
fun <T> ButtonGrid(
  items: List<List<T>>,
  rowModifier: Modifier = Modifier,
  columnModifier: Modifier = Modifier,
  colorPalette: ColorPalette = ColorPalette.Primary,
  onClick: (T, row: Int, col: Int) -> Unit,
  active: (T, row: Int, col: Int) -> Boolean = { _, _, _ -> false },
  weight: (T, row: Int, col: Int) -> Float = { _, _, _ -> 1f },
  content: @Composable RowScope.(T, row: Int, col: Int) -> Unit,
) {
  Column(
    modifier = columnModifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    items.forEachIndexed { rowIndex, row ->
      ButtonRow(
        items = row,
        modifier = rowModifier,
        colorPalette = colorPalette,
        onClick = { it, colIndex ->
          onClick(it, rowIndex, colIndex)
        },
        active = { it, colIndex ->
          active(it, rowIndex, colIndex)
        },
        roundingType = when (rowIndex) {
          0 -> RoundingType.Top
          items.size - 1 -> RoundingType.Bottom
          else -> RoundingType.None
        },
        borderType = when (rowIndex) {
          0 -> BorderType.Horizontal
          else -> BorderType.Both
        },
        weight = { it, colIndex ->
          weight(it, rowIndex, colIndex)
        },
      ) { it, colIndex ->
        content(it, rowIndex, colIndex)
      }
    }
  }
}

@SuppressLint("ModifierParameter")
@Composable
fun <T> ButtonGrid(
  items: List<List<T>>,
  rowModifier: Modifier = Modifier,
  columnModifier: Modifier = Modifier,
  colorPalette: ColorPalette = ColorPalette.Primary,
  onClick: (T) -> Unit,
  active: (T) -> Boolean = { false },
  weight: (T) -> Float = { 1f },
  content: @Composable RowScope.(T) -> Unit,
) {
  Column(
    modifier = columnModifier,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    items.forEachIndexed { rowIndex, row ->
      ButtonRow(
        items = row,
        modifier = rowModifier,
        colorPalette = colorPalette,
        onClick = { it, _ -> onClick(it) },
        active = { it, _ -> active(it) },
        roundingType = when (rowIndex) {
          0 -> RoundingType.Top
          items.size - 1 -> RoundingType.Bottom
          else -> RoundingType.None
        },
        borderType = when (rowIndex) {
          0 -> BorderType.Horizontal
          else -> BorderType.Both
        },
        weight = { it, _ -> weight(it) },
      ) { it, _ ->
        content(it)
      }
    }
  }
}


@Composable
fun <T> ButtonRow(
  items: List<T>,
  modifier: Modifier,
  colorPalette: ColorPalette = ColorPalette.Primary,
  onClick: (T, Int) -> Unit,
  active: (T, Int) -> Boolean,
  roundingType: RoundingType,
  borderType: BorderType,
  weight: (T, Int) -> Float,
  content: @Composable RowScope.(T, Int) -> Unit,
) {
  Row(
    modifier = modifier,
    horizontalArrangement = Arrangement.Center,
  ) {
    items.forEachIndexed { i, _ ->
      Button(
        modifier = Modifier
          .fillMaxWidth()
          .height(50.dp)
          .weight(weight(items[i], i))
          .drawWithContent {
            drawContent()
            if (borderType == BorderType.None) return@drawWithContent

            val strokeWidth = 2 * density
            val borderColor = when (colorPalette) {
              ColorPalette.Primary -> Colors.Primary80
              ColorPalette.Secondary -> Colors.Secondary80
              ColorPalette.Tertiary -> Colors.Tertiary80
            }
            if (borderType == BorderType.Both || borderType == BorderType.Top) {
              drawLine(
                borderColor, Offset(0f, 0f), Offset(size.width - density, 0f), strokeWidth
              )
            }
            if ((borderType == BorderType.Both || borderType == BorderType.Horizontal) && i != items.size - 1) {
              drawLine(
                borderColor,
                Offset(size.width - density, 0f),
                Offset(size.width - density, size.height),
                strokeWidth
              )
            }
          },
        onClick = { onClick(items[i], i) },
        shape = run {
          val topAmount = when (roundingType) {
            RoundingType.Top, RoundingType.Both -> 8f
            else -> 0f
          }
          val bottomAmount = when (roundingType) {
            RoundingType.Bottom, RoundingType.Both -> 8f
            else -> 0f
          }

          when (i) {
            0 -> RoundedCornerShape(
              topStart = topAmount.dp, bottomStart = bottomAmount.dp
            )

            items.size - 1 -> RoundedCornerShape(
              topEnd = topAmount.dp, bottomEnd = bottomAmount.dp
            )

            else -> RectangleShape
          }
        },
        contentPadding = PaddingValues(horizontal = 12.dp),
        colors = ButtonDefaults.buttonColors(
          containerColor = if (active(items[i], i)) when (colorPalette) {
            ColorPalette.Primary -> MaterialTheme.colorScheme.primary
            ColorPalette.Secondary -> MaterialTheme.colorScheme.secondary
            ColorPalette.Tertiary -> MaterialTheme.colorScheme.tertiary
          } else when (colorPalette) {
            ColorPalette.Primary -> MaterialTheme.colorScheme.primaryContainer
            ColorPalette.Secondary -> MaterialTheme.colorScheme.secondaryContainer
            ColorPalette.Tertiary -> MaterialTheme.colorScheme.tertiaryContainer
          },
          contentColor = if (active(items[i], i)) when (colorPalette) {
            ColorPalette.Primary -> MaterialTheme.colorScheme.onPrimary
            ColorPalette.Secondary -> MaterialTheme.colorScheme.onSecondary
            ColorPalette.Tertiary -> MaterialTheme.colorScheme.onTertiary
          } else when (colorPalette) {
            ColorPalette.Primary -> MaterialTheme.colorScheme.onPrimaryContainer
            ColorPalette.Secondary -> MaterialTheme.colorScheme.onSecondaryContainer
            ColorPalette.Tertiary -> MaterialTheme.colorScheme.onTertiaryContainer
          },
        ),
      ) {
        content(items[i], i)
      }
    }
  }
}