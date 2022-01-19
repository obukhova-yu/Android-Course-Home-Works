package com.triare.myapplicationdrawer.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.triare.myapplicationdrawer.api.ApiConsts.BASE_URL
import com.triare.myapplicationdrawer.api.ApiConsts.MMI
import com.triare.p131_quake_alert_app.api.QuakeService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuakeRepository {

    val quakeResult = MutableLiveData<QuakeDto>()

    @JvmName("getQuakeResult1")
    fun getQuakeDTO() : MutableLiveData<QuakeDto> {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        val quakeService = retrofit.create(QuakeService::class.java)

        quakeService.getQuake(MMI).enqueue(object :
            Callback<QuakeDto> {

            override fun onResponse(call: Call<QuakeDto>, response: Response<QuakeDto>) {

                quakeResult.value = response.isSuccessful.let { response.body() }

                Log.d("RespCode", response.code().toString())

            }

            override fun onFailure(call: Call<QuakeDto>, t: Throwable) {
                Log.d("reqErr", t.message.toString())
                t.printStackTrace()
            }
        })
        return quakeResult
    }
}