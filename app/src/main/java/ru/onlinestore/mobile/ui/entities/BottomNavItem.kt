package ru.onlinestore.mobile.ui.entities

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val label: String,
    val unselectedIcon: Painter,
    val selectedIcon: Painter,
    val route: Any
)