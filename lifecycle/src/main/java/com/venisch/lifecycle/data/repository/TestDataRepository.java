package com.venisch.lifecycle.data.repository;

import com.venisch.lifecycle.data.TestData;

/**
 * Created by shenwenjie on 2017/12/29.
 */

public class TestDataRepository implements DataRepository<TestData>{
    @Override
    public TestData getData() {
        return new TestData("hello");
    }

    @Override
    public void cancel(String tag) {
        //todo
    }
}
