package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.UserRepository
import ru.onlinestore.mobile.domain.toUI

class FetchMeUseCase(private val repository: UserRepository) {

    operator fun invoke() = flow {
        emit(Response.Loading)
        emit(repository.me().mapSuccess { it.toUI() }.mapInvalid { it.toUI() })
    }
}