package ru.onlinestore.mobile.ui.navigation.secondary

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class ItemNavigation(
    val title: String,
    @Contextual val icon: ImageVector
)
