package ru.onlinestore.mobile

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.onlinestore.mobile.di.RemoteSourceModule
import ru.onlinestore.mobile.di.RepositoryModule
import ru.onlinestore.mobile.di.UseCaseModule
import ru.onlinestore.mobile.di.ViewModelModule
import ru.onlinestore.mobile.di.koinModule

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
    }
}