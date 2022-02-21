package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class Wind(
    val speed : String?,
    val deg : String?,
    val gust : String?
) {
}