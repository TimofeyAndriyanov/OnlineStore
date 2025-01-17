package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.ProductUI


data class ProductDomain(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
) {
    fun toUI() =
        ProductUI(
            id = id,
            title = title,
            category = category,
            description = description,
            price = price,
            thumbnail = thumbnail,
            images = images
        )
}