package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.ui.entities.ProductListUI

class FetchProductListUseCase(private val repository: ProductRepository) {

    operator fun invoke(url: String): Flow<Response<ProductListUI>> = flow {
        emit(Response.Loading)
        emit(repository.fetchProducts(url = url).map { it.toUI() })
    }
}