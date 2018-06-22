package com.contactskotlin.data.factory

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.contactskotlin.data.repository.ContactsRepository
import com.contactskotlin.ui.main.ContactsViewModel
import javax.inject.Inject

class ContactsViewModelFactory @Inject constructor(val contactRepository: ContactsRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
            return ContactsViewModel(contactRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}