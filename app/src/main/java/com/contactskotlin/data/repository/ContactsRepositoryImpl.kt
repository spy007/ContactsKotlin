package com.contactskotlin.data.repository

import com.contactskotlin.data.ContactsResponse
import com.contactskotlin.data.dto.ContactDTO
import com.contactskotlin.data.model.Contact
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ContactsRepositoryImpl @Inject constructor(
    private val remoteContactsDataSource: RemoteContactsDataSource) : ContactsRepository {

    override fun getContacts(): Single<ContactsResponse> {
        return remoteContactsDataSource.requestContacts()
    }
}