package com.irontec.axier.rxweather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.irontec.axier.rxweather.databinding.ActivityMainBinding;
import com.irontec.axier.rxweather.model.Weather;

import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doGetBilbaoWeather();
    }

    private void doGetBilbaoWeather() {
        ServiceGenerator.createService(RxWeatherService.class)
                .getWeather(BuildConfig.APIXU_KEY, "Bilbao")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(weather -> {
                            binding.setCurrent(weather.getCurrent());
                            binding.setLocation(weather.getLocation());
                            initListView(weather);
                        }
                        , throwable -> throwable.printStackTrace()
                        , () -> Log.d(TAG, "Completed"));
    }

    private void initListView(Weather weather) {
        final RecyclerView list = binding.list;
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        final WeatherAdapter adapter = new WeatherAdapter(
                weather.getForecast().getForecastdays().get(0).getHours());
        list.setAdapter(adapter);
    }
}