package com.example.projectpresensi.data.repository;

import com.example.projectpresensi.data.model.Mahasiswa;
import com.example.projectpresensi.data.model.Nilai;
import com.example.projectpresensi.data.model.Presence;
import com.example.projectpresensi.data.model.Schedule;

import java.util.ArrayList;
import java.util.List;

// class untuk membuat data default
public class DefaultDataEntities {

    private static List<Mahasiswa> listMahasiswa = new ArrayList<>();
    private static List<Presence> listPresence = new ArrayList<>();
    private static List<Schedule> listSchedule = new ArrayList<>();
    private static List<Nilai> listNilai = new ArrayList<>();

    public static List<Mahasiswa> getDefaultMahasiswa() {
        listMahasiswa.add(new Mahasiswa("Abdul Firdaus", "17.12.0210", "S1 - Sistem Informasi - 04", 1));
        listMahasiswa.add(new Mahasiswa("Nuraeni Novianti", "17.12.0216", "S1 - Sistem Informasi - 04", 2));
        listMahasiswa.add(new Mahasiswa("Dharmasyah agus.png Prasetyo", "17.12.0228", "S1 - Sistem Informasi - 04", 3));
        return listMahasiswa;
    }

    public static List<Presence> getDefaultPresence() {
        listPresence.add(new Presence("Pemrograman Client Server", 7, "pP00Q27"));
        listPresence.add(new Presence("Metodologi Penelitian", 7, "Ah78Jk0l"));
        listPresence.add(new Presence("Rekayasa Perangkat Lunak", 7, "zXDC023"));
        listPresence.add(new Presence("E-Business", 5, "09HJK4m"));
        listPresence.add(new Presence("Manajemen Strategik", 6, "09HJK4m"));
        listPresence.add(new Presence("Tugas Proyek Media Interaktif", 10, "8jYX095"));
        listPresence.add(new Presence("Keamanan Komputer", 7, "90HRvv6"));
        listPresence.add(new Presence("Menejemen Sains", 4, "ty768IB"));
        return listPresence;
    }

    public static List<Schedule> getDefaultSchedule() {
        listSchedule.add(new Schedule(
                "Senin",
                "Pemrograman Client Server",
                "13.20 - 15.00",
                "L 2.4.2",
                "Ikmah,M.Kom"));
        listSchedule.add(new Schedule(
                "Selasa",
                "Metodologi Penelitian",
                "10.40 - 12.20",
                "04.03.01",
                "Rum Mohammad Andri Kr, Ir, M.kom"));
        listSchedule.add(new Schedule(
                "Selasa",
                "Rekayasa Perangkat Lunak",
                "13.20 - 15.00",
                "05.03.02",
                "Supriatin, M.kom"));
        listSchedule.add(new Schedule(
                "Rabu",
                "E-Business",
                "07.00 - 08.40",
                "04.02.05",
                "Nur Widiati, M.kom"));
        listSchedule.add(new Schedule(
                "Rabu",
                "Manajemen Strategik",
                "10.40 - 12.20",
                "05.03.08",
                "Nurhayanto, SE, MBA"));
        listSchedule.add(new Schedule(
                "Rabu",
                "Tugas Proyek Media Interaktif",
                "15.30 - 17.10",
                "05.04.02",
                "Ika Asti Atuti, S.Kom, M.Kom"));
        listSchedule.add(new Schedule(
                "Kamis",
                "Keamanan Komputer",
                "07.00 - 08.40",
                "05.02.01",
                "Toto Indriyatmoko, M.Kom"));
        listSchedule.add(new Schedule(
                "Kamis",
                "Rekayasa Perangkat Lunak",
                "08.50 - 10.30",
                "05.02.08",
                "Supriatin, M.Kom"));
        listSchedule.add(new Schedule(
                "Kamis",
                "Tugas Proyek Media Interaktif",
                "10.40 - 12.20",
                "05.04.08",
                "Ika Asti Atuti, S.Kom, M.Kom"));
        listSchedule.add(new Schedule(
                "Kamis",
                "Menejemen Sains",
                "10.40 - 12.20",
                "05.04.08",
                "Nurhayanto, SE, MBA"));
        return listSchedule;
    }

    public static List<Nilai> getDefaultNilai() {
        listNilai.add(new Nilai("SS001", "Pemrograman Client Server", "W", "2", "A"));
        listNilai.add(new Nilai("SS002", "Metodologi Penelitian", "W", "2", "A"));
        listNilai.add(new Nilai("SS032", "Rekayasa Perangkat Lunak", "W", "2", "A"));
        listNilai.add(new Nilai("SS016", "E-Business", "W", "2", "B"));
        listNilai.add(new Nilai("SS004", "Manajemen Strategik", "W", "2", "A"));
        listNilai.add(new Nilai("SS008", "Tugas Proyek Media Interaktif", "W", "4", "B"));
        listNilai.add(new Nilai("SS024", "Keamanan Komputer", "K", "2", "A"));
        listNilai.add(new Nilai("SS013", "Menejemen Sains", "K", "2", "B"));
        return listNilai;
    }

}
