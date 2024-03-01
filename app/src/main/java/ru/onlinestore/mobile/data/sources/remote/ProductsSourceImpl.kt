package ru.onlinestore.mobile.data.sources.remote

import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.sources.remote.dto.*
import ru.onlinestore.mobile.data.models.*
import ru.onlinestore.mobile.core.*

class ProductsSourceImpl(
    private val productsApiService: ProductsApiService
): ProductsRemoteSource {

    override suspend fun fetchListProducts(): ResultContainer<ProductListData> =
        try {
            val productsData = mapperProductList(
                productsApiService.fetchProductsList().await()
            )

            SuccessResult(productsData)
        } catch (exception: Exception) {
            ErrorResult(exception)
        }

    private val mapperProductList = { products: ProductListDTO ->
        ProductListData(
            products = mapperProduct(products.products),
            total = products.total,
            skip = products.skip,
            limit = products.limit
        )
    }

    private val mapperProduct = { products: List<ProductDTO> ->
        products.map { product ->
            ProductData(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                discountPercentage = product.discountPercentage,
                rating = product.rating,
                stock = product.stock,
                brand = product.brand,
                category = product.category,
                thumbnail = product.thumbnail,
                images = product.images
            )
        }

    }
}