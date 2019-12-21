package com.example.projectpresensi.view.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.model.Presence;
import com.example.projectpresensi.view.base.BaseActivity;

import static com.example.projectpresensi.AppApplication.db;

public class InputCodeActivity extends BaseActivity {

    private EditText etInputCode;
    private Button btnInputCode;
    private ImageView ivBack;

    @Override
    public int setLayout() {
        return R.layout.activity_input_code;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {

    }

    @Override
    public void findView() {
        etInputCode = findViewById(R.id.et_input_code);
        btnInputCode = findViewById(R.id.btn_input_code);
        ivBack = findViewById(R.id.iv_back_input_code);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {

    }

    @Override
    public void listener() {

        btnInputCode.setOnClickListener(v -> {

            String inputCode = etInputCode.getText().toString();
            String code = null;

            if (!inputCode.equals("")) {
                code = db.presenceDao().getCode(inputCode);
            } else {
                Toast.makeText(this, "Silahkan masukan Code", Toast.LENGTH_SHORT).show();
            }

            if (code != null && !code.equals("")) {
                Presence presence = db.presenceDao().getSingleData(code);
                presence.setPresensi(presence.getPresensi() + 1);
                db.presenceDao().update(presence);

                Toast.makeText(this, "Presensi Berhasil", Toast.LENGTH_SHORT).show();

                finish();

            } else {

                Toast.makeText(this, "Code yang Anda masukan salah", Toast.LENGTH_SHORT).show();
            }

        });

        ivBack.setOnClickListener(v -> onBackPressed());
    }

}
