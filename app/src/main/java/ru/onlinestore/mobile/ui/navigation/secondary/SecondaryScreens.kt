package ru.onlinestore.mobile.ui.navigation.secondary

import kotlinx.serialization.Serializable

@Serializable
sealed class SecondaryScreens {

    @Serializable
    data object Products: SecondaryScreens()
}