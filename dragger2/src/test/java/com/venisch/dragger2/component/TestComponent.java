package com.venisch.dragger2.component;

import com.venisch.dragger2.DaggerTest;
import com.venisch.dragger2.MainActivity;

import dagger.Component;

/**
 * Created by shenwenjie on 2017/12/28.
 */

@Component
public interface TestComponent {
    void inject(DaggerTest activity);
}


