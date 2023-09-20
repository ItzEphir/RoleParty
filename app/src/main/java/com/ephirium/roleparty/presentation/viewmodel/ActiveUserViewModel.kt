package com.ephirium.roleparty.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.ephirium.roleparty.domain.usecase.LoadActiveUserUseCase
import com.ephirium.roleparty.domain.usecase.SaveActiveUserUseCase
import com.ephirium.roleparty.presentation.model.base.UserBase
import com.ephirium.roleparty.presentation.model.implementation.UserImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ActiveUserViewModel(
    val loadActiveUserUseCase: LoadActiveUserUseCase,
    val saveActiveUserUseCase: SaveActiveUserUseCase
) : ViewModel() {

    private val mutActiveUser = MutableStateFlow<UserImpl?>(null)
    val activeUser = mutActiveUser.asStateFlow()

    fun updateActiveUser(user: UserImpl) {
        mutActiveUser.value?.let {
            mutActiveUser.value = user
        }
    }

    fun saveNewActiveUser(user: UserBase, password: String) {
        TODO()
    }

}