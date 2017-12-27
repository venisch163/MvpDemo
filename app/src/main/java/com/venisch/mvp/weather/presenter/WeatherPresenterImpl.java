package com.venisch.mvp.weather.presenter;

import com.venisch.mvp.weather.contract.WeatherContract;
import com.venisch.mvp.weather.data.WeatherInfo;
import com.venisch.mvp.weather.model.WeatherModel;
import com.venisch.mvp.weather.model.WeatherModelImpl;

import java.util.ArrayList;

/**
 * Created by shenwenjie on 2017/12/27.
 * Presenter
 */

public class WeatherPresenterImpl implements WeatherContract.WeatherPresenter {

    private WeatherContract.WeatherView mViewInterface;
    private final WeatherModel mWeatherInfoModel;

    public WeatherPresenterImpl(WeatherContract.WeatherView viewInterface){
        this.mViewInterface = viewInterface;
        mWeatherInfoModel = new WeatherModelImpl();
    }

    @Override
    public void refreshWeatherData() {
        //for Test
        ArrayList<WeatherInfo> weatherInfos = mWeatherInfoModel.fetchWeatherInfo();
        mViewInterface.notifyAdapter(weatherInfos);
    }
}
