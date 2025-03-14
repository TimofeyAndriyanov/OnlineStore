package ru.onlinestore.mobile.data.sources

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.CategoryData
import ru.onlinestore.mobile.data.entities.ProductListData

interface ProductsRemoteSource {

    suspend fun fetchProducts(url: String): Response<ProductListData, Nothing>

    suspend fun fetchCategoryList(): Response<List<CategoryData>, Nothing>
}