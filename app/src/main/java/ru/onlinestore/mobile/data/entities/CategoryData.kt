package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    val slug: String,
    val name: String,
    val url: String
)