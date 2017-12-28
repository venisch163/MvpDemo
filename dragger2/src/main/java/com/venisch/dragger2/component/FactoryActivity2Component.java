package com.venisch.dragger2.component;

import com.venisch.dragger2.MainActivity;
import com.venisch.dragger2.module.UserModule;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 * 申明将依赖注入到的目标位置
 */

@Component(modules = UserModule.class)
public interface FactoryActivity2Component {
    void inject(MainActivity activity);
}
