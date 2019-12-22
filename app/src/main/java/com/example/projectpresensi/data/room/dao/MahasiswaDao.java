package com.example.projectpresensi.data.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.projectpresensi.data.model.Mahasiswa;

import java.util.List;

// class untuk mengakses tabel mahasiswa(Dao = data access object)
@Dao
public interface MahasiswaDao {

    // methode insert data ke tabel mahasiswa
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Mahasiswa mahasiswa);

    // mengambil data berdasarkan nim
    @Query("SELECT * FROM mahasiswa WHERE nim = :nim")
    Mahasiswa getSingleData(String nim);

    // mngambil nim dari tabel
    @Query("SELECT nim FROM mahasiswa")
    List<String> getNim();

}
