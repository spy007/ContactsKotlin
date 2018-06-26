package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import io.reactivex.Single
import retrofit2.http.GET

interface RemoteContactsService {
    @GET("contacts")
    fun requestContacts(): Single<ContactDTO>
}