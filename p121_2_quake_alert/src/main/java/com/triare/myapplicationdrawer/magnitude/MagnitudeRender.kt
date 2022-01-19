package com.triare.myapplicationdrawer.magnitude

object MagnitudeRender{

    fun initMagnitude(magnitude: Double): Magnitude {
        return when (magnitude) {
            in 1.0..1.99 -> Magnitude.BARELY_NOTICIABLE
            in 2.0..2.99 -> Magnitude.WEAK
            in 3.0..4.99 -> Magnitude.AVERAGE
            in 5.0..5.99 -> Magnitude.STRONG
            else -> Magnitude.VERY_STRONG
        }
    }
}