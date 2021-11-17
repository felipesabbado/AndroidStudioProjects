package com.example.exercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecundaryActivity extends AppCompatActivity {

    private TextView latTextView, lonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);

        // Aceder aos dados enviados
        Intent intent = getIntent();
        String latitude = intent.getStringExtra("Latitude");
        String longitude = intent.getStringExtra("Longitude");

        latTextView = findViewById(R.id.textViewLatitude);
        latTextView.setText(latitude);

        lonTextView = findViewById(R.id.textViewLongitude);
        lonTextView.setText(longitude);
    }
}
