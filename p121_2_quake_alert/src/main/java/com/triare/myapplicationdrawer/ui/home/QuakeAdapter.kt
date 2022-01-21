package com.triare.myapplicationdrawer.ui.home

import android.annotation.SuppressLint
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.triare.myapplicationdrawer.R
import com.triare.myapplicationdrawer.api.Feature
import com.triare.myapplicationdrawer.magnitude.MagnitudeRender
import com.triare.myapplicationdrawer.utils.TimeUtils
import java.util.*

class QuakeAdapter(
    var features: List<Feature>,
    private val listener: OnItemClickListener
)
    : RecyclerView.Adapter<QuakeAdapter.QuakeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuakeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        return QuakeViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: QuakeViewHolder, position: Int) {
        holder.bind(features[position])
    }

    override fun getItemCount() = features.size

    inner class QuakeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val whenQuake = itemView.findViewById<TextView>(R.id.when_q_i)
        private val whereQuake = itemView.findViewById<TextView>(R.id.where_i)
        private val powerQuake = itemView.findViewById<TextView>(R.id.power_score_i)
        private val intenseQuake = itemView.findViewById<TextView>(R.id.quake_intensity_i)

        init {
            itemView.setOnClickListener(this)
        }

        @SuppressLint("ResourceType")
        fun bind(data: Feature) {
            val intensityData = MagnitudeRender.initMagnitude(features[0].properties.magnitude)
          val time = features[0].properties.time

           val formatTime = time.let { TimeUtils.parseTime(it) }

          val niceDateStr: String = formatTime?.let {
                DateUtils.getRelativeTimeSpanString(
                   it,
                   Calendar.getInstance().timeInMillis,
                    DateUtils.DAY_IN_MILLIS
                )
           } as String
            whenQuake.text = niceDateStr

            whenQuake.text = niceDateStr
            whereQuake.text = data.properties.locality
            intenseQuake.setText(intensityData.title)
            intenseQuake.setBackgroundResource(intensityData.color)
            powerQuake.text = String.format("%.2f", features[0].properties.magnitude)

        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, data = features[position])
                Log.d("TEST", features[position].toString())
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, data: Feature)
    }

}