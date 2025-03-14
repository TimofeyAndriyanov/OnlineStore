package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.MessageUI
import ru.onlinestore.mobile.ui.entities.auth.AuthRequestBodyUI
import ru.onlinestore.mobile.ui.entities.auth.AuthResponseBodyUI

data class AuthState(
    val state: ResponseEnum = ResponseEnum.DEFAULT,
    val request: AuthRequestBodyUI = AuthRequestBodyUI(),
    val response: AuthResponseBodyUI = AuthResponseBodyUI(),
    val invalidResponse: MessageUI = MessageUI(),
    val exceptionMessage: String = "",
    val invalidMessage: String = invalidResponse.message,
    val isMessageShow: Boolean = invalidMessage.isNotEmpty(),
    val enableAuthButton: Boolean = true,
    val userState: UserState = UserState()
)