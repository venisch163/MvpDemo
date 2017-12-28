package com.venisch.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.venisch.mvp.weather.WeatherFragment;
import com.venisch.mvp.weather.presenter.WeatherPresenterImpl;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WeatherFragment weatherFragment = new WeatherFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,weatherFragment , WeatherFragment.class.getSimpleName()).commit();
    }
}
