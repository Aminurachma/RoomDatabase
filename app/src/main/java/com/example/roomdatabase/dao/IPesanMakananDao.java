package com.example.roomdatabase.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase.database.EntitasMenu;

import java.util.List;

@Dao
public interface IPesanMakananDao {
    @Query("Select * from menu_table")
    LiveData<List<EntitasMenu>> getAllMenu();

    @Insert
    void insert (EntitasMenu menu);

    @Update
    void update (EntitasMenu menu);
}
