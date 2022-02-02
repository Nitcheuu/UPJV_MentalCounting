package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class ResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        // Permet de retourner sur l'activité précédente
        Button button = findViewById(R.id.previous_button);
        button.setOnClickListener(view -> finish());

    }



}