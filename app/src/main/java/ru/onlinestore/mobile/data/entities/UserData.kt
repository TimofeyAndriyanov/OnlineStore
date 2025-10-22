package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val id: Long,
    val image: String,
    val firstName: String,
    val lastName: String,
    val username: String,
    val password: String
)