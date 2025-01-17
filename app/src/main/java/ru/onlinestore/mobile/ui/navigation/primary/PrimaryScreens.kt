package ru.onlinestore.mobile.ui.navigation.primary

import kotlinx.serialization.Serializable

@Serializable
sealed class PrimaryScreens {

    @Serializable
    data object Primary: PrimaryScreens()

    @Serializable
    data object Authorization: PrimaryScreens()
}