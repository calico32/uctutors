package lol.calico.uctutors.util

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import androidx.annotation.FloatRange
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.CacheDrawScope
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutScope

@SuppressLint("ModifierFactoryExtensionFunction", "ComposableModifierFactory")
fun modifier(block: ModifierDsl.() -> Unit): Modifier {
  return ModifierDsl().run {
    block()
    modifier
  }
}

class ModifierDsl {
  var modifier: Modifier = Modifier

  /** Concatenates this modifier with another. */
  fun apply(modifier: Modifier) {
    this.modifier = this.modifier then modifier
  }

  @SuppressLint("UnnecessaryComposedModifier")
  fun composed(block: @Composable ModifierDsl.() -> Unit) {
    modifier = modifier.composed { ModifierDsl().apply { block() }.modifier }
  }

  /* ***************************************************************************************** *
   *
   * Custom
   *
   * ***************************************************************************************** */

  fun innerShadow(
    color: Color = Color.Black,
    cornersRadius: Dp = 0.dp,
    spread: Dp = 0.dp,
    blur: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
  ) = drawWithContent {
    drawContent()

    val rect = Rect(Offset.Zero, size)
    val paint = Paint()

    drawIntoCanvas {
      paint.color = color
      paint.isAntiAlias = true
      it.saveLayer(rect, paint)
      it.drawRoundRect(
        left = rect.left,
        top = rect.top,
        right = rect.right,
        bottom = rect.bottom,
        cornersRadius.toPx(),
        cornersRadius.toPx(),
        paint
      )
      val frameworkPaint = paint.asFrameworkPaint()
      frameworkPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
      if (blur.toPx() > 0) {
        frameworkPaint.maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
      }
      val left =
        if (offsetX > 0.dp) {
          rect.left + offsetX.toPx()
        } else {
          rect.left
        }
      val top =
        if (offsetY > 0.dp) {
          rect.top + offsetY.toPx()
        } else {
          rect.top
        }
      val right =
        if (offsetX < 0.dp) {
          rect.right + offsetX.toPx()
        } else {
          rect.right
        }
      val bottom =
        if (offsetY < 0.dp) {
          rect.bottom + offsetY.toPx()
        } else {
          rect.bottom
        }
      paint.color = Color.Black
      it.drawRoundRect(
        left = left + spread.toPx() / 2,
        top = top + spread.toPx() / 2,
        right = right - spread.toPx() / 2,
        bottom = bottom - spread.toPx() / 2,
        cornersRadius.toPx(),
        cornersRadius.toPx(),
        paint
      )
      frameworkPaint.xfermode = null
      frameworkPaint.maskFilter = null
    }
  }

  /* ***************************************************************************************** *
   *
   * Padding.kt
   *
   * ***************************************************************************************** */

  /**
   * Apply additional space along each edge of the content in [Dp]: [start], [top], [end] and
   * [bottom]. The start and end edges will be determined by the current [LayoutDirection]. Padding
   * is applied before content measurement and takes precedence; content may only be as large as the
   * remaining space.
   *
   * Negative padding is not permitted — it will cause [IllegalArgumentException]. See
   * [Modifier.offset].
   */
  fun padding(start: Dp = 0.dp, top: Dp = 0.dp, end: Dp = 0.dp, bottom: Dp = 0.dp) {
    modifier = modifier.padding(start, top, end, bottom)
  }

  /**
   * Apply [horizontal] dp space along the left and right edges of the content, and [vertical] dp
   * space along the top and bottom edges. Padding is applied before content measurement and takes
   * precedence; content may only be as large as the remaining space.
   *
   * Negative padding is not permitted — it will cause [IllegalArgumentException]. See
   * [Modifier.offset].
   */
  fun padding(horizontal: Dp = 0.dp, vertical: Dp = 0.dp) {
    modifier = modifier.padding(horizontal, vertical)
  }

  /**
   * Apply [all] dp of additional space along each edge of the content, left, top, right and bottom.
   * Padding is applied before content measurement and takes precedence; content may only be as
   * large as the remaining space.
   *
   * Negative padding is not permitted — it will cause [IllegalArgumentException]. See
   * [Modifier.offset].
   */
  fun padding(all: Dp) {
    modifier = modifier.padding(all)
  }

  /**
   * Apply [PaddingValues] to the component as additional space along each edge of the content's
   * left, top, right and bottom. Padding is applied before content measurement and takes
   * precedence; content may only be as large as the remaining space.
   *
   * Negative padding is not permitted — it will cause [IllegalArgumentException]. See
   * [Modifier.offset].
   */
  fun padding(paddingValues: PaddingValues) {
    modifier = modifier.padding(paddingValues)
  }

  /**
   * Apply additional space along each edge of the content in [Dp]: [left], [top], [right] and
   * [bottom]. These paddings are applied without regard to the current [LayoutDirection], see
   * [padding] to apply relative paddings. Padding is applied before content measurement and takes
   * precedence; content may only be as large as the remaining space.
   *
   * Negative padding is not permitted — it will cause [IllegalArgumentException]. See
   * [Modifier.offset].
   */
  fun absolutePadding(left: Dp = 0.dp, top: Dp = 0.dp, right: Dp = 0.dp, bottom: Dp = 0.dp) {
    modifier = modifier.absolutePadding(left, top, right, bottom)
  }

