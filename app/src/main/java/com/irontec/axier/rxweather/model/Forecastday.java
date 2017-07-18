package com.irontec.axier.rxweather.model;

import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by axier on 14/7/17.
 */

public class Forecastday {

    @SerializedName("day")
    private Day day;
    @SerializedName("hour")
    private List<Hour> hours;

    public Forecastday() {
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public List<Hour> getHours() {
        return hours;
    }

    public void setHours(List<Hour> hours) {
        this.hours = hours;
    }

    public class Day {

        @SerializedName("maxtemp_c")
        private Float maxTemp;
        @SerializedName("mintemp_c")
        private Float minTemp;
        @SerializedName("humidity")
        private Integer humidity;
        @SerializedName("condition")
        private Condition condition;

        public Day() {
        }

        public Float getMaxTemp() {
            return maxTemp;
        }

        public void setMaxTemp(Float maxTemp) {
            this.maxTemp = maxTemp;
        }

        public Float getMinTemp() {
            return minTemp;
        }

        public void setMinTemp(Float minTemp) {
            this.minTemp = minTemp;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Condition getCondition() {
            return condition;
        }

        public void setCondition(Condition condition) {
            this.condition = condition;
        }
    }

    public class Hour {

        @SerializedName("time_epoch")
        private Long timeEpoch;
        @SerializedName("temp_c")
        private Float temperature;
        @SerializedName("condition")
        private Condition condition;

        public Hour() {
        }

        public Long getTimeEpoch() {
            return timeEpoch;
        }

        public void setTimeEpoch(Long timeEpoch) {
            this.timeEpoch = timeEpoch;
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

        public String getEpochAsDate() {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            return sdf.format(new Date(timeEpoch * 1000));
        }

        public String getTemperatureDisplay() {
            return String.format("%sCº", temperature);
        }
    }

}
