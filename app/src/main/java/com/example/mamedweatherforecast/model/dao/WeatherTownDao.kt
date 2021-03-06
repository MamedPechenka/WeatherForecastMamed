package com.example.mamedweatherforecast.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mamedweatherforecast.model.entity.WeatherTown

@Dao
interface WeatherTownDao {

    @Query("SELECT * FROM infoTown")
    fun findAll() : LiveData<WeatherTown>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(infoTown: WeatherTown)
}