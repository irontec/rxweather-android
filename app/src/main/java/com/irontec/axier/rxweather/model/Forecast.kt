package com.irontec.axier.rxweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by axier on 14/7/17.
 */

class Forecast {

    @SerializedName("forecastday")
    var forecastdays: List<Forecastday>? = null
}
