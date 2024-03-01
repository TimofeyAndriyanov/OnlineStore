package ru.onlinestore.mobile.domain.models

data class ProductListDomain(
    val products: List<ProductDomain>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
