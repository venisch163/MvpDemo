package com.venisch.dragger2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venisch.dragger2.R;
import com.venisch.dragger2.model.User;
//import com.venisch.dragger2.module.UserModule;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2017/12/28.
 */

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

//    @Inject
//    public User mUser;
    private TextView mTvData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,null,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view,savedInstanceState);

        initData();
    }

    private void initData() {

    }

    private void initView(View view, Bundle savedInstanceState) {
        mTvData = view.findViewById(R.id.tv_data);

    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
