package ru.onlinestore.mobile.ui.basket

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.onlinestore.mobile.ui.entities.state.BasketState

class BasketViewModel: ViewModel() {

    private val _stateflow = MutableStateFlow(BasketState())
    val stateflow = _stateflow.asStateFlow()

}