package com.jdcf.verticalscoll;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shenwenjie on 2018/2/8.
 */

public class TestActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_vertical);

        initView();

    }

    private void initView() {
        VerticalScrolledListView scrollView = findViewById(R.id.scrollView);

        List<String> datas = new ArrayList<>();
        datas.add("张学友来了");
        datas.add("张杰来了");
        datas.add("张三丰来了");
        datas.add("张二胖来了");
        datas.add("张晓来了");
        scrollView.setData(datas);
    }
}
