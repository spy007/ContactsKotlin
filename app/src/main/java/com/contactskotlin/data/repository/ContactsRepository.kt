package com.contactskotlin.data.repository

import com.contactskotlin.data.model.Contact
import io.reactivex.Flowable
import io.reactivex.Single


interface ContactsRepository {
    fun getContacts(): Single<List<Contact>>
}