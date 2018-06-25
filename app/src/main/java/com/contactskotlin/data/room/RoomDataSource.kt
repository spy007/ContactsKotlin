package com.contactskotlin.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.contactskotlin.data.dto.ContactDTO


@Database(entities = arrayOf(ContactEntity::class), version = 1)
abstract class RoomDataSource : RoomDatabase() {

    abstract fun contactDao(): ContactDTO

    companion object {

        @Volatile private var INSTANCE: RoomDataSource? = null

        fun getInstance(context: Context): RoomDataSource =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        RoomDataSource::class.java, RoomConfig.DATABASE_CONTACTS)
                        .build()
    }
}