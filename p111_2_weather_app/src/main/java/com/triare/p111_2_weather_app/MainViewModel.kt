package com.triare.p111_2_weather_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.p111_2_weather_app.api.WeatherDTODaily
import com.triare.p111_2_weather_app.api.WeatherServiceDaily
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.triare.p111_2_weather_app.Consts.BASE_URL

class MainViewModel:ViewModel() {

    private val _weatherDTODailyResult = MutableLiveData<WeatherDTODaily>()
    val weatherDTODailyResult:LiveData<WeatherDTODaily> = _weatherDTODailyResult

    init {
        getWeatherDaily()
    }

    private fun getWeatherDaily(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        val weatherServiceDaily = retrofit.create(WeatherServiceDaily ::class.java)
        weatherServiceDaily.getDaily(32.05f,49.43f).enqueue(object : Callback<WeatherDTODaily> {

            override fun onResponse(call: Call<WeatherDTODaily>, response: Response<WeatherDTODaily>){
                _weatherDTODailyResult.value = response.body()

            }

            override fun onFailure(call: Call<WeatherDTODaily>, t: Throwable) {
                Log.d("reqErr", t.message.toString())
                t.printStackTrace()

            }
        })
    }
}