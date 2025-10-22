package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.UserRepository
import ru.onlinestore.mobile.domain.toUI
import ru.onlinestore.mobile.ui.entities.ResultListUI

class FetchUserListUseCase(private val repository: UserRepository) {

    operator fun invoke() = flow {
        emit(Response.Loading)
        emit(repository.fetchUserList().mapSuccess { it.toUI() })
    }
}