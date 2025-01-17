package ru.onlinestore.mobile.ui.products

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.domain.usecase.FetchCategoryListUseCase
import ru.onlinestore.mobile.domain.usecase.FetchProductListUseCase
import ru.onlinestore.mobile.ui.entities.CategoryState
import ru.onlinestore.mobile.ui.entities.ProductListUI
import ru.onlinestore.mobile.ui.entities.ProductsState

class ProductsViewModel(
    private val fetchProductListUseCase: FetchProductListUseCase,
    private val fetchCategoryListUseCase: FetchCategoryListUseCase
): ViewModel() {

    private val _stateflow = MutableStateFlow(ProductsState.default())
    val stateflow = _stateflow.asStateFlow()

    init {
        loadCategoryList()
        screenMessage()
    }

    fun loadProducts(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            fetchProductListUseCase(url).collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                content = response.data,
                                state = ResponseEnum.SUCCESS,
                                exception = "",
                                isScreenMessage = false
                            )
                        }
                    is Response.Empty ->
                        _stateflow.update {
                            it.copy(
                                content = ProductListUI.default(),
                                state = ResponseEnum.EMPTY,
                                exception = "",
                                isScreenMessage = true
                            )
                        }
                    is Response.Error ->
                        _stateflow.update {
                            it.copy(
                                content = ProductListUI.default(),
                                state = ResponseEnum.ERROR,
                                exception = response.exception.toString(),
                                isScreenMessage = true
                            )
                        }
                    is Response.Loading ->
                        _stateflow.update {
                            it.copy(
                                content = ProductListUI.default(),
                                state = ResponseEnum.LOADING,
                                exception = "",
                                isScreenMessage = true
                            )
                        }
                }
            }
        }
    }

    private fun loadCategoryList() {
        CoroutineScope(Dispatchers.IO).launch {
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
                }
            }
        }
    }

    private fun screenMessage() {
        CoroutineScope(Dispatchers.IO).launch {
            _stateflow.collect { response ->
                if (response.isScreenMessage) {
                    when(response.state) {
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
                                    screenMessage = it.exception,
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
                    }
                }
            }
        }
    }
}