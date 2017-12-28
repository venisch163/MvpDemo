package com.venisch.mvp.weather.contract;

import com.venisch.mvp.weather.data.WeatherInfo;
import com.venisch.mvp.base.ViewInterface;

import java.util.ArrayList;

/**
 * Created by shenwenjie on 2017/12/27.
 */

public interface WeatherContract {

    interface WeatherView extends ViewInterface {
        void notifyAdapter(ArrayList<WeatherInfo> weatherInfoArrayList);
    }

    interface WeatherPresenter {
        void refreshWeatherData();
    }

}
