package lol.calico.uctutors.ui.compose

import androidx.compose.runtime.compositionLocalOf
import lol.calico.uctutors.data.common.GrpcConnection

val LocalGrpcConnection = compositionLocalOf<GrpcConnection> {
  error("No GrpcConnection provided")
}