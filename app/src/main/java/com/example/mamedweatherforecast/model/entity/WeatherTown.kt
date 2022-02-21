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
    val id : String,
    @SerializedName("coordination")
    val coordination : MutableList<Coordination>,
    @SerializedName("weather")
    val weather : MutableList<Weather>,
    @SerializedName("base")
    val base : String? = null,
    @SerializedName("main")
    val main : MutableList<Main>,
    @SerializedName("visibility")
    val visibility : String? = null,
    @SerializedName("wind")
    val wind : MutableList<Wind>,
    @SerializedName("clouds")
    val clouds : MutableList<Clouds>,
    @SerializedName("dt")
    val dt : String? = null,
    @SerializedName("systemWeather")
    val systemWeather: MutableList<SystemWeather>,
    @SerializedName("timeZone")
    val timeZone: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("cod")
    val cod : String? = null
) {
}