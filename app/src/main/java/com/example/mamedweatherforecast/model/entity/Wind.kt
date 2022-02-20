package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class Wind(
    val speed : String? = null,
    val deg : String? = null,
    val gust : String? = null,
) {
}