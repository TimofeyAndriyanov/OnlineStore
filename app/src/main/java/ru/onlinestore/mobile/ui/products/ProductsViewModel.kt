package ru.onlinestore.mobile.ui.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.ui.entities.state.CategoryState
import ru.onlinestore.mobile.ui.entities.ProductListUI
import ru.onlinestore.mobile.ui.entities.state.ProductState
import ru.onlinestore.mobile.ui.entities.state.ProductsState

class ProductsViewModel(
    private val fetchProductListUseCase: FetchProductListUseCase,
    private val fetchCategoryListUseCase: FetchCategoryListUseCase
): ViewModel() {

    private val _stateflow = MutableStateFlow(ProductsState())
    val stateflow = _stateflow.asStateFlow()

    init {
        loadCategoryList()
        screenMessage()
    }

    fun loadProducts(url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            fetchProductListUseCase(url).collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(
                                    content = response.data,
                                    state = ResponseEnum.SUCCESS,
                                    exception = "",
                                ),
                                isScreenMessage = false
                            )
                        }
                    is Response.Empty ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(
                                    content = ProductListUI(),
                                    state = ResponseEnum.EMPTY,
                                    exception = "",
                                ),
                                isScreenMessage = true
                            )
                        }
                    is Response.Error ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(
                                    content = ProductListUI(),
                                    state = ResponseEnum.ERROR,
                                    exception = response.exception.toString(),
                                ),
                                isScreenMessage = true
                            )
                        }
                    is Response.Loading ->
                        _stateflow.update {
                            it.copy(
                                productState = ProductState(
                                    content = ProductListUI(),
                                    state = ResponseEnum.LOADING,
                                    exception = "",
                                ),
                                isScreenMessage = true
                            )
                        }

                    is Response.Invalid -> TODO()
                }
            }
        }
    }

    private fun loadCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCategoryListUseCase().collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                categoryState = CategoryState(
                                    categoryList = response.data,
                                    state = ResponseEnum.SUCCESS,
                                    exception = ""
                                )
                            )
                        }

                    is Response.Empty ->
                        _stateflow.update {
                            it.copy(
                                categoryState = CategoryState(
                                    categoryList = emptyList(),
                                    state = ResponseEnum.EMPTY,
                                    exception = ""
                                )
                            )
                        }
                    is Response.Error ->
                        _stateflow.update {
                            it.copy(
                                categoryState = CategoryState(
                                    categoryList = emptyList(),
                                    state = ResponseEnum.ERROR,
                                    exception = response.exception.toString()
                                )
                            )
                        }
                    is Response.Loading ->
                        _stateflow.update {
                            it.copy(
                                categoryState = CategoryState(
                                    categoryList = emptyList(),
                                    state = ResponseEnum.LOADING,
                                    exception = ""
                                )
                            )
                        }

                    is Response.Invalid -> TODO()
                }
            }
        }
    }

    private fun screenMessage() {
        viewModelScope.launch(Dispatchers.IO) {
            _stateflow.collect { response ->
                if (response.isScreenMessage) {
                    when(response.productState.state) {
                        ResponseEnum.SUCCESS ->
                            _stateflow.update {
                                it.copy(
                                    isScreenMessage = false,
                                    isLoading = false
                                )
                            }
                        ResponseEnum.LOADING ->
                            _stateflow.update {
                                it.copy(
                                    screenMessage = "Загрузка...",
                                    isScreenMessage = true,
                                    isLoading = true
                                )
                            }
                        ResponseEnum.ERROR ->
                            _stateflow.update {
                                it.copy(
                                    screenMessage = it.productState.exception,
                                    isScreenMessage = true,
                                    isLoading = false
                                )
                            }
                        ResponseEnum.EMPTY ->
                            _stateflow.update {
                                it.copy(
                                    screenMessage = "Пусто",
                                    isScreenMessage = true,
                                    isLoading = false
                                )
                            }
                        ResponseEnum.DEFAULT ->
                            _stateflow.update {
                                it.copy(
                                    screenMessage = "Выберите категорию.",
                                    isScreenMessage = true,
                                    isLoading = false
                                )
                            }

                        ResponseEnum.INVALID -> TODO()
                    }
                }
            }
        }
    }
}