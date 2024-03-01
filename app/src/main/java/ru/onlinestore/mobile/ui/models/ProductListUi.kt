package ru.onlinestore.mobile.ui.models

data class ProductListUi(
    val products: List<ProductUi>,
    val total: Int,
    val skip: Int,
    val limit: Int
)
