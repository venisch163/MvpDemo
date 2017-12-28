package com.venisch.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.venisch.dragger2.ui.MainFragment;

/**
 * Created by shenwenjie on 2017/12/28.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,new MainFragment(),MainFragment.class.getSimpleName()).commitAllowingStateLoss();
    }
}
