package ru.onlinestore.mobile.ui.navigation.primary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.koin.compose.viewmodel.koinViewModel
import ru.onlinestore.mobile.ui.identification.authorization.AuthorizationScreen
import ru.onlinestore.mobile.ui.identification.authorization.AuthorizationViewModel
import ru.onlinestore.mobile.ui.navigation.primary.PrimaryScreens.*
import ru.onlinestore.mobile.ui.primary.PrimaryScreen

@Composable
fun PrimaryGraph(controller: NavHostController) =
    NavHost(
        navController = controller,
        startDestination = Primary,
        builder = {
            composable<Primary> { PrimaryScreen() }

            composable<Authorization> {
                val vm = koinViewModel<AuthorizationViewModel>()
                val state = vm.stateflow.collectAsState()
                AuthorizationScreen(
                    state = state.value,
                    auth = { vm.authorization(it) }
                )
            }
        }
    )