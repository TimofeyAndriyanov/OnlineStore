package ru.onlinestore.mobile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.sources.remote.ProductsSourceImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun bindProductRemoteSource(impl: ProductsSourceImpl): ProductsRemoteSource
}