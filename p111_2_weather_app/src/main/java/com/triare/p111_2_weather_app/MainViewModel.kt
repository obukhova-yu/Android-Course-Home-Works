package com.triare.p111_2_weather_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.triare.p111_2_weather_app.api.WeatherDTODaily
import com.triare.p111_2_weather_app.api.WeatherService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.triare.p111_2_weather_app.Consts.BASE_URL
import com.triare.p111_2_weather_app.api.WeatherDTOHourly

class MainViewModel:ViewModel() {

    private val _weatherDTODailyResult = MutableLiveData<WeatherDTODaily>()
    val weatherDTODailyResult:LiveData<WeatherDTODaily> = _weatherDTODailyResult

    private val _weatherDTOHourlyResult = MutableLiveData<WeatherDTOHourly>()
    val weatherDTOHourlyResult:LiveData<WeatherDTOHourly> = _weatherDTOHourlyResult

    init {
        getWeatherDaily()
        getWeatherHourly()
    }

    private fun getWeatherDaily(){
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        val weatherServiceDaily = retrofit.create(WeatherService ::class.java)
        weatherServiceDaily.getDaily(32.05f,49.44f, "metric").enqueue(object : Callback<WeatherDTODaily> {

            override fun onResponse(call: Call<WeatherDTODaily>, response: Response<WeatherDTODaily>){
                _weatherDTODailyResult.value = response.body()
            }
            override fun onFailure(call: Call<WeatherDTODaily>, t: Throwable) {
                Log.d("reqErr", t.message.toString())
                t.printStackTrace()
            }
        })
    }
    private fun getWeatherHourly(){

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory((GsonConverterFactory.create()))
            .build()

        val weatherServiceHourly = retrofit.create(WeatherService :: class.java)
        weatherServiceHourly.getHourly(32.05f,49.44f,48, "metric").enqueue(object : Callback<WeatherDTOHourly>{

            override fun onResponse(
                call: Call<WeatherDTOHourly>,
                response: Response<WeatherDTOHourly>
            ) {
                _weatherDTOHourlyResult.value = response.body()
            }

            override fun onFailure(call: Call<WeatherDTOHourly>, t: Throwable) {
                Log.d("reqErr", t.message.toString())
                t.printStackTrace()
            }
        })
    }
}