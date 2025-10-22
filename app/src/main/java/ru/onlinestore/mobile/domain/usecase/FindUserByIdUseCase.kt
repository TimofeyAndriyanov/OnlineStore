package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.UserRepository
import ru.onlinestore.mobile.domain.toUI

class FindUserByIdUseCase(private val repository: UserRepository) {

    operator fun invoke(id: Int) = flow {
        emit(Response.Loading)
        emit(repository.findUserByID(id).mapSuccess { it.toUI() }.mapInvalid { it.toUI() })
    }
}