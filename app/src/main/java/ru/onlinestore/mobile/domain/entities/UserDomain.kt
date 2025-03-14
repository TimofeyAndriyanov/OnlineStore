package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.UserUI


data class UserDomain(
    val id: Long,
    val image: String,
    val username: String,
    val password: String
) {
    fun toUI() =
        UserUI(
            id = id,
            image = image,
            username = username,
            password = password
        )
}