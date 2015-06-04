package com.nedjar;

import javax.swing.*;

/**
 * Created by nedjar on 04/06/15.
 */
public class BoutonScore extends JButton {

    private Score score;

    public BoutonScore() {
        vider();
        setEnabled(false);
    }

    void setScore(Score score) {
        this.score = score;
        setIcon(score.getIcon());
        setDisabledIcon(score.getIcon());
    }

    public void vider() {
        setScore(Score.VIDE);
    }
}
