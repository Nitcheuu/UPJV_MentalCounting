package com.example.mentalcounting.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mentalcounting.outils.Statistiques;

import com.example.mentalcounting.R;

public class ResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);

        // Permet de retourner sur l'activité précédente
        Button button = findViewById(R.id.previous_button);
        button.setOnClickListener(view -> finish());

        TextView bonnes_reponses = findViewById(R.id.res_correcte);
        bonnes_reponses.setText(Statistiques.getBonnes_reponses() + " bons");

        TextView essais = findViewById(R.id.res_essais);
        essais.setText(Statistiques.getCompteur() + " bons");

    }



}