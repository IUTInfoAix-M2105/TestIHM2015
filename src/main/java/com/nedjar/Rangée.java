package com.nedjar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nedjar on 04/06/15.
 */
public class Rangée extends JPanel {
    private final int nombrePionsParRangée;
    private BoutonPion[] pions;

    public Rangée(int nombrePionsParRangée) {
        this.nombrePionsParRangée = nombrePionsParRangée;
        this.pions = new BoutonPion[nombrePionsParRangée];
        this.setLayout(new GridLayout(1, nombrePionsParRangée, 0, 0));
        for (int i = 0; i < pions.length; i++) {
            pions[i] = new BoutonPion();
            add(pions[i]);
        }
    }

    public Combinaison getCombinaison() {
        Combinaison combinaison = new Combinaison(nombrePionsParRangée);
        for (int i = 0; i < pions.length; i++) {
            combinaison.setPion(i, pions[i].getPion());
        }
        return combinaison;
    }

    public void setCombinaison(Combinaison combinaison) {
        for (int i = 0; i < pions.length; i++) {
            pions[i].setPion(combinaison.getPion(i));
        }
    }

    public void setEnabled(boolean enabled) {
        for (BoutonPion pion : pions) {
            pion.setEnabled(enabled);
        }
    }

    public void setMasqué(boolean masqué) {
        for (BoutonPion pion : pions) {
            pion.setMasqué(masqué);
        }
    }

    public void vider() {
        for (BoutonPion pion : pions) {
            pion.vider();
        }
    }
}
