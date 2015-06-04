package com.nedjar;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nedjar on 04/06/15.
 */
public class ScoreRangée extends JPanel {
    private final int nombrePionsParRangée;
    private BoutonScore[] scores;

    public ScoreRangée(int nombrePionsParRangée) {
        this.nombrePionsParRangée = nombrePionsParRangée;
        this.scores = new BoutonScore[nombrePionsParRangée];
        this.setLayout(new GridLayout(2, 2));
        for (int i = 0; i < nombrePionsParRangée; i++) {
            scores[i] = new BoutonScore();
            add(scores[i]);
        }
    }

    public void setScore(int nombrePionsBiensPlacés, int nombrePionsMalsPlacés) {
        if (nombrePionsBiensPlacés + nombrePionsMalsPlacés > nombrePionsParRangée)
            throw new RuntimeException("Trop de points marqués");

        for (int i = 0; i < nombrePionsBiensPlacés; i++) {
            scores[i].setScore(Score.BIENPLACE);
        }

        for (int i = nombrePionsBiensPlacés; i < nombrePionsBiensPlacés + nombrePionsMalsPlacés; i++) {
            scores[i].setScore(Score.MALPLACE);
        }
    }

    public void vider() {
        for (BoutonScore score : scores) {
            score.vider();
        }
    }
}
