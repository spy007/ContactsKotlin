package com.contactskotlin

import android.app.Application
import com.contactskotlin.data.di.*

class ContactsApp: Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .roomModule(RoomModule())
                .remoteModule(RemoteModule()).build()
    }
}