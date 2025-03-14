package ru.onlinestore.mobile.ui.navigation.secondary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import ru.onlinestore.mobile.ui.navigation.secondary.SecondaryScreens.*
import ru.onlinestore.mobile.ui.products.ProductsScreen
import ru.onlinestore.mobile.ui.products.ProductsViewModel

@Composable
fun SecondaryGraph(
    controller: NavHostController,
    modifier: Modifier = Modifier
) =
    NavHost(
        navController = controller,
        startDestination = Products,
        builder = {
            composable<Products> {
                val vm = koinViewModel<ProductsViewModel>()
                val state = vm.stateflow.collectAsState()
                ProductsScreen(
                    state = state.value,
                    choiceCategory = { vm.loadProducts(it.url) }
                )
            }

        },
        modifier = modifier
    )