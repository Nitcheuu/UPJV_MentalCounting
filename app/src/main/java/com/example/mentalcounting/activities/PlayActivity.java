package com.example.mentalcounting.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mentalcounting.R;
import com.example.mentalcounting.models.OperationModel;
import com.example.mentalcounting.models.exceptions.DiviseException;
import com.example.mentalcounting.models.exceptions.OperatorException;
import com.example.mentalcounting.models.exceptions.ResultException;
import com.example.mentalcounting.outils.GenerationService;
import com.example.mentalcounting.outils.OperationsService;
import com.example.mentalcounting.outils.ResolutionService;
import com.example.mentalcounting.outils.Statistiques;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private final String[] operateurs = {"+", "-", "x", "/"};
    private int bonne_reponse;
    private OperationModel operation;
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
        button.setOnClickListener(view -> {
            try {
                envoyerResultat();
            } catch (OperatorException e) {
                e.printStackTrace();
            } catch (ResultException e) {
                e.printStackTrace();
            } catch (DiviseException e) {
                e.printStackTrace();
            }
        });
        try {
            this.nouveauCalcul();
        } catch (OperatorException e) {
            e.printStackTrace();
        } catch (ResultException e) {
            e.printStackTrace();
        } catch (DiviseException e) {
            e.printStackTrace();
        }

    }

    protected void nouveauCalcul() throws OperatorException, ResultException, DiviseException {

        this.operation = new GenerationService().generation_facile();

        String affichage = getString(R.string.operation_text, this.operation.getFirstValue(), this.operation.getOperator(), this.operation.getSecondValue());
        // Récupération du textView qui affiche le calcul
        TextView calcul = findViewById(R.id.text_calcul);
        // Changement du texte
        calcul.setText(affichage);
        // Changement de la visibilité
        calcul.setVisibility(View.VISIBLE);
        // Calcul de la bonne réponse
        //this.calculerBonneReponse(nombre_a, nombre_b, this.operateurs[nombre_operateur]);
        this.bonne_reponse = new OperationsService().computeResult(this.operation);
    }

    protected void changerLesTextes(int visibilite_bon, int visibilite_mauvais){
        TextView resultat_bon = findViewById(R.id.resultat_bon);
        resultat_bon.setVisibility(visibilite_bon);
        String affichage = getString(R.string.right_answer, String.valueOf(this.bonne_reponse));
        resultat_bon.setText(affichage);
        TextView resultat_faux = findViewById(R.id.resultat_faux);
        resultat_faux.setVisibility(visibilite_mauvais);
        affichage = getString(R.string.wrong_answer, String.valueOf(this.bonne_reponse));
        resultat_faux.setText(affichage);
        if(visibilite_bon == View.VISIBLE)
            Statistiques.addBonnes_reponses(1);
    }

    protected void afficherErreurEmpty(){
        TextView resultat_bon = findViewById(R.id.resultat_bon);
        resultat_bon.setVisibility(View.GONE);
        TextView erreur_empty = findViewById(R.id.resultat_faux);
        erreur_empty.setVisibility(View.VISIBLE);
        erreur_empty.setText(R.string.empty_error);
    }

    protected void envoyerResultat() throws OperatorException, ResultException, DiviseException {
        EditText resultat_utilisateur = findViewById(R.id.resultat_utilisateur);
        String resultat = resultat_utilisateur.getText().toString();
        if (resultat.isEmpty()){
            this.afficherErreurEmpty();
        }
        else{
            if (ResolutionService.verifierResultat(this.operation, resultat)){
                this.changerLesTextes(View.VISIBLE, View.GONE);
            }else{
                this.changerLesTextes(View.GONE, View.VISIBLE);
            }
            resultat_utilisateur.getText().clear();
            Statistiques.addCompteur(1);
            this.nouveauCalcul();
        }

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
                // On reset les stats
                Statistiques.reset();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }


}