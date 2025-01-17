package ru.onlinestore.mobile.data.sources.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.data.entities.CategoryData
import ru.onlinestore.mobile.data.entities.ProductListData
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource

class ProductsRemoteSourceImpl(private val client: HttpClient): ProductsRemoteSource {

    override suspend fun fetchProducts(url: String): Response<ProductListData> =
        try {
            val get = client.get(urlString = url)

            Response.Success(data = get.body())
        } catch (exception: Exception) { Response.Error(exception = exception) }

    override suspend fun fetchCategoryList(): Response<List<CategoryData>> =
        try {
            val get = client.get("products/categories")

            Response.Success(data = get.body())
        } catch (exception: Exception) { Response.Error(exception = exception) }
}