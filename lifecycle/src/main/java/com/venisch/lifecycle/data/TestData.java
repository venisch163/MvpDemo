package com.venisch.lifecycle.data;

/**
 * Created by shenwenjie on 2017/12/29.
 */

public class TestData {
    private String name;

    public TestData(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "name='" + name + '\'' +
                '}';
    }
}
