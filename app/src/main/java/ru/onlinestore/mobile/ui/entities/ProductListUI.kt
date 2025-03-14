package ru.onlinestore.mobile.ui.entities

data class ProductListUI(
    val products: List<ProductUI> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
)