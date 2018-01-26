package com.venisch.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.venisch.mvp.R;


public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        findViewById(R.id.btn_open).setOnClickListener(v -> startActivity(new Intent(NewActivity.this,LifecycleActivity.class)));
    }
}
