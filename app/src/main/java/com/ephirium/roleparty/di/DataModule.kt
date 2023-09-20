package com.ephirium.roleparty.di

import android.content.Context
import android.content.SharedPreferences
import com.ephirium.roleparty.data.repository.ActiveUserIdRepositoryImpl
import com.ephirium.roleparty.data.repository.UserRepository
import com.ephirium.roleparty.data.storage.SharedPreferencesStorage
import com.ephirium.roleparty.domain.repositorybase.ActiveUserIdRepositoryBase
import com.ephirium.roleparty.domain.repositorybase.UserRepositoryBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private const val SHARED_PREFERENCES_KEY = "sharedPreferencesKey"

val dataModule = module {

    single<SharedPreferences> {
        androidContext().getSharedPreferences(SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
    }

    single {
        SharedPreferencesStorage(sharedPreferences = get())
    }

    single<UserRepositoryBase> {
        UserRepository()
    }

    single<ActiveUserIdRepositoryBase> {
        ActiveUserIdRepositoryImpl(sharedPreferencesStorage = get())
    }

}
