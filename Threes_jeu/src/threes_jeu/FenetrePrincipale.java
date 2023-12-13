/*
 * Emilie Bourg / Lucile Berger / Pauline Cantie
 * TDC
 * 28/11/2023
 */
package threes_jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Emilie
 */
public class FenetrePrincipale extends javax.swing.JFrame {
        Grille grille;

    /**
     * Creates new form FenetrePrincipale
     */
      public FenetrePrincipale() {
        initComponents();
        setTitle("Bienvenue dans le jeu Threes!");
        créer_grille(5,80,50);
        System.out.println(grille);
        setLocationRelativeTo(null);
        setSize(800, 500);
        
        
        haut.setBackground(new Color(136, 211, 229));
        
     bas.setBackground(new Color(136, 211, 229));
     gauche.setBackground(new Color(136, 211, 229));
     droite.setBackground(new Color(136, 211, 229)); 
    }

    
    public void créer_grille(int nb_case, int taille_grille, int taille_cellule){
        int nbLignes = nb_case;
        int nbColonnes = nb_case;
        getContentPane().add(endroitgrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(taille_grille, taille_grille, nbColonnes*taille_cellule, nbLignes*taille_cellule));
        this.pack();
        this.revalidate();
        grille=new Grille(nbLignes,nbColonnes);
        endroitgrille.setLayout(new GridLayout(nbLignes, nbColonnes));
        
        for (int i=0; i < nbLignes; i++) { 
            for (int j=0; j < nbColonnes; j++ ) {
               // Cellule bouton_cellule = new Cellule(36, 36);
                endroitgrille.add(grille.grillecellule[i][j]); // ajout au Jpanel PanneauGrille
            }
        }
    }
    
    /*public void couleurs () {
        
         if (valeur == 1) {
        this.setBackground(new Color(244, 0, 0)); 
    } else if (valeur == 2) {
        this.setBackground(new Color(0, 0, 255)); 
    } else if (valeur == 3) {
        this.setBackground(new Color(255, 0, 0)); 
    }
    }*/



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endroitgrille = new javax.swing.JPanel();
        haut = new javax.swing.JButton();
        bas = new javax.swing.JButton();
        droite = new javax.swing.JButton();
        gauche = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(2000, 1000));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        endroitgrille.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout endroitgrilleLayout = new javax.swing.GroupLayout(endroitgrille);
        endroitgrille.setLayout(endroitgrilleLayout);
        endroitgrilleLayout.setHorizontalGroup(
            endroitgrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );
        endroitgrilleLayout.setVerticalGroup(
            endroitgrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );

        getContentPane().add(endroitgrille, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 270, 140));

        haut.setText("↑");
        haut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hautActionPerformed(evt);
            }
        });
        getContentPane().add(haut, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 40, 40));

        bas.setText("↓ ");
        bas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basActionPerformed(evt);
            }
        });
        getContentPane().add(bas, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 40, 40));

        droite.setText("→");
        droite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                droiteActionPerformed(evt);
            }
        });
        getContentPane().add(droite, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 40, 40));

        gauche.setText("←");
        gauche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gaucheActionPerformed(evt);
            }
        });
        getContentPane().add(gauche, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 40, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hautActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hautActionPerformed
        grille.deplacementHaut();
        System.out.println(grille);
        endroitgrille.repaint();
    }//GEN-LAST:event_hautActionPerformed

    private void gaucheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gaucheActionPerformed
        grille.deplacementGauche();
        System.out.println(grille);
        endroitgrille.repaint();
    }//GEN-LAST:event_gaucheActionPerformed

    private void droiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_droiteActionPerformed
        grille.deplacementDroite();
        System.out.println(grille);
        endroitgrille.repaint();
    }//GEN-LAST:event_droiteActionPerformed

    private void basActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basActionPerformed
        grille.deplacementBas();
        System.out.println(grille);
        endroitgrille.repaint();
    }//GEN-LAST:event_basActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetrePrincipale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetrePrincipale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bas;
    private javax.swing.JButton droite;
    private javax.swing.JPanel endroitgrille;
    private javax.swing.JButton gauche;
    private javax.swing.JButton haut;
    // End of variables declaration//GEN-END:variables
}
