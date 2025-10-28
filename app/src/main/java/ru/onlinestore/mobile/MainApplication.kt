package ru.onlinestore.mobile

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.onlinestore.mobile.di.*
import android.app.Application
import org.koin.android.ext.android.inject
import ru.onlinestore.mobile.core.Core
import ru.onlinestore.mobile.core.CoreProvider
import kotlin.getValue

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidLogger(Level.DEBUG)
            modules(
                koinModule,
                UseCaseModule,
                RepositoryModule,
                RemoteSourceModule,
                ViewModelModule
            )
        }

        val defaultCoreProvider by inject<CoreProvider>()
        Core.init(defaultCoreProvider)
    }
}