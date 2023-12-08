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
    Cellule[][] grillecellule;
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
    grillecellule=new Cellule[nbLignes][nbColonnes];
    for (int i=0; i<nbLignes; i++){
        for (int j=0;j<nbColonnes;j++){
            grillecellule[i][j]= new Cellule(40,40);
        }
    }
}
    public void deplacementgauche(){
    for (int i=0; i<nbColonnes; i++){
        for (int j=0;j<nbLignes;j++){
            if (grillecellule[i-1][j].valeur==0) {
                grillecellule[i-1][j].valeur = grillecellule[i][j].valeur;
            } else if (grillecellule[i-1][j].valeur==grillecellule[i][j].valeur && grillecellule[i][j].valeur!=1 && grillecellule[i][j].valeur!=2){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            } else if (grillecellule[i][j].valeur==1 && grillecellule[i-1][j].valeur==2){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            } else if (grillecellule[i][j].valeur==2 && grillecellule[i-1][j].valeur==1){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
                    }
        }
    }
    }
    public void deplacementdroite(){
    for (int i=0; i<nbColonnes; i++){
        for (int j=0;j<nbLignes;j++){
            if (grillecellule[i-1][j].valeur==0) {
                grillecellule[i-1][j].valeur = grillecellule[i][j].valeur;
            } else if (grillecellule[i-1][j].valeur==grillecellule[i][j].valeur && grillecellule[i][j].valeur!=1 && grillecellule[i][j].valeur!=2){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            } else if (grillecellule[i][j].valeur==1 && grillecellule[i-1][j].valeur==2){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            } else if (grillecellule[i][j].valeur==2 && grillecellule[i-1][j].valeur==1){
                grillecellule[i-1][j].valeur = grillecellule[i-1][j].valeur+grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
                    }
        }
    }
    }
    
}
