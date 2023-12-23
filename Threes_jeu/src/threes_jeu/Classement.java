/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 22/12/2023
 */
package threes_jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.io.*;

/**
 *
 * @author Emilie
 */
public class Classement {
    ArrayList<Integer> scores;
    String fichierClassement = "classement.txt";
    
    public Classement(){
    scores = new ArrayList<Integer>();
    Recupscore();
}
    public void AjouterScore(int nouveauScore) {
        scores.add(nouveauScore);
        Triage();
        sauvegarder();
    }
    
    public ArrayList<Integer> obtenirClassement() {
        return scores;
    }
    
    public void Triage() {
        Collections.sort(scores, Collections.reverseOrder());
    }
    
    private void sauvegarder() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fichierClassement))) {
            for (Integer score : scores) {
                writer.println(score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void Recupscore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fichierClassement))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                scores.add(Integer.parseInt(ligne));
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
