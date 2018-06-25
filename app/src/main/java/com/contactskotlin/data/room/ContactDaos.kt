package com.contactskotlin.data.room

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
interface ContactsDao {

    @Insert
    fun insertAll(cities: List<ContactEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: ContactEntity)

    @Query(RoomConfig.SELECT_CONTACTS)
    fun getAllCities(): Flowable<List<ContactEntity>>
}