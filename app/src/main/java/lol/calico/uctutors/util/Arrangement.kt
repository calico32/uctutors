package lol.calico.uctutors.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.unit.Density

val Arrangement.Reverse: Arrangement.Vertical
  get() = ReverseArrangement

object ReverseArrangement : Arrangement.Vertical {
  override fun Density.arrange(totalSize: Int, sizes: IntArray, outPositions: IntArray) {}
}
