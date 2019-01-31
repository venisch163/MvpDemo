package com.venisch.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.venisch.dragger2.component.DaggerMainFragmentComponent;
//import com.venisch.dragger2.component.MainAcitivityComponent;
//import com.venisch.dragger2.data.User;
//
//import javax.inject.Inject;

/**
 * Created by shenwenjie on 2018/3/25.
 */

public class MainFragment extends Fragment {

    private static final String TAG = "MainFragment";

//    @Inject
//    User user;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
//        MainAcitivityComponent mainAcitivityComponent = ((MainActivity) getActivity()).getMainAcitivityComponent();
//        DaggerMainFragmentComponent.builder().mainAcitivityComponent(mainAcitivityComponent).build().inject(this);
//
//        Log.d(TAG, user.toString());
    }
}
