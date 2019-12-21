package com.example.projectpresensi.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "schedule")
public class Schedule {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "hari")
    private String hari;

    @ColumnInfo(name = "makul")
    private String makul;

    @ColumnInfo(name = "jam")
    private String jam;

    @ColumnInfo(name = "ruang")
    private String ruang;

    @ColumnInfo(name = "dosen")
    private String dosen;

    public Schedule(String hari, String makul, String jam, String ruang, String dosen) {
        this.hari = hari;
        this.makul = makul;
        this.jam = jam;
        this.ruang = ruang;
        this.dosen = dosen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

}
