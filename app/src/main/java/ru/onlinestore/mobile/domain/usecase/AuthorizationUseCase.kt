package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.entities.MessageDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthRequestBodyDomain
import ru.onlinestore.mobile.domain.entities.auth.AuthResponseBodyDomain
import ru.onlinestore.mobile.domain.repository.IdentificationRepository
import ru.onlinestore.mobile.ui.entities.MessageUI
import ru.onlinestore.mobile.ui.entities.auth.AuthRequestBodyUI
import ru.onlinestore.mobile.ui.entities.auth.AuthResponseBodyUI

class AuthorizationUseCase(private val repository: IdentificationRepository) {

    operator fun invoke(auth: AuthRequestBodyUI): Flow<Response<AuthResponseBodyUI, MessageUI>> = flow {
        emit(Response.Loading)
        emit(
            repository.authorization(
                AuthRequestBodyDomain(
                    username = auth.username,
                    password = auth.password
                )
            ).mapT { it: AuthResponseBodyDomain ->
                AuthResponseBodyUI(
                    id = it.id,
                    username = it.username,
                    image = it.image,
                    email = it.email,
                    firstName = it.firstName,
                    lastName = it.lastName,
                    accessToken = it.accessToken,
                    refreshToken = it.refreshToken
                )
            }.mapI { it: MessageDomain -> MessageUI(message = it.message) }
        )
    }
}