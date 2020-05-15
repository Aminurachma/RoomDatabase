package com.example.roomdatabase.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "menu_table")
public class EntitasMenu {
    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "kode_menu")
    private String kodeMenu;
    @ColumnInfo(name = "penjelasan")
    private String penjelasan;
    @ColumnInfo(name = "nama_makanan")
    private String namaMakanan;

    public EntitasMenu(@NonNull String kodeMenu, String penjelasan, String namaMakanan) {
        this.kodeMenu = kodeMenu;
        this.penjelasan = penjelasan;
        this.namaMakanan = namaMakanan;
    }

    @NonNull
    public String getKodeMenu() {
        return kodeMenu;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setKodeMenu(@NonNull String kodeMenu) {
        this.kodeMenu = kodeMenu;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }
}
