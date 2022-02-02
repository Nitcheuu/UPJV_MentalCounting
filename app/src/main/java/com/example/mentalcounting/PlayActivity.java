package com.example.mentalcounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity {

    /**
     * Appelée au démarrage de l'acitivité
     * @param savedInstanceState : paramètre par défault
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        // Association du bouton submit à une fonction qui
        // envoie le résultat et vérifie si il et correct
        // ou non
        Button button = findViewById(R.id.submit_res_button);
        button.setOnClickListener(view -> sendResult());
    }

    /**
     * Appelée au chargement du menu
     * @param menu : Menu que l'on charge sur l'activité
     *               ici le nav_menu
     * @return : Bool
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Association avec le nav_menu
        MenuInflater menuInflater =  getMenuInflater();
        menuInflater.inflate(R.menu.nav_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Appelée quand un élément du menu est cliqué
     * @param item : Item qui du menu qui a été cliqué
     * @return : Bool
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        // Récupération de l'id de l'élément cliqué
        int id = item.getItemId();

        // Les différennts cas envisageable
        switch (id){
            case R.id.main_menu_button:
                // Si l'utilisateur veut retourner au menu
                // principal, il suffit de kill l'activité
                finish();
                break;
            case R.id.reset_menu_button:
                // Fonction qui nettoie la BDD
                break;
        }
        return  super.onOptionsItemSelected(item);
    }



    private void sendResult(){
        // Fonction qui permettra de soumettre son calcul
    }

}