package com.venisch.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.venisch.dragger2.annotation.DaggerParamType;
import com.venisch.dragger2.component.DaggerFactoryActivity2Component;
import com.venisch.dragger2.model.User;
import com.venisch.dragger2.model.User2;
import com.venisch.dragger2.ui.MainFragment;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by shenwenjie on 2017/12/28.
 * <p>
 * 目标类，需要使用其它被依赖类(User,User2)
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Inject
    public User mUser;//每次注入都会产生一个新的实例

    @Inject
    public User mUser1;

    @Named("TypeOneParam")
    @Inject
    public User2 mUser2A;

    @Named("TypeTwoParam")
    @Inject
    public User2 mUser2B;

    @Named("TypeTwoParam2")
    @Inject
    public User2 mUser2B2;

    @DaggerParamType
    @Inject
    public User2 mUser2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, new MainFragment(), MainFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();

        DaggerFactoryActivity2Component.create().inject(this);
        if (mUser != null) {
            Log.d(TAG, mUser.toString());
        }

        if (mUser1 != null) {
            Log.d(TAG, mUser1.toString());
        }

        if (mUser2A != null) {
            Log.d(TAG, mUser2A.toString());
        }

        if (mUser2B != null) {
            Log.d(TAG, mUser2B.toString());
        }

        if (mUser2B2 != null) {
            Log.d(TAG, mUser2B2.toString());
        }

        if (mUser2 != null) {
            Log.d(TAG, mUser2.toString());
        }


    }

}
