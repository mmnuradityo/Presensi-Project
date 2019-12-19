package com.example.projectpresensi.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.sharedpref.PreferenceLogin;

public class SpalshScreenActivity extends AppCompatActivity {

    private PreferenceLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_spalsh_screen);

        login = PreferenceLogin.getInstance(getApplicationContext());
        int SPLAH_TIME_OUT = 2500;
        new Handler().postDelayed(() -> {
            if (!login.isLogin()){
                startActivity(new Intent(SpalshScreenActivity.this, LoginActivity.class));
                finish();
            }else {
                startActivity(new Intent(SpalshScreenActivity.this, MainActivity.class));
                finish();

            }
        }, SPLAH_TIME_OUT);
    }

}
