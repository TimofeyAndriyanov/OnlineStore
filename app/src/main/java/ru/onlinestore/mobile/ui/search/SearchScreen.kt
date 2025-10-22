package ru.onlinestore.mobile.ui.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import ru.onlinestore.mobile.R
import ru.onlinestore.mobile.ui.entities.state.SearchState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(state: SearchState) {
    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {

        }
    }
}

@Composable
fun <T> SearchBar(onSearch: (String) -> Unit, searchResult: List<T>) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Box(
        Modifier
            .fillMaxSize()
            .semantics { isTraversalGroup = true }
    ) {

    }
}