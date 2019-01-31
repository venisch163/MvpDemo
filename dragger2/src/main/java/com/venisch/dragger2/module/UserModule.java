package com.venisch.dragger2.module;

import com.venisch.dragger2.data.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by shenwenjie on 2018/3/25.
 */

@Module
public class UserModule {

    private String name;
    private int age;

    public UserModule(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Provides
    User providerUser() {
        return new User(name, age);
    }

}
