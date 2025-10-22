package ru.onlinestore.mobile.ui.navigation.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.viewmodel.koinViewModel
import ru.onlinestore.mobile.ui.basket.BasketScreen
import ru.onlinestore.mobile.ui.basket.BasketViewModel
import ru.onlinestore.mobile.ui.navigation.secondary.keys.*
import ru.onlinestore.mobile.ui.home.HomeScreen
import ru.onlinestore.mobile.ui.home.HomeViewModel
import ru.onlinestore.mobile.ui.profile.ProfileScreen
import ru.onlinestore.mobile.ui.profile.ProfileViewModel
import ru.onlinestore.mobile.ui.search.SearchScreen
import ru.onlinestore.mobile.ui.search.SearchViewModel

@Composable
fun SecondaryNavDisplay(modifier: Modifier, backstack: SnapshotStateList<Any>) =
    NavDisplay(
        entryProvider = entryProvider {
            entry<Main> {
                val vm = koinViewModel<HomeViewModel>()
                val state by vm.stateflow.collectAsState()

                HomeScreen(state) { vm.loadProducts(it.url) }
            }
            entry<Search> {
                val vm = koinViewModel<SearchViewModel>()
                val state by vm.stateflow.collectAsState()

                SearchScreen(state)
            }
            entry<Basket> {
                val vm = koinViewModel<BasketViewModel>()
                val state by vm.stateflow.collectAsState()

                BasketScreen(state)
            }
            entry<Profile> {
                val vm = koinViewModel<ProfileViewModel>()
                val state by vm.stateflow.collectAsState()

                ProfileScreen(state)
            }
        },
        backStack = backstack,
        modifier = modifier
    )