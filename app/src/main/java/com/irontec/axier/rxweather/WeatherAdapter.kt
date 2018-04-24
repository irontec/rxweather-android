package com.irontec.axier.rxweather

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.irontec.axier.rxweather.databinding.RowWeatherBinding
import com.irontec.axier.rxweather.model.Forecastday

/**
 * Created by axier on 8/3/17.
 */

class WeatherAdapter(private val mData: List<Forecastday>) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder internal constructor(val binding: RowWeatherBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.binding.forecast = mData[i]
        viewHolder.binding.day = mData[i].day
        viewHolder.binding.condition = mData[i].day!!.condition
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val layoutInflater: LayoutInflater? = LayoutInflater.from(viewGroup.context)
        val binding: RowWeatherBinding = DataBindingUtil.inflate<RowWeatherBinding>(
                layoutInflater!!, R.layout.row_weather, viewGroup, false)
        return ViewHolder(binding)
    }
}
