/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 28/11/2023
 */
package threes_jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
    
    /**
     * Cette fonction crée une cellule de dimension defini en paramètre
     * La valeur initiale dans la cellule est aléatoire entre 0 et 3
     * cependant si la valeur aléatoire est 0, la cellule reste vide.
     * @param larg
     * @param longu
     */
    public Cellule(int larg, int longu){
        Random nombre = new Random();
        valeur = nombre.nextInt(4);
        largeur = larg;
        longueur = longu;
        
        this.setBackground(new Color(222, 140, 194));

       
   
    Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 15); 
    this.setFont(font);
    this.setForeground(Color.DARK_GRAY);
       
    }

    public int getValeur() {
        return valeur;
    }
    
    /**
     * Cette fonction permet d'afficher une valeur de départ sur une cellule
     * Si la valeur est entre 1 et 3, on affiche la valeur sinon on laisse la case vide.
     * @return
     */
    @Override 
    public String toString () {    
            if (valeur!=0){
                return String.valueOf(valeur);
            }
        return " ";
    }

    public String toString2 () {
            if (valeur!=0){
                return String.valueOf(valeur);
            }
        
        return "0";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        this.setText(toString());
    
    }
    
    
    
}
