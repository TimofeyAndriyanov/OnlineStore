package ru.onlinestore.mobile.data.models

data class ProductListData(
    val products: List<ProductData>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
