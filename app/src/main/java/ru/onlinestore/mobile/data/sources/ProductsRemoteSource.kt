package ru.onlinestore.mobile.data.sources

import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.CategoryData
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.ProductData
import ru.onlinestore.mobile.data.entities.ResultListData

interface ProductsRemoteSource {

    suspend fun fetchProductByID(id: Int): Response<ProductData, MessageData>

    suspend fun searchProductByName(name: String): Response<ProductData, MessageData>

    suspend fun fetchProducts(url: String): Response<ResultListData<ProductData>, Nothing>

    suspend fun fetchCategoryList(): Response<List<CategoryData>, Nothing>
}