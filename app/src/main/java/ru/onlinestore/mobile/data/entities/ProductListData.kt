package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.ProductListDomain

@Serializable
data class ProductListData(
    val products: List<ProductData> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
) {
    fun toDomain() =
        ProductListDomain(
            products = products.map { it.toDomain() },
            total = total,
            skip = skip,
            limit = limit
        )
}