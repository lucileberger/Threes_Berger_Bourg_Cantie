/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * Class cellule: Initialise les cellules et leur donne attributs et méthodes
 * 23/12/2023
 */
package threes_jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JButton;

/**
 * Class cellule avec ses attributs
 * @author Emilie
 */
public class Cellule extends JButton {
    int valeur;
    int largeur;
    int longueur;

    /**
     * Cette fonction crée une cellule de dimension defini en paramètre La
     * valeur initiale dans la cellule est aléatoire entre 0 et 3
     * @param larg
     * @param longu
     */
    public Cellule(int larg, int longu) {
        Random nombre = new Random();
        valeur = nombre.nextInt(4);
        largeur = larg;
        longueur = longu;
        this.setBackground(new Color(222, 140, 194));
        Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
        this.setFont(font);
        this.setForeground(new Color(255, 255, 255));
    }
    public int getValeur() {
        return valeur;
    }

    /**
     * Cette methode permet d'afficher la valeur d'une cellule, si sa valeur est
     * 0, alors elle affiche une case vide.
     * @return la valeur en string ou un espace (rien) si c'est une valeur de 0
     */
    @Override
    public String toString() {
        if (valeur != 0) {
            return String.valueOf(valeur);
        }
        return " ";
    }

    /**
     * Permet d'afficher la cellule en fonction de sa valeur
     * @return la valeur de la cellule
     */
    public String toString2() {
        if (valeur != 0) {
            return String.valueOf(valeur);
        }
        return "0";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (valeur == 0) {
            setBackground(Color.WHITE);
        } else {
            switch (valeur) {
                case 1:
                    setBackground(new Color(229, 156, 156));
                    break;
                case 2:
                    setBackground(new Color(229, 156, 163));
                    break;
                case 3:
                    setBackground(new Color(229, 156, 200));
                    break;
                case 6:
                    setBackground(new Color(222, 156, 229));
                    break;
                case 12:
                    setBackground(new Color(213, 119, 213));
                    break;
                case 24:
                    setBackground(new Color(151, 63, 116));
                    break;
                case 48:
                    setBackground(new Color(142, 63, 151));
                    break;

            }

            this.setText(toString());
        }
    }
}
