package com.venisch.dragger2.component;

import com.venisch.dragger2.MainActivity;
import com.venisch.dragger2.annotation.ActivityScope;
import com.venisch.dragger2.module.ActivityModule;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(MainActivity.OutClass outClass);
}
