package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteContactsService {
    @GET
    fun requestContacts(): Single<ContactsResponse>
}