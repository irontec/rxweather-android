package com.irontec.axier.rxweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by axier on 14/7/17.
 */

class Current {

    @SerializedName("last_updated_epoch")
    var lastUpdatedEpoch: Long? = null
    @SerializedName("temp_c")
    var temperature: Float? = null
    @SerializedName("condition")
    var condition: Condition? = null
    @SerializedName("humidity")
    var humidity: Int? = null
    @SerializedName("feelslike_c")
    var feelslike: Float? = null

    val temperatureDisplay: String
        get() = String.format("Temperatura actual: %sCº (sensación de %sCº)", temperature, feelslike)
}
