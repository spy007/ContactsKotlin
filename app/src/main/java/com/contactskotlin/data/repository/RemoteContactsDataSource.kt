package com.contactskotlin.data.repository

import javax.inject.Inject

class RemoteContactsDataSource @Inject constructor(private val remoteContactsService : RemoteContactsService) {
    fun requestContacts() = remoteContactsService.requestContacts()
}
