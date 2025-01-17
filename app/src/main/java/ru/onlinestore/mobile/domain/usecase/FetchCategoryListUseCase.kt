package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.ui.entities.CategoryUI

class FetchCategoryListUseCase(private val repository: ProductRepository) {

    operator fun invoke(): Flow<Response<List<CategoryUI>>> = flow {
        emit(Response.Loading)
        emit(repository.fetchCategoryList().map { it -> it.map { it.toUI() } })
    }
}