package lol.calico.uctutors.data.common

import android.content.Context
import lol.calico.uctutors.R
import okhttp3.OkHttpClient
import okhttp3.tls.HandshakeCertificates
import okhttp3.tls.decodeCertificatePem

fun newHttpClient(context: Context): OkHttpClient {
  val certStream = context.resources.openRawResource(R.raw.mkcert)
  val cert = certStream.bufferedReader().use { it.readText() }
  certStream.close()

  val certificates =
    HandshakeCertificates.Builder().addTrustedCertificate(cert.decodeCertificatePem()).build()

  return OkHttpClient.Builder()
    .sslSocketFactory(certificates.sslSocketFactory(), certificates.trustManager)
    .build()
}
