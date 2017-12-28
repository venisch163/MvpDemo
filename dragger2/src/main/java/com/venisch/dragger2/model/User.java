package com.venisch.dragger2.model;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2017/12/28.
 * 被依赖类，构造方法需要添加Inject注解,并且不能有多个构造方法同时使用Inject
 */

public class User {

    private static final String TAG = "User";
    private String name;

    @Inject
    public User(){
        Log.d(TAG,"user without parameter");
    }

//    @Inject
//    public User(String name){
//        Log.d(TAG,"user with parameter");
//        this.name = name;
//    }

}
