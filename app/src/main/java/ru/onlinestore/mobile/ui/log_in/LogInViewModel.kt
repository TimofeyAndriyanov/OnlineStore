package ru.onlinestore.mobile.ui.log_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.onlinestore.mobile.domain.usecase.FetchUserListUseCase
import ru.onlinestore.mobile.domain.usecase.LogInUseCase
import ru.onlinestore.mobile.ui.entities.log_in.LogInRequestBodyUI
import ru.onlinestore.mobile.ui.entities.state.LogInState

class LogInViewModel(
    private val logInUseCase: LogInUseCase,
    private val fetchUserListUseCase: FetchUserListUseCase
): ViewModel() {

    private val _stateflow = MutableStateFlow(LogInState())
    val stateflow = _stateflow.asStateFlow()

    init { loadUsers() }

    fun logIn(login: LogInRequestBodyUI) {
        viewModelScope.launch(Dispatchers.IO) {
            logInUseCase(login).collect { response ->
                _stateflow.update {
                    it.copy(response.state)
                }
            }
        }
    }

    private fun loadUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchUserListUseCase().collect { response ->

            }
        }
    }
}