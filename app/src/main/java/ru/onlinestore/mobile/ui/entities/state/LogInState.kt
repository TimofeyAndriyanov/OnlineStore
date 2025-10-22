package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.MessageUI
import ru.onlinestore.mobile.ui.entities.log_in.LogInRequestBodyUI
import ru.onlinestore.mobile.ui.entities.log_in.LogInResponseBodyUI

data class LogInState(
    val state: ResponseEnum = ResponseEnum.UNKNOW,
    val request: LogInRequestBodyUI = LogInRequestBodyUI(),
    val response: LogInResponseBodyUI = LogInResponseBodyUI(),
    val invalidResponse: MessageUI = MessageUI(),
    val exceptionMessage: String = "",
    val invalidMessage: String = invalidResponse.message,
    val isMessageShow: Boolean = invalidMessage.isNotEmpty(),
    val enableAuthButton: Boolean = true,
    val userState: UserState = UserState()
)