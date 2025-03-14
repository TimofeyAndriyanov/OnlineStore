package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.MessageUI

data class MessageDomain(val message: String) {
    fun toUI() = MessageUI(message = message)
}