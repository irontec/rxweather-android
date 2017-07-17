package com.irontec.axier.rxweather.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.irontec.axier.rxweather.BR;

/**
 * Created by axier on 14/7/17.
 */

public class Condition extends BaseObservable {

    @SerializedName("text")
    private String text;
    @SerializedName("icon")
    private String imageUrl;
    @SerializedName("code")
    private Integer code;

    public Condition() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Bindable
    public String getImageUrl() {
        return String.format("https:%s", imageUrl);
    }

    public Condition setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        notifyPropertyChanged(BR.imageUrl);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
