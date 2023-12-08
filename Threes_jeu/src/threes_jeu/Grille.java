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
    for (int i=0;i<nbLignes;i++){
        int j =0;
       while (j < nbColonnes && grillecellule[i][j].valeur !=0) {
          j++;
       }
       // un trou a été découvert
       if (j != nbColonnes && grillecellule[i][j].valeur ==0)  {
           System.out.println(" trou découvert " + i + ","+j);
         for (int k = j; k < nbColonnes-1; k++) {
             System.out.println("décalage numero "+ k);
             grillecellule[i][k].valeur = grillecellule[i][k+1].valeur;
             System.out.println(this);
         }    
        grillecellule[i][nbColonnes-1].valeur = 0;
       } 
       
    }
        
        /*for (int j=1; j<nbColonnes; j++){
        for (int i=0;i<nbLignes;i++){
            if (fusionnable(grillecellule[i][j], grillecellule[i][j-1])==true){
                grillecellule[i][j-1].valeur += grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            }
        }
    }*/
    }
    public void deplacementdroite(){
    for (int j=nbColonnes-1; j>=0; j--){
        for (int i=0;i<nbLignes;i++){
            if (fusionnable(grillecellule[i][j], grillecellule[i][j+1])==true){
                grillecellule[i][j+1].valeur = grillecellule[i][j].valeur;
                grillecellule[i][j].valeur=0;
            }
        }
    }
    }
    public boolean fusionnable(Cellule cellu1, Cellule cellu2){
        if (cellu1.valeur == cellu2.valeur && cellu1.valeur!=1 && cellu1.valeur!=2){
            return true;
        } else if (cellu1.valeur==1 && cellu2.valeur==2){
            return true;
        } else if (cellu1.valeur==2 && cellu2.valeur==1){
            return true;
        }
        return false;
    } 

    @Override
    public String toString() {
        String result = "\n\n";
        for (int i=0;i<nbLignes;i++){
           for (int j=0; j<nbColonnes; j++){
              result +=grillecellule[i][j].toString2();  
           }
           result += "\n";
        }
        return result;
        
    }


}
