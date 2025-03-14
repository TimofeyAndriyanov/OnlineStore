package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.UserDomain

@Serializable
data class UserData(
    val id: Long,
    val image: String,
    val username: String,
    val password: String
) {
    fun toDomain() =
        UserDomain(
            id = id,
            image = image,
            username = username,
            password = password
        )
}