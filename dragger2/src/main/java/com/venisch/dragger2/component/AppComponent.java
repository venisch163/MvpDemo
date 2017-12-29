package com.venisch.dragger2.component;

import android.app.Application;

import com.venisch.dragger2.App;
import com.venisch.dragger2.data.AppBean;
import com.venisch.dragger2.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 * 全局单例的Component,只需在application中初始化一次
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App application);

    AppBean providerAppBean();
}
