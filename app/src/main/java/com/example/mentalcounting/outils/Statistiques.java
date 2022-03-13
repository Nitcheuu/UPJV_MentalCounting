package com.example.mentalcounting.outils;

public class Statistiques {


    private static int compteur = 0;
    private static int bonnes_reponses = 0;

    public static int getCompteur() {
        return compteur;
    }

    public static void addCompteur(int compteur) {
        Statistiques.compteur += compteur;
    }

    public static int getBonnes_reponses() {
        return bonnes_reponses;
    }

    public static void addBonnes_reponses(int bonnes_reponses) {
        Statistiques.bonnes_reponses += bonnes_reponses;
    }

    public static void reset(){
        Statistiques.bonnes_reponses = 0;
        Statistiques.compteur = 0;
    }
}
