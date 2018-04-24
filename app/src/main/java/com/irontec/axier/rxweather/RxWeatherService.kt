package com.irontec.axier.rxweather

import com.irontec.axier.rxweather.model.Weather

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by axier on 7/4/15.
 */
interface RxWeatherService {

    @GET("forecast.json")
    fun getWeather(
            @Query("key") key: String,
            @Query("q") city: String,
            @Query("days") days: String
    ): Observable<Weather>

}
