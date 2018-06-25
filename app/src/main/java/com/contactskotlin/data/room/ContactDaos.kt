package com.contactskotlin.data.room

import android.arch.persistence.room.*
import io.reactivex.Flowable

@Dao
interface WeatherCitiesDao {

    @Insert
    fun insertAll(cities: List<ContactEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: ContactEntity)

    @Query(RoomConfig.SELECT_CONTACTS)
    fun getAllCities(): Flowable<List<ContactEntity>>
}