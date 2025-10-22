package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.onlinestore.mobile.data.sources.ProductsRemoteSource
import ru.onlinestore.mobile.data.sources.UserRemoteSource
import ru.onlinestore.mobile.data.sources.remote.ProductsRemoteSourceImpl
import ru.onlinestore.mobile.data.sources.remote.UserRemoteSourceImpl

val RemoteSourceModule = module {
    singleOf(::ProductsRemoteSourceImpl) bind ProductsRemoteSource::class
    singleOf(::UserRemoteSourceImpl) bind UserRemoteSource::class
}