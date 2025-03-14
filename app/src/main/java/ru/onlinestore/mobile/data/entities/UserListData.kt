package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.UserListDomain

@Serializable
data class UserListData(
    val users: List<UserData>,
    val total: Int,
    val skip: Int,
    val limit: Int
) {
    fun toDomain() =
        UserListDomain(
            users = users.map { it.toDomain() },
            total = total,
            skip = skip,
            limit = limit
        )
}