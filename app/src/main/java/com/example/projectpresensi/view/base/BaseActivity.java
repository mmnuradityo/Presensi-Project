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

/*
onCreate(activity) dan onCreateView(fragment) tidak ada karena di pindah dan di konfigurasi pada
pada Class BaseActivity dan BaseFragment.
fungsi masing" methode:
- setLayout() : set tampilan dasar
- initComponent() : untuk memanggil / menginisiasi suatu class
- initView() : membangun tampilan
- findView() : set componen tampilan berdasarkan id
- loadView() : methode tambahan dari initView
- listener() : untuk set tombol dan menangani event click
 */