  /* ***************************************************************************************** *
   *
   * Size.kt
   *
   * ***************************************************************************************** */

  /**
   * Declare the preferred width of the content to be exactly [width]dp. The incoming measurement
   * [Constraints] may override this value, forcing the content to be either smaller or larger.
   *
   * For a modifier that sets the width of the content regardless of the incoming constraints see
   * [Modifier.requiredWidth]. See [height] or [size] to set other preferred dimensions. See
   * [widthIn], [heightIn] or [sizeIn] to set a preferred size range.
   */
  fun width(width: Dp) {
    modifier = modifier.width(width)
  }

  /**
   * Declare the preferred height of the content to be exactly [height]dp. The incoming measurement
   * [Constraints] may override this value, forcing the content to be either smaller or larger.
   *
   * For a modifier that sets the height of the content regardless of the incoming constraints see
   * [Modifier.requiredHeight]. See [width] or [size] to set other preferred dimensions. See
   * [widthIn], [heightIn] or [sizeIn] to set a preferred size range.
   */
  fun height(height: Dp) {
    modifier = modifier.height(height)
  }

  /**
   * Declare the preferred size of the content to be exactly [size]dp square. The incoming
   * measurement [Constraints] may override this value, forcing the content to be either smaller or
   * larger.
   *
   * For a modifier that sets the size of the content regardless of the incoming constraints, see
   * [Modifier.requiredSize]. See [width] or [height] to set width or height alone. See [widthIn],
   * [heightIn] or [sizeIn] to set a preferred size range.
   */
  fun size(size: Dp) {
    modifier = modifier.size(size)
  }

  /**
   * Declare the preferred size of the content to be exactly [width]dp by [height]dp. The incoming
   * measurement [Constraints] may override this value, forcing the content to be either smaller or
   * larger.
   *
   * For a modifier that sets the size of the content regardless of the incoming constraints, see
   * [Modifier.requiredSize]. See [width] or [height] to set width or height alone. See [widthIn],
   * [heightIn] or [sizeIn] to set a preferred size range.
   */
  fun size(width: Dp, height: Dp) {
    modifier = modifier.size(width, height)
  }

  /**
   * Declare the preferred size of the content to be exactly [size]. The incoming measurement
   * [Constraints] may override this value, forcing the content to be either smaller or larger.
   *
   * For a modifier that sets the size of the content regardless of the incoming constraints, see
   * [Modifier.requiredSize]. See [width] or [height] to set width or height alone. See [widthIn],
   * [heightIn] or [sizeIn] to set a preferred size range.
   */
  fun size(size: DpSize) {
    modifier = modifier.size(size)
  }

