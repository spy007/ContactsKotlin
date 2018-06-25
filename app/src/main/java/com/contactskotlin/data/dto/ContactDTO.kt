package com.contactskotlin.data.dto

import com.contactskotlin.data.model.Phone
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
data class ContactDTO @ParcelConstructor constructor(
        val cityName: String,
        val name: String,
        val email: String,
        val address: String,
        val gender: String,
        val phone: Phone
)

@Parcel(Parcel.Serialization.BEAN)
data class PhoneDTO @ParcelConstructor constructor(
        val mobile: String,
        val home: String,
        val office: String
)