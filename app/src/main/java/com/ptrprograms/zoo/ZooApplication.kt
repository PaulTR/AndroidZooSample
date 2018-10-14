package com.ptrprograms.zoo

import android.app.Application
import org.koin.android.ext.android.startKoin

class ZooApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(koinModule))
    }
}