package ru.onlinestore.mobile.ui.entities.product

data class ProductUI(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
)