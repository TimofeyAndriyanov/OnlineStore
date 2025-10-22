package ru.onlinestore.mobile.ui.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.ui.entities.state.BasketState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketScreen(state: BasketState) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                { Text(stringResource(R.string.basket)) }
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {},
                icon = {
                    Icon(painterResource(R.drawable.outline_shopping_cart_checkout_24), null)
                },
                text = {
                    Text(stringResource(R.string.make_an_order))
                }
            )
        }
    ) { paddingValues ->
        ShoppingList(paddingValues, emptyList())
    }
}

@Composable
private fun ShoppingList(padding: PaddingValues, list: List<Unit>) {
    LazyColumn(
        modifier = Modifier.padding(padding),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(list) {
            BasketItem()
        }
    }
}

@Composable
private fun BasketItem() {

}