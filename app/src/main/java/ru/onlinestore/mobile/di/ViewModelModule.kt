package ru.onlinestore.mobile.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import ru.onlinestore.mobile.ui.basket.BasketViewModel
import ru.onlinestore.mobile.ui.log_in.LogInViewModel
import ru.onlinestore.mobile.ui.home.HomeViewModel
import ru.onlinestore.mobile.ui.profile.ProfileViewModel
import ru.onlinestore.mobile.ui.search.SearchViewModel

val ViewModelModule = module {
    viewModelOf(::HomeViewModel)
    viewModelOf(::LogInViewModel)
    viewModelOf(::SearchViewModel)
    viewModelOf(::BasketViewModel)
    viewModelOf(::ProfileViewModel)
}