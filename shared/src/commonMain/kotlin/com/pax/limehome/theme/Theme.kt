package com.pax.limehome.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Teal700,
    onPrimary = White,
    background = White,
    onBackground = Black,
    // Add more colors as needed
)

@Composable
fun LimehomeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        // For now, using light scheme for both as we don't have dark colors yet
        LightColorScheme 
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = getTypography(),
        content = content
    )
}
