package com.irontec.axier.rxweather.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by axier on 14/7/17.
 */

public class Location {

    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}
