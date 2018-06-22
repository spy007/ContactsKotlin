package com.contactskotlin.data.room

class RoomConfig {
    companion object {

        const val DATABASE_CONTACTS = "contacts.db"
        const val TABLE_CONTACTS= "contacts"

        private const val SELECT_FROM = "SELECT * FROM "

        const val SELECT_CONTACTS = SELECT_FROM + TABLE_CONTACTS
    }
}