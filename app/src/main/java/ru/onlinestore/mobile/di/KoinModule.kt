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
import ru.onlinestore.mobile.data.repository.IdentificationRepositoryImpl
import ru.onlinestore.mobile.data.repository.ProductRepositoryImpl
import ru.onlinestore.mobile.data.sources.IdentificationRemoteSource
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.sources.remote.IdentificationRemoteSourceImpl
import ru.onlinestore.mobile.data.sources.remote.ProductsRemoteSourceImpl
import ru.onlinestore.mobile.domain.repository.IdentificationRepository
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.usecase.AuthorizationUseCase
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchUserListUseCase
import ru.onlinestore.mobile.ui.identification.authorization.AuthorizationViewModel
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

    single<IdentificationRemoteSource> { IdentificationRemoteSourceImpl(client = get<HttpClient>()) }

    single<ProductRepository> { ProductRepositoryImpl(remote = get<ProductsRemoteSource>()) }

    single<IdentificationRepository> { IdentificationRepositoryImpl(remote = get<IdentificationRemoteSource>()) }

    single { FetchProductListUseCase(repository = get<ProductRepository>()) }

    single { FetchCategoryListUseCase(repository = get<ProductRepository>()) }

    single { AuthorizationUseCase(repository = get<IdentificationRepository>()) }

    single { FetchUserListUseCase(repository = get<IdentificationRepository>()) }

    viewModel<ProductsViewModel> {
        ProductsViewModel(
            fetchProductListUseCase = get<FetchProductListUseCase>(),
            fetchCategoryListUseCase = get<FetchCategoryListUseCase>()
        )
    }

    viewModel<AuthorizationViewModel> {
        AuthorizationViewModel(
            authorizationUseCase = get<AuthorizationUseCase>(),
            fetchUserListUseCase = get<FetchUserListUseCase>()
        )
    }
}