package com.example.mamedweatherforecast.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiRequest {

    val api = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/weather?q=")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}