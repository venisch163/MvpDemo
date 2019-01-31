package com.venisch.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.venisch.dragger2.component.DaggerMainAcitivityComponent;
import com.venisch.dragger2.component.MainAcitivityComponent;
import com.venisch.dragger2.data.User;
import com.venisch.dragger2.module.UserModule;

import javax.inject.Inject;


/**
 * Created by shenwenjie on 2017/12/28.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Inject
    User user;
    private MainAcitivityComponent mainAcitivityComponent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }

    private void init() {
        // init with param
        mainAcitivityComponent = DaggerMainAcitivityComponent.builder().userModule(new UserModule("venisch", 26)).build();
        mainAcitivityComponent.inject(this);
        if (user == null) {
            Log.d(TAG, "userFactory = null");
        } else {
            Log.d(TAG, "User = " + user.toString());
        }

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,new MainSubFragment()).commitAllowingStateLoss();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public MainAcitivityComponent getMainAcitivityComponent() {
        return mainAcitivityComponent;
    }
}
