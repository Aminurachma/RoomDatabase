package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.roomdatabase.adapters.MenuAdapter;
import com.example.roomdatabase.database.EntitasMenu;
import com.example.roomdatabase.viewModel.PesananViewModel;

import java.net.ContentHandler;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PesananViewModel pesananViewModel;
    RecyclerView rvMenu;
    RecyclerView.LayoutManager layoutManager;


    List<EntitasMenu> entitasMenus = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMenu = findViewById(R.id.recyclerMenu);





        pesananViewModel = ViewModelProviders.of(this).get(PesananViewModel.class);
        pesananViewModel.insertMenu(new EntitasMenu("B01","Minuman Kopi enak Rp. 5000","Kopi Pahit"));
        pesananViewModel.insertMenu(new EntitasMenu("B05","Minuman Teh enak Rp. 5000","Teh Manis"));
        pesananViewModel.insertMenu(new EntitasMenu("B06","Minuman Es Jeruk enak Rp. 5000","Es Jeruk"));
        pesananViewModel.insertMenu(new EntitasMenu("B07","Minuman Millo enak Rp. 5000","Millo"));
        pesananViewModel.insertMenu(new EntitasMenu("B08","Minuman Sirup enak Rp. 5000","Sirup"));
        //pesananViewModel.updateMenu(new EntitasMenu("B04","ini penjelasana","oofaepucino"));
        pesananViewModel.getAllMenu().observe(this, new Observer<List<EntitasMenu>>() {
            @Override
            public void onChanged(List<EntitasMenu> entitasMenus) {

                MenuAdapter menuAdapter = new MenuAdapter(entitasMenus);
                layoutManager = new LinearLayoutManager(getApplicationContext());





                
                rvMenu.setAdapter(menuAdapter);
                rvMenu.setLayoutManager(layoutManager);
//                Log.i("hasil", entitasMenus.toString());
            }
        });
    }

    public void clickGetStarted(View view) {
            Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
    }
}
