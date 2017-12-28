package com.venisch.mvp.weather.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.venisch.mvp.R;
import com.venisch.mvp.utils.ViewHolderUtil;
import com.venisch.mvp.weather.data.WeatherInfo;

import java.util.ArrayList;

/**
 * 作者：guannan on 2016/5/25 14:54
 */
public class WeatherAdapter extends BaseAdapter {

    private ArrayList<WeatherInfo> soleNewsList;
    private Context             mContext;
    private TextView           mTvIp;
    private TextView            mTextViewDes;

    public WeatherAdapter(Context context, ArrayList<WeatherInfo> soleList){

        this.mContext=context;
        this.soleNewsList=soleList;
    }

    @Override
    public int getCount() {
        return soleNewsList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView=inflater.inflate(R.layout.recycle_item_weather,parent,false);
        }
        mTvIp = ViewHolderUtil.get(convertView, R.id.tv_ip);
        mTextViewDes = ViewHolderUtil.get(convertView, R.id.tv_address);

        if(soleNewsList.size()!=0) {
            WeatherInfo weatherInfo = soleNewsList.get(position);
            mTvIp.setText(weatherInfo.getIp());
            mTextViewDes.setText(weatherInfo.getCity());
        }

        return convertView;
    }
}
