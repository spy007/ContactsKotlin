package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.dto.ContactsDTO
import com.contactskotlin.data.model.CityResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteContactsService {
    @GET("contacts")
    fun requestContacts(): Single<ContactsDTO>

    @GET("citiesJSON")
    fun requestCities(@Query("north") north: Double, @Query("south") south: Double,
                      @Query("east") east: Double, @Query("west") west: Double, @Query("lang") lang: String): Single<CityResponse>
}