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
     * Permet de créer la grille avec le nombre de colonnes et de lignes voulues
     * et ajoute une cellule dans chaque case
     *
     * @param ligne nombre de lignes voulues
     * @param colo nombre de colonnes voulues
     */
    public Grille(int ligne, int colo) {
        nbLignes = ligne;
        nbColonnes = colo;
        grillecellule = new Cellule[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grillecellule[i][j] = new Cellule(40, 40);
            }
        }
    }

    public void deplacementGauche() {
        boolean fusion;
        for (int i = 0; i < nbLignes; i++) {
            fusion = false;
            int j = 0;
            while (j < nbColonnes && grillecellule[i][j].valeur != 0 && fusion==false) {
                if (j< nbColonnes-1 && fusionnable(grillecellule[i][j], grillecellule[i][j + 1])){
                    fusion = true;
                }
                j++;
            }
            // un trou a été découvert
            if (j != nbColonnes && grillecellule[i][j].valeur == 0) {
                //System.out.println(" trou découvert " + i + ","+j);
                for (int k = j; k < nbColonnes - 1; k++) {
                    //System.out.println("décalage numero "+ k);
                    grillecellule[i][k].valeur = grillecellule[i][k + 1].valeur;
                    //System.out.println(this);
                }
                grillecellule[i][nbColonnes - 1].valeur = 0;
            }
            if (fusion == true) {
                int f = 0;
                while (f < nbColonnes-1 && fusionnable(grillecellule[i][f], grillecellule[i][f + 1]) == false) {
                    f++;
                }
                if (f<nbColonnes-1 && fusionnable(grillecellule[i][f], grillecellule[i][f + 1]) == true) {
                    System.out.println(" fusionnable " + i + "," + f);
                    for (int l = f; l < nbColonnes - 1; l++) {
                        grillecellule[i][l].valeur += grillecellule[i][l + 1].valeur;
                        grillecellule[i][l + 1].valeur = 0;
                    }
                }
            }
        }
    }

    public void deplacementDroite() {
        boolean fusion;
        for (int i = 0; i < nbLignes; i++) {
            fusion=false;
            int j = nbColonnes - 1;
            while (j > 0 && grillecellule[i][j].valeur != 0) {
                if (j > 1 && fusionnable(grillecellule[i][j], grillecellule[i][j - 1])){
                    fusion = true;
                }
                j--;
            }
            if (j != 0 && grillecellule[i][j].valeur == 0) {
                //System.out.println("trou découvert " + i + "," + j);
                for (int k = j; k > 0; k--) {
                    //System.out.println("décalage numero " + k);
                    grillecellule[i][k].valeur = grillecellule[i][k - 1].valeur;
                    //System.out.println(this);
                }
                grillecellule[i][0].valeur = 0;
            }
            if (fusion == true) {
                int f = nbColonnes-1;
                while (f > 1 && fusionnable(grillecellule[i][f], grillecellule[i][f - 1]) == false) {
                    f--;
                }
                if (f>1 && fusionnable(grillecellule[i][f], grillecellule[i][f - 1]) == true) {
                    System.out.println(" fusionnable " + i + "," + f);
                    for (int l = f; l > 1; l--) {
                        grillecellule[i][l].valeur += grillecellule[i][l - 1].valeur;
                        grillecellule[i][l - 1].valeur = 0;
                    }
                }
            }
        }
    }

    public void deplacementHaut() {
        boolean fusion;
        for (int j = 0; j < nbColonnes; j++) {
            fusion=false;
            int i = 0;
            while (i < nbLignes - 1 && grillecellule[i][j].valeur != 0) {
                if (i < nbLignes - 1 && fusionnable(grillecellule[i][j], grillecellule[i + 1][j])){
                    fusion = true;
                }
                i++;
            }
            if (i != nbLignes - 1 && grillecellule[i][j].valeur == 0) {
                //System.out.println("trou découvert " + i + "," + j);
                for (int k = i; k < nbLignes - 1; k++) {
                    //System.out.println("décalage numero " + k);
                    grillecellule[k][j].valeur = grillecellule[k + 1][j].valeur;
                    //System.out.println(this);
                }
                grillecellule[nbLignes - 1][j].valeur = 0;
            }
            if (fusion == true) {
                int f = 0;
                while (f < nbLignes-1 && fusionnable(grillecellule[f][j], grillecellule[f+1][j]) == false) {
                    f++;
                }
                if (f<nbLignes-1 && fusionnable(grillecellule[f][j], grillecellule[f+1][j]) == true) {
                    System.out.println(" fusionnable " + f + "," + j);
                    for (int l = f; l < nbLignes - 1; l++) {
                        grillecellule[l][j].valeur += grillecellule[l+1][j].valeur;
                        grillecellule[l+1][j].valeur = 0;
                    }
                }
            }
        }
    }

    public void deplacementBas() {
        boolean fusion;
        for (int j = 0; j < nbColonnes; j++) {
            fusion = false;
            int i = nbLignes - 1;
            while (i > 0 && grillecellule[i][j].valeur != 0) {
                if (i > 1 && fusionnable(grillecellule[i][j], grillecellule[i - 1][j])){
                    fusion = true;
                }
                i--;
            }
            if (i != 0 && grillecellule[i][j].valeur == 0) {
                //System.out.println("trou découvert " + i + "," + j);
                for (int k = i; k > 0; k--) {
                    //System.out.println("décalage numero " + k);
                    grillecellule[k][j].valeur = grillecellule[k - 1][j].valeur;
                    //System.out.println(this);
                }
                grillecellule[0][j].valeur = 0;
            }
            if (fusion == true) {
                int f = nbLignes-1;
                while (f > 1 && fusionnable(grillecellule[f][j], grillecellule[f-1][j]) == false) {
                    f--;
                }
                if (f > 1 && fusionnable(grillecellule[f][j], grillecellule[f-1][j]) == true) {
                    System.out.println(" fusionnable " + f + "," + j);
                    for (int l = f; l > 1; l--) {
                        grillecellule[l][j].valeur += grillecellule[l-1][j].valeur;
                        grillecellule[l-1][j].valeur = 0;
                    }
                }
            }
        }
    }

    public boolean fusionnable(Cellule cellu1, Cellule cellu2) {
        if (cellu1.valeur == cellu2.valeur && cellu1.valeur != 1 && cellu1.valeur != 2 && cellu1.valeur!=0) {
            return true;
        } else if (cellu1.valeur == 1 && cellu2.valeur == 2) {
            return true;
        } else if (cellu1.valeur == 2 && cellu2.valeur == 1) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        String result = "\n\n";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                result += grillecellule[i][j].toString2();
            }
            result += "\n";
        }
        return result;

    }

}
