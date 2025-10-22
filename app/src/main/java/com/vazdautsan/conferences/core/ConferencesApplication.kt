package com.vazdautsan.conferences.core

import android.app.Application
import com.vazdautsan.conferences.data.di.dataModule
import com.vazdautsan.conferences.domain.di.domainModule
import com.vazdautsan.conferences.features.conferenses.di.conferencesModule
import com.vazdautsan.conferences.local_storage.localStorageModule
import com.vazdautsan.conferences.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ConferencesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ConferencesApplication)
            modules(
                dataModule,
                domainModule,
                networkModule,
                conferencesModule,
                localStorageModule
            )
        }
    }
}