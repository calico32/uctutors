package lol.calico.uctutors.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import lol.calico.uctutors.BuildConfig
import lol.calico.uctutors.ui.compose.LocalHttpClient

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
