package com.triare.p111_2_weather_app.api

import com.google.gson.annotations.SerializedName

data class WeatherDTODaily(
    @SerializedName("data") val data : List<Data>,
    @SerializedName("count") val count : Int
)

data class Data(

    @SerializedName("rh") val rh : Double,
    @SerializedName("pod") val pod : String,
    @SerializedName("lon") val lon : Double,
    @SerializedName("pres") val pres : Int,
    @SerializedName("timezone") val timezone : String,
    @SerializedName("ob_time") val ob_time : String,
    @SerializedName("country_code") val country_code : String,
    @SerializedName("clouds") val clouds : Int,
    @SerializedName("ts") val ts : Int,
    @SerializedName("solar_rad") val solar_rad : Int,
    @SerializedName("state_code") val state_code : Int,
    @SerializedName("city_name") val city_name : String,
    @SerializedName("wind_spd") val wind_spd : Double,
    @SerializedName("wind_cdir_full") val wind_cdir_full : String,
    @SerializedName("wind_cdir") val wind_cdir : String,
    @SerializedName("slp") val slp : Int,
    @SerializedName("vis") val vis : Int,
    @SerializedName("h_angle") val h_angle : String,
    @SerializedName("sunset") val sunset : String,
    @SerializedName("dni") val dni : Int,
    @SerializedName("dewpt") val dewpt : Double,
    @SerializedName("snow") val snow : Int,
    @SerializedName("uv") val uv : Int,
    @SerializedName("precip") val precip : Int,
    @SerializedName("wind_dir") val wind_dir : Int,
    @SerializedName("sunrise") val sunrise : String,
    @SerializedName("ghi") val ghi : Int,
    @SerializedName("dhi") val dhi : Int,
    @SerializedName("aqi") val aqi : Int,
    @SerializedName("lat") val lat : Double,
    @SerializedName("weather") val weather : Weather,
    @SerializedName("datetime") val datetime : String,
    @SerializedName("temp") val temp : Double,
    @SerializedName("station") val station : String,
    @SerializedName("elev_angle") val elev_angle : Double,
    @SerializedName("app_temp") val app_temp : Double
)

data class Weather(
    @SerializedName("icon") val icon : String,
    @SerializedName("code") val code : Int,
    @SerializedName("description") val description : String
)