package com.triare.p111_2_weather_app.api

import com.google.gson.annotations.SerializedName


data class WeatherDTOHourly (

    @field:SerializedName("country_code")
    val countryCode: String,

    @field:SerializedName("city_name")
    val cityName: String,

    @field:SerializedName("data")
    val data: List<DataHourly>,

    @field:SerializedName("timezone")
    val timezone: String,

    @field:SerializedName("lon")
    val lon: Double,

    @field:SerializedName("state_code")
    val stateCode: String,

    @field:SerializedName("lat")
    val lat: Double
)

data class DataHourly(

    @field:SerializedName("sunrise")
    val sunrise: String,

    @field:SerializedName("pod")
    val pod: String,

    @field:SerializedName("pres")
    val pres: Double,

    @field:SerializedName("timezone")
    val timezone: String,

    @field:SerializedName("ob_time")
    val obTime: String,

    @field:SerializedName("wind_cdir")
    val windCdir: String,

    @field:SerializedName("lon")
    val lon: Double,

    @field:SerializedName("clouds")
    val clouds: Int,

    @field:SerializedName("wind_spd")
    val windSpd: Double,

    @field:SerializedName("city_name")
    val cityName: String,

    @field:SerializedName("h_angle")
    val hAngle: Int,

    @field:SerializedName("datetime")
    val datetime: String,

    @field:SerializedName("precip")
    val precip: Double,

    @field:SerializedName("weather")
    val weatherHourly: WeatherHourly,

    @field:SerializedName("station")
    val station: String,

    @field:SerializedName("elev_angle")
    val elevAngle: Double,

    @field:SerializedName("dni")
    val dni: Double,

    @field:SerializedName("lat")
    val lat: Double,

    @field:SerializedName("vis")
    val vis: Double,

    @field:SerializedName("uv")
    val uv: Double,

    @field:SerializedName("temp")
    val temp: Double,

    @field:SerializedName("dhi")
    val dhi: Double,

    @field:SerializedName("ghi")
    val ghi: Double,

    @field:SerializedName("app_temp")
    val appTemp: Double,

    @field:SerializedName("dewpt")
    val dewpt: Double,

    @field:SerializedName("wind_dir")
    val windDir: Int,

    @field:SerializedName("solar_rad")
    val solarRad: Double,

    @field:SerializedName("country_code")
    val countryCode: String,

    @field:SerializedName("rh")
    val rh: Double,

    @field:SerializedName("slp")
    val slp: Double,

    @field:SerializedName("snow")
    val snow: Int,

    @field:SerializedName("sunset")
    val sunset: String,

    @field:SerializedName("aqi")
    val aqi: Int,

    @field:SerializedName("state_code")
    val stateCode: String,

    @field:SerializedName("wind_cdir_full")
    val windCdirFull: String,

    @field:SerializedName("ts")
    val ts: Int
)

data class WeatherHourly(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("icon")
    val icon: String,

    @field:SerializedName("description")
    val description: String
)