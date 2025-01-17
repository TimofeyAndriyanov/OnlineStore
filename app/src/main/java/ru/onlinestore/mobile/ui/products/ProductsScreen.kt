package ru.onlinestore.mobile.ui.products

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.ui.entities.CategoryUI
import ru.onlinestore.mobile.ui.entities.ProductsState

@Preview
@Composable
private fun ProductsScreenPreview() =
    ProductsScreen(
        state = ProductsState.default(),
        choiceCategory = {}
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(
    state: ProductsState,
    choiceCategory: (CategoryUI) -> Unit
) {
    Log.d("ProductsScreen", state.toString())

    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "Продукты",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },
                    //actions = {
                    //    IconButton(
                    //        onClick = {},
                    //        content = {
                    //            Icon(
                    //                imageVector = Icons.Filled.Search,
                    //                contentDescription = null
                    //            )
                    //        }
                    //    )
                    //}
                )

                var selectedItem by remember { mutableStateOf(CategoryUI.default()) }

                LazyRow(
                    content = {
                        items(state.categoryState.categoryList) { item ->
                            FilterChip(
                                onClick = {
                                    choiceCategory(item)
                                    selectedItem = item
                                },
                                label = { Text(text = item.name) },
                                selected = selectedItem == item
                            )
                        }
                    },
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                )
            }
        },
        content = { padding ->
            if (!state.isScreenMessage)
                LazyColumn(
                    content = { items(state.content.products) { ProductItem(it) } },
                    modifier = Modifier.padding(padding)
                )
            else
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                    content = {
                        if (state.isLoading) CircularProgressIndicator()
                        else Text(text = state.screenMessage)
                    }
                )
        }
    )
}