package com.triare.p131_quake_alert_app.api

import com.triare.myapplicationdrawer.api.QuakeDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuakeService {

    @GET("quake")

    fun getQuake(
        @Query("MMI") MMI : Int

    ): Call<QuakeDto>
}