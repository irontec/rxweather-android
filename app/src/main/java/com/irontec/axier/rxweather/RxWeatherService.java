package com.irontec.axier.rxweather;

import com.irontec.axier.rxweather.model.Weather;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by axier on 7/4/15.
 */
public interface RxWeatherService {

    @GET("forecast.json")
    Observable<Weather> getWeather(
            @Query("key") String key,
            @Query("q") String city
    );

}
