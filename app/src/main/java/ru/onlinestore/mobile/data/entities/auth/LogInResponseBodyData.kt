package ru.onlinestore.mobile.data.entities.auth

import kotlinx.serialization.Serializable

@Serializable
data class LogInResponseBodyData(
    val id: Long,
    val username: String,
    val image: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val accessToken: String,
    val refreshToken: String
)