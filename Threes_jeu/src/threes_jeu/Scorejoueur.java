/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 22/12/2023
 */
package threes_jeu;

/**
 *
 * @author Emilie
 */
public class Scorejoueur implements Comparable<Scorejoueur> {
    String Pseudo;
    int Score;

    public Scorejoueur(String pseudo, int score) {
        Pseudo = pseudo;
        Score = score;
    }

    public String getPseudo() {
        return Pseudo;
    }

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

    public static Scorejoueur fromString(String ligne) {
    String[] elements = ligne.split(":");
    String pseudo = elements[0].trim();
    int score = Integer.parseInt(elements[1].trim());
    return new Scorejoueur(pseudo, score);
}
}
