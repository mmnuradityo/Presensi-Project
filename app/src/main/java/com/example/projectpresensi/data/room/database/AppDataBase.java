package com.example.projectpresensi.data.room.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.projectpresensi.data.model.Mahasiswa;
import com.example.projectpresensi.data.model.Presence;
import com.example.projectpresensi.data.model.Schedule;
import com.example.projectpresensi.data.room.dao.MahasiswaDao;
import com.example.projectpresensi.data.room.dao.PresenceDao;
import com.example.projectpresensi.data.room.dao.ScheduleDao;

@Database(entities = {Mahasiswa.class, Presence.class, Schedule.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract MahasiswaDao mahasiswaDao();

    public abstract PresenceDao presenceDao();

    public abstract ScheduleDao scheduleDao();
}