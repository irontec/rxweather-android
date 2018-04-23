package com.irontec.axier.rxweather.model

import com.google.gson.annotations.SerializedName

/**
 * Created by axier on 14/7/17.
 */

class Location {

    @SerializedName("name")
    var name: String? = null
    @SerializedName("region")
    var region: String? = null

}
