package com.example.projectpresensi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.projectpresensi.R;
import com.example.projectpresensi.data.sharedpref.PreferenceLogin;
import com.example.projectpresensi.handler.CustomLogoutDialog;
import com.example.projectpresensi.view.adapter.viewpager.ViewPagerAdapter;
import com.example.projectpresensi.view.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity implements CustomLogoutDialog.LogoutDialog {

    private ViewPagerAdapter viewPagerAdapter; // class adapter penampil fragment
    private Toolbar toolbar; // sebagai custom appbar
    private BottomNavigationView bottomNav; // navigasi bawah
    private ViewPager viewPager; // menampilkan fragment
    private MenuItem prevMenuItem; // membuat menu 3 titik di appbar
    private PreferenceLogin login; // database sharedpreference untuk login

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        login = PreferenceLogin.getInstance(this.getApplicationContext());
    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar_main);
        bottomNav = findViewById(R.id.bottom_nav_main);
        viewPager = findViewById(R.id.vp_menu_main);
    }

    @Override
    public void initView() {
        setToolbar(0);
        setSupportActionBar(toolbar);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void loadView() {
        viwePager();
    }

    @Override
    public void listener() {
        bottomNavigation();
    }

    private void bottomNavigation() {

        // menghendel navigasi bawah ketika di klik
        bottomNav.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.homeBottom:
                    item.setIcon(R.drawable.ic_home);
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.agendaBottom:
                    item.setIcon(R.drawable.ic_agenda);
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.presenceBottom:
                    item.setIcon(R.drawable.ic_presence);
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.profileBottom:
                    item.setIcon(R.drawable.ic_account);
                    viewPager.setCurrentItem(3);
                    break;
            }
            return false;

        });

    }

    private void viwePager() {
        // menghendel viewPager ketika di swap
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            // unutk merubah tampilan navigasi bawah sesuai posisi fragment yang tampil
            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNav.getMenu().getItem(0).setChecked(false);
                }

                setToolbar(position);
                bottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }

    // set toolbar name
    private void setToolbar(int position) {
        if (position == 0) {
            toolbar.setTitle("Home");
        } else if (position == 1) {
            toolbar.setTitle("Jadwal");
        } else if (position == 2) {
            toolbar.setTitle("Presensi");
        } else {
            toolbar.setTitle("Profil");
        }
    }

    // membuat tampilan 3 titik pada appbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menusetting, menu);
        return  true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        // menghendel menu 3 titik appbar ketika di klik
        switch (item.getItemId()){
            case R.id.Info_kampus_menu:
                //pindah ke tampilan tentang kampus
                startActivity(new Intent(this, InfoUnivActivity.class));
                return true;
            case R.id.logout_menu:
                //menampilkan pop up dialog
                login.setLogin(false);
                CustomLogoutDialog dialog = new CustomLogoutDialog(this, this);
                dialog.show();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        alertDialogExit();
    }

    //menampilkan dialog konfirmasi untuk keluar aplikasi
    private void alertDialogExit() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah anda ingin keluar?");

        builder.setPositiveButton("Ya", (dialog, which) -> finish());
        builder.setNeutralButton("Tidak", (dialog, which) -> dialog.cancel());

        AlertDialog alert = builder.create();
        alert.show();

    }

    @Override
    public void onClickDialog() {
        //menampilkan keterangan logout sukses
        Toast.makeText(this, "Logout sukses", Toast.LENGTH_SHORT).show();
        //set database logout
        login.setLogin(false);
        //pindah tampilan ke login
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
