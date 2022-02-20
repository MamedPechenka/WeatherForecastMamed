package com.example.mamedweatherforecast.model.api

import com.example.mamedweatherforecast.model.entity.WeatherTown
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface WeatherTownApi {

    @GET("")
    fun getAllAsync() : Deferred<List<WeatherTown>>
}