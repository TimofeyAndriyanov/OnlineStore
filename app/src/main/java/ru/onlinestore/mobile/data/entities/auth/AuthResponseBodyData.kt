package ru.onlinestore.mobile.data.entities.auth

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.auth.AuthResponseBodyDomain

@Serializable
data class AuthResponseBodyData(
    val id: Long,
    val username: String,
    val image: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val accessToken: String,
    val refreshToken: String
) {
    fun toDomain() =
        AuthResponseBodyDomain(
            id = id,
            username = username,
            image = image,
            email = email,
            firstName = firstName,
            lastName = lastName,
            accessToken = accessToken,
            refreshToken = refreshToken
        )
}