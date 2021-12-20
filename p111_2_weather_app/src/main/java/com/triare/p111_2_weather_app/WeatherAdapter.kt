package com.triare.p111_2_weather_app


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.p111_2_weather_app.api.DataHourly



class WeatherAdaptor: RecyclerView.Adapter<WeatherAdaptor.HourlyWeatherViewHolder>() {
    var items: List<DataHourly> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hourly_weather, parent, false)
        return HourlyWeatherViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HourlyWeatherViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount() = items.size

    inner class HourlyWeatherViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val littleIcon = itemView.findViewById<ImageView>(R.id.little_icon)
        private val littleTemp = itemView.findViewById<TextView>(R.id.temp)
        private val littleTime = itemView.findViewById<TextView>(R.id.time)

        fun bind(dataHourly: DataHourly) {

            littleTemp.text = dataHourly.temp.toString()
            littleTime.text = dataHourly.datetime
            littleIcon.setImageResource(R.drawable.ic_sunny)

        }
    }
}