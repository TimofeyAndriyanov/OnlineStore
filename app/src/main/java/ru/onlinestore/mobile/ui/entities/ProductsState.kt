package ru.onlinestore.mobile.ui.entities

import ru.onlinestore.mobile.core.ResponseEnum

data class ProductsState(
    val state: ResponseEnum,
    val exception: String,
    val content: ProductListUI,
    val categoryState: CategoryState,
    val isScreenMessage: Boolean,
    val isLoading: Boolean,
    val screenMessage: String
) {
    companion object {
        fun default() =
            ProductsState(
                state = ResponseEnum.DEFAULT,
                exception = "",
                content = ProductListUI.default(),
                categoryState = CategoryState.default(),
                isScreenMessage = true,
                isLoading = false,
                screenMessage = ""
            )
    }
}
