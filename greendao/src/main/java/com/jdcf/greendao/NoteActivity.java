package com.jdcf.greendao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jdcf.greendao.gen.User;
import com.jdcf.greendao.gen.UserDao;

/**
 * Created by shenwenjie on 2018/2/5.
 */

public class NoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        initData();
    }

    private void initData() {
        UserDao userDao = ((NoteApplication) getApplication()).getDaoSession().getUserDao();
        userDao.insert(new User());
    }
}
