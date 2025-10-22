package ru.onlinestore.mobile.domain.usecase

import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.toUI

class FetchProductListUseCase(private val repository: ProductRepository) {

    operator fun invoke(url: String) = flow {
        emit(Response.Loading)
        emit(repository.fetchProducts(url).mapSuccess { it.toUI() })
    }
}