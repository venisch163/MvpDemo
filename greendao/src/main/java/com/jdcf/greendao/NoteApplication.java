package com.jdcf.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.jdcf.greendao.gen.DaoMaster;
import com.jdcf.greendao.gen.DaoSession;

/**
 * Created by shenwenjie on 2018/2/7.
 */

public class NoteApplication extends Application {

    private SQLiteDatabase db;
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "note-db", null);
        db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mDaoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }



}
