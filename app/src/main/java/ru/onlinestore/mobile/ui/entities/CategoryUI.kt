package ru.onlinestore.mobile.ui.entities

data class CategoryUI(
    val slug: String,
    val name: String,
    val url: String
)  {
    companion object {
        fun default() =
            CategoryUI(
                slug = "",
                name = "",
                url = ""
            )
    }
}