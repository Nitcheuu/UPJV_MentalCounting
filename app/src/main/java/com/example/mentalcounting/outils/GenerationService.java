package com.example.mentalcounting.outils;

import com.example.mentalcounting.models.OperationModel;

import java.util.Random;

public class GenerationService {

    private final String[] operateurs = {"+", "-", "x", "/"};

    public OperationModel generation_facile(){

        // Génération des nombres
        int nombre_a = new Random().nextInt(100);
        int nombre_b = new Random().nextInt(100);
        int nombre_operateur = new Random().nextInt(2);
        String operateur = "";

        // Multiplication par un facteur inférieur ou égal à 10
        if (nombre_a <= 10){
            operateur = "x";
        // Division par 1 ou 2
        }else if (nombre_b <= 2 && nombre_a%2 == 0){
            operateur = "/";
        // Sinon addition ou soustraction
        }else{
            operateur = this.operateurs[nombre_operateur];
        }

        return  new OperationModel(
                String.valueOf(nombre_a),
                String.valueOf(nombre_b),
                operateur
        );
    }
}
