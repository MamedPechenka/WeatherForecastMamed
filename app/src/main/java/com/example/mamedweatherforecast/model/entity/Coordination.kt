package com.example.mamedweatherforecast.model.entity

import androidx.room.Entity

@Entity
data class Coordination(
    val longitude : String? = null,
    val latitude : String? = null
) {
}