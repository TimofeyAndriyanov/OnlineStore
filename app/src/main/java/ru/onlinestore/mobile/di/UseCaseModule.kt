package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchMeUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchRefreshUseCase
import ru.onlinestore.mobile.domain.usecase.FetchUserListUseCase
import ru.onlinestore.mobile.domain.usecase.FindUserByIdUseCase
import ru.onlinestore.mobile.domain.usecase.LogInUseCase
import ru.onlinestore.mobile.domain.usecase.SearchUserByNameUseCase

val UseCaseModule = module {
    singleOf(::FetchProductListUseCase)
    singleOf(::FetchCategoryListUseCase)
    singleOf(::LogInUseCase)
    singleOf(::FetchUserListUseCase)
    singleOf(::FetchMeUseCase)
    singleOf(::FetchRefreshUseCase)
    singleOf(::FindUserByIdUseCase)
    singleOf(::SearchUserByNameUseCase)
}