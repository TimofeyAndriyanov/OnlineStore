package ru.onlinestore.mobile.ui.entities.log_in

data class LogInResponseBodyUI(
    val id: Long = 0,
    val username: String = "",
    val image: String = "",
    val email: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val accessToken: String = "",
    val refreshToken: String = ""
)