package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;

import androidx.lifecycle.LiveData;

import com.example.roomdatabase.dao.IPesanMakananDao;
import com.example.roomdatabase.database.EntitasMenu;
import com.example.roomdatabase.database.EntitasPesanan;

import java.util.List;

public class PesananRepository {

    private IPesanMakananDao makananDao;
    private LiveData<List<EntitasMenu>> listMenu;
    private LiveData<List<EntitasPesanan>> listPesanan;

    public PesananRepository(Application application) {
        BuilderRoomDatabase buildDatabase =
                BuilderRoomDatabase.getDatabase(application);
        makananDao =  buildDatabase.pesananDao();
        listMenu = makananDao.getAllMenu();
    }

    public  LiveData<List<EntitasMenu>> getAllMenu (){
        return listMenu;
    }


    public   void insertMenu(EntitasMenu menu){
        new AsyncInsertMenu(makananDao).execute(menu);
    }

    //public   void updateMenu(EntitasMenu menu){
      //  new AsyncUpdateMenu(makananDao).execute(menu);
    //}

    private static class AsyncInsertMenu extends AsyncTask<EntitasMenu, Void, Void>{
        IPesanMakananDao asyncMakananDao;

        public AsyncInsertMenu(IPesanMakananDao asyncMakananDao) {
            this.asyncMakananDao = asyncMakananDao;
        }

        @Override
        protected Void doInBackground(EntitasMenu... entitasMenus) {
            asyncMakananDao.insert(entitasMenus[0]);
            asyncMakananDao.update(entitasMenus[0]);
            return null;
        }

    }

}
