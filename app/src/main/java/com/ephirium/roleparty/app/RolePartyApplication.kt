package com.ephirium.roleparty.app

import android.app.Application
import com.ephirium.roleparty.di.appModule
import com.ephirium.roleparty.di.dataModule
import com.ephirium.roleparty.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RolePartyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@RolePartyApplication)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}