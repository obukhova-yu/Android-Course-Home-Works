package com.triare.p111_2_weather_app.api

import com.triare.p111_2_weather_app.Consts.KEY_API
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherServiceDaily {

        @Headers(KEY_API)

        @GET("current")

        fun getDaily(
            @Query("lat") lat:Float,
            @Query("lon") lon:Float

        ): Call<WeatherDTODaily>
    }
