package com.example.projectpresensi.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "presence")
public class Presence {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "makul")
    private String makul;

    @ColumnInfo(name = "presensi")
    private int presensi;

    @ColumnInfo(name = "code")
    private String code;


    public Presence(String makul, int presensi, String code) {
        this.makul = makul;
        this.presensi = presensi;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public int getPresensi() {
        return presensi;
    }

    public void setPresensi(int presensi) {
        this.presensi = presensi;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
