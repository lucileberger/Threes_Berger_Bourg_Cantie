/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * Class Scorejoueur: Pour relier les scores aux joueurs
 * 22/12/2023
 */
package threes_jeu;

/**
 * Permet d'associer le score à un joueur
 * @author Emilie
 */
public class Scorejoueur implements Comparable<Scorejoueur> {
    String Pseudo;
    int Score;

    /**
     * assigne aux attributs score et joueur un nom et un score
     * @param pseudo
     * @param score
     */
    public Scorejoueur(String pseudo, int score) {
        Pseudo = pseudo;
        Score = score;
    }

    /**
     * pour récupérer le pseudo
     * @return le pseudo
     */
    public String getPseudo() {
        return Pseudo;
    }

    /**
     * pour récupérer le score
     * @return le score
     */
    public int getScore() {
        return Score;
    }

    @Override
    public int compareTo(Scorejoueur autreScore) {
        return Integer.compare(this.Score, autreScore.Score);
    }

    @Override
    public String toString() {
        return Pseudo + ": " + Score;
    }

    /**
     * Associe le score et le joueur notés sur un dossier à des données utilisables
     * dans le code
     * @param ligne
     * @return
     */
    public static Scorejoueur fromString(String ligne) {
    String[] elements = ligne.split(":");
    String pseudo = elements[0].trim();
    int score = Integer.parseInt(elements[1].trim());
    return new Scorejoueur(pseudo, score);
}
}
