package lol.calico.uctutors.ui.theme

// import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import lol.calico.uctutors.R

// private val fontProvider =
//  GoogleFont.Provider(
//    providerAuthority = "com.google.android.gms.fonts",
//    providerPackage = "com.google.android.gms",
//    certificates = R.array.com_google_android_gms_fonts_certs
//  )
//
// private val googleFont = GoogleFont("Work Sans")

private val weights =
  listOf(
    FontWeight.Thin,
    FontWeight.ExtraLight,
    FontWeight.Light,
    FontWeight.Normal,
    FontWeight.Medium,
    FontWeight.SemiBold,
    FontWeight.Bold,
    FontWeight.ExtraBold,
    FontWeight.Black,
  )

// private val styles = listOf(FontStyle.Normal, FontStyle.Italic)

@OptIn(ExperimentalTextApi::class)
val workSans =
  FontFamily(
    weights.flatMap { weight ->
      //      styles.map { style ->
      listOf(
        Font(
          //          googleFont = googleFont,
          //          fontProvider = fontProvider,
          //          weight = weight,
          //          style = style,
          R.font.work_sans_var,
          weight = weight,
          style = FontStyle.Normal,
          variationSettings =
            FontVariation.Settings(
              FontVariation.weight(weight.weight),
            )
        ),
        Font(
          R.font.work_sans_var_italic,
          weight = weight,
          style = FontStyle.Italic,
          variationSettings =
            FontVariation.Settings(
              FontVariation.weight(weight.weight),
            )
        )
      )
      //      }
    }
  )

// val typography =
