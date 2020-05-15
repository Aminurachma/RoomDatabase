package com.example.roomdatabase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.roomdatabase.R;
import com.example.roomdatabase.database.EntitasMenu;
import com.example.roomdatabase.models.Menu;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MyViewHolder> {
    List<EntitasMenu> entitasMenu;

    public MenuAdapter(List<EntitasMenu> entitasMenus) {
        this.entitasMenu = entitasMenus;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View menuView = layoutInflater.inflate(R.layout.item_menu,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MyViewHolder holder, int position) {
        //ambil satu item hero
        EntitasMenu menu = entitasMenu.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.menuName.setText(menu.getNamaMakanan());
        holder.menuPenjelas.setText(menu.getPenjelasan());

    }

    @Override
    public int getItemCount(){
        return entitasMenu.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView menuName, menuPenjelas;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menuName = itemView.findViewById(R.id.menuNama);
            menuPenjelas = itemView.findViewById(R.id.menuPenjelasan);
        }
    }
}