package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import io.reactivex.Single


interface ContactsRepository {
    fun getContacts(): Single<ContactsResponse>
}