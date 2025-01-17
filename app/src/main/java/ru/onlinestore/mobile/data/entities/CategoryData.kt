package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable
import ru.onlinestore.mobile.domain.entities.CategoryDomain

@Serializable
data class CategoryData(
    val slug: String,
    val name: String,
    val url: String
) {
    fun toDomain() =
        CategoryDomain(
            slug = slug,
            name = name,
            url = url
        )
}