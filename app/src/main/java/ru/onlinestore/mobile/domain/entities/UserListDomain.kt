package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.UserListUI

data class UserListDomain(
    val users: List<UserDomain>,
    val total: Int,
    val skip: Int,
    val limit: Int
) {
    fun toUI() =
        UserListUI(
            users = users.map { it.toUI() },
            total = total,
            skip = skip,
            limit = limit
        )
}