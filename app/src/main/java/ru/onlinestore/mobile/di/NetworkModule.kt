package ru.onlinestore.mobile.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.onlinestore.mobile.core.Constants
import ru.onlinestore.mobile.data.sources.remote.ProductsApiService


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideProductsApi(): ProductsApiService =
        createService<ProductsApiService>(Constants.ROOT_URL)

    private inline fun <reified T> createService(url: String) =
        Retrofit.Builder().apply {
            baseUrl(url)
            addConverterFactory(GsonConverterFactory.create())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
        }.build().create(T::class.java)
}