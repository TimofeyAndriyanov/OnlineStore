package ru.onlinestore.mobile.domain.entities

data class UserDomain(
    val id: Long,
    val image: String,
    val username: String,
    val password: String
)