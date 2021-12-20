package com.triare.p111_2_weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.triare.p111_2_weather_app.api.DataHourly
import com.triare.p111_2_weather_app.api.WeatherDTODaily
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    private var weatherAdaptor:WeatherAdaptor? = null

    private var bigTemp:TextView?=null
    private var dateAndTime:TextView?=null
    private var bigWeatherIcon:ImageView?=null
    private var realFeel:TextView?=null
    private var wind:TextView?=null
    private var cloudy:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
        observeUpdates()
    }

    private fun initUI(){
        bigTemp = findViewById(R.id.temp_big)
        dateAndTime = findViewById(R.id.date)
        bigWeatherIcon = findViewById(R.id.ic_weather)
        realFeel= findViewById(R.id.real_feel)
        wind = findViewById(R.id.wind)
        cloudy = findViewById(R.id.cloudy)

        initRecyclerView()
    }


    private fun initRecyclerView(){

        val recyclerViewHourlyWeather = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerViewHourlyWeather.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        weatherAdaptor = WeatherAdaptor()
        recyclerViewHourlyWeather.adapter = weatherAdaptor }

    private fun observeUpdates(){

        viewModel.weatherDTOHourlyResult.observe( this, Observer {
            weatherAdaptor?.items = it.data
        })

        viewModel.weatherDTODailyResult.observe(this, Observer{
            if (it !=null) {
                renderWeatherDaily(it)
            }
            else{
                Toast.makeText(this,"no information",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun renderWeatherDaily(weatherDTODaily : WeatherDTODaily){

        bigTemp?.text = weatherDTODaily.data[0].temp.roundToInt().toString()
        dateAndTime?.text = weatherDTODaily.data[0].ob_time
        bigWeatherIcon?.setImageResource(getWeatherIcon(weatherDTODaily))
        cloudy?.text = weatherDTODaily.data[0].weather.description
        realFeel?.setText(getRealFeel(weatherDTODaily))
        wind?.setText(getWind(weatherDTODaily))
    }
   private fun getWeatherIcon(weatherDTODaily: WeatherDTODaily): Int {

        val isDay = weatherDTODaily.data[0].pod == "d"

        if (isDay) {
            return if (weatherDTODaily.data[0].clouds <= 10 && weatherDTODaily.data[0].rh <= 0){
                R.drawable.ic_sunny
            } else if (weatherDTODaily.data[0].clouds > 10 && weatherDTODaily.data[0].rh <= 10){
                R.drawable.ic_partly_cloudy
            } else if (weatherDTODaily.data[0].clouds<= 50 && weatherDTODaily.data[0].rh > 10) {
                R.drawable.ic_rain_with_clearing
            }else R.drawable.ic_rain
        }
        return R.drawable.ic_night_icon
    }
   private fun getRealFeel(weatherDTODaily: WeatherDTODaily): String {
        return "feel like ${weatherDTODaily.data[0].app_temp.roundToInt()}C°"
    }

   private fun getWind(weatherDTODaily: WeatherDTODaily): String {
        return "Wind ${weatherDTODaily.data[0].wind_spd.roundToInt()} km/h, ${weatherDTODaily.data[0].wind_cdir_full}"
    }
}