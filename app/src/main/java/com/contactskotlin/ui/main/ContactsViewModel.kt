package com.contactskotlin.ui.main

import android.arch.lifecycle.ViewModel
import com.contactskotlin.data.repository.ContactsRepository
import javax.inject.Inject

class ContactsViewModel @Inject constructor(val contactsRepository: ContactsRepository) : ViewModel() {
    fun getContacts() = contactsRepository.getContacts()
}