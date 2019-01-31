package com.venisch.dragger2.component;

import com.venisch.dragger2.MainActivity;
import com.venisch.dragger2.data.User;
import com.venisch.dragger2.module.UserModule;

import dagger.Component;

/**
 * Created by shenwenjie on 2018/3/25.
 */

@Component(modules = UserModule.class)
public interface MainAcitivityComponent {
    void inject(MainActivity mainActivity);

//    User providerUser();

    MainSubFragmentComponent mainSubFragmentComponent();

}
