package org.example.project.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = GeoBlue,
    onPrimary = Color.White,
    secondary = SuccessGreen,
    onSecondary = Color.White,
    background = BackgroundLight,
    onBackground = TextDark,
    surface = Color.White,
    onSurface = TextDark
)

@Composable
fun GeoSnowTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}