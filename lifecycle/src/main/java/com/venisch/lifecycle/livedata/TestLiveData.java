package com.venisch.lifecycle.livedata;

import android.Manifest;
import android.annotation.SuppressLint;
import android.arch.lifecycle.LiveData;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.venisch.lifecycle.data.repository.TestDataRepository;

/**
 * Created by shenwenjie on 2017/12/29.
 *
 */

public class TestLiveData extends LiveData {

    private TestDataRepository mTestDataRepository;

    public TestLiveData() {
        mTestDataRepository = new TestDataRepository();

    }

    @SuppressLint("MissingPermission")
    @Override
    protected void onActive() {
        setValue(mTestDataRepository.getData());
    }

    @Override
    protected void onInactive() {
    }
}
