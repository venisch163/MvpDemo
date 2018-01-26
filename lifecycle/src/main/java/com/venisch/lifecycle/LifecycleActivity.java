package com.venisch.lifecycle;

import android.Manifest;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.venisch.lifecycle.livedata.TestLiveData;
import com.venisch.lifecycle.viewModel.TestViewModel;
import com.venisch.mvp.R;


public class LifecycleActivity extends AppCompatActivity {
    private static final String TAG = "LifecycleActivity";

    //    static class TestHandler extends Handler{
    //        // 测试内存泄漏
    //        LifecycleActivity mainActivity;
    //
    //        public TestHandler(LifecycleActivity activity){
    //            this.mainActivity = activity;
    //        }
    //        @Override
    //        public void handleMessage(Message msg) {
    //            super.handleMessage(msg);
    //        }
    //    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //        Handler handler = new TestHandler(this);


    }

    class MyLifecycleObserver implements LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        public void onCreate() {
            Log.d(TAG, "onCreate");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            Log.d(TAG, "onStart");

        }

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        public void onResume() {
            Log.d(TAG, "onResume");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void onStop() {
            Log.d(TAG, "onStop");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Log.d(TAG, "onDestroy");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {

        //        getLifecycle().addObserver(new MyLifecycleObserver());
        //        TestViewModel model = ViewModelProviders.of(this).get(TestViewModel.class);
        //        model.getTestData().observe(this, testData -> {
        //            // update UI
        //            Log.d(TAG,testData.toString());
        //        });


        TestViewModel testLiveData = ViewModelProviders.of(this).get(TestViewModel.class);

        testLiveData.getTestData().observe(this, string -> {
            Log.d(TAG, "string = " + string);

        });
        super.onResume();
    }
}
