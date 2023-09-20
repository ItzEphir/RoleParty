package com.ephirium.roleparty.domain.usecase

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnSuccessListener
import com.ephirium.roleparty.domain.repositorybase.ActiveUserIdRepositoryBase

class SaveActiveUserUseCase(private val repository: ActiveUserIdRepositoryBase) {
    fun execute(
        userId: String,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener
    ) {
        repository.saveActiveUser(userId, onSuccessListener, onExceptionListener)
    }
}