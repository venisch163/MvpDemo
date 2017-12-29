package com.venisch.dragger2;

import android.app.Application;
import android.util.Log;

import com.venisch.dragger2.component.AppComponent;
import com.venisch.dragger2.component.DaggerAppComponent;
import com.venisch.dragger2.data.AppBean;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2017/12/28.
 */

public class App extends Application {
    private static final String TAG = "App";

    private AppComponent mAppComponent;
    @Inject
    AppBean mAppBean1;
    @Inject
    AppBean mAppBean2;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initGlobalComponent();
    }


    private void initGlobalComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.create();
        }
        mAppComponent.inject(this);

        Log.d(TAG,"AppBean1 hashCode = "+mAppBean1.toString());
        Log.d(TAG,"mAppBean2 hashCode = "+mAppBean2.toString());

    }

    public AppBean getmAppBean() {
        return mAppBean1;

    }

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
