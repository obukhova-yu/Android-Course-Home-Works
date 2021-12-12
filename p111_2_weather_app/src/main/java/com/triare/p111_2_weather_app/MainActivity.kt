package com.triare.p111_2_weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.triare.p111_2_weather_app.api.WeatherDTODaily

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private var bigTemp:TextView?=null
    private var dateAndTime:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeUpdates()
        initUI()
    }

    private fun observeUpdates(){
        viewModel.weatherDTODailyResult.observe(this, Observer {
            renderWeatherDaily(it)
        })
    }

    private fun initUI(){

        bigTemp = findViewById(R.id.temp_big)
        dateAndTime = findViewById(R.id.date)
    }

    private fun renderWeatherDaily(weatherDTODaily : WeatherDTODaily){
        bigTemp?.text = weatherDTODaily.data[0].temp.toString()
        dateAndTime?.text = weatherDTODaily.data[0].ob_time
    }
}