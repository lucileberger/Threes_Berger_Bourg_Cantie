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
    boolean etat;
    int largeur;
    int longueur;
    
    /**
     * 
     * @param larg
     * @param longu
     */
    public Cellule(int larg, int longu){
        Random nombre = new Random();
        valeur = nombre.nextInt(4);
        if (valeur==0){
            etat=false;
        } else {
            etat=true;
        }
        largeur = larg;
        longueur = longu;
    }

    /**
     * Cette fonction permet d'afficher une valeur de départ sur une case
     * Si la valeur est entre 1 et 3, on affiche la valeur sinon on laisse la case vide.
     * @return
     */
    @Override 
    public String toString () {
        if (etat==true){
            if (valeur==1){
                return "1";
            } else if (valeur==2){
                return "2";
            } else if (valeur==3){
                return "3";
            }
        }
        return null;
    }
}
