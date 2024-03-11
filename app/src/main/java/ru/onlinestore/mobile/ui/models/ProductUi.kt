package ru.onlinestore.mobile.ui.models

data class ProductUi(
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
