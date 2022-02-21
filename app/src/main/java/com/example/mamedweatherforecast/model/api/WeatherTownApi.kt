package com.example.mamedweatherforecast.model.api

import com.example.mamedweatherforecast.model.entity.WeatherTown
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherTownApi {

    @GET("/data/2.5/weather")
    fun getAllAsync(@Query("q") town : String = "Moscow",
                    @Query("appid") appid : String = "b02d9d8d78457598638588402117da1e") : Deferred<WeatherTown>
}