package ru.onlinestore.mobile.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class ResultListData<T>(
    val result: List<T> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
)