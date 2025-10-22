package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.ResultListUI
import ru.onlinestore.mobile.ui.entities.user.UserUI

data class UserState(
    val state: ResponseEnum = ResponseEnum.UNKNOW,
    val exceptionMessage: String = "",
    val list: ResultListUI<UserUI> = ResultListUI()
)
