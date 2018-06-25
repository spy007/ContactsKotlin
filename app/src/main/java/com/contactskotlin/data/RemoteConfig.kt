package com.contactskotlin.data


class RemoteConfig {
    companion object {
        const val BASE_API_LAYER = "https://api.androidhive.info/"
        const val CONTACTS = "contacts"
        const val BASE_URL = BASE_API_LAYER + CONTACTS + "/"
    }
}