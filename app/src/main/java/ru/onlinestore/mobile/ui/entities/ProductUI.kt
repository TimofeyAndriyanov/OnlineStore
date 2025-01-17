package ru.onlinestore.mobile.ui.entities

data class ProductUI(
    val id: Long,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val thumbnail: String,
    val images: List<String>
) {
    companion object {
        fun default() =
            ProductUI(
                id = 0,
                title = "",
                category = "",
                description = "",
                price = 0.0,
                thumbnail = "",
                images = emptyList()
            )
    }
}