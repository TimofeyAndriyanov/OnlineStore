package ru.onlinestore.mobile.domain.entities

data class ProductDomain(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
)