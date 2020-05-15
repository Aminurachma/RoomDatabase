package com.example.roomdatabase.viewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roomdatabase.PesananRepository;
import com.example.roomdatabase.database.EntitasMenu;

import java.util.List;

public class PesananViewModel extends AndroidViewModel {

    private PesananRepository pesananRepository;
    LiveData<List<EntitasMenu>> listAllMenu;

    public PesananViewModel(Application application) {
        super(application);
        pesananRepository = new PesananRepository(application);
        listAllMenu = pesananRepository.getAllMenu();
    }

    public LiveData<List<EntitasMenu>> getAllMenu (){
        return  listAllMenu;
    }
    public Long insertMenu(EntitasMenu menuInput){
        pesananRepository.insertMenu(menuInput);
        return null;
    }
  //  public void updateMenu(EntitasMenu menuInput){
    //    pesananRepository.updateMenu(menuInput);
    //}
}
