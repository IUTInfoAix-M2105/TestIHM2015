package com.nedjar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nedjar on 04/06/15.
 */
public class BoutonPion extends JButton {
    private Pion pion;
    private final ActionListener boutonPionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setPion(pion.suivant());
        }
    };

    public BoutonPion() {
        vider();
        addActionListener(boutonPionListener);
        setEnabled(false);
    }

    public void vider() {
        setPion(Pion.VIDE);
    }

    public Pion getPion() {
        return pion;
    }

    void setPion(Pion pion) {
        this.pion = pion;
        setIcon(pion.getIcon());
        setDisabledIcon(pion.getIcon());
    }
}
