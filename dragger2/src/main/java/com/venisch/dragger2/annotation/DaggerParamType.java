package com.venisch.dragger2.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by shenwenjie on 2017/12/28.
 * @Qualifier 修饰语 用来自定义类似@Name 的注解
 */

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DaggerParamType {
    int value() default 0;
}
