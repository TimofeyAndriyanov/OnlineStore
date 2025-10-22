package ru.onlinestore.mobile.data.entities.auth

import kotlinx.serialization.Serializable

@Serializable
data class RefreshResponseBodyData(
    val accessToken: String,
    val refreshToken: String
)