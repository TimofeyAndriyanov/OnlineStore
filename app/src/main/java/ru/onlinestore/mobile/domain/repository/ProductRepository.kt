package ru.onlinestore.mobile.domain.repository

import ru.onlinestore.mobile.core.ResultContainer
import ru.onlinestore.mobile.domain.models.ProductListDomain

interface ProductRepository {

    suspend fun fetchListProducts(): ResultContainer<ProductListDomain>
}