package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.ProductListUI

data class ProductListDomain(
    val products: List<ProductDomain> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
) {
    fun toUI() =
        ProductListUI(
            products = products.map { it.toUI() },
            total = total,
            skip = skip,
            limit = limit
        )
}