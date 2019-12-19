package com.example.projectpresensi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.sharedpref.PreferenceLogin;
import com.example.projectpresensi.view.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private PreferenceLogin login;
    private EditText etNim;
    private EditText etPass;
    private Button btnLogin;

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        login = PreferenceLogin.getInstance(getApplicationContext());
        login.setPass("123456");
    }

    @Override
    public void findView() {
        etNim = findViewById(R.id.et_login_nim);
        etPass = findViewById(R.id.et_login_pass);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        btnLogin.setOnClickListener(v -> {

            String nim = etNim.getText().toString();
            String pass = etPass.getText().toString();

            if (nim.equals("17.12.0210")
                && pass.equals("123456")) {

                login.setLogin(true);
                login.setNim(nim);
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            } else if (nim.equals("") && pass.equals("")) {

                Toast.makeText(this, "Nim dan Password harus diisi", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Input Nim atau Password anda salah", Toast.LENGTH_SHORT).show();

            }

        });
    }

}

