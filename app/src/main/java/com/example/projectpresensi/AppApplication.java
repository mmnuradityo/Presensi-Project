package com.example.projectpresensi;

import android.app.Application;

import androidx.room.Room;

import com.example.projectpresensi.data.room.database.AppDataBase;

public class AppApplication extends Application {

    public static AppDataBase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "presensidb").allowMainThreadQueries().build();
    }

}
