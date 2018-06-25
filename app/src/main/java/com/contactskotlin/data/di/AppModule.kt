package com.contactskotlin.data.di

import android.content.Context
import com.contactskotlin.ContactsApp
import com.contactskotlin.data.factory.ContactsViewModelFactory
import com.contactskotlin.data.repository.ContactsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val weatherApplication: ContactsApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = weatherApplication

    @Provides
    @Singleton
    fun provideViewModelFactory(weatherRepository: ContactsRepository): ContactsViewModelFactory{
        return ContactsViewModelFactory(weatherRepository)
    }

}