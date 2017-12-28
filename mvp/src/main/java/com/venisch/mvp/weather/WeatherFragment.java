package com.venisch.mvp.weather;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.venisch.mvp.R;
import com.venisch.mvp.weather.adapter.WeatherAdapter;
import com.venisch.mvp.weather.contract.WeatherContract;
import com.venisch.mvp.weather.data.WeatherInfo;
import com.venisch.mvp.weather.presenter.WeatherPresenterImpl;
import com.venisch.mvp.weather.ui.BaseFragment;

import java.util.ArrayList;

/**
 * Created by shenwenjie on 2017/12/27.
 * 关于生命周期的处理将在下个版本添加
 */

public class WeatherFragment extends BaseFragment implements WeatherContract.WeatherView {

    private WeatherPresenterImpl mPresenter;
    private ListView mRecyclerView;
    private WeatherAdapter mWeatherAdapter;

    public WeatherFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new WeatherPresenterImpl(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, null, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initView(view, savedInstanceState);

    }

    private void initView(View view, Bundle savedInstanceState) {
        Button btnLoad = view.findViewById(R.id.btn_load);
        mRecyclerView = view.findViewById(R.id.lv_weather);

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.refreshWeatherData();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mPresenter != null){
            mPresenter = null;
        }
    }

    @Override
    public void notifyAdapter(ArrayList<WeatherInfo> weatherInfoArrayList) {
        if (null == mWeatherAdapter) {
            mWeatherAdapter = new WeatherAdapter(getContext(), weatherInfoArrayList);
            mRecyclerView.setAdapter(mWeatherAdapter);
        }
        mWeatherAdapter.notifyDataSetChanged();
    }
}
