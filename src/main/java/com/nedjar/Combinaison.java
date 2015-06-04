package com.nedjar;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by nedjar on 04/06/15.
 */
public class Combinaison {
    private final int nombrePionsParRangée;
    private Pion[] pions;

    public Combinaison(int nombrePionsParRangée) {
        this.nombrePionsParRangée = nombrePionsParRangée;
        this.pions = new Pion[nombrePionsParRangée];
        for (int i = 0; i < pions.length; i++) {
            pions[i] = Pion.VIDE;
        }
    }

    public static Combinaison genererCombinaisonAléatoire(int nombrePionsParRangée) {
        Combinaison combinaison = new Combinaison(nombrePionsParRangée);
        Random random = new Random();
        for (int i = 0; i < nombrePionsParRangée; i++) {
            while (combinaison.pions[i] == Pion.VIDE) {
                int indicePion = random.nextInt(nombrePionsParRangée);
                combinaison.pions[i] = Pion.values()[indicePion];
            }
        }
        return combinaison;
    }

    public boolean contient(Pion pion) {
        return Arrays.asList(pions).contains(pion);
    }

    public Pion getPion(int i) {
        return pions[i];
    }

    public void setPion(int i, Pion pion) {
        pions[i] = pion;
    }

    public int nombrePions() {
        return pions.length;
    }
}
