package com.example.projectpresensi.view.fragment;


import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.projectpresensi.R;
import com.example.projectpresensi.view.activity.InputBarcodeActivity;
import com.example.projectpresensi.view.base.BaseFragment;

public class HomeFragment extends BaseFragment {

    private LinearLayout btnScanBarcode;
    private LinearLayout btnInputCode;
    private Button button;

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
        button = v.findViewById(R.id.btn_test);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        button.setOnClickListener(v -> startActivity(new Intent(getActivity(), InputBarcodeActivity.class)));
        btnScanBarcode.setOnClickListener(v -> startActivity(new Intent(getActivity(), InputBarcodeActivity.class)));
        btnInputCode.setOnClickListener(v -> startActivity(new Intent(getActivity(), InputBarcodeActivity.class)));
    }

}
