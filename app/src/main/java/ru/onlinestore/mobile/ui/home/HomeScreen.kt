package ru.onlinestore.mobile.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.ui.components.DisplayLoading
import ru.onlinestore.mobile.ui.components.StateDisplay
import ru.onlinestore.mobile.ui.entities.CategoryUI
import ru.onlinestore.mobile.ui.entities.product.ProductUI
import ru.onlinestore.mobile.ui.entities.state.HomeState
import ru.onlinestore.mobile.ui.util.KoinPreview

@Preview
@Composable
private fun ProductsScreenPreview() =
    KoinPreview {
        HomeScreen(HomeState()) {}
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(state: HomeState, choiceCategory: (CategoryUI) -> Unit) {
    Scaffold(
        topBar = {
            Column {
                CenterAlignedTopAppBar(
                    { Text(stringResource(R.string.home)) }
                )
                when(state.categoryState.state) {
                    ResponseEnum.SUCCESS ->
                        CategoryList(state.categoryState.content, choiceCategory)
                    ResponseEnum.LOADING -> DisplayLoading()
                    ResponseEnum.INVALID -> StateDisplay(state.categoryState.invalidMessage)
                    ResponseEnum.EMPTY -> StateDisplay(stringResource(R.string.empty))
                    ResponseEnum.ERROR_CLIENT_REQUEST -> TODO()
                    ResponseEnum.ERROR_SERVER_RESPONSE -> TODO()
                    ResponseEnum.ERROR_IO -> TODO()
                    ResponseEnum.ERROR_SERIALIZATION -> TODO()
                    ResponseEnum.UNKNOW -> TODO()
                }
            }
        }
    ) { paddingValues -> paddingValues
        when(state.productState.state) {
            ResponseEnum.SUCCESS ->
                ProductList(state.productState.content.result, paddingValues)
            ResponseEnum.LOADING -> DisplayLoading()
            ResponseEnum.INVALID -> StateDisplay("")
            ResponseEnum.EMPTY -> TODO()
            ResponseEnum.ERROR_CLIENT_REQUEST -> TODO()
            ResponseEnum.ERROR_SERVER_RESPONSE -> TODO()
            ResponseEnum.ERROR_IO -> TODO()
            ResponseEnum.ERROR_SERIALIZATION -> TODO()
            ResponseEnum.UNKNOW -> TODO()
        }
    }
}

@Composable
private fun ProductList(list: List<ProductUI>, padding: PaddingValues) =
    LazyColumn(
        content = {
            items(list) {
                ListItem(
                    leadingContent = {

                    },
                    headlineContent = {

                    },
                    supportingContent = {

                    }
                )
            }
        },
        modifier = Modifier.padding(padding)
    )

@Composable
private fun CategoryList(list: List<CategoryUI>, choiceCategory: (CategoryUI) -> Unit) {
    var selectedItem by remember { mutableStateOf(CategoryUI()) }

    LazyRow(
        content = {
            items(list) { item ->
                FilterChip(
                    onClick = {
                        choiceCategory(item)
                        selectedItem = item
                    },
                    label = { Text(item.name) },
                    selected = selectedItem == item
                )
            }
        },
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    )
}