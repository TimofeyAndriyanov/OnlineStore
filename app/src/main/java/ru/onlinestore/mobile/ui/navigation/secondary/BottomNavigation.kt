package ru.onlinestore.mobile.ui.navigation.secondary

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigation(controller: NavController) {
    val itemList = mapOf(
        SecondaryScreens.Products
                to ItemNavigation(title = "Продукты", icon = Icons.Filled.ShoppingCart)
    )

    BottomAppBar(
        content = {
            val backstackEntry by controller.currentBackStackEntryAsState()
            val destination = backstackEntry?.destination?.route
            itemList.forEach { (t, u) ->
                NavigationBarItem(
                    selected = t::class.qualifiedName == destination,
                    onClick = { controller.navigate(SecondaryScreens.Products) },
                    label = {
                        Text(
                            text = u.title,
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = u.icon,
                            contentDescription = null
                        )
                    }
                )
            }
        }
    )
}