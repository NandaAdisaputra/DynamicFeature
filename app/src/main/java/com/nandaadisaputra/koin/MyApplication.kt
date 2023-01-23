package com.nandaadisaputra.koin

import android.app.Application
import com.nandaadisaputra.koin.core.di.databaseModule
import com.nandaadisaputra.koin.core.di.networkModule
import com.nandaadisaputra.koin.core.di.repositoryModule
import com.nandaadisaputra.koin.di.useCaseModule
import com.nandaadisaputra.koin.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}