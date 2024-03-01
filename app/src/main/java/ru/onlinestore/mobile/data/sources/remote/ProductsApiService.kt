package ru.onlinestore.mobile.data.sources.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import ru.onlinestore.mobile.data.sources.remote.dto.ProductListDTO

interface ProductsApiService {

    @GET("products")
    fun fetchProductsList(): Deferred<ProductListDTO>
}