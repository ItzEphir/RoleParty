package com.ephirium.roleparty.domain.usecase

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.domain.dtobase.UserDtoBase
import com.ephirium.roleparty.domain.repositorybase.ActiveUserIdRepositoryBase
import com.ephirium.roleparty.domain.repositorybase.UserRepositoryBase

class LoadActiveUserUseCase(
    private val activeUserIdRepositoryBase: ActiveUserIdRepositoryBase,
    private val userRepository: UserRepositoryBase,
) {
    fun execute(
        onReceiveListener: OnReceiveListener<UserDtoBase>,
        onExceptionListener: OnExceptionListener,
    ) {
        activeUserIdRepositoryBase.loadActiveUser(onReceiveListener = { id ->
            when (id) {
                null -> onExceptionListener(NullPointerException("User is null"))
                else -> {
                    userRepository.loadUserById(id, onReceiveListener, onExceptionListener)
                }
            }
        }, onExceptionListener = onExceptionListener)
    }
}
