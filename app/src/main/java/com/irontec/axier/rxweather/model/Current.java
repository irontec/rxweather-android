package com.irontec.axier.rxweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by axier on 14/7/17.
 */

public class Current {

    @SerializedName("last_updated_epoch")
    private Long lastUpdatedEpoch;
    @SerializedName("temp_c")
    private Float temperature;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("humidity")
    private Integer humidity;
    @SerializedName("feelslike_c")
    private Float feelslike;

    public Current() {
    }

    public Long getLastUpdatedEpoch() {
        return lastUpdatedEpoch;
    }

    public void setLastUpdatedEpoch(Long lastUpdatedEpoch) {
        this.lastUpdatedEpoch = lastUpdatedEpoch;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Float getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(Float feelslike) {
        this.feelslike = feelslike;
    }

    public String getTemperatureDisplay() {
        return String.format("Temperatura actual: %sCº (sensación de %sCº)", getTemperature(), getFeelslike());
    }
}
