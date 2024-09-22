package com.example.tugaspam4;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    KontakAdapter kontakRecyclerAdapter;
    ArrayList<Kontak> _kontakList;
    Button btnAddData;
    int[] foto ={R.drawable.avatar1,R.drawable.avatar2,R.drawable.avatar3,R.drawable.avatar4,R.drawable.avatar5,R.drawable.avatar6};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAddData = findViewById(R.id.id_btnAddData);
        btnAddData.setOnClickListener(v -> {
            addData();
            kontakRecyclerAdapter.notifyDataSetChanged();
        });

        loadData();  // Memuat data awal
        initRecycleView();  // Inisialisasi RecyclerView
    }

    private void initRecycleView(){
        recyclerView = findViewById(R.id.id_rvKontak);
        kontakRecyclerAdapter = new KontakAdapter(_kontakList, this);
        recyclerView.setAdapter(kontakRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void addData(){
        Random ran = new Random();
        int choose = ran.nextInt(6);
        _kontakList.add(new Kontak("newData" + (_kontakList.size()), "081234294677" + (_kontakList.size()), foto[choose]));
    }

    private void loadData(){
        _kontakList = new ArrayList<>();
        _kontakList.add(new Kontak("Vincentius", "081234567890", foto[0]));
        _kontakList.add(new Kontak("Fadhly", "085648640046", foto[1]));
        _kontakList.add(new Kontak("Owen", "085648640047", foto[2]));
        _kontakList.add(new Kontak("Jul", "082134567891", foto[3]));
        _kontakList.add(new Kontak("Ahmad", "083234567892", foto[4]));
        _kontakList.add(new Kontak("Ruben", "084234567893", foto[5]));
    }

}