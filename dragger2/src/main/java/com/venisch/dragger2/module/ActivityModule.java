package com.venisch.dragger2.module;

import com.venisch.dragger2.data.ActivityBean;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shenwenjie on 2017/12/28.
 */

@Module
public class ActivityModule {
    @Provides
    public ActivityBean providerActivityBean(){
        return new ActivityBean("activityBean");
    }
}
