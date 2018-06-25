package com.contactskotlin.data.di

import com.contactskotlin.data.repository.ContactsRepository
import com.contactskotlin.data.repository.ContactsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ContactsRepositoryModule {
    @Binds
    abstract fun bindsContactsRepository(contactsRepositoryImpl: ContactsRepositoryImpl): ContactsRepository
}