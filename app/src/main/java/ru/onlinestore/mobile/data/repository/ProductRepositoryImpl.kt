package ru.onlinestore.mobile.data.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.toDomain
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.ProductDomain
import ru.onlinestore.mobile.domain.entities.ResultListDomain
import ru.onlinestore.mobile.domain.repository.ProductRepository

class ProductRepositoryImpl(private val remote: ProductsRemoteSource): ProductRepository {

    override suspend fun fetchProducts(url: String): Response<ResultListDomain<ProductDomain>, Nothing> =
        remote.fetchProducts(url).mapSuccess { it.toDomain() }

    override suspend fun fetchCategoryList(): Response<List<CategoryDomain>, Nothing> =
        remote.fetchCategoryList().mapSuccess { it.toDomain() }
}