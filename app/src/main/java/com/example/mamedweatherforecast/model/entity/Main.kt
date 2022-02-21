package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity


@Entity
data class Main(
    val temp : String?,
    val feels_like : String?,
    val temp_min : String?,
    val temp_max : String?,
    val pressure : String?,
    val humidity : String?,
    val sea_level : String?,
    val grnd_level : String?
) {
}