package com.venisch.dragger2.data;

import javax.inject.Inject;

/**
 * Created by shenwenjie on 2018/3/25.
 */

public class User {
    public String name;

    public int age;

    // type 1,在构造
//    @Inject
//    public User(){
//
//    }

    @Inject
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
