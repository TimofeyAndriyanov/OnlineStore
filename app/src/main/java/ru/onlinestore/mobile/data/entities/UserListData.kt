package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class UserListData(
    val users: List<UserData>,
    val total: Int,
    val skip: Int,
    val limit: Int
)