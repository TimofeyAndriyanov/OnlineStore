package ru.onlinestore.mobile.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.core.ErrorResult
import ru.onlinestore.mobile.core.LoadingResult
import ru.onlinestore.mobile.core.SuccessResult
import ru.onlinestore.mobile.domain.usecase.GetListProductsUseCase
import ru.onlinestore.mobile.ui.states.MainState
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getListProductsUseCase: GetListProductsUseCase
): ViewModel() {


    private val _stateFlow = MutableStateFlow(MainState())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            getListProductsUseCase().collect { result ->
                when(result) {
                    is ErrorResult -> _stateFlow.update {
                        it.copy(errorMessage = result.exception.message)
                    }

                    is LoadingResult -> _stateFlow.update {
                        it.copy(loading = true)
                    }

                    is SuccessResult -> _stateFlow.update {
                        it.copy(
                            loading = false,
                            products = result.data.products
                        )
                    }
                }
            }
        }
    }
}