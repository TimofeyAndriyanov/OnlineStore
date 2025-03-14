package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.CategoryUI

data class CategoryState(
    val state: ResponseEnum = ResponseEnum.DEFAULT,
    val exception: String = "",
    val categoryList: List<CategoryUI> = emptyList()
)
