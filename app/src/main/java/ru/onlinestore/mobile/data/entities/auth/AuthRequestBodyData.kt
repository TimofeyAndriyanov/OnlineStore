package ru.onlinestore.mobile.data.entities.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequestBodyData(
    val username: String,
    val password: String
)
