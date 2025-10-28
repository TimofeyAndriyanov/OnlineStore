package ru.onlinestore.mobile.di

import android.content.Context
import androidx.room.Room
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.resources.Resources
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.onlinestore.mobile.core.DefaultCoreProvider
import ru.onlinestore.mobile.data.sources.locale.room.OnlineStoreDatabase

val koinModule = module {
    single<HttpClient> {
        HttpClient {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "dummyjson.com"
                }
                contentType(ContentType.Application.Json)
                header(HttpHeaders.Authorization, "")
            }
            install(ContentNegotiation) { json(Json { ignoreUnknownKeys = true }) }
            install(Resources)
        }
    }
    single<OnlineStoreDatabase> {
        Room.databaseBuilder(
                context = get<Context>(),
                klass = OnlineStoreDatabase::class.java,
                name = "database"
        ).fallbackToDestructiveMigration(false).build()
    }
    singleOf(::DefaultCoreProvider)
}