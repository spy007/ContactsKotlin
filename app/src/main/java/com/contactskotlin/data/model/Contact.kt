package com.contactskotlin.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.contactskotlin.data.room.RoomConfig

@Entity(tableName = RoomConfig.TABLE_CONTACTS)
data class Contact(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        val cityName: String,
        val name: String,
        val email: String,
        val address: String,
        val gender: String,
        val phone: Phone
)