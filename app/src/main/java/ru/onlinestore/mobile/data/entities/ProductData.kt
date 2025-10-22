package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ProductData(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
)