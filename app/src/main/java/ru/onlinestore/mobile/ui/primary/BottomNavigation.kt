package ru.onlinestore.mobile.ui.primary

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.ui.entities.BottomNavItem
import ru.onlinestore.mobile.ui.navigation.secondary.keys.Basket
import ru.onlinestore.mobile.ui.navigation.secondary.keys.Main
import ru.onlinestore.mobile.ui.navigation.secondary.keys.Profile
import ru.onlinestore.mobile.ui.navigation.secondary.keys.Search

private val items @Composable get() = listOf(
    BottomNavItem(
        label = stringResource(R.string.main),
        unselectedIcon = painterResource(R.drawable.outline_home_24),
        selectedIcon = painterResource(R.drawable.baseline_home_24),
        route = Main
    ),
    BottomNavItem(
        label = stringResource(R.string.search),
        unselectedIcon = painterResource(R.drawable.outline_search_24),
        selectedIcon = painterResource(R.drawable.outline_search_24),
        route = Search
    ),
    BottomNavItem(
        label = stringResource(R.string.basket),
        unselectedIcon = painterResource(R.drawable.outline_shopping_basket_24),
        selectedIcon = painterResource(R.drawable.baseline_shopping_basket_24),
        route = Basket
    ),
    BottomNavItem(
        label = stringResource(R.string.profile),
        unselectedIcon = painterResource(R.drawable.outline_person_24),
        selectedIcon = painterResource(R.drawable.baseline_person_24),
        route = Profile
    )
)

@Composable
fun BottomNavigation(backStack: SnapshotStateList<Any>) =
    BottomAppBar {
        items.forEach { item ->
            val isSelected = backStack.last() == item.route

            NavigationBarItem(
                selected = isSelected,
                onClick = { backStack.add(item.route) },
                label = { Text(item.label) },
                icon = {
                    if (isSelected)
                        Icon(item.selectedIcon, null)
                    else
                        Icon(item.unselectedIcon, null)
                }
            )
        }
    }