package dz.bechar.univtahrimohamed.adminapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list4);

        RecyclerView recyclerView = findViewById(R.id.recycleview4);

        List<Item> items = new ArrayList<Item>();
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("karim bechar", "karim.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("salima bechar", "salima.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("ilham bechar", "ilham.bechar@gmail.com",R.drawable.profile));
        items.add(new Item("allae bechar", "allae.bechar@gmail.com",R.drawable.profile));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));

    }

}