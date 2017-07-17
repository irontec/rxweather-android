package com.irontec.axier.rxweather;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.irontec.axier.rxweather.databinding.RowWeatherBinding;
import com.irontec.axier.rxweather.model.Forecastday;

import java.util.List;

/**
 * Created by axier on 8/3/17.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Forecastday.Hour> mData;
    private LayoutInflater layoutInflater;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final RowWeatherBinding binding;

        ViewHolder(final RowWeatherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public WeatherAdapter(List<Forecastday.Hour> mData) {
        this.mData = mData;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.binding.setHour(mData.get(i));
        viewHolder.binding.setCondition(mData.get(i).getCondition());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        final RowWeatherBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.row_weather, viewGroup, false);
        return new ViewHolder(binding);
    }
}
