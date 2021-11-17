package com.example.ulide2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SpotsMenu extends AppCompatActivity {

    ListView listViewRouteSpots;
    ArrayList<String> spots;
    ArrayAdapter<String> adapterSpots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spots_menu);
        setTitle("Spots");

        listViewRouteSpots = findViewById(R.id.ListViewRouteSpots);


    }
}