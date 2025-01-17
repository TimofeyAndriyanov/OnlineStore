package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.ProductDomain

@Serializable
data class ProductData(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
) {
    fun toDomain() =
        ProductDomain(
            id = id,
            title = title,
            category = category,
            description = description,
            price = price,
            thumbnail = thumbnail,
            images = images
        )
}