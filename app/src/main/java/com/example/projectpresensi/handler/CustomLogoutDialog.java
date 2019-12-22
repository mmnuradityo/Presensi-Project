package com.example.projectpresensi.handler;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;

import com.example.projectpresensi.R;

import java.util.Objects;

// unutk menampilkan pop up logout
public class CustomLogoutDialog extends Dialog {

    private Activity activity;
    private LogoutDialog dialog;

    // konstruktor class
    public CustomLogoutDialog(Activity a, LogoutDialog dialog) {
        super(a);
        this.activity = a;
        this.dialog = dialog;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // set window tanpa judul
        setContentView(R.layout.custom_logout_dialog); // memasukan tampilan ui
        // set ukuran tampilan dialog
        Objects.requireNonNull(
                getWindow()).setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        // pengaturan tombol
        findViewById(R.id.btn_tidak_logout).setOnClickListener(v -> this.dismiss());
        findViewById(R.id.btn_ya_logout).setOnClickListener(v -> dialog.onClickDialog());
    }

    public interface LogoutDialog {
        void onClickDialog();
    }

}
