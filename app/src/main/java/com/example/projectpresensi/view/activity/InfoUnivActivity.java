package com.example.projectpresensi.view.activity;


import android.os.Bundle;
import android.widget.ImageView;

import com.example.projectpresensi.R;
import com.example.projectpresensi.view.base.BaseActivity;

public class InfoUnivActivity extends BaseActivity {

    private ImageView ivBack;

    @Override
    public int setLayout() {
        return R.layout.activity_info_univ;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {

    }

    @Override
    public void findView() {
        ivBack = findViewById(R.id.iv_back_info_univ);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        ivBack.setOnClickListener(v -> onBackPressed());
    }

}
