package com.venisch.dragger2.demo.model;

/**
 * Created by shenwenjie on 2017/12/28.
 * 被依赖类，构造方法需要添加Inject注解
 */

public class User2 {
    private String name;
    private int age;

    public User2() {

    }

    public User2(String name) {
        this.name = name;
    }

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
