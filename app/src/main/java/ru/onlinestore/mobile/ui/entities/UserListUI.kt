package ru.onlinestore.mobile.ui.entities

data class UserListUI(
    val users: List<UserUI> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
)