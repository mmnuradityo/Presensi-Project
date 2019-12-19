package com.example.projectpresensi.view.activity;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.projectpresensi.R;
import com.example.projectpresensi.view.adapter.ViewPagerAdapter;
import com.example.projectpresensi.view.base.BaseActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends BaseActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private Toolbar toolbar;
    private BottomNavigationView bottomNav;
    private ViewPager viewPager;
    private MenuItem prevMenuItem;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar_main);
        bottomNav = findViewById(R.id.bottom_nav_main);
        viewPager = findViewById(R.id.vp_menu_main);
    }

    @Override
    public void initView() {
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

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

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

            }

        });

    }

    private void viwePager() {

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNav.getMenu().getItem(0).setChecked(false);
                }

                Log.d("page", "onPageSelected: "+position);
                bottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menusetting, menu);
        return  true;

    }

    public boolean onOptionsItemSelected(MenuItem item){

        switch (item.getItemId()){
            case R.id.MenuSetting:
                startActivity(new Intent(this, SettingActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        alertDialogExit();
    }

    private void alertDialogExit()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Apakah anda ingin keluar?");

        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNeutralButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

}
