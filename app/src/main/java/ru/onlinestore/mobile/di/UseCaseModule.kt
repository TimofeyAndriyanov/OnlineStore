package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.onlinestore.mobile.domain.usecase.*

val UseCaseModule = module {
    singleOf(::FetchProductListUseCase)
    singleOf(::FetchCategoryListUseCase)
    singleOf(::LogInUseCase)
    singleOf(::FetchUserListUseCase)
    singleOf(::FetchMeUseCase)
    singleOf(::FetchRefreshUseCase)
    singleOf(::FindUserByIdUseCase)
    singleOf(::SearchUserByNameUseCase)
    singleOf(::FetchProductByIdUseCase)
    singleOf(::FetchBrandListByCategoryUseCase)
}