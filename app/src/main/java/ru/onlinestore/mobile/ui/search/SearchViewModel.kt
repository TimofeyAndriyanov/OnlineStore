package ru.onlinestore.mobile.ui.search

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.onlinestore.mobile.ui.entities.state.SearchState

class SearchViewModel: ViewModel() {

    private val _stateflow = MutableStateFlow(SearchState())
    val stateflow = _stateflow.asStateFlow()
}