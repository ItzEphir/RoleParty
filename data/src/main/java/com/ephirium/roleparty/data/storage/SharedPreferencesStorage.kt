package com.ephirium.roleparty.data.storage

import android.content.SharedPreferences
import com.ephirium.roleparty.common.OnExceptionListener
import com.ephirium.roleparty.common.OnReceiveListener
import com.ephirium.roleparty.common.OnSuccessListener
import com.ephirium.roleparty.domain.dtobase.UserDtoBase
import kotlinx.coroutines.*

class SharedPreferencesStorage(private val sharedPreferences: SharedPreferences) {

    fun loadActiveUserId(
        onReceiveListener: OnReceiveListener<kotlin.String?>,
        onExceptionListener: OnExceptionListener,
    ) {
        runBlocking {
            val deferredData = async {
                try {
                    withContext(Dispatchers.IO) {
                        return@withContext sharedPreferences.getString(ACTIVE_USER_KEY, null)
                    }
                } catch (exception: Exception) {
                    onExceptionListener(exception)
                    return@async null
                }
            }
            onReceiveListener(deferredData.await())
        }
    }

    fun saveActiveUserId(
        user: UserDtoBase,
        onSuccessListener: OnSuccessListener,
        onExceptionListener: OnExceptionListener,
    ) {
        runBlocking {
            launch {
                try {
                    withContext(Dispatchers.IO) {
                        sharedPreferences.edit().putString(ACTIVE_USER_KEY, user.id)
                    }
                    onSuccessListener()
                } catch (e: Exception) {
                    onExceptionListener(e)
                }
            }
        }
    }

    companion object {
        private const val ACTIVE_USER_KEY = "ActiveUser"
    }

}