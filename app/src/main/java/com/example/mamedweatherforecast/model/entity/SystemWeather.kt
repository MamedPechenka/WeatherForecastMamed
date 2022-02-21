package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class SystemWeather(
    val type : String?,
    val id : String?,
    val country : String?,
    val sunrise : String?,
    val sunset : String?
)
