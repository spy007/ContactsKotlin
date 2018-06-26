package com.contactskotlin.data.di

import com.contactskotlin.MainActivity
import com.contactskotlin.ui.main.MainFragment
import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class, RemoteModule::class, RoomModule::class, ContactsRepositoryModule::class))
@Singleton
interface AppComponent {
    fun inject(mainFragment: MainActivity)
}