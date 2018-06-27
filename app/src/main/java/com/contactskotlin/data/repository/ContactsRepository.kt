package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.dto.ContactsDTO
import com.contactskotlin.data.model.CityResponse
import io.reactivex.Single


interface ContactsRepository {
    fun getContacts(): Single<ContactsDTO>
    fun getCities(): Single<CityResponse>
}