package com.example.mamedweatherforecast.model.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import java.util.*

@Entity(tableName = "infoTown")
data class WeatherTown(
    @PrimaryKey
    @SerializedName("id")
    val id : String? = null,
    @SerializedName("coordination")
    val coordination : MutableList<Coordination>? = null,
    @SerializedName("weather")
    val weather : MutableList<Weather>? = null,
    @SerializedName("base")
    val base : String? = null,
    @SerializedName("main")
    val main : MutableList<Main>? = null,
    @SerializedName("visibility")
    val visibility : String? = null,
    @SerializedName("wind")
    val wind : MutableList<Wind>? = null,
    @SerializedName("clouds")
    val clouds : MutableList<Clouds>? = null,
    @SerializedName("dt")
    val dt : String? = null,
    @SerializedName("systemWeather")
    val systemWeather: MutableList<SystemWeather>? = null,
    @SerializedName("timeZone")
    val timeZone: String? = null,
    @SerializedName("cod")
    val cod : String? = null
) {
}