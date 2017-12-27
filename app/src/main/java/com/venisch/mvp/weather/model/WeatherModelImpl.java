package com.venisch.mvp.weather.model;

import com.venisch.mvp.weather.data.WeatherInfo;

import java.util.ArrayList;

/**
 * Created by shenwenjie on 2017/12/27.
 */

public class WeatherModelImpl implements WeatherModel {
    @Override
    public ArrayList<WeatherInfo> fetchWeatherInfo() {

        // 模拟数据
        ArrayList<WeatherInfo> weatherInfoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeatherInfo weatherInfo = new WeatherInfo();
            weatherInfo.setIp("1.1.1."+i);
            weatherInfo.setCity("北京"+i);
            weatherInfoList.add(weatherInfo);
        }
        return weatherInfoList;
    }
}
