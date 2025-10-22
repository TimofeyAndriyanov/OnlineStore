package ru.onlinestore.mobile.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.onlinestore.mobile.ui.entities.state.ProfileState

class ProfileViewModel: ViewModel() {

    private val _stateflow = MutableStateFlow(ProfileState())
    val stateflow = _stateflow.asStateFlow()
}