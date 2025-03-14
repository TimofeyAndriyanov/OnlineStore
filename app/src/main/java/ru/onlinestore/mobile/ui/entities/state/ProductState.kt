package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.ProductListUI

data class ProductState(
    val state: ResponseEnum = ResponseEnum.DEFAULT,
    val exception: String = "",
    val content: ProductListUI = ProductListUI()
)
