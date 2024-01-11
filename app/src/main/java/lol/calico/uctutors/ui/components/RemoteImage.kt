package lol.calico.uctutors.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.ui.compose.LocalHttpClient
import lol.calico.uctutors.util.TestData
import lol.calico.uctutors.util.modifier

class TransparentPainter(
  private val image: ImageBitmap,
  private val size: IntSize = IntSize(image.width, image.height),
) : Painter() {
  override val intrinsicSize: Size
    get() = size.toSize()

  override fun DrawScope.onDraw() {
    drawImage(image, topLeft = Offset.Zero)
  }
}

@Composable
fun RemoteImage(
  id: String,
  modifier: Modifier = Modifier,
  contentDescription: String? = null,
  transform: (AsyncImagePainter.State) -> AsyncImagePainter.State =
    AsyncImagePainter.DefaultTransform,
  onState: ((AsyncImagePainter.State) -> Unit)? = null,
  alignment: Alignment = Alignment.Center,
  contentScale: ContentScale = ContentScale.Fit,
  alpha: Float = DefaultAlpha,
  colorFilter: ColorFilter? = null,
  filterQuality: FilterQuality = DrawScope.DefaultFilterQuality,
) {
  if (TestData.images.containsKey(id)) {
    //    val bitmap = ImageBitmap.imageResource(TestData.images[id]!!)
    return Image(
      ImageBitmap.imageResource(TestData.images[id]!!),
      contentDescription = contentDescription,
      modifier = modifier,
      alignment = alignment,
      contentScale = contentScale,
      alpha = alpha,
      colorFilter = colorFilter,
    )
  }
  AsyncImage(
    model = remoteImage(id),
    imageLoader = remoteImageLoader(),
    contentDescription = contentDescription,
    modifier = modifier,
    transform = transform,
    onState = onState,
    alignment = alignment,
    contentScale = contentScale,
    alpha = alpha,
    colorFilter = colorFilter,
    filterQuality = filterQuality,
  )
}

@Composable
fun remoteImage(id: String): ImageRequest {
  return ImageRequest.Builder(LocalContext.current)
    //    .okHttpClient(LocalHttpClient.current)
    .data("${BuildConfig.CONTENT_URL}/$id")
    .build()
}

@Composable
fun remoteImageLoader(): ImageLoader {
  return ImageLoader.Builder(LocalContext.current).okHttpClient(LocalHttpClient.current).build()
}

val ContentScale.Companion.Fill: ContentScale
  get() =
    object : ContentScale {
      override fun computeScaleFactor(srcSize: Size, dstSize: Size): ScaleFactor {
        val horizontalScale = dstSize.width / srcSize.width
        val verticalScale = dstSize.height / srcSize.width
        val targetScale = maxOf(horizontalScale, verticalScale)
        return ScaleFactor(targetScale, targetScale)
      }
    }

@Preview(showBackground = true, backgroundColor = 0xfff4fff6)
@Composable
fun TestUserAvatarPreview() {
  RemoteImage(
    TestData.user.avatarId,
    modifier =
      modifier {
        padding(16.dp)
        clip(CircleShape)
      }
  )
}

@Preview(showBackground = true, backgroundColor = 0xfff4fff6)
@Composable
fun TestUserBannerPreview() {
  RemoteImage(
    TestData.user.bannerId,
    contentScale = ContentScale.Crop,
    modifier =
      modifier {
        padding(16.dp)
        size(200.dp, 100.dp)
      }
  )
}

@Preview(showBackground = true, backgroundColor = 0xfff4fff6)
@Composable
fun TestUserExperiencePreview() {
  RemoteImage(
    TestData.user.experiencesList[0].imageId,
    modifier =
      modifier {
        padding(16.dp)
        clip(CircleShape)
      }
  )
}
