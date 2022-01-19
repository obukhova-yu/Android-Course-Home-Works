package com.triare.myapplicationdrawer.api

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class QuakeDto(

    @SerializedName("features")
    val features: List<Feature>,

    @SerializedName("type")
    val type: String
)

data class Feature(

    @SerializedName("geometry")
    val geometry: Geometry,

    @SerializedName("type")
    val type: String,

    @SerializedName("properties")
    val properties: Properties
) : Serializable

data class Properties(

    @SerializedName("depth")
    val depth: Double,

    @SerializedName("mmi")
    val mmi: Int,

    @SerializedName("locality")
    val locality: String,

    @SerializedName("magnitude")
    val magnitude: Double,

    @SerializedName("time")
    val time: String,

    @SerializedName("publicID")
    val publicID: String,

    @SerializedName("quality")
    val quality: String
)

data class Geometry(

    @SerializedName("coordinates")
    val coordinates: List<Double>,

    @SerializedName("type")
    val type: String
)