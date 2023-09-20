package com.ephirium.roleparty.domain.repositorybase

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.common.OnSuccessListener

interface ActiveUserIdRepositoryBase {
    fun loadActiveUser(
        onReceiveListener: OnReceiveListener<String?>,
        onExceptionListener: OnExceptionListener
    )

    fun saveActiveUser(
        user: String,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener
    )
}