package ru.onlinestore.mobile.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = contentColor,
    onPrimary = dominantColor,
    background = dominantColor,
    secondaryContainer = contentColor,
    onSecondaryContainer = dominantColor,
    surfaceContainer = surfaceContainerColor,
    surfaceTint = contentColor,
    onSurfaceVariant = unselectColor,
    surface = dominantColor,
    onSurface = textColor,
    outlineVariant = borderColor
)

@Composable
fun OnlineStoreTheme(content: @Composable () -> Unit) =
    MaterialTheme(
        colorScheme = MaterialTheme.colorScheme,
        typography = MaterialTheme.typography,
        content = content
    )