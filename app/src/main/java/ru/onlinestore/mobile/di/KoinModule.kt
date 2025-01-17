package ru.onlinestore.mobile.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.onlinestore.mobile.data.repository.ProductRepositoryImpl
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.sources.remote.ProductsRemoteSourceImpl
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.ui.products.ProductsViewModel

val koinModule = module {
    single<HttpClient> {
        HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "dummyjson.com"
                }
                contentType(ContentType.Application.Json)
            }
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
        }
    }

    single<ProductsRemoteSource> { ProductsRemoteSourceImpl(client = get<HttpClient>()) }

    single<ProductRepository> { ProductRepositoryImpl(remote = get<ProductsRemoteSource>()) }

    single { FetchProductListUseCase(repository = get<ProductRepository>()) }

    single { FetchCategoryListUseCase(repository = get<ProductRepository>()) }

    viewModel {
        ProductsViewModel(
            fetchProductListUseCase = get<FetchProductListUseCase>(),
            fetchCategoryListUseCase = get<FetchCategoryListUseCase>()
        )
    }
}