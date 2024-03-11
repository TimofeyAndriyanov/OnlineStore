package ru.onlinestore.mobile.domain.usecase

import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.models.ProductListDomain
import ru.onlinestore.mobile.domain.models.ProductDomain
import ru.onlinestore.mobile.ui.models.ProductListUi
import ru.onlinestore.mobile.core.ResultContainer
import ru.onlinestore.mobile.ui.models.ProductUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.onlinestore.mobile.core.LoadingResult
import javax.inject.Inject

class GetListProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) {

    operator fun invoke(): Flow<ResultContainer<ProductListUi>> = flow {
        emit(LoadingResult())
        emit(productRepository.fetchListProducts().map(mapper))
    }

    private val mapper = { products: ProductListDomain ->
        ProductListUi(
            products = mapperProductUi(products.products),
            total = products.total,
            skip = products.skip,
            limit = products.limit
        )
    }

    private val mapperProductUi = { products: List<ProductDomain> ->
        products.map { product ->
            ProductUi(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price,
                discountPercentage = product.discountPercentage,
                rating = product.rating,
                stock = product.stock,
                brand = product.brand,
                category = product.category,
                thumbnail = product.thumbnail,
                images = product.images
            )
        }

    }

}