package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.UserListUI

data class UserState(
    val state: ResponseEnum = ResponseEnum.DEFAULT,
    val exceptionMessage: String = "",
    val list: UserListUI = UserListUI()
)
