package ru.onlinestore.mobile.ui.entities.state

data class HomeState(
    val productState: ProductState = ProductState(),
    val categoryState: CategoryState = CategoryState(),
)