package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class SystemWeather(
    val type : String? = null,
    val id : String? = null,
    val country : String? = null,
    val sunrise : String? = null,
    val sunset : String? = null,
)
