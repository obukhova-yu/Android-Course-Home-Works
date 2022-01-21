package com.triare.myapplicationdrawer.ui.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.triare.myapplicationdrawer.R
import com.triare.myapplicationdrawer.api.Feature
import com.triare.myapplicationdrawer.magnitude.MagnitudeRender.initMagnitude
import com.triare.myapplicationdrawer.utils.TimeUtils
import java.util.*


class DetailsFragment : Fragment() {

    private var dataDetailsQuake: Feature? = null

    private var whenQuake: TextView? = null
    private var depthQuake: TextView? = null
    private var powerQuake: TextView? = null
    private var intenseQuake: TextView? = null

    private var hide: ImageView? = null
    private var wait: ImageView? = null
    private var firstRec: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initArgs()
    }

    private fun initArgs() {
        arguments?.let {
            if (it.containsKey(KEY_DATA_ARGS)) {
                dataDetailsQuake = arguments?.getInt(KEY_DATA_ARGS) as Feature?
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()

    }

    private fun initUi() {
        initViews()

        val magnitudeRender =
            dataDetailsQuake?.properties?.let { initMagnitude(it.magnitude) }

        whenQuake?.text = getTime()
        depthQuake?.text = getDepthQuake()
        intenseQuake?.setText(magnitudeRender!!.title)
        intenseQuake?.setBackgroundResource(magnitudeRender!!.color)

        powerQuake?.text = String.format("%.2f", dataDetailsQuake?.properties!!.magnitude)
    }

    @SuppressLint("StringFormatInvalid")
    private fun getDepthQuake(): String {
        return getString(
            R.string.distance_description,
            dataDetailsQuake?.properties?.depth.toString()
        )
    }

    @SuppressLint("ResourceType")
    private fun initViews() {

        whenQuake = view?.findViewById(R.id.when_q)
        depthQuake = view?.findViewById(R.id.where)
        intenseQuake = view?.findViewById(R.id.quake_intensity)
        powerQuake = view?.findViewById(R.id.power_score)
        hide = view?.findViewById(R.id.image_hide)
        wait = view?.findViewById(R.id.image_wait)
        firstRec = view?.findViewById((R.id.text_first_rec))
        imageTrue()
    }

    private fun getTime(): String {
        val time = dataDetailsQuake?.properties?.time
        val formatTime = time?.let { TimeUtils.parseTime(it) }

        val niceDateStr: String = formatTime?.let {
            DateUtils.getRelativeTimeSpanString(
                it,
                Calendar.getInstance().timeInMillis,
                DateUtils.DAY_IN_MILLIS
            )
        } as String
        return niceDateStr
    }

    private fun imageTrue() {
        val intensityData = initMagnitude(dataDetailsQuake?.properties!!.magnitude)

        if (intensityData.title != R.string.strong_title ||
            intensityData.title != R.string.very_strong_title) {

            hide?.visibility = View.GONE
            wait?.visibility = View.GONE
            firstRec?.visibility = View.GONE
        }
    }


    companion object {
        private const val KEY_DATA_ARGS = "Feature"

        fun newInstance(dataDetailsFragment: Feature): DetailsFragment {
            val args = bundleOf(KEY_DATA_ARGS to dataDetailsFragment)

            val detailsFragment = DetailsFragment()
            detailsFragment.arguments = args

            return detailsFragment
        }

    }
}

