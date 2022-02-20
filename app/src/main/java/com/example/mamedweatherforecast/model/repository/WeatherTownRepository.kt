package com.example.mamedweatherforecast.model.repository

import com.example.mamedweatherforecast.model.api.WeatherTownApi
import com.example.mamedweatherforecast.model.dao.WeatherTownDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherTownRepository(private val weatherTownApi : WeatherTownApi, private val weatherTownDao: WeatherTownDao) {

    val data = weatherTownDao.findAll()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val weatherTown = weatherTownApi.getAllAsync().await()
            weatherTownDao.add(weatherTown)
        }
    }
}