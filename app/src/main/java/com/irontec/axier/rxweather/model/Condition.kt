package com.irontec.axier.rxweather.model

import android.databinding.BaseObservable
import android.databinding.Bindable

import com.google.gson.annotations.SerializedName
import com.irontec.axier.rxweather.BR

/**
 * Created by axier on 14/7/17.
 */

class Condition : BaseObservable() {

    @SerializedName("text")
    var text: String? = null
    @SerializedName("icon")
    private var imageUrl: String? = null
    @SerializedName("code")
    var code: Int? = null

    @Bindable
    fun getImageUrl(): String {
        return String.format("https:%s", imageUrl)
    }

    fun setImageUrl(imageUrl: String): Condition {
        this.imageUrl = imageUrl
        notifyPropertyChanged(BR.imageUrl)
        return this
    }

}
