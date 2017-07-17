package com.irontec.axier.rxweather.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by axier on 14/7/17.
 */

public class Forecast {

    @SerializedName("forecastday")
    private List<Forecastday> forecastdays;

    public Forecast() {
    }

    public List<Forecastday> getForecastdays() {
        return forecastdays;
    }

    public void setForecastdays(List<Forecastday> forecastdays) {
        this.forecastdays = forecastdays;
    }
}
