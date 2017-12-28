package com.venisch.dragger2.demo.component;

import com.venisch.dragger2.DaggerTest;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 */

@Component
public interface TestComponent {
    void inject(DaggerTest activity);
}


