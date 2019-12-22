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

    private EditText etInputCode; // form intup code
    private Button btnInputCode; // tombol input code
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

        //manangani tombol input keyika di klik
        btnInputCode.setOnClickListener(v -> {

            String inputCode = etInputCode.getText().toString(); // mengambil isi dari form input
            String code = null;

            if (!inputCode.equals("")) {
                code = db.presenceDao().getCode(inputCode); // panggil databse dan cek datanya benar atau tidak
            } else {
                Toast.makeText(this, "Silahkan masukan Code", Toast.LENGTH_SHORT).show(); // tapikan pesan error bila form input kosong
            }

            if (code != null && !code.equals("")) {
                Presence presence = db.presenceDao().getSingleData(code); // ambil data dari databse
                presence.setPresensi(presence.getPresensi() + 1); // update nilai presensi
                db.presenceDao().update(presence); // update database presendi

                Toast.makeText(this, "Presensi Berhasil", Toast.LENGTH_SHORT).show(); // pesan berhasil

                finish();

            } else {

                Toast.makeText(this, "Code yang Anda masukan salah", Toast.LENGTH_SHORT).show(); // tapikan pesan error bila data kosong
            }

        });

        ivBack.setOnClickListener(v -> onBackPressed());
    }

}
