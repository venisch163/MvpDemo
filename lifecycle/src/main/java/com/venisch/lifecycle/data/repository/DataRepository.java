package com.venisch.lifecycle.data.repository;

/**
 * Created by shenwenjie on 2017/12/29.
 */

public interface DataRepository<T> {
    T getData();
    void cancel(String tag);
}
