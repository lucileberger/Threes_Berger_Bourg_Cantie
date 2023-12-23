/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * Class grille: affiche la grille et permet de réaliser les actions dans celle-ci
 * 23/12/2023
 */
package threes_jeu;

import java.util.Random;

/**
 * Permet l'affichage et les modification de la grille
 * @author Emilie
 */
public class Grille {

    Cellule[][] grillecellule;
    int nbLignes;
    int nbColonnes;

    /**
     * Permet de créer la grille avec le nombre de colonnes et de lignes voulues
     * et ajoute une cellule dans chaque case
     * @param ligne nombre de lignes voulues
     * @param colo nombre de colonnes voulues
     */
    public Grille(int ligne, int colo) {
        nbLignes = ligne;
        nbColonnes = colo;
        grillecellule = new Cellule[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                grillecellule[i][j] = new Cellule(48, 48);
            }
        }
    }

    /**
     * Vérifie s'il y a encore la possibilité de faire un mouvement vers la 
     * gauche 
     * @return "true" si c'est possible et "false" si ça ne l'est pas 
     */
    public boolean possible_deplaGauche() {
        boolean fusion = false;
        boolean deplacement = false;
        for (int i = 0; i < nbLignes; i++) {
            int j = 0;
            while (j < nbColonnes && grillecellule[i][j].valeur != 0 && fusion == false) {
                if (j < nbColonnes - 1 && fusionnable(grillecellule[i][j], grillecellule[i][j + 1])) {
                    fusion = true;
                }
                j++;
            }
            if (j != nbColonnes && grillecellule[i][j].valeur == 0) {
                deplacement = true;
            }
        }
        if (fusion == false && deplacement == false) {
            return false;
        }
        return true;
    }

    /**
     ** Vérifie s'il y a encore la possibilité de faire un mouvement vers la 
     * droite
     * @return "true" si c'est possible et "false" si ça ne l'est pas 
     */
    public boolean possible_deplaDroite() {
        boolean fusion = false;
        boolean deplacement = false;
        for (int i = 0; i < nbLignes; i++) {
            int j = nbColonnes - 1;
            while (j > 0 && grillecellule[i][j].valeur != 0) {
                if (j > 0 && fusionnable(grillecellule[i][j], grillecellule[i][j - 1])) {
                    fusion = true;
                }
                j--;
            }
            if (j != 0 && grillecellule[i][j].valeur == 0) {
                deplacement = true;
            }
        }
        if (fusion == false && deplacement == false) {
            return false;
        }
        return true;
    }

    /**
     * Vérifie s'il y a encore la possibilité de faire un mouvement vers le 
     * haut
     * @return "true" si c'est possible et "false" si ça ne l'est pas
     */
    public boolean possible_deplaHaut() {
        boolean fusion = false;
        boolean deplacement = false;
        for (int j = 0; j < nbColonnes; j++) {
            int i = 0;
            while (i < nbLignes - 1 && grillecellule[i][j].valeur != 0) {
                if (i < nbLignes - 1 && fusionnable(grillecellule[i][j], grillecellule[i + 1][j])) {
                    fusion = true;
                }
                i++;
            }
            if (i != nbLignes - 1 && grillecellule[i][j].valeur == 0) {
                deplacement = true;
            }
        }
        if (fusion == false && deplacement == false) {
            return false;
        }
        return true;
    }
    
    /**
     * Vérifie s'il y a encore la possibilité de faire un mouvement vers le 
     * bas
     * @return "true" si c'est possible et "false" si ça ne l'est pas
     */
    public boolean possible_deplaBas(){
        boolean fusion=false;
        boolean deplacement = false;
        for (int j = 0; j < nbColonnes; j++) {
            int i = nbLignes - 1;
            while (i > 0 && grillecellule[i][j].valeur != 0) {
                if (i > 0 && fusionnable(grillecellule[i][j], grillecellule[i - 1][j])) {
                    fusion = true;
                }
                i--;
            }
            if (i != 0 && grillecellule[i][j].valeur == 0) {
                deplacement = true;
            }
        }
        if (fusion == false && deplacement == false) {
            return false;
        }
        return true;
    }

    /**
     * Permet les déplacements vers la gauche des cellules de la grille, entraine
     * aussi la fusion à gauche si c'est possible
     */
    public void deplacementGauche() {
        boolean fusion;
        for (int i = 0; i < nbLignes; i++) {
            fusion = false;
            int j = 0;
            while (j < nbColonnes && grillecellule[i][j].valeur != 0 && fusion == false) {
                if (j < nbColonnes - 1 && fusionnable(grillecellule[i][j], grillecellule[i][j + 1])) {
                    fusion = true;
                }
                j++;
            }
            // un trou a été découvert
            if (j != nbColonnes && grillecellule[i][j].valeur == 0) {
                for (int k = j; k < nbColonnes - 1; k++) {
                    grillecellule[i][k].valeur = grillecellule[i][k + 1].valeur;
                }
                grillecellule[i][nbColonnes - 1].valeur = valeur_alea();
            }
            if (fusion == true) {
                fusionGauche(i);
            }
        }
    }

    /**
     * Permet la fusion des cellules lorsqu'elles se déplacent vers la gauche
     * @param num_lign pour l'indice de la ligne
     */
    public void fusionGauche(int num_lign) {
        int f = 0;
        while (f < nbColonnes - 1 && fusionnable(grillecellule[num_lign][f], grillecellule[num_lign][f + 1]) == false) {
            f++;
        }
        if (f < nbColonnes - 1 && fusionnable(grillecellule[num_lign][f], grillecellule[num_lign][f + 1]) == true) {
            System.out.println(" fusionnable " + num_lign + "," + f);
            for (int l = f; l < nbColonnes - 1; l++) {
                grillecellule[num_lign][l].valeur += grillecellule[num_lign][l + 1].valeur;
                grillecellule[num_lign][l + 1].valeur = 0;
            }
        }
    }

    /**
     * Permet les déplacements vers la droite des cellules de la grille, entraine
     * aussi la fusion à droite si c'est possible
     */
    public void deplacementDroite() {
        boolean fusion;
        for (int i = 0; i < nbLignes; i++) {
            fusion = false;
            int j = nbColonnes - 1;
            while (j > 0 && grillecellule[i][j].valeur != 0) {
                if (j > 0 && fusionnable(grillecellule[i][j], grillecellule[i][j - 1])) {
                    fusion = true;
                }
                j--;
            } //trou découvert:
            if (j != 0 && grillecellule[i][j].valeur == 0) {
                for (int k = j; k > 0; k--) {
                    grillecellule[i][k].valeur = grillecellule[i][k - 1].valeur;
                }
                grillecellule[i][0].valeur = valeur_alea();
            }
            if (fusion == true) {
                fusionDroite(i);
            }
        }
    }

    /**
     * Permet la fusion des cellules lorsqu'elles se déplacent vers la droite
     * @param num_lign pour l'indice de la ligne
     */
    public void fusionDroite(int num_lign) {
        int f = nbColonnes - 1;
        while (f > 0 && fusionnable(grillecellule[num_lign][f], grillecellule[num_lign][f - 1]) == false) {
            f--;
        }
        if (f > 0 && fusionnable(grillecellule[num_lign][f], grillecellule[num_lign][f - 1]) == true) {
            System.out.println(" fusionnable " + num_lign + "," + f);
            for (int l = f; l > 0; l--) {
                grillecellule[num_lign][l].valeur += grillecellule[num_lign][l - 1].valeur;
                grillecellule[num_lign][l - 1].valeur = 0;
            }
        }
    }

    /**
     * Permet les déplacements vers le haut des cellules de la grille, entraine
     * aussi la fusion en haut si c'est possible
     */
    public void deplacementHaut() {
        boolean fusion;
        for (int j = 0; j < nbColonnes; j++) {
            fusion = false;
            int i = 0;
            while (i < nbLignes - 1 && grillecellule[i][j].valeur != 0) {
                if (i < nbLignes - 1 && fusionnable(grillecellule[i][j], grillecellule[i + 1][j])) {
                    fusion = true;
                }
                i++;
            } //trou découvert:
            if (i != nbLignes - 1 && grillecellule[i][j].valeur == 0) {
                for (int k = i; k < nbLignes - 1; k++) {
                    grillecellule[k][j].valeur = grillecellule[k + 1][j].valeur;
                }
                grillecellule[nbLignes - 1][j].valeur = valeur_alea();
            }
            if (fusion == true) {
                fusionHaut(j);
            }
        }
    }

    /**
     * Permet la fusion des cellules lorsqu'elles se déplacent vers le haut
     * @param num_colo pour l'indice de la colonne
     */
    public void fusionHaut(int num_colo) {
        int f = 0;
        while (f < nbLignes - 1 && fusionnable(grillecellule[f][num_colo], grillecellule[f + 1][num_colo]) == false) {
            f++;
        }
        if (f < nbLignes - 1 && fusionnable(grillecellule[f][num_colo], grillecellule[f + 1][num_colo]) == true) {
            System.out.println(" fusionnable " + f + "," + num_colo);
            for (int l = f; l < nbLignes - 1; l++) {
                grillecellule[l][num_colo].valeur += grillecellule[l + 1][num_colo].valeur;
                grillecellule[l + 1][num_colo].valeur = 0;
            }
        }
    }

    /**
     * Permet les déplacements vers le bas des cellules de la grille, entraine
     * aussi la fusion en bas si c'est possible
     */
    public void deplacementBas() {
        boolean fusion;
        for (int j = 0; j < nbColonnes; j++) {
            fusion = false;
            int i = nbLignes - 1;
            while (i > 0 && grillecellule[i][j].valeur != 0) {
                if (i > 0 && fusionnable(grillecellule[i][j], grillecellule[i - 1][j])) {
                    fusion = true;
                }
                i--;
            } // trou découvert:
            if (i != 0 && grillecellule[i][j].valeur == 0) {
                for (int k = i; k > 0; k--) {
                    grillecellule[k][j].valeur = grillecellule[k - 1][j].valeur;
                }
                grillecellule[0][j].valeur = valeur_alea();
            }
            if (fusion == true) {
                fusionBas(j);
            }
        }
    }

    /**
     * Permet la fusion des cellules lorsqu'elles se déplacent vers le bas
     * @param num_colo pour l'indice de la colonne
     */
    public void fusionBas(int num_colo) {
        int f = nbLignes - 1;
        while (f > 0 && fusionnable(grillecellule[f][num_colo], grillecellule[f - 1][num_colo]) == false) {
            f--;
        }
        if (f > 0 && fusionnable(grillecellule[f][num_colo], grillecellule[f - 1][num_colo]) == true) {
            System.out.println(" fusionnable " + f + "," + num_colo);
            for (int l = f; l > 0; l--) {
                grillecellule[l][num_colo].valeur += grillecellule[l - 1][num_colo].valeur;
                grillecellule[l - 1][num_colo].valeur = 0;
            }
        }
    }

    /**
     * permet de savoir si deux cellules peuvent se fusionner
     * @param cellu1 première cellule dont la valeur sera comparée pour la
     * fusion
     * @param cellu2 seconde cellule dont la valeur sera comparée pour la fusion
     * @return "true" si la fusion est possible et "false" si ça ne l'est pas
     */
    public boolean fusionnable(Cellule cellu1, Cellule cellu2) {
        if (cellu1.valeur == cellu2.valeur && cellu1.valeur != 1 && cellu1.valeur != 2 && cellu1.valeur != 0) {
            return true;
        } else if (cellu1.valeur == 1 && cellu2.valeur == 2) {
            return true;
        } else if (cellu1.valeur == 2 && cellu2.valeur == 1) {
            return true;
        }
        return false;
    }

    /**
     * Choisie un nombre aléatoire entre "0", "1", "2" et "3" avec une plus
     * grande chance d'obtenir un "0"
     * @return le nombre
     */
    public int valeur_alea() {
        Random nb = new Random();
        int val = nb.nextInt(4);
        val = val * nb.nextInt(2);
        return val;
    }
    
    /**
     * Compte le score d'une cellule grâce à sa valeur
     * @param cellule dont on veut le score
     * @return Le score obtenu grâce à la cellule
     */
    public int score (Cellule cellule){
       if (cellule.valeur==1 || cellule.valeur==2){
           return 0;
       } 
       int nb = cellule.valeur;
       int puissance=1;
       while (nb!=3){
           nb=nb/2;
           puissance+=1;
       }
       return (int) Math.pow(3, puissance);
    }
    
    /**
     * Compte le score total obtenu avec toutes les cellules de la grille
     * @return le score total
     */
    public int compte_score (){
        int score_tot=0;
        for (int i=0; i<nbLignes; i++){
            for (int j=0; j<nbColonnes; j++){
                score_tot+=score(grillecellule[i][j]);
            }
        }
        return score_tot;
    }

    /**
     * Permet d'afficher la grille dans la console
     * @return l'affichage de la grille
     */
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
