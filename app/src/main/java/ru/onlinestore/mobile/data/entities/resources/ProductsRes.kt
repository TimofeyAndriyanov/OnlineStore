package ru.onlinestore.mobile.data.entities.resources

import io.ktor.resources.Resource

@Resource("products")
data class ProductsRes(val parent: RootRes = RootRes) {

    @Resource("{id}")
    data class Product(val id: Int, val parent: ProductsRes = ProductsRes())

    @Resource("categories")
    data class Categories(val parent: ProductsRes = ProductsRes())

    @Resource("search?q={text}")
    data class Search(val text: String, val parent: ProductsRes = ProductsRes())
}