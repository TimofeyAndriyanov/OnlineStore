package ru.onlinestore.mobile.ui.entities.state

import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.entities.ResultListUI
import ru.onlinestore.mobile.ui.entities.product.ProductUI

data class ProductState(
    val state: ResponseEnum = ResponseEnum.UNKNOW,
    val content: ResultListUI<ProductUI> = ResultListUI()
)
