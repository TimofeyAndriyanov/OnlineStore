package ru.onlinestore.mobile.data.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.ProductListDomain
import ru.onlinestore.mobile.domain.repository.ProductRepository

class ProductRepositoryImpl(private val remote: ProductsRemoteSource): ProductRepository {

    override suspend fun fetchProducts(url: String): Response<ProductListDomain> =
        remote.fetchProducts(url = url).map { it.toDomain() }

    override suspend fun fetchCategoryList(): Response<List<CategoryDomain>> =
        remote.fetchCategoryList().map { it -> it.map { it.toDomain() } }
}