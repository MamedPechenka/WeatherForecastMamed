package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class Weather(
    val id : String?,
    val main : String?,
    val description : String?,
    val icon : String?
) {
}