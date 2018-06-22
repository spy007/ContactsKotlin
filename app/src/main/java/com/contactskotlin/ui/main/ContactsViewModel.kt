package com.contactskotlin.ui.main

import android.arch.lifecycle.ViewModel
import com.contactskotlin.data.repository.ContactsRepository
import javax.inject.Inject

class ContactsViewModel @Inject constructor(val contactsRepository: ContactsRepository) : ViewModel() {

    fun getWeather(cityName: String) = contactsRepository.getWeather(cityName)

    fun getCities() = contactsRepository.getCities()

    fun addCity(cityName: String) = contactsRepository.addCity(cityName)

}