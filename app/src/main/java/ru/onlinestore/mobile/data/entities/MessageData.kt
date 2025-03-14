package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.MessageDomain

@Serializable
data class MessageData(val message: String) {

    fun toDomain() = MessageDomain(message = message)
}
