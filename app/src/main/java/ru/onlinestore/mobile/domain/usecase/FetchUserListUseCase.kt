package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.IdentificationRepository
import ru.onlinestore.mobile.ui.entities.UserListUI

class FetchUserListUseCase(private val repository: IdentificationRepository) {

    operator fun invoke(): Flow<Response<UserListUI, Nothing>> = flow {
        emit(Response.Loading)
        emit(repository.fetchUserList().mapT { it.toUI() })
    }
}