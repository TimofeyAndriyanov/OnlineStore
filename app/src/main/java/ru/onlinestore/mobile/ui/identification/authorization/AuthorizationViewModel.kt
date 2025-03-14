package ru.onlinestore.mobile.ui.identification.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.core.Response
import ru.onlinestore.mobile.core.ResponseEnum
import ru.onlinestore.mobile.domain.usecase.AuthorizationUseCase
import ru.onlinestore.mobile.domain.usecase.FetchUserListUseCase
import ru.onlinestore.mobile.ui.entities.MessageUI
import ru.onlinestore.mobile.ui.entities.UserListUI
import ru.onlinestore.mobile.ui.entities.auth.AuthRequestBodyUI
import ru.onlinestore.mobile.ui.entities.auth.AuthResponseBodyUI
import ru.onlinestore.mobile.ui.entities.state.AuthState
import ru.onlinestore.mobile.ui.entities.state.UserState

class AuthorizationViewModel(
    private val authorizationUseCase: AuthorizationUseCase,
    private val fetchUserListUseCase: FetchUserListUseCase
): ViewModel() {

    private val _stateflow = MutableStateFlow(AuthState())
    val stateflow = _stateflow.asStateFlow()

    init { loadUsers() }

    fun authorization(auth: AuthRequestBodyUI) {

        viewModelScope.launch(Dispatchers.IO) {
            authorizationUseCase(auth = auth).collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                state = ResponseEnum.SUCCESS,
                                response = response.data,
                                invalidResponse = MessageUI()
                            )
                        }

                    is Response.Loading ->
                        _stateflow.update {
                            it.copy(
                                state = ResponseEnum.LOADING,
                                response = AuthResponseBodyUI(),
                                invalidResponse = MessageUI()
                            )
                        }

                    is Response.Invalid ->
                        _stateflow.update {
                            it.copy(
                                state = ResponseEnum.INVALID,
                                response = AuthResponseBodyUI(),
                                invalidResponse = response.data
                            )
                        }

                    is Response.Error ->
                        _stateflow.update {
                            it.copy(
                                state = ResponseEnum.ERROR,
                                response = AuthResponseBodyUI(),
                                invalidResponse = MessageUI()
                            )
                        }

                    is Response.Empty ->
                        _stateflow.update {
                            it.copy(
                                state = ResponseEnum.EMPTY,
                                response = AuthResponseBodyUI(),
                                invalidResponse = MessageUI()
                            )
                        }
                }
            }
        }
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchUserListUseCase().collect { response ->
                when(response) {
                    is Response.Success ->
                        _stateflow.update {
                            it.copy(
                                userState = UserState(
                                    state = ResponseEnum.SUCCESS,
                                    exceptionMessage = "",
                                    list = response.data
                                )
                            )
                        }

                    is Response.Invalid ->
                        _stateflow.update {
                            it.copy(
                                userState = UserState(
                                    state = ResponseEnum.INVALID,
                                    exceptionMessage = "",
                                    list = UserListUI()
                                )
                            )
                        }

                    is Response.Error ->
                        _stateflow.update {
                            it.copy(
                                userState = UserState(
                                    state = ResponseEnum.ERROR,
                                    exceptionMessage = response.exception.toString(),
                                    list = UserListUI()
                                )
                            )
                        }

                    is Response.Loading ->
                        _stateflow.update {
                            it.copy(
                                userState = UserState(
                                    state = ResponseEnum.LOADING,
                                    exceptionMessage = "",
                                    list = UserListUI()
                                )
                            )
                        }

                    is Response.Empty ->
                        _stateflow.update {
                            it.copy(
                                userState = UserState(
                                    state = ResponseEnum.EMPTY,
                                    exceptionMessage = "",
                                    list = UserListUI()
                                )
                            )
                        }
                }
            }
        }
    }
}