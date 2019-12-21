package com.example.projectpresensi.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projectpresensi.data.model.Nilai;

import java.util.List;

@Dao
public interface NilaiDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Nilai nilai);

    @Query("SELECT * FROM nilai")
    List<Nilai> getAll();

}
