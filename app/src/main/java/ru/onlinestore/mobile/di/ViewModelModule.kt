package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.onlinestore.mobile.ui.basket.BasketViewModel
import ru.onlinestore.mobile.ui.filter.ProductFilterViewModel
import ru.onlinestore.mobile.ui.product.ProductViewModel
import ru.onlinestore.mobile.ui.sign_in.SignInViewModel
import ru.onlinestore.mobile.ui.products.ProductsViewModel
import ru.onlinestore.mobile.ui.profile.ProfileViewModel
import ru.onlinestore.mobile.ui.search.SearchViewModel

val ViewModelModule = module {
    viewModelOf(::ProductsViewModel)
    viewModelOf(::SignInViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::BasketViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::ProductViewModel)
    viewModelOf(::ProductFilterViewModel)
}