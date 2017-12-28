package com.venisch.dragger2.demo.component;

import com.venisch.dragger2.demo.TestActivity;
import com.venisch.dragger2.demo.module.UserModule;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 * 申明将依赖注入到的目标位置
 */

//@Singleton
@Component(modules = UserModule.class)
public interface FactoryActivity2Component{
    void inject(TestActivity activity);
}
