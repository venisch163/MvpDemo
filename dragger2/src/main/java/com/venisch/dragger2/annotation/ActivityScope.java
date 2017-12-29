package com.venisch.dragger2.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by shenwenjie on 2017/12/28.
 * 用于限制Component的使用范围，此处用于限定了Activity Component的使用范围
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
