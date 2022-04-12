package com.example.makepizza

import android.app.Application
import com.example.makepizza.di.categoriesModule
import com.example.makepizza.di.salesModule
import com.example.makepizza.di.serviceModule
import com.example.makepizza.di.viewmodelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MakePizzaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MakePizzaApplication)
            modules(listOf(salesModule, categoriesModule, serviceModule, viewmodelModule))
        }
    }
}