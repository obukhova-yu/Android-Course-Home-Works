package com.triare.myapplicationdrawer.magnitude

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import com.triare.myapplicationdrawer.R

enum class Magnitude(
    @StringRes
    val title:Int,
    @ColorRes
    val color: Int
) {
    BARELY_NOTICIABLE(R.string.bar_not_title, R.color.light_green),
    WEAK(R.string.average_title, R.color.sea_green),
    AVERAGE(R.string.average_title, R.color.yellow),
    STRONG(R.string.strong_title, R.color.orange),
    VERY_STRONG(R.string.very_strong_title, R.color.red)
}