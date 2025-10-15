package com.example.kotlinmultiplatformdemo

import android.app.Application
import com.example.kotlinmultiplatformdemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KmpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KmpApplication)
            modules(appModule)
        }
    }
}
