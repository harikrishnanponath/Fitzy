package com.harikrish.fitzy.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

// Define your custom colors
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    // Customize the text colors here
    onPrimary = Color.White,  // Text color for primary elements
    onSecondary = Color.White, // Text color for secondary elements
    onTertiary = Color.White, // Text color for tertiary elements
    background = Color(0xFF121212), // Dark background
    surface = Color(0xFF1F1F1F), // Surface color
    onBackground = Color.White,  // Text color on background
    onSurface = Color.White // Text color on surface
)

private val LightColorScheme = lightColorScheme(
    primary = Purple600,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun FitzyTheme(
    darkTheme: Boolean = true, // Force dark theme
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme // Always use dark theme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
