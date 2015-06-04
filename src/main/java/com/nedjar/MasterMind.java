package com.nedjar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 */
public class MasterMind extends JFrame {

    private static final int NB_RANGEES = 8;
    private static final int NB_PIONS_PAR_RANGEES = 4;

    private Plateau plateau = new Plateau(NB_RANGEES, NB_PIONS_PAR_RANGEES);
    private Combinaison combinaisonSecrète;
    private Rangée rangée;


    private MasterMind() {
        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("MasterMind");
        setLayout(new BorderLayout());

        setJMenuBar(barreDeMenus());

        add(creerPanelCombinaisonSecrète(), BorderLayout.NORTH);
        add(plateau, BorderLayout.CENTER);
        add(creerPanelValidationRangéeCourante(), BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MasterMind();
    }

    private JPanel creerPanelCombinaisonSecrète() {
        JPanel panelCombinaisonSecrète = new JPanel();
        rangée = new Rangée(NB_PIONS_PAR_RANGEES);

        combinaisonSecrète = Combinaison.genererCombinaisonAléatoire(NB_PIONS_PAR_RANGEES);
        rangée.setCombinaison(combinaisonSecrète);

        panelCombinaisonSecrète.add(rangée);
        return panelCombinaisonSecrète;
    }

    private void afficherDialogFinDePartie() {
        String messageFinDePartie;
        if (plateau.aGagné())
            messageFinDePartie = "Vous avez trouvez la bonne combinaison en " + plateau.nombreDeCoupsJoués() + " coups";
        else
            messageFinDePartie = "Vous avez perdu !";

        JOptionPane.showMessageDialog(this, messageFinDePartie);
    }

    private JPanel creerPanelValidationRangéeCourante() {
        JPanel panelValidationRangéeCourante = new JPanel();
        JButton boutonEffacer = new JButton("Effacer");
        boutonEffacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateau.viderRangéeCourante();
            }
        });


        JButton boutonValider = new JButton("Valider");
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plateau.validerRangéeCourante(combinaisonSecrète);
                if (plateau.estFinDePartie()) {
                    afficherDialogFinDePartie();
                }
            }
        });

        panelValidationRangéeCourante.add(boutonValider);
        panelValidationRangéeCourante.add(boutonEffacer);

        return panelValidationRangéeCourante;
    }

    private JMenuBar barreDeMenus() {
        JMenuBar barre = new JMenuBar();
        barre.add(creerMenuJeu());
        return barre;
    }

    private JMenu creerMenuJeu() {
        JMenu menuJeu = new JMenu("Jeu");
        menuJeu.add(creerMenuJeuNouveau());
        menuJeu.add(creerMenuJeuQuitter());
        return menuJeu;
    }

    private JMenuItem creerMenuJeuNouveau() {
        JMenuItem menu = new JMenuItem("Nouveau");
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionMenuJeuNouveau();
            }
        });
        return menu;
    }

    private JMenuItem creerMenuJeuQuitter() {
        JMenuItem menu = new JMenuItem("Quitter");
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionMenuJeuQuitter();
            }
        });
        return menu;
    }

    private void actionMenuJeuQuitter() {
        if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment quitter ?"))
            System.exit(0);
    }

    private void actionMenuJeuNouveau() {
        combinaisonSecrète = Combinaison.genererCombinaisonAléatoire(NB_PIONS_PAR_RANGEES);
        rangée.setCombinaison(combinaisonSecrète);
        plateau.nouvellePartie();
    }
}
