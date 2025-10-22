package ru.onlinestore.mobile.domain.entities

data class ResultListDomain<T>(
    val result: List<T> = emptyList(),
    val total: Int = 0,
    val skip: Int = 0,
    val limit: Int = 0
)