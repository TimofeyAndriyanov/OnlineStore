package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.onlinestore.mobile.data.repository.ProductRepositoryImpl
import ru.onlinestore.mobile.data.repository.UserRepositoryImpl
import ru.onlinestore.mobile.domain.repository.ProductRepository
import ru.onlinestore.mobile.domain.repository.UserRepository

val RepositoryModule = module {
    singleOf(::ProductRepositoryImpl) bind ProductRepository::class
    singleOf(::UserRepositoryImpl) bind UserRepository::class
}