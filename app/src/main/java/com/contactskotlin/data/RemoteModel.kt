package com.contactskotlin.data

import com.contactskotlin.data.model.Phone

data class ContactsResponse(
        val cityName: String,
        val name: String,
        val email: String,
        val address: String,
        val gender: String,
        val phone: Phone
)

data class Phone(
        val mobile: String,
        val home: String,
        val office: String
)