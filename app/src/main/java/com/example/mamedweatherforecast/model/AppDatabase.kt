package com.example.mamedweatherforecast.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mamedweatherforecast.model.dao.WeatherTownDao
import com.example.mamedweatherforecast.model.entity.WeatherTown

@Database(entities = [WeatherTown::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val weatherTownDao : WeatherTownDao
}