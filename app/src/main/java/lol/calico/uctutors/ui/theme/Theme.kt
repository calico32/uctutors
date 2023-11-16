package lol.calico.uctutors.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.TextStyle
import androidx.core.view.WindowCompat


@Composable
fun UCTutorsTheme(
  darkTheme: Boolean = isSystemInDarkTheme(),
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = true,
  content: @Composable () -> Unit
) {
  val colorScheme = LightColors
//        if (darkTheme) DarkColors
//        else LightColors

  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as Activity).window
      window.statusBarColor = colorScheme.primary.toArgb()
      WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography(
      bodyLarge = TextStyle(
        fontFamily = md_sys_typescale_body_large_font_family,
        fontWeight = md_sys_typescale_body_large_font_weight,
        fontSize = md_sys_typescale_body_large_font_size,
        lineHeight = md_sys_typescale_body_large_line_height,
        letterSpacing = md_sys_typescale_body_large_letter_spacing,
      ),
      bodyMedium = TextStyle(
        fontFamily = md_sys_typescale_body_medium_font_family,
        fontWeight = md_sys_typescale_body_medium_font_weight,
        fontSize = md_sys_typescale_body_medium_font_size,
        lineHeight = md_sys_typescale_body_medium_line_height,
        letterSpacing = md_sys_typescale_body_medium_letter_spacing,
      ),
      bodySmall = TextStyle(
        fontFamily = md_sys_typescale_body_small_font_family,
        fontWeight = md_sys_typescale_body_small_font_weight,
        fontSize = md_sys_typescale_body_small_font_size,
        lineHeight = md_sys_typescale_body_small_line_height,
        letterSpacing = md_sys_typescale_body_small_letter_spacing,
      ),
      displayLarge = TextStyle(
        fontFamily = md_sys_typescale_display_large_font_family,
        fontWeight = md_sys_typescale_display_large_font_weight,
        fontSize = md_sys_typescale_display_large_font_size,
        lineHeight = md_sys_typescale_display_large_line_height,
        letterSpacing = md_sys_typescale_display_large_letter_spacing,
      ),
      displayMedium = TextStyle(
        fontFamily = md_sys_typescale_display_medium_font_family,
        fontWeight = md_sys_typescale_display_medium_font_weight,
        fontSize = md_sys_typescale_display_medium_font_size,
        lineHeight = md_sys_typescale_display_medium_line_height,
        letterSpacing = md_sys_typescale_display_medium_letter_spacing,
      ),
      displaySmall = TextStyle(
        fontFamily = md_sys_typescale_display_small_font_family,
        fontWeight = md_sys_typescale_display_small_font_weight,
        fontSize = md_sys_typescale_display_small_font_size,
        lineHeight = md_sys_typescale_display_small_line_height,
        letterSpacing = md_sys_typescale_display_small_letter_spacing,
      ),
      headlineLarge = TextStyle(
        fontFamily = md_sys_typescale_headline_large_font_family,
        fontWeight = md_sys_typescale_headline_large_font_weight,
        fontSize = md_sys_typescale_headline_large_font_size,
        lineHeight = md_sys_typescale_headline_large_line_height,
        letterSpacing = md_sys_typescale_headline_large_letter_spacing,
      ),
      headlineMedium = TextStyle(
        fontFamily = md_sys_typescale_headline_medium_font_family,
        fontWeight = md_sys_typescale_headline_medium_font_weight,
        fontSize = md_sys_typescale_headline_medium_font_size,
        lineHeight = md_sys_typescale_headline_medium_line_height,
        letterSpacing = md_sys_typescale_headline_medium_letter_spacing,
      ),
      headlineSmall = TextStyle(
        fontFamily = md_sys_typescale_headline_small_font_family,
        fontWeight = md_sys_typescale_headline_small_font_weight,
        fontSize = md_sys_typescale_headline_small_font_size,
        lineHeight = md_sys_typescale_headline_small_line_height,
        letterSpacing = md_sys_typescale_headline_small_letter_spacing,
      ),
      labelLarge = TextStyle(
        fontFamily = md_sys_typescale_label_large_font_family,
        fontWeight = md_sys_typescale_label_large_font_weight,
        fontSize = md_sys_typescale_label_large_font_size,
        lineHeight = md_sys_typescale_label_large_line_height,
        letterSpacing = md_sys_typescale_label_large_letter_spacing,
      ),
      labelMedium = TextStyle(
        fontFamily = md_sys_typescale_label_medium_font_family,
        fontWeight = md_sys_typescale_label_medium_font_weight,
        fontSize = md_sys_typescale_label_medium_font_size,
        lineHeight = md_sys_typescale_label_medium_line_height,
        letterSpacing = md_sys_typescale_label_medium_letter_spacing,
      ),
      labelSmall = TextStyle(
        fontFamily = md_sys_typescale_label_small_font_family,
        fontWeight = md_sys_typescale_label_small_font_weight,
        fontSize = md_sys_typescale_label_small_font_size,
        lineHeight = md_sys_typescale_label_small_line_height,
        letterSpacing = md_sys_typescale_label_small_letter_spacing,
      ),
      titleLarge = TextStyle(
        fontFamily = md_sys_typescale_title_large_font_family,
        fontWeight = md_sys_typescale_title_large_font_weight,
        fontSize = md_sys_typescale_title_large_font_size,
        lineHeight = md_sys_typescale_title_large_line_height,
        letterSpacing = md_sys_typescale_title_large_letter_spacing,
      ),
      titleMedium = TextStyle(
        fontFamily = md_sys_typescale_title_medium_font_family,
        fontWeight = md_sys_typescale_title_medium_font_weight,
        fontSize = md_sys_typescale_title_medium_font_size,
        lineHeight = md_sys_typescale_title_medium_line_height,
        letterSpacing = md_sys_typescale_title_medium_letter_spacing,
      ),
      titleSmall = TextStyle(
        fontFamily = md_sys_typescale_title_small_font_family,
        fontWeight = md_sys_typescale_title_small_font_weight,
        fontSize = md_sys_typescale_title_small_font_size,
        lineHeight = md_sys_typescale_title_small_line_height,
        letterSpacing = md_sys_typescale_title_small_letter_spacing,
      ),
    ),
    content = content,
  )
}