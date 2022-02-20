package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity


@Entity
data class Main(
    val temp : String? = null,
    val feels_like : String? = null,
    val temp_min : String? = null,
    val temp_max : String? = null,
    val pressure : String? = null,
    val humidity : String? = null,
    val sea_level : String? = null,
    val grnd_level : String? = null,
) {
}