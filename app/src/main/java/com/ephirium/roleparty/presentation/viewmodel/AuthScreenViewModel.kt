package com.ephirium.roleparty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ephirium.roleparty.presentation.model.screenstates.AuthScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class AuthScreenViewModel: ViewModel() {
    abstract val screenState: StateFlow<AuthScreenState>

    abstract fun updateScreenState(newState: AuthScreenState)
}

internal class AuthScreenViewModelImpl() : AuthScreenViewModel() {
    override var screenState: MutableStateFlow<AuthScreenState> =
        MutableStateFlow(AuthScreenState())

    override fun updateScreenState(newState: AuthScreenState) {
        screenState.value = newState
    }


}