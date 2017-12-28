package com.venisch.dragger2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.venisch.dragger2.component.DaggerFactoryActivity2Component;
import com.venisch.dragger2.model.User;
import com.venisch.dragger2.model.User2;
import com.venisch.dragger2.ui.MainFragment;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by shenwenjie on 2017/12/28.
 *
 * 目标类，需要使用其它被依赖类(User,User2)
 */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Inject
    public User mUser;

    @Named("TypeOneParam")
    @Inject
    public User2 mUser2;

    @Named("TypeTwoParam")
    @Inject
    public User2 mUser2B;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,new MainFragment(),MainFragment.class.getSimpleName()).commitAllowingStateLoss();
    }

    @Override
    protected void onResume() {
        super.onResume();

        DaggerFactoryActivity2Component.create().inject(this);
        if(mUser!=null){
            Log.d(TAG,"1111");
        }
        if(mUser2!=null){
            Log.d(TAG,mUser2.toString());
        }

        if(mUser2B!=null){
            Log.d(TAG,mUser2B.toString());
        }


    }
}
