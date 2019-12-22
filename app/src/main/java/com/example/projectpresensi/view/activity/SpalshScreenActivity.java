package com.example.projectpresensi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.sharedpref.PreferenceLogin;

public class SpalshScreenActivity extends AppCompatActivity {

    private PreferenceLogin login; // database saredpref

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // agar tampilan window full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spalsh_screen);

        login = PreferenceLogin.getInstance(getApplicationContext()); // inisiasi database sharedpref
        int SPLAH_TIME_OUT = 2500; // waktu delay
        // set waktu delay
        new Handler().postDelayed(() -> {
            // cek kondisi login
            if (!login.isLogin()){
                startActivity(new Intent(SpalshScreenActivity.this, LoginActivity.class)); // bila sudah login
                finish();
            }else {
                startActivity(new Intent(SpalshScreenActivity.this, MainActivity.class)); // bila belum
                finish();

            }
        }, SPLAH_TIME_OUT);
    }

}
