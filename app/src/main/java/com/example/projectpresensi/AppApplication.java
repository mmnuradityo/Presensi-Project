package com.example.projectpresensi;

import android.app.Application;

import androidx.room.Room;

import com.example.projectpresensi.data.room.database.AppDataBase;

// class yang memiliki daur hidup berdasar aplikasi
public class AppApplication extends Application {

    public static AppDataBase db; // database sql

    @Override
    public void onCreate() {
        super.onCreate();
        // membangan datase sql
        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "presensidb").allowMainThreadQueries().build();
    }

}
