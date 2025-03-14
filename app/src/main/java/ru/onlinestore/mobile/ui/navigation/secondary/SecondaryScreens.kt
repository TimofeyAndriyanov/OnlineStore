package ru.onlinestore.mobile.ui.navigation.secondary

import kotlinx.serialization.Serializable

@Serializable
sealed interface SecondaryScreens {

    @Serializable
    data object Products: SecondaryScreens
}