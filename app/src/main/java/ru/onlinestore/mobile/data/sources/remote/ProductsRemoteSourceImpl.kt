package ru.onlinestore.mobile.data.sources.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.http.HttpStatusCode
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.core.networkExceptionWrapper
import ru.onlinestore.mobile.data.entities.CategoryData
import ru.onlinestore.mobile.data.entities.MessageData
import ru.onlinestore.mobile.data.entities.ProductData
import ru.onlinestore.mobile.data.entities.ResultListData
import ru.onlinestore.mobile.data.entities.resources.ProductsRes
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource

class ProductsRemoteSourceImpl(private val client: HttpClient): ProductsRemoteSource {

    override suspend fun fetchProductByID(id: Int) =
        networkExceptionWrapper {
            val get = client.get(ProductsRes.Product(id))

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<ProductData>())
                HttpStatusCode.NotFound -> Response.Invalid(get.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun searchProductByName(name: String) =
        networkExceptionWrapper {
            val get = client.get(ProductsRes.Search(name))

            when(get.status) {
                HttpStatusCode.OK -> Response.Success(get.body<ProductData>())
                HttpStatusCode.NotFound -> Response.Invalid(get.body<MessageData>())
                else -> Response.Unknow
            }
        }

    override suspend fun fetchProducts(url: String) =
        networkExceptionWrapper {
            val get = client.get(url)

            Response.Success(get.body<ResultListData<ProductData>>())
        }

    override suspend fun fetchCategoryList() =
        networkExceptionWrapper {
            val get = client.get(ProductsRes.Categories)

            Response.Success(get.body<List<CategoryData>>())
        }
}