package com.contactskotlin.data.dto

import org.parceler.Parcel
import org.parceler.ParcelConstructor

data class ContactsDTO(val contacts: List<ContactDTO>?) {
}

class ContactDTO {
    var cityName: String? = null
    val name: String? = null
    val email: String? = null
    val address: String? = null
    val gender: String? = null
    val phone: PhoneDTO? = null
}

class PhoneDTO {
    var mobile: String? = null
    var home: String? = null
    var office: String? = null
}

class Geoname {

    var lat: Double = 0.toDouble()
    var lng: Double = 0.toDouble()
    var geonameId: Long = 0
    var countrycode: String? = null
    var name: String? = null
    var fclName: String? = null
    var toponymName: String? = null
    var fcodeName: String? = null
    var wikipedia: String? = null
    var fcl: String? = null
    var population: Long = 0
    var fcode: String? = null
}