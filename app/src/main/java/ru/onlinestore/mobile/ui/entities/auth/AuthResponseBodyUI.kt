package ru.onlinestore.mobile.ui.entities.auth

data class AuthResponseBodyUI(
    val id: Long = 0,
    val username: String = "",
    val image: String = "",
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val accessToken: String = "",
    val refreshToken: String = ""
)