package com.example.projectpresensi.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projectpresensi.data.model.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Mahasiswa mahasiswa);

    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    Mahasiswa getSingleData(String nim);

    @Query("SELECT nim FROM mahasiswa")
    List<String> getNim();

}
