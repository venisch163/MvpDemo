package com.venisch.dragger2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.venisch.dragger2.component.ActivityComponent;
import com.venisch.dragger2.component.AppComponent;
import com.venisch.dragger2.component.DaggerActivityComponent;
import com.venisch.dragger2.data.ActivityBean;
import com.venisch.dragger2.data.AppBean;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2017/12/28.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Inject
    AppBean mAppBean1;
    @Inject
    AppBean mAppBean2;
    @Inject
    ActivityBean mActivityBean;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        App app = (App) getApplication();
        AppComponent appComponent = app.getmAppComponent();
        ActivityComponent activityComponent = DaggerActivityComponent.builder().appComponent(appComponent).build();
        activityComponent.inject(this);
        Log.d(TAG,"mAppBean1 hashCode = " + mAppBean1);
        Log.d(TAG,"mAppBean2 hashCode = " + mAppBean2);
        Log.d(TAG,"mActivityBean hashCode = " + mActivityBean);

        OutClass outClass = new OutClass();

    }

    // for test Scope
    public class OutClass {
        @Inject
        AppBean mAppBean1;
        @Inject
        AppBean mAppBean2;
        @Inject
        ActivityBean mActivityBean;
        public OutClass(){
            App app = (App) getApplication();
            AppComponent appComponent = app.getmAppComponent();
            ActivityComponent activityComponent = DaggerActivityComponent.builder().appComponent(appComponent).build();
            activityComponent.inject(this);
            Log.d(TAG,"mAppBean1 hashCode = " + mAppBean1);
            Log.d(TAG,"mAppBean2 hashCode = " + mAppBean2);
            Log.d(TAG,"mActivityBean hashCode = " + mActivityBean);
        }
    }
}
