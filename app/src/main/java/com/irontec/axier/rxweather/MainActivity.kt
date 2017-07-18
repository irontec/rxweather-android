package com.irontec.axier.rxweather

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log

import com.irontec.axier.rxweather.databinding.ActivityMainBinding
import com.irontec.axier.rxweather.model.Weather

import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        doGetBilbaoWeather()
    }

    private fun doGetBilbaoWeather() {
        ServiceGenerator.createService<RxWeatherService>(RxWeatherService::class.java)
                .getWeather(BuildConfig.APIXU_KEY, "Bilbao")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ weather ->
                    binding!!.current = weather.current
                    binding!!.location = weather.location
                    initListView(weather)
                }, { throwable -> throwable.printStackTrace() }) { Log.d(TAG, "Completed") }
    }

    private fun initListView(weather: Weather) {
        val list = binding!!.list
        list.layoutManager = LinearLayoutManager(applicationContext)
        val adapter = WeatherAdapter(
                weather.forecast!!.forecastdays!![0].hours!!)
        list.adapter = adapter
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}