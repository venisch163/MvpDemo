package com.venisch.mvp.weather.model;

import com.venisch.mvp.weather.data.WeatherInfo;

import java.util.ArrayList;

/**
 * Created by shenwenjie on 2017/12/27.
 */

public interface WeatherModel {
    ArrayList<WeatherInfo> fetchWeatherInfo();
}