  /**
   * Constrain the width of the content to be between [min]dp and [max]dp as permitted by the
   * incoming measurement [Constraints]. If the incoming constraints are more restrictive the
   * requested size will obey the incoming constraints and attempt to be as close as possible to the
   * preferred size.
   */
  fun widthIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified) {
    modifier = modifier.widthIn(min, max)
  }

  /**
   * Constrain the height of the content to be between [min]dp and [max]dp as permitted by the
   * incoming measurement [Constraints]. If the incoming constraints are more restrictive the
   * requested size will obey the incoming constraints and attempt to be as close as possible to the
   * preferred size.
   */
  fun heightIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified) {
    modifier = modifier.heightIn(min, max)
  }

  /**
   * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp and the height
   * of the content to be between [minHeight]dp and [maxHeight]dp as permitted by the incoming
   * measurement [Constraints]. If the incoming constraints are more restrictive the requested size
   * will obey the incoming constraints and attempt to be as close as possible to the preferred
   * size.
   */
  fun sizeIn(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
  ) {
    modifier = modifier.sizeIn(minWidth, minHeight, maxWidth, maxHeight)
  }

  /**
   * Declare the width of the content to be exactly [width]dp. The incoming measurement
   * [Constraints] will not override this value. If the content chooses a size that does not satisfy
   * the incoming [Constraints], the parent layout will be reported a size coerced in the
   * [Constraints], and the position of the content will be automatically offset to be centered on
   * the space assigned to the child by the parent layout under the assumption that [Constraints]
   * were respected.
   *
   * See [requiredWidthIn] and [requiredSizeIn] to set a size range. See [width] to set a preferred
   * width, which is only respected when the incoming constraints allow it.
   */
  fun requiredWidth(width: Dp) {
    modifier = modifier.requiredWidth(width)
  }

  /**
   * Declare the height of the content to be exactly [height]dp. The incoming measurement
   * [Constraints] will not override this value. If the content chooses a size that does not satisfy
   * the incoming [Constraints], the parent layout will be reported a size coerced in the
   * [Constraints], and the position of the content will be automatically offset to be centered on
   * the space assigned to the child by the parent layout under the assumption that [Constraints]
   * were respected.
   *
   * See [requiredHeightIn] and [requiredSizeIn] to set a size range. See [height] to set a
   * preferred height, which is only respected when the incoming constraints allow it.
   */
  fun requiredHeight(height: Dp) {
    modifier = modifier.requiredHeight(height)
  }

  /**
   * Declare the size of the content to be exactly [size]dp width and height. The incoming
   * measurement [Constraints] will not override this value. If the content chooses a size that does
   * not satisfy the incoming [Constraints], the parent layout will be reported a size coerced in
   * the [Constraints], and the position of the content will be automatically offset to be centered
   * on the space assigned to the child by the parent layout under the assumption that [Constraints]
   * were respected.
   *
   * See [requiredSizeIn] to set a size range. See [size] to set a preferred size, which is only
   * respected when the incoming constraints allow it.
   */
  fun requiredSize(size: Dp) {
    modifier = modifier.requiredSize(size, size)
  }

  /**
   * Declare the size of the content to be exactly [width]dp and [height]dp. The incoming
   * measurement [Constraints] will not override this value. If the content chooses a size that does
   * not satisfy the incoming [Constraints], the parent layout will be reported a size coerced in
   * the [Constraints], and the position of the content will be automatically offset to be centered
   * on the space assigned to the child by the parent layout under the assumption that [Constraints]
   * were respected.
   *
   * See [requiredSizeIn] to set a size range. See [size] to set a preferred size, which is only
   * respected when the incoming constraints allow it.
   */
  fun requiredSize(width: Dp, height: Dp) {
    modifier = modifier.requiredSize(width, height)
  }

  /**
   * Declare the size of the content to be exactly [size]. The incoming measurement [Constraints]
   * will not override this value. If the content chooses a size that does not satisfy the incoming
   * [Constraints], the parent layout will be reported a size coerced in the [Constraints], and the
   * position of the content will be automatically offset to be centered on the space assigned to
   * the child by the parent layout under the assumption that [Constraints] were respected.
   *
   * See [requiredSizeIn] to set a size range. See [size] to set a preferred size, which is only
   * respected when the incoming constraints allow it.
   */
  fun requiredSize(size: DpSize) {
    modifier = modifier.requiredSize(size)
  }

  /**
   * Constrain the width of the content to be between [min]dp and [max]dp. If the content chooses a
   * size that does not satisfy the incoming [Constraints], the parent layout will be reported a
   * size coerced in the [Constraints], and the position of the content will be automatically offset
   * to be centered on the space assigned to the child by the parent layout under the assumption
   * that [Constraints] were respected.
   */
  fun requiredWidthIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified) {
    modifier = modifier.requiredWidthIn(min, max)
  }

  /**
   * Constrain the height of the content to be between [min]dp and [max]dp. If the content chooses a
   * size that does not satisfy the incoming [Constraints], the parent layout will be reported a
   * size coerced in the [Constraints], and the position of the content will be automatically offset
   * to be centered on the space assigned to the child by the parent layout under the assumption
   * that [Constraints] were respected.
   */
  fun requiredHeightIn(min: Dp = Dp.Unspecified, max: Dp = Dp.Unspecified) {
    modifier = modifier.requiredHeightIn(min, max)
  }

  /**
   * Constrain the width of the content to be between [minWidth]dp and [maxWidth]dp, and the height
   * of the content to be between [minHeight]dp and [maxHeight]dp. If the content chooses a size
   * that does not satisfy the incoming [Constraints], the parent layout will be reported a size
   * coerced in the [Constraints], and the position of the content will be automatically offset to
   * be centered on the space assigned to the child by the parent layout under the assumption that
   * [Constraints] were respected.
   */
  fun requiredSizeIn(
    minWidth: Dp = Dp.Unspecified,
    minHeight: Dp = Dp.Unspecified,
    maxWidth: Dp = Dp.Unspecified,
    maxHeight: Dp = Dp.Unspecified
  ) {
    modifier = modifier.requiredSizeIn(minWidth, minHeight, maxWidth, maxHeight)
  }

  /**
   * Have the content fill (possibly only partially) the [Constraints.maxWidth] of the incoming
   * measurement constraints, by setting the [minimum width][Constraints.minWidth] and the
   * [maximum width][Constraints.maxWidth] to be equal to the [maximum width][Constraints.maxWidth]
   * multiplied by [fraction]. Note that, by default, the [fraction] is 1, so the modifier will make
   * the content fill the whole available width. If the incoming maximum width is
   * [Constraints.Infinity] this modifier will have no effect.
   *
   * @param fraction The fraction of the maximum width to use, between `0` and `1`, inclusive.
   */
  fun fillMaxWidth(/*@FloatRange(from = 0.0, to = 1.0)*/ fraction: Float = 1f) {
    modifier = modifier.fillMaxWidth(fraction)
  }

  /**
   * Have the content fill (possibly only partially) the [Constraints.maxHeight] of the incoming
   * measurement constraints, by setting the [minimum height][Constraints.minHeight] and the
   * [maximum height][Constraints.maxHeight] to be equal to the
   * [maximum height][Constraints.maxHeight] multiplied by [fraction]. Note that, by default, the
   * [fraction] is 1, so the modifier will make the content fill the whole available height. If the
   * incoming maximum height is [Constraints.Infinity] this modifier will have no effect.
   *
   * @param fraction The fraction of the maximum height to use, between `0` and `1`, inclusive.
   */
  fun fillMaxHeight(/*@FloatRange(from = 0.0, to = 1.0)*/ fraction: Float = 1f) {
    modifier = modifier.fillMaxHeight(fraction)
  }

  /**
   * Have the content fill (possibly only partially) the [Constraints.maxWidth] and
   * [Constraints.maxHeight] of the incoming measurement constraints, by setting the
   * [minimum width][Constraints.minWidth] and the [maximum width][Constraints.maxWidth] to be equal
   * to the [maximum width][Constraints.maxWidth] multiplied by [fraction], as well as the
   * [minimum height][Constraints.minHeight] and the [maximum height][Constraints.minHeight] to be
   * equal to the [maximum height][Constraints.maxHeight] multiplied by [fraction]. Note that, by
   * default, the [fraction] is 1, so the modifier will make the content fill the whole available
   * space. If the incoming maximum width or height is [Constraints.Infinity] this modifier will
   * have no effect in that dimension.
   *
   * @param fraction The fraction of the maximum size to use, between `0` and `1`, inclusive.
   */
  fun fillMaxSize(/*@FloatRange(from = 0.0, to = 1.0)*/ fraction: Float = 1f) {
    modifier = modifier.fillMaxSize(fraction)
  }
  /**
   * Allow the content to measure at its desired width without regard for the incoming measurement
   * [minimum width constraint][Constraints.minWidth], and, if [unbounded] is true, also without
   * regard for the incoming measurement [maximum width constraint][Constraints.maxWidth]. If the
   * content's measured size is smaller than the minimum width constraint, [align] it within that
   * minimum width space. If the content's measured size is larger than the maximum width constraint
   * (only possible when [unbounded] is true), [align] over the maximum width space.
   */
  fun wrapContentWidth(
    align: Alignment.Horizontal = Alignment.CenterHorizontally,
    unbounded: Boolean = false
  ) {
    modifier = modifier.wrapContentWidth(align, unbounded)
  }

  /**
   * Allow the content to measure at its desired height without regard for the incoming measurement
   * [minimum height constraint][Constraints.minHeight], and, if [unbounded] is true, also without
   * regard for the incoming measurement [maximum height constraint][Constraints.maxHeight]. If the
   * content's measured size is smaller than the minimum height constraint, [align] it within that
   * minimum height space. If the content's measured size is larger than the maximum height
   * constraint (only possible when [unbounded] is true), [align] over the maximum height space.
   */
  fun wrapContentHeight(
    align: Alignment.Vertical = Alignment.CenterVertically,
    unbounded: Boolean = false
  ) {
    modifier = modifier.wrapContentHeight(align, unbounded)
  }

  /**
   * Allow the content to measure at its desired size without regard for the incoming measurement
   * [minimum width][Constraints.minWidth] or [minimum height][Constraints.minHeight] constraints,
   * and, if [unbounded] is true, also without regard for the incoming maximum constraints. If the
   * content's measured size is smaller than the minimum size constraint, [align] it within that
   * minimum sized space. If the content's measured size is larger than the maximum size constraint
   * (only possible when [unbounded] is true), [align] within the maximum space.
   */
  fun wrapContentSize(align: Alignment = Alignment.Center, unbounded: Boolean = false) {
    modifier = modifier.wrapContentSize(align, unbounded)
  }

  /**
   * Constrain the size of the wrapped layout only when it would be otherwise unconstrained: the
   * [minWidth] and [minHeight] constraints are only applied when the incoming corresponding
   * constraint is `0`. The modifier can be used, for example, to define a default min size of a
   * component, while still allowing it to be overidden with smaller min sizes across usages.
   */
  fun defaultMinSize(minWidth: Dp = Dp.Unspecified, minHeight: Dp = Dp.Unspecified) {
    modifier = modifier.defaultMinSize(minWidth, minHeight)
  }

  /* ***************************************************************************************** *
   *
   * Scroll.kt
   *
   * ***************************************************************************************** */

  fun verticalScroll(
    state: ScrollState,
    enabled: Boolean = true,
    flingBehavior: FlingBehavior? = null,
    reverseScrolling: Boolean = false
  ) {
    modifier =
      modifier.verticalScroll(
        state = state,
        enabled = enabled,
        flingBehavior = flingBehavior,
        reverseScrolling = reverseScrolling,
      )
  }

  /**
   * Modify element to allow to scroll horizontally when width of the content is bigger than max
   * constraints allow.
   *
   * In order to use this modifier, you need to create and own [ScrollState]
   *
   * @param state state of the scroll
   * @param enabled whether or not scrolling via touch input is enabled
   * @param flingBehavior logic describing fling behavior when drag has finished with velocity. If
   *   `null`, default from [ScrollableDefaults.flingBehavior] will be used.
   * @param reverseScrolling reverse the direction of scrolling, when `true`, 0 [ScrollState.value]
   *   will mean right, when `false`, 0 [ScrollState.value] will mean left
   * @see [rememberScrollState]
   */
  fun horizontalScroll(
    state: ScrollState,
    enabled: Boolean = true,
    flingBehavior: FlingBehavior? = null,
    reverseScrolling: Boolean = false
  ) {
    modifier =
      modifier.horizontalScroll(
        state = state,
        enabled = enabled,
        flingBehavior = flingBehavior,
        reverseScrolling = reverseScrolling,
      )
  }

  /* ***************************************************************************************** *
   *
   * DrawModifier.kt
   *
   * ***************************************************************************************** */

  /** Draw into a [Canvas] behind the modified content. */
  fun drawBehind(onDraw: DrawScope.() -> Unit) {
    modifier = modifier.drawBehind(onDraw)
  }

  /**
   * Draw into a [DrawScope] with content that is persisted across draw calls as long as the size of
   * the drawing area is the same or any state objects that are read have not changed. In the event
   * that the drawing area changes, or the underlying state values that are being read change, this
   * method is invoked again to recreate objects to be used during drawing
   *
   * For example, a [androidx.compose.ui.graphics.LinearGradient] that is to occupy the full bounds
   * of the drawing area can be created once the size has been defined and referenced for subsequent
   * draw calls without having to re-allocate.
   */
  fun drawWithCache(onBuildDrawCache: CacheDrawScope.() -> DrawResult) {
    modifier = modifier.drawWithCache(onBuildDrawCache)
  }

  /**
   * Creates a [DrawModifier] that allows the developer to draw before or after the layout's
   * contents. It also allows the modifier to adjust the layout's canvas.
   */
  fun drawWithContent(onDraw: ContentDrawScope.() -> Unit) {
    modifier = modifier.drawWithContent(onDraw)
  }

  /* ***************************************************************************************** *
   *
   * Clip.kt
   *
   * ***************************************************************************************** */

  /** Clip the content to the bounds of a layer defined at this modifier. */
  fun clipToBounds() {
    modifier = modifier.clipToBounds()
  }

  /**
   * Clip the content to [shape].
   *
   * @param shape the content will be clipped to this [Shape].
   */
  fun clip(shape: Shape) {
    modifier = modifier.clip(shape)
  }

  /* ***************************************************************************************** *
   *
   * Shadow.kt
   *
   * ***************************************************************************************** */

  /**
   * Creates a [graphicsLayer] that draws a shadow. The [elevation] defines the visual depth of the
   * physical object. The physical object has a shape specified by [shape].
   *
   * If the passed [shape] is concave the shadow will not be drawn on Android versions less than 10.
   *
   * Note that [elevation] is only affecting the shadow size and doesn't change the drawing order.
   * Use a [androidx.compose.ui.zIndex] modifier if you want to draw the elements with larger
   * [elevation] after all the elements with a smaller one.
   *
   * Usage of this API renders this composable into a separate graphics layer
   *
   * @param elevation The elevation for the shadow in pixels
   * @param shape Defines a shape of the physical object
   * @param clip When active, the content drawing clips to the shape.
   * @see graphicsLayer
   */
  fun shadow(
    elevation: Dp,
    shape: Shape = RectangleShape,
    clip: Boolean = elevation > 0.dp,
    ambientColor: Color = DefaultShadowColor,
    spotColor: Color = DefaultShadowColor,
  ) {
    modifier = modifier.shadow(elevation, shape, clip, ambientColor, spotColor)
  }

  /* ***************************************************************************************** *
   *
   * Background.kt
   *
   * ***************************************************************************************** */

  /**
   * Draws [shape] with a solid [color] behind the content.
   *
   * @param color color to paint background with
   * @param shape desired shape of the background
   */
  fun background(color: Color, shape: Shape = RectangleShape) {
    modifier = modifier.background(color, shape)
  }

  /**
   * Draws [shape] with [brush] behind the content.
   *
   * @param brush brush to paint background with
   * @param shape desired shape of the background
   * @param alpha Opacity to be applied to the [brush], with `0` being completely transparent and
   *   `1` being completely opaque. The value must be between `0` and `1`.
   */
  fun background(
    brush: Brush,
    shape: Shape = RectangleShape,
    /*@FloatRange(from = 0.0, to = 1.0)*/
    alpha: Float = 1.0f
  ) {
    modifier = modifier.background(brush, shape, alpha)
  }

  /* ***************************************************************************************** *
   *
   * Border.kt
   *
   * ***************************************************************************************** */

  /**
   * Modify element to add border with appearance specified with a [border] and a [shape] and clip
   * it.
   *
   * @param border [BorderStroke] class that specifies border appearance, such as size and color
   * @param shape shape of the border
   */
  fun border(border: BorderStroke, shape: Shape = RectangleShape) {
    modifier = modifier.border(border, shape)
  }

  /**
   * Modify element to add border with appearance specified with a [width], a [color] and a [shape]
   * and clip it.
   *
   * @param width width of the border. Use [Dp.Hairline] for a hairline border.
   * @param color color to paint the border with
   * @param shape shape of the border
   */
  fun border(width: Dp, color: Color, shape: Shape = RectangleShape) {
    modifier = modifier.border(width, color, shape)
  }
  /**
   * Modify element to add border with appearance specified with a [width], a [brush] and a [shape]
   * and clip it.
   *
   * @param width width of the border. Use [Dp.Hairline] for a hairline border.
   * @param brush brush to paint the border with
   * @param shape shape of the border
   */
  fun border(width: Dp, brush: Brush, shape: Shape) {
    modifier = modifier.border(width, brush, shape)
  }

  /* ***************************************************************************************** *
   *
   * Column.kt
   *
   * ***************************************************************************************** */

  /**
   * Size the element's height proportional to its [weight] relative to other weighted sibling
   * elements in the [Column]. The parent will divide the vertical space remaining after measuring
   * unweighted child elements and distribute it according to this weight. When [fill] is true, the
   * element will be forced to occupy the whole height allocated to it. Otherwise, the element is
   * allowed to be smaller - this will result in [Column] being smaller, as the unused allocated
   * height will not be redistributed to other siblings.
   *
   * In a [FlowColumn], when a weight is applied to an item, the item is scaled based on the number
   * of weighted items that fall on the column it was placed in.
   *
   * @param weight The proportional height to give to this element, as related to the total of all
   *   weighted siblings. Must be positive.
   * @param fill When `true`, the element will occupy the whole height allocated.
   */
  fun ColumnScope.weight(
    @FloatRange(from = 0.0, fromInclusive = false) weight: Float,
    fill: Boolean = true
  ) {
    modifier = modifier.weight(weight, fill)
  }

  /**
   * Align the element horizontally within the [Column]. This alignment will have priority over the
   * [Column]'s `horizontalAlignment` parameter.
   */
  fun ColumnScope.align(alignment: Alignment.Horizontal) {
    modifier = modifier.align(alignment)
  }

  /**
   * Position the element horizontally such that its [alignmentLine] aligns with sibling elements
   * also configured to [alignBy]. [alignBy] is a form of [align], so both modifiers will not work
   * together if specified for the same layout. Within a [Column], all components with [alignBy]
   * will align horizontally using the specified [VerticalAlignmentLine]s or values provided using
   * the other [alignBy] overload, forming a sibling group. At least one element of the sibling
   * group will be placed as it had [Alignment.Start] align in [Column], and the alignment of the
   * other siblings will be then determined such that the alignment lines coincide. Note that if
   * only one element in a [Column] has the [alignBy] modifier specified the element will be
   * positioned as if it had [Alignment.Start] align.
   */
  fun ColumnScope.alignBy(alignmentLine: VerticalAlignmentLine) {
    modifier = modifier.alignBy(alignmentLine)
  }

  /**
   * Position the element horizontally such that the alignment line for the content as determined by
   * [alignmentLineBlock] aligns with sibling elements also configured to [alignBy]. [alignBy] is a
   * form of [align], so both modifiers will not work together if specified for the same layout.
   * Within a [Column], all components with [alignBy] will align horizontally using the specified
   * [VerticalAlignmentLine]s or values obtained from [alignmentLineBlock], forming a sibling group.
   * At least one element of the sibling group will be placed as it had [Alignment.Start] align in
   * [Column], and the alignment of the other siblings will be then determined such that the
   * alignment lines coincide. Note that if only one element in a [Column] has the [alignBy]
   * modifier specified the element will be positioned as if it had [Alignment.Start] align.
   */
  @Stable
  fun ColumnScope.alignBy(alignmentLineBlock: (Measured) -> Int) {
    modifier = modifier.alignBy(alignmentLineBlock)
  }

  /* ***************************************************************************************** *
   *
   * Row.kt
   *
   * ***************************************************************************************** */

  /**
   * Size the element's width proportional to its [weight] relative to other weighted sibling
   * elements in the [Row]. The parent will divide the horizontal space remaining after measuring
   * unweighted child elements and distribute it according to this weight. When [fill] is true, the
   * element will be forced to occupy the whole width allocated to it. Otherwise, the element is
   * allowed to be smaller - this will result in [Row] being smaller, as the unused allocated width
   * will not be redistributed to other siblings.
   *
   * @param weight The proportional width to give to this element, as related to the total of all
   *   weighted siblings. Must be positive.
   * @param fill When `true`, the element will occupy the whole width allocated.
   */
  @Stable
  fun RowScope.weight(
    /*@FloatRange(from = 0.0, fromInclusive = false)*/
    weight: Float,
    fill: Boolean = true
  ) {
    modifier = modifier.weight(weight, fill)
  }

  /**
   * Align the element vertically within the [Row]. This alignment will have priority over the
   * [Row]'s `verticalAlignment` parameter.
   */
  @Stable
  fun RowScope.align(alignment: Alignment.Vertical) {
    modifier = modifier.align(alignment)
  }

  /**
   * Position the element vertically such that its [alignmentLine] aligns with sibling elements also
   * configured to [alignBy]. [alignBy] is a form of [align], so both modifiers will not work
   * together if specified for the same layout. [alignBy] can be used to align two layouts by
   * baseline inside a [Row], using `alignBy(FirstBaseline)`. Within a [Row], all components with
   * [alignBy] will align vertically using the specified [HorizontalAlignmentLine]s or values
   * provided using the other [alignBy] overload, forming a sibling group. At least one element of
   * the sibling group will be placed as it had [Alignment.Top] align in [Row], and the alignment of
   * the other siblings will be then determined such that the alignment lines coincide. Note that if
   * only one element in a [Row] has the [alignBy] modifier specified the element will be positioned
   * as if it had [Alignment.Top] align.
   *
   * @see alignByBaseline
   */
  @Stable
  fun RowScope.alignBy(alignmentLine: HorizontalAlignmentLine) {
    modifier = modifier.alignBy(alignmentLine)
  }

  /**
   * Position the element vertically such that its first baseline aligns with sibling elements also
   * configured to [alignByBaseline] or [alignBy]. This modifier is a form of [align], so both
   * modifiers will not work together if specified for the same layout. [alignByBaseline] is a
   * particular case of [alignBy]. See [alignBy] for more details.
   *
   * @see alignBy
   */
  @Stable
  fun RowScope.alignByBaseline() {
    modifier = modifier.alignByBaseline()
  }

  /**
   * Position the element vertically such that the alignment line for the content as determined by
   * [alignmentLineBlock] aligns with sibling elements also configured to [alignBy]. [alignBy] is a
   * form of [align], so both modifiers will not work together if specified for the same layout.
   * Within a [Row], all components with [alignBy] will align vertically using the specified
   * [HorizontalAlignmentLine]s or values obtained from [alignmentLineBlock], forming a sibling
   * group. At least one element of the sibling group will be placed as it had [Alignment.Top] align
   * in [Row], and the alignment of the other siblings will be then determined such that the
   * alignment lines coincide. Note that if only one element in a [Row] has the [alignBy] modifier
   * specified the element will be positioned as if it had [Alignment.Top] align.
   */
  @Stable
  fun RowScope.alignBy(alignmentLineBlock: (Measured) -> Int) {
    modifier = modifier.alignBy(alignmentLineBlock)
  }

  /* ***************************************************************************************** *
   *
   * Box.kt
   *
   * ***************************************************************************************** */

  /**
   * Pull the content element to a specific [Alignment] within the [Box]. This alignment will have
   * priority over the [Box]'s `alignment` parameter.
   */
  @Stable
  fun BoxScope.align(alignment: Alignment) {
    modifier = modifier.align(alignment)
  }

  /**
   * Size the element to match the size of the [Box] after all other content elements have been
   * measured.
   *
   * The element using this modifier does not take part in defining the size of the [Box]. Instead,
   * it matches the size of the [Box] after all other children (not using matchParentSize()
   * modifier) have been measured to obtain the [Box]'s size. In contrast, a general-purpose
   * [Modifier.fillMaxSize] modifier, which makes an element occupy all available space, will take
   * part in defining the size of the [Box]. Consequently, using it for an element inside a [Box]
   * will make the [Box] itself always fill the available space.
   */
  @Stable
  fun BoxScope.matchParentSize() {
    modifier = modifier.matchParentSize()
  }

  /* ***************************************************************************************** *
   *
   * AnimationModifier.kt
   *
   * ***************************************************************************************** */

  /**
   * This modifier animates its own size when its child modifier (or the child composable if it is
   * already at the tail of the chain) changes size. This allows the parent modifier to observe a
   * smooth size change, resulting in an overall continuous visual change.
   *
   * A [FiniteAnimationSpec] can be optionally specified for the size change animation. By default,
   * [spring] will be used.
   *
   * An optional [finishedListener] can be supplied to get notified when the size change animation
   * is finished. Since the content size change can be dynamic in many cases, both initial value and
   * target value (i.e. final size) will be passed to the [finishedListener]. __Note:__ if the
   * animation is interrupted, the initial value will be the size at the point of interruption. This
   * is intended to help determine the direction of the size change (i.e. expand or collapse in x
   * and y dimensions).
   *
   * @param animationSpec a finite animation that will be used to animate size change, [spring] by
   *   default
   * @param finishedListener an optional listener to be called when the content change animation is
   *   completed.
   */
  @Stable
  fun animateContentSize(
    animationSpec: FiniteAnimationSpec<IntSize> = spring(),
    finishedListener: ((initialValue: IntSize, targetValue: IntSize) -> Unit)? = null
  ) {
    modifier = modifier.animateContentSize(animationSpec, finishedListener)
  }

  /* ***************************************************************************************** *
   *
   * Clickable.kt
   *
   * ***************************************************************************************** */

  /**
   * Configure component to receive clicks via input or accessibility "click" event.
   *
   * Add this modifier to the element to make it clickable within its bounds and show a default
   * indication when it's pressed.
   *
   * This version has no [MutableInteractionSource] or [Indication] parameters, default indication
   * from [LocalIndication] will be used. To specify [MutableInteractionSource] or [Indication], use
   * another overload.
   *
   * If you need to support double click or long click alongside the single click, consider using
   * [combinedClickable].
   *
   * @param enabled Controls the enabled state. When `false`, [onClick], and this modifier will
   *   appear disabled for accessibility services
   * @param onClickLabel semantic / accessibility label for the [onClick] action
   * @param role the type of user interface element. Accessibility services might use this to
   *   describe the element or do customizations
   * @param onClick will be called when user clicks on the element
   */
  fun clickable(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit
  ) {
    modifier =
      modifier.clickable(
        enabled,
        onClickLabel,
        role,
        onClick,
      )
  }

  /* ***************************************************************************************** *
   *
   * Alpha.kt
   *
   * ***************************************************************************************** */

  /**
   * Draw content with modified alpha that may be less than 1.
   *
   * Usage of this API renders this composable into a separate graphics layer. Note when an alpha
   * less than 1.0f is provided, contents are implicitly clipped to their bounds. This is because an
   * intermediate compositing layer is created to render contents into first before being drawn into
   * the destination with the desired alpha. This layer is sized to the bounds of the composable
   * this modifier is configured on, and contents outside of these bounds are omitted.
   *
   * @param alpha the fraction of children's alpha value and must be between `0` and `1`, inclusive.
   * @see graphicsLayer
   */
  @Stable
  fun alpha(
    /*@FloatRange(from = 0.0, to = 1.0)*/
    alpha: Float
  ) {
    modifier = modifier.alpha(alpha)
  }

  /* ***************************************************************************************** *
   *
   * Intrinsic.kt
   *
   * ***************************************************************************************** */

  /**
   * Declare the preferred width of the content to be the same as the min or max intrinsic width of
   * the content. The incoming measurement [Constraints] may override this value, forcing the
   * content to be either smaller or larger.
   *
   * See [height] for options of sizing to intrinsic height. Also see [width] and [widthIn] for
   * other options to set the preferred width.
   *
   * Example usage for min intrinsic:
   *
   * @sample androidx.compose.foundation.layout.samples.SameWidthBoxes
   *
   * Example usage for max intrinsic:
   *
   * @sample androidx.compose.foundation.layout.samples.SameWidthTextBoxes
   */
  @Stable
  fun width(intrinsicSize: IntrinsicSize) {
    modifier = modifier.width(intrinsicSize)
  }

  /**
   * Declare the preferred height of the content to be the same as the min or max intrinsic height
   * of the content. The incoming measurement [Constraints] may override this value, forcing the
   * content to be either smaller or larger.
   *
   * See [width] for other options of sizing to intrinsic width. Also see [height] and [heightIn]
   * for other options to set the preferred height.
   */
  @Stable
  fun height(intrinsicSize: IntrinsicSize) {
    modifier = modifier.height(intrinsicSize)
  }

  /**
   * Declare the width of the content to be exactly the same as the min or max intrinsic width of
   * the content. The incoming measurement [Constraints] will not override this value. If the
   * content intrinsic width does not satisfy the incoming [Constraints], the parent layout will be
   * reported a size coerced in the [Constraints], and the position of the content will be
   * automatically offset to be centered on the space assigned to the child by the parent layout
   * under the assumption that [Constraints] were respected.
   *
   * See [height] for options of sizing to intrinsic height. See [width] and [widthIn] for options
   * to set the preferred width. See [requiredWidth] and [requiredWidthIn] for other options to set
   * the required width.
   */
  @Stable
  fun requiredWidth(intrinsicSize: IntrinsicSize) {
    modifier = modifier.requiredWidth(intrinsicSize)
  }

  /**
   * Declare the height of the content to be exactly the same as the min or max intrinsic height of
   * the content. The incoming measurement [Constraints] will not override this value. If the
   * content intrinsic height does not satisfy the incoming [Constraints], the parent layout will be
   * reported a size coerced in the [Constraints], and the position of the content will be
   * automatically offset to be centered on the space assigned to the child by the parent layout
   * under the assumption that [Constraints] were respected.
   *
   * See [width] for options of sizing to intrinsic width. See [height] and [heightIn] for options
   * to set the preferred height. See [requiredHeight] and [requiredHeightIn] for other options to
   * set the required height.
   */
  @Stable
  fun requiredHeight(intrinsicSize: IntrinsicSize) {
    modifier = modifier.requiredHeight(intrinsicSize)
  }

  /* ***************************************************************************************** *
   *
   * ConstraintLayout.kt
   *
   * ***************************************************************************************** */

  /**
   * [Modifier] that defines the constraints, as part of a [ConstraintLayout], of the layout
   * element.
   */
  @Stable
  fun ConstraintLayoutScope.constrainAs(
    ref: ConstrainedLayoutReference,
    constrainBlock: ConstrainScope.() -> Unit
  ) {
    modifier = modifier.constrainAs(ref, constrainBlock)
  }
}
