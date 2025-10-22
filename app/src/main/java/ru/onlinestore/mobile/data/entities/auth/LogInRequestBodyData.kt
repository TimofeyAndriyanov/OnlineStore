package ru.onlinestore.mobile.data.entities.auth

import kotlinx.serialization.Serializable

@Serializable
data class LogInRequestBodyData(
    val username: String,
    val password: String
)