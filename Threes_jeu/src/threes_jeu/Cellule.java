/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 28/11/2023
 */
package threes_jeu;

import java.util.Random;
import javax.swing.JButton;

/**
 *
 * @author Emilie
 */
public class Cellule extends JButton{
    int valeur;
    int largeur;
    int longueur;
    

    public Cellule(int larg, int longu){
        Random nombre = new Random();
        valeur = nombre.nextInt(4);
        largeur = larg;
        longueur = longu;
    }
    
}
