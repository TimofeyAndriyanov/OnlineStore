package ru.onlinestore.mobile.ui.navigation.primary

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

            }
        }
    )