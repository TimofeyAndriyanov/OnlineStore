package ru.onlinestore.mobile.ui.entities

data class ProductListUI(
    val products: List<ProductUI>,
    val total: Int,
    val skip: Int,
    val limit: Int
) {
    companion object {
        fun default() =
            ProductListUI(
                products = emptyList(),
                total = 0,
                skip = 0,
                limit = 0
            )
    }
}