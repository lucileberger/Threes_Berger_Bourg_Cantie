/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 28/11/2023
 */
package threes_jeu;

/**
 *
 * @author Emilie
 */
public class Grille {
    Cellule[][] matriceCellules;
    int nbLignes;
    int nbColonnes;
    
    /**
     * Permet de créer la grille avec le nombre de
     * colonnes et de lignes voulues et ajoute 
     * une cellule dans chaque case 
     * @param ligne nombre de lignes voulues
     * @param colo nombre de colonnes voulues
     */
    public Grille (int ligne, int colo){
    nbLignes=ligne;
    nbColonnes=colo;
    matriceCellules=new Cellule[nbLignes][nbColonnes];
    for (int i=0; i<nbLignes; i++){
        for (int j=0;j<nbColonnes;j++){
            matriceCellules[i][j]= new Cellule(36,36);
        }
    }
}
}
