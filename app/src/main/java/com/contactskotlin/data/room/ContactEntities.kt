package com.contactskotlin.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomConfig.TABLE_CONTACTS)
data class ContactEntity(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        var contactName: String
)