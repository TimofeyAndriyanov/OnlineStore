package ru.onlinestore.mobile.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.ui.entities.state.ProductState
import ru.onlinestore.mobile.ui.entities.state.HomeState

class HomeViewModel(
    private val fetchProductListUseCase: FetchProductListUseCase,
    private val fetchCategoryListUseCase: FetchCategoryListUseCase
): ViewModel() {

    private val _stateflow = MutableStateFlow(HomeState())
    val stateflow = _stateflow.asStateFlow()

    init {
        loadCategoryList()
    }

    fun loadProducts(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchProductListUseCase(url).collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(
                                    content = response.data
                                )
                            )
                        }
                    is Response.Invalid ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(

                                )
                            )
                        }
                    is Response.Loading -> TODO()
                    is Response.Error.ClientRequest -> TODO()
                    is Response.Error.Io -> TODO()
                    is Response.Error.Serialization -> TODO()
                    is Response.Error.ServerResponse -> TODO()
                    is Response.Unknow -> TODO()
                }
            }
        }
    }

    private fun loadCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCategoryListUseCase().collect { response ->
                when(response) {
                    is Response.Success -> TODO()
                    is Response.Invalid -> TODO()
                    is Response.Loading -> TODO()
                    is Response.Error.ClientRequest -> TODO()
                    is Response.Error.Io -> TODO()
                    is Response.Error.Serialization -> TODO()
                    is Response.Error.ServerResponse -> TODO()
                    is Response.Unknow -> TODO()
                }
            }
        }
    }
}