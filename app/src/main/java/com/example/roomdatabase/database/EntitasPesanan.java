package com.example.roomdatabase.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pesanan_table")
public class EntitasPesanan {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id_pesanan;
    @ColumnInfo(name = "tanggal")
    private String tanggal;
    @ColumnInfo(name = "jam")
    private String jam;
    @ColumnInfo(name = "nomor_meja")
    private String nomorMeja;
    @ColumnInfo(name = "kode_menu")
    private String kodeMenu;
    @ColumnInfo(name = "harga")
    private String harga;
    @ColumnInfo(name = "kode_unik")
    private String kode_unik;

    public int getId_pesanan() {
        return id_pesanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJam() {
        return jam;
    }

    public String getNomorMeja() {
        return nomorMeja;
    }

    public String getKodeMenu() {
        return kodeMenu;
    }

    public String getHarga() {
        return harga;
    }

    public String getKode_unik() {
        return kode_unik;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public void setNomorMeja(String nomorMeja) {
        this.nomorMeja = nomorMeja;
    }

    public void setKodeMenu(String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public void setKode_unik(String kode_unik) {
        this.kode_unik = kode_unik;
    }
}
