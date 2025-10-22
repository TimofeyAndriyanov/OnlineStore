package ru.onlinestore.mobile.domain.entities.auth

data class LogInRequestBodyDomain(
    val username: String,
    val password: String
)