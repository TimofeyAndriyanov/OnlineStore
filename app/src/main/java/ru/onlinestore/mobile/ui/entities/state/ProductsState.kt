package ru.onlinestore.mobile.ui.entities.state

data class ProductsState(
    val productState: ProductState = ProductState(),
    val categoryState: CategoryState = CategoryState(),
    val isScreenMessage: Boolean = false,
    val isLoading: Boolean = false,
    val screenMessage: String = "мда"
)