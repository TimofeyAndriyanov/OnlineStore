package ru.onlinestore.mobile.domain.entities

data class RefreshResponseBodyDomain(
    val accessToken: String,
    val refreshToken: String
)