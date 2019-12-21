package com.example.projectpresensi.view.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity implements BaseCompponent.Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initComponent(savedInstanceState);
        findView();
        initView();
        loadView();
        listener();
    }

}
