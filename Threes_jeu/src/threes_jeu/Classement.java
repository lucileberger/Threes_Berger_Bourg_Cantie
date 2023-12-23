/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 22/12/2023
 */
package threes_jeu;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

/**
 * Crée un classement des meilleurs joueurs
 * @author Emilie
 */
public class Classement {
    ArrayList<Scorejoueur> scoresGagnants;
    String fichierClassement = "classement.txt";

    /**
     * recupère le classement enregistrer sur un fichier et le met dans une liste
     */
    public Classement() {
        scoresGagnants = new ArrayList<>();
        recupererScore();
    }

    /**
     * Ajoute un score au classement
     * @param nouveauScore à ajouter au classement
     */
    public void ajouterScore(int nouveauScore) {
    if (nouveauScore > 0) {
        System.out.println("Taille de scoresGagnants : " + scoresGagnants.size());
        if (scoresGagnants.size() < 10 || nouveauScore > scoresGagnants.get(9).getScore()) {
            System.out.println("Demander le pseudo.");
            String pseudo = demanderNom(nouveauScore);
            System.out.println("Pseudo saisi : " + pseudo);

            scoresGagnants.add(new Scorejoueur(pseudo, nouveauScore));
            trier();
            sauvegarder();
        }
    }
}

    /**
     * Pour obtenir les scores reliers aux joueurs
     * @return les scores des joueurs
     */
    public ArrayList<Scorejoueur> obtenirClassement() {
        return scoresGagnants;
    }

    private void trier() {
        Collections.sort(scoresGagnants, Collections.reverseOrder());
    }

    private void sauvegarder() {
        System.out.println("Sauvegarde du classement");
    try (PrintWriter writer = new PrintWriter(new FileWriter(fichierClassement))) {
        for (Scorejoueur score : scoresGagnants) {
    writer.println(score.getPseudo() + ": " + score.getScore());
}
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    private void recupererScore() {
        System.out.println("Récupération du classement");
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierClassement))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                scoresGagnants.add(new Scorejoueur("Anonyme", Integer.parseInt(ligne)));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
    
    private String demanderNom(int nouveauScore) {
    if (scoresGagnants.size() < 10 || nouveauScore > scoresGagnants.get(9).getScore()) {
        return JOptionPane.showInputDialog(null, "Félicitations ! Vous êtes dans le top 10 !\nEntrez votre pseudo :",
                "Nouveau Record", JOptionPane.QUESTION_MESSAGE);
    } else {
        return "Anonyme";
    }
}

}
