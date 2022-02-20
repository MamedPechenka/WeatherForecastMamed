package com.example.mamedweatherforecast.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mamedweatherforecast.model.entity.WeatherTown

interface WeatherTownDao {

    @Query("SELECT * FROM infoTown")
    fun findAll() : LiveData<List<WeatherTown>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(infoTown : List<WeatherTown>)
}