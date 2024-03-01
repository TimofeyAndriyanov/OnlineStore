package ru.onlinestore.mobile.data.repository

import ru.onlinestore.mobile.core.ResultContainer
import ru.onlinestore.mobile.data.models.ProductData
import ru.onlinestore.mobile.data.models.ProductListData
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.domain.models.ProductDomain
import ru.onlinestore.mobile.domain.models.ProductListDomain
import ru.onlinestore.mobile.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val productsRemoteSource: ProductsRemoteSource
): ProductRepository {

    override suspend fun fetchListProducts(): ResultContainer<ProductListDomain> =
        productsRemoteSource.fetchListProducts().map(mapperProductList)

    private val mapperProductList = { products: ProductListData ->
        ProductListDomain(
            products = mapperProduct(products.products),
            total = products.total,
            skip = products.skip,
            limit = products.limit
        )
    }

    private val mapperProduct = { products: List<ProductData> ->
        products.map { product ->
            ProductDomain(
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