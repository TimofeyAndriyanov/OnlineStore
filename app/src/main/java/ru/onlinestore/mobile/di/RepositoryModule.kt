package ru.onlinestore.mobile.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.onlinestore.mobile.data.repository.ProductRepositoryImpl
import ru.onlinestore.mobile.domain.repository.ProductRepository

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindProductsRepository(impl: ProductRepositoryImpl): ProductRepository
}