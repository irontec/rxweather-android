package com.irontec.axier.rxweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by axier on 14/7/17.
 */

class Weather {

    @SerializedName("location")
    var location: Location? = null
    @SerializedName("current")
    var current: Current? = null
    @SerializedName("forecast")
    var forecast: Forecast? = null
}
