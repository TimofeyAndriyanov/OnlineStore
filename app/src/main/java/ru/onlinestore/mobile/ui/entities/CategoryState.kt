package ru.onlinestore.mobile.ui.entities

import ru.onlinestore.mobile.core.ResponseEnum

data class CategoryState(
    val state: ResponseEnum,
    val exception: String,
    val categoryList: List<CategoryUI>
) {
    companion object {
        fun default() =
            CategoryState(
                state = ResponseEnum.DEFAULT,
                exception = "",
                categoryList = emptyList()
            )
    }
}
