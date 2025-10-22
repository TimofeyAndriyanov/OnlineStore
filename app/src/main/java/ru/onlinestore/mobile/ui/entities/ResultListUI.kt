package ru.onlinestore.mobile.ui.entities

data class ResultListUI<T>(
    val result: List<T> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
)