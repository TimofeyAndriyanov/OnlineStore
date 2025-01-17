package ru.onlinestore.mobile.domain.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.ProductListDomain

interface ProductRepository {

    suspend fun fetchProducts(url: String): Response<ProductListDomain>

    suspend fun fetchCategoryList(): Response<List<CategoryDomain>>
}