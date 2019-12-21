package com.example.projectpresensi.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projectpresensi.data.model.Schedule;

import java.util.List;

@Dao
public interface ScheduleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Schedule schedule);

    @Query("SELECT * FROM schedule")
    List<Schedule> getAll();

}
