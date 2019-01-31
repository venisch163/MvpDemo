package com.venisch.dragger2.component;

import com.venisch.dragger2.MainFragment;
import com.venisch.dragger2.MainSubFragment;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by shenwenjie on 2018/3/25.
 */

@Subcomponent
public interface MainSubFragmentComponent {
    void inject(MainSubFragment mainSubFragment);

}
