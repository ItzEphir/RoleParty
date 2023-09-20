package com.ephirium.roleparty.data.repository

import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.common.OnSuccessListener
import com.ephirium.roleparty.data.storage.SharedPreferencesStorage
import com.ephirium.roleparty.domain.repositorybase.ActiveUserIdRepositoryBase

class ActiveUserIdRepositoryImpl(
    private val sharedPreferencesStorage: SharedPreferencesStorage,
) : ActiveUserIdRepositoryBase {

    override fun loadActiveUser(
        onReceiveListener: OnReceiveListener<String?>,
        onExceptionListener: OnExceptionListener,
    ) {
        sharedPreferencesStorage.loadActiveUserId(onReceiveListener = {
            onReceiveListener(it)
        }, onExceptionListener = onExceptionListener)
    }

    override fun saveActiveUser(
        user: String,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener,
    ) {

    }
}