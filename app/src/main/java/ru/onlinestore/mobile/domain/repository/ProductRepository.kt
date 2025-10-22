package ru.onlinestore.mobile.domain.repository

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.entities.CategoryDomain
import ru.onlinestore.mobile.domain.entities.ProductDomain
import ru.onlinestore.mobile.domain.entities.ResultListDomain

interface ProductRepository {

    suspend fun fetchProducts(url: String): Response<ResultListDomain<ProductDomain>, Nothing>

    suspend fun fetchCategoryList(): Response<List<CategoryDomain>, Nothing>
}