package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class Coordination(
    val longitude : String?,
    val latitude : String?
) {
}