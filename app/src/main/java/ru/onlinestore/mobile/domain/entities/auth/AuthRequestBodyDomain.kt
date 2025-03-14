package ru.onlinestore.mobile.domain.entities.auth

import ru.onlinestore.mobile.data.entities.auth.AuthRequestBodyData
import ru.onlinestore.mobile.ui.entities.auth.AuthRequestBodyUI

data class AuthRequestBodyDomain(
    val username: String,
    val password: String
) {
    fun toData() =
        AuthRequestBodyData(
            username = username,
            password = password
        )

    fun toUI() =
        AuthRequestBodyUI(
            username = username,
            password = password
        )
}