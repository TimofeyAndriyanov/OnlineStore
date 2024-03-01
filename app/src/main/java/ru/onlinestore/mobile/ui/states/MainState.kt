package ru.onlinestore.mobile.ui.states

import ru.onlinestore.mobile.ui.models.ProductUi

data class MainState(
    val channels: List<ProductUi> = emptyList(),
    val loading: Boolean? = false,
    val errorMessage: String? = ""
)
