package com.example.mamedweatherforecast.model.entity

import androidx.room.*
import com.example.mamedweatherforecast.utils.GsonUtils
import com.google.gson.annotations.SerializedName
import java.util.*

@TypeConverters(WeatherTown.Converter::class)
@Entity(tableName = "infoTown")

data class WeatherTown @JvmOverloads constructor (
    @PrimaryKey
    @SerializedName("id")
    val id : String,

    @SerializedName("coordination")
    val coordination : MutableList<Coordination>,

    @SerializedName("weather")
    val weather : MutableList<Weather>,

    @SerializedName("base")
    val base : String,

    @SerializedName("main")
    val main : MutableList<Main>,

    @SerializedName("visibility")
    val visibility : String,

    @SerializedName("wind")
    val wind : MutableList<Wind>,

    @SerializedName("clouds")
    val clouds : MutableList<Clouds>,

    @SerializedName("dt")
    val dt : String?,

    @SerializedName("systemWeather")
    val systemWeather: MutableList<SystemWeather>,

    @SerializedName("timeZone")
    val timeZone: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("cod")
    val cod : String?
) {
    object Converter {
        @TypeConverter
        @JvmStatic
        fun toJsonCoordination(coordination : List<Coordination>?) : String {
            return GsonUtils.writeValue(coordination.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonCoordination(json : String) : List<Coordination>? {
            return GsonUtils.readValues(json, Coordination::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonWeather(weather : List<Weather>?) : String {
            return GsonUtils.writeValue(weather.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonWeather(json : String) : List<Weather>? {
            return GsonUtils.readValues(json, Weather::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonMain(main : List<Main>?) : String {
            return GsonUtils.writeValue(main.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonMain(json : String) : List<Main>? {
            return GsonUtils.readValues(json, Main::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonWind(wind : List<Wind>?) : String {
            return GsonUtils.writeValue(wind.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonWind(json : String) : List<Wind>? {
            return GsonUtils.readValues(json, Wind::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonClouds(clouds : List<Clouds>?) : String {
            return GsonUtils.writeValue(clouds.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonClouds(json : String) : List<Clouds>? {
            return GsonUtils.readValues(json, Clouds::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonSystemWeather(systemWeather : List<SystemWeather>?) : String {
            return GsonUtils.writeValue(systemWeather.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonSystemWeather(json : String) : List<SystemWeather>? {
            return GsonUtils.readValues(json, SystemWeather::class.java)
        }
    }
}