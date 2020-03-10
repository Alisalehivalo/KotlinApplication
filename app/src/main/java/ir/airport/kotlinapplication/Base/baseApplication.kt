package ir.airport.kotlinapplication.Base

import android.app.Application
import ir.airport.kotlinapplication.AladhanwithKoin.KoinModule
import ir.airport.kotlinapplication.Koin.ClassAModule
import ir.airport.kotlinapplication.Koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class baseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@baseApplication)
            modules(ClassAModule,viewModelModule,KoinModule)
        }
    }
}