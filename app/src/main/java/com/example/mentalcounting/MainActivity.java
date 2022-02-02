package com.example.mentalcounting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Associer une action au bouton play

        associateOpenActivityToButton(R.id.play_button, PlayActivity.class);

        // Associer une action au bouton resultat

        associateOpenActivityToButton(R.id.res_button, ResActivity.class);

    }

    private void associateOpenActivityToButton(int id, Class activity){
        Button button = findViewById(id);
        button.setOnClickListener(view -> openActivity(activity));
    }

    private void openActivity(Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

}