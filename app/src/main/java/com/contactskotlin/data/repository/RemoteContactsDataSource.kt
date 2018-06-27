package com.contactskotlin.data.repository

import javax.inject.Inject

class RemoteContactsDataSource @Inject constructor(private val remoteContactsService : RemoteContactsService) {
    fun requestContacts() = remoteContactsService.requestContacts()
    fun requestCities() = remoteContactsService.requestCities(44.1, -9.9, -22.4, 55.2, "de")
}
