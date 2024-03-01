package ru.onlinestore.mobile.data.sources

import ru.onlinestore.mobile.core.ResultContainer
import ru.onlinestore.mobile.data.models.ProductListData

interface ProductsRemoteSource {

    suspend fun fetchListProducts(): ResultContainer<ProductListData>
}