package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roomdatabase.dao.IPesanMakananDao;
import com.example.roomdatabase.database.EntitasMenu;
import com.example.roomdatabase.database.EntitasPesanan;

@Database(entities = {EntitasMenu.class, EntitasPesanan.class},version = 1, exportSchema = false)
public abstract class BuilderRoomDatabase extends RoomDatabase {
    private static BuilderRoomDatabase Instance;
    private static String Database_Name = "bmi_database";
    public abstract IPesanMakananDao pesananDao();

    //Todo 8 add function to create database
    public static BuilderRoomDatabase getDatabase(final Context context){
        if (Instance == null){
            synchronized (BuilderRoomDatabase.class){
                if (Instance == null){
                    Instance = Room.databaseBuilder(context.getApplicationContext(),
                            BuilderRoomDatabase.class, Database_Name)
                            .build();
                }
            }
        }
        return Instance;
    }
}
