package com.contactskotlin.ui.main

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableInt
import android.util.Log
import com.contactskotlin.data.dto.ContactsDTO
import com.contactskotlin.data.repository.ContactsRepository
import com.contactskotlin.databinding.MainActivityBinding
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ContactsViewModel @Inject constructor(val contactsRepository: ContactsRepository) : ViewModel() {
    fun getContacts() = contactsRepository.getContacts()

    val count = ObservableInt(0)

    fun setContacts(binding: MainActivityBinding) {
        getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { contacts: ContactsDTO?? ->
                    val contactsStr = StringBuffer()
                    val contactsLst = contacts?.contacts
                    contactsLst?.forEach {
                        contactsStr.append(it.name).append("\n")
                    }
                    binding.setContacts(contactsStr.toString())
                    Log.d("me007", "received city name: " + contactsStr.toString())
                }
    }

    fun pressedShowCities() {
        count.set(count.get() + 1)
    }
}