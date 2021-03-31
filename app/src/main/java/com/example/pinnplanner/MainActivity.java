package com.example.pinnplanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<task> tasksList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        tasksList = new ArrayList<>();

        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        setDummyTaskInfo();
        setAdapter();
    }

    private void setAdapter() {
        recyclerAdapter adapter = new recyclerAdapter(tasksList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setDummyTaskInfo() {
        tasksList.add(new task("Tugas PPB","Tugas mockup dan deskripsi solusi","Due Today","10.00 pm"));
        tasksList.add(new task("Tugas PPL","Deskripsi","Due Tomorrow","10.00 pm"));
        tasksList.add(new task("Tugas StatProb","Deskripsi","Due 3 April 2021","07.00 pm"));
        tasksList.add(new task("Koding tugas PHP","latihan 14","Due 7 April 2021","05.00 pm"));
        tasksList.add(new task("Tugas APSI","Deskripsi","Due 7 April 2021","12.00 pm"));
        tasksList.add(new task("Tugas Pkn","Deskripsi","Due 10 April 2021","07.00 pm"));
    }
}