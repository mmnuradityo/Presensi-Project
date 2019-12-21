package com.example.projectpresensi.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.projectpresensi.data.model.Presence;

import java.util.List;

@Dao
public interface PresenceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Presence presence);

    @Query("SELECT * FROM presence WHERE code = :code")
    Presence getSingleData(String code);

    @Query("SELECT code FROM presence WHERE code = :code")
    String getCode(String code);

    @Query("SELECT * FROM presence")
    List<Presence> getAll();

    @Update
    void update(Presence presence);

}
