package com.irontec.axier.rxweather.model

import com.google.gson.annotations.SerializedName

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by axier on 14/7/17.
 */

class Forecastday {

    @SerializedName("day")
    var day: Day? = null
    @SerializedName("hour")
    var hours: List<Hour>? = null

    inner class Day {

        @SerializedName("maxtemp_c")
        var maxTemp: Float? = null
        @SerializedName("mintemp_c")
        var minTemp: Float? = null
        @SerializedName("humidity")
        var humidity: Int? = null
        @SerializedName("condition")
        var condition: Condition? = null
    }

    inner class Hour {

        @SerializedName("time_epoch")
        var timeEpoch: Long? = null
        @SerializedName("temp_c")
        var temperature: Float? = null
        @SerializedName("condition")
        var condition: Condition? = null

        val epochAsDate: String
            get() {
                val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
                return sdf.format(Date(timeEpoch!! * 1000))
            }

        val temperatureDisplay: String
            get() = String.format("%sCº", temperature)
    }

}
