package com.venisch.lifecycle.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.venisch.lifecycle.data.TestData;
import com.venisch.lifecycle.data.repository.TestDataRepository;

import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;
import io.reactivex.Observer;


/**
 * Created by shenwenjie on 2017/12/29.
 * ViewModel是可观察的数据持有者
 */

public class TestViewModel extends ViewModel {

    public MutableLiveData<TestData> testData;

    public LiveData<TestData> getTestData() {
        if (testData == null) {
            testData = new MutableLiveData<>();
            loadTestData();
        }
        return testData;
    }

    private void loadTestData() {
        TestDataRepository mTestDataRepository = new TestDataRepository();
        testData.setValue(mTestDataRepository.getData());
    }


}
