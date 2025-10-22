package ru.onlinestore.mobile.ui.navigation.primary

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.koin.compose.viewmodel.koinViewModel
import ru.onlinestore.mobile.ui.log_in.LogInScreen
import ru.onlinestore.mobile.ui.log_in.LogInViewModel
import ru.onlinestore.mobile.ui.navigation.primary.keys.LogIn
import ru.onlinestore.mobile.ui.navigation.primary.keys.Primary
import ru.onlinestore.mobile.ui.primary.PrimaryScreen

@Composable
fun PrimaryNavDisplay() {
    val backStack = remember { mutableStateListOf<Any>(Primary) }

    NavDisplay(
        entryProvider = entryProvider {
            entry<Primary> {
                PrimaryScreen()
            }

            entry<LogIn> {
                val vm = koinViewModel<LogInViewModel>()
                val state by vm.stateflow.collectAsState()

                LogInScreen(
                    state = state,
                    logIn = { vm.logIn(it) }
                )
            }
        },
        backStack = backStack
    )
}