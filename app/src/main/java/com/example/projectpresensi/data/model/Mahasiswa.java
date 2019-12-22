package com.example.projectpresensi.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// class untuk membuat tabel pada database sql
@Entity(tableName = "mahasiswa")
public class Mahasiswa {

    @PrimaryKey(autoGenerate = true) // primary key kolom tabel
    private int id;

    @ColumnInfo(name = "nama") // kolom tabel
    private String nama;

    @ColumnInfo(name = "nim")
    private String nim;

    @ColumnInfo(name = "kelas")
    private String kelas;

    @ColumnInfo(name = "foto")
    private int foto;

    // konstruktor class
    public Mahasiswa(String nama, String nim, String kelas, int foto) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.foto = foto;
    }

    // methode untuk mengambil id
    public int getId() {
        return id;
    }

    // methode untuk set id
    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
