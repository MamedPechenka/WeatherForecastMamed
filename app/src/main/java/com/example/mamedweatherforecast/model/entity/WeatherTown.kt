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

    @SerializedName("coord")
    val coordination : Coordination,

    @SerializedName("weather")
    val weather : Weather,

    @SerializedName("base")
    val base : String,

    @SerializedName("main")
    val main : Main,

    @SerializedName("visibility")
    val visibility : String,

    @SerializedName("wind")
    val wind : Wind,

    @SerializedName("clouds")
    val clouds : Clouds,

    @SerializedName("dt")
    val dt : String,

    @SerializedName("sys")
    val systemWeather: SystemWeather,

    @SerializedName("timezone")
    val timeZone: String,

    @SerializedName("name")
    val name: String = "Moscow",

    @SerializedName("cod")
    val cod : String
) {
    object Converter {
        @TypeConverter
        @JvmStatic
        fun toJsonCoordination(coordination : Coordination) : String {
            return GsonUtils.writeValue(coordination.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonCoordination(json : String) : Coordination {
            return GsonUtils.readValue(json, Coordination::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonWeather(weather : Weather) : String {
            return GsonUtils.writeValue(weather.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonWeather(json : String) : Weather {
            return GsonUtils.readValue(json, Weather::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonMain(main : Main) : String {
            return GsonUtils.writeValue(main.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonMain(json : String) : Main {
            return GsonUtils.readValue(json, Main::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonWind(wind : Wind) : String {
            return GsonUtils.writeValue(wind.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonWind(json : String) : Wind {
            return GsonUtils.readValue(json, Wind::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonClouds(clouds : Clouds) : String {
            return GsonUtils.writeValue(clouds.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonClouds(json : String) : Clouds {
            return GsonUtils.readValue(json, Clouds::class.java)
        }


        @TypeConverter
        @JvmStatic
        fun toJsonSystemWeather(systemWeather : SystemWeather) : String {
            return GsonUtils.writeValue(systemWeather.toString())
        }

        @TypeConverter
        @JvmStatic
        fun fromJsonSystemWeather(json : String) : SystemWeather {
            return GsonUtils.readValue(json, SystemWeather::class.java)
        }
    }
}