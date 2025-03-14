package ru.onlinestore.mobile.domain.entities.auth

data class AuthResponseBodyDomain(
    val id: Long,
    val username: String,
    val image: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val accessToken: String,
    val refreshToken: String
)