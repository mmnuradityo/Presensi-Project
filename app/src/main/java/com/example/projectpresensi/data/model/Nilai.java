package com.example.projectpresensi.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Nilai")
public class Nilai {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "kode")
    private String kode;

    @ColumnInfo(name = "makul")
    private String makul;

    @ColumnInfo(name = "sifat")
    private String sifat;

    @ColumnInfo(name = "sks")
    private String sks;

    @ColumnInfo(name = "nilai")
    private String nilai;

    public Nilai(String kode, String makul, String sifat, String sks, String nilai) {
        this.kode = kode;
        this.makul = makul;
        this.sifat = sifat;
        this.sks = sks;
        this.nilai = nilai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getSifat() {
        return sifat;
    }

    public void setSifat(String sifat) {
        this.sifat = sifat;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
