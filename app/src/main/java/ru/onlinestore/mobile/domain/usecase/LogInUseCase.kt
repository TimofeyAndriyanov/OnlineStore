package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.UserRepository
import ru.onlinestore.mobile.domain.toDomain
import ru.onlinestore.mobile.domain.toUI
import ru.onlinestore.mobile.ui.entities.log_in.LogInRequestBodyUI

class LogInUseCase(private val repository: UserRepository) {

    operator fun invoke(auth: LogInRequestBodyUI) = flow {
        emit(Response.Loading)
        emit(repository.logIn(auth.toDomain()).mapSuccess { it.toUI() }.mapInvalid { it.toUI() })
    }
}