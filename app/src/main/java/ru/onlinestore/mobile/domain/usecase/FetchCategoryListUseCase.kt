package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.toUI

class FetchCategoryListUseCase(private val repository: ProductRepository) {

    operator fun invoke() = flow {
        emit(Response.Loading)
        emit(repository.fetchCategoryList().mapSuccess { it -> it.map { it.toUI() } })
    }
}