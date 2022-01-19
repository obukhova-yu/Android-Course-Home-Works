package com.triare.myapplicationdrawer.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

object TimeUtils {

    const val DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"

    @SuppressLint("SimpleDateFormat")
    fun parseTime(time:String) : Long? {
        val inputFormat = SimpleDateFormat(DATE_TIME_PATTERN)
        return inputFormat.parse(time)?.time
    }
}