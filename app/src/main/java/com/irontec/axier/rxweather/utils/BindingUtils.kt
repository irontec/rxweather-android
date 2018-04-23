package com.irontec.axier.rxweather.utils

import android.databinding.BindingAdapter
import android.widget.ImageView

import com.bumptech.glide.Glide

/**
 * Created by axier on 14/7/17.
 */

object BindingUtils {

    @JvmStatic @BindingAdapter("bind:imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

}
