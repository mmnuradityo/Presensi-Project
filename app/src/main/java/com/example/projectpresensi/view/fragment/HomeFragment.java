package com.example.projectpresensi.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.projectpresensi.R;
import com.example.projectpresensi.view.activity.InputCodeActivity;
import com.example.projectpresensi.view.activity.ScannerActivity;
import com.example.projectpresensi.view.base.BaseFragment;

public class HomeFragment extends BaseFragment {

    private LinearLayout btnScanBarcode;
    private LinearLayout btnInputCode;

    @Override
    public int setLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    }

    @Override
    public void findView(View v) {
        btnScanBarcode = v.findViewById(R.id.ll_scanbarcode_home);
        btnInputCode = v.findViewById(R.id.ll_inputbarcode_home);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        btnScanBarcode.setOnClickListener(v -> startActivity(new Intent(getActivity(), ScannerActivity.class)));
        btnInputCode.setOnClickListener(v -> startActivity(new Intent(getActivity(), InputCodeActivity.class)));
    }

}
