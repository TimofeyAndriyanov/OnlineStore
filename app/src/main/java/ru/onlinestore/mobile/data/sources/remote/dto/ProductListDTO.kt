package ru.onlinestore.mobile.data.sources.remote.dto

data class ProductListDTO(
    val products: List<ProductDTO>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
