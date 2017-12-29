package com.venisch.dragger2.module;

import com.venisch.dragger2.data.AppBean;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shenwenjie on 2017/12/28.
 * 全局单例AppBean的实例化提供者
 */


@Module
public class AppModule {

    @Singleton
    @Provides
    public AppBean providerAppBean(){
       return new AppBean("com.venisch.dragger2");
    }
}
