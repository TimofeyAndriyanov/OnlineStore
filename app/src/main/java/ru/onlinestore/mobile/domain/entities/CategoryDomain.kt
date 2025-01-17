package ru.onlinestore.mobile.domain.entities

import ru.onlinestore.mobile.ui.entities.CategoryUI

data class CategoryDomain(
    val slug: String,
    val name: String,
    val url: String
) {
    fun toUI() =
        CategoryUI(
            slug = slug,
            name = name,
            url = url
        )
}