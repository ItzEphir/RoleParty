package com.ephirium.roleparty.domain.repositorybase

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.common.OnSuccessListener
import com.ephirium.roleparty.domain.dtobase.UserDtoBase

interface UserRepositoryBase {
    fun loadUserById(
        id: String,
        onReceiveListener: OnReceiveListener<UserDtoBase>,
        onExceptionListener: OnExceptionListener,
    )

    fun saveUser(
        user: UserDtoBase,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener,
    )
}