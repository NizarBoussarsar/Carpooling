package team.esprit.presentationAdministrateur;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GestionCovoiturages extends javax.swing.JFrame {

    public GestionCovoiturages() {
        initComponents();
        setTitle("Gestion des covoiturages");
        initialise();
    }
    
    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutton_AjouterCovoiturage = new javax.swing.JButton();
        boutton_AfficherLesCovoiturages = new javax.swing.JButton();
        boutton_RechercherCovoiturage = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_AjouterCovoiturage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_AjouterCovoiturage.setText("Ajouter un covoiturage");
        boutton_AjouterCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AjouterCovoiturageActionPerformed(evt);
            }
        });

        boutton_AfficherLesCovoiturages.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_AfficherLesCovoiturages.setText("Afficher les covoiturages");
        boutton_AfficherLesCovoiturages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherLesCovoituragesActionPerformed(evt);
            }
        });

        boutton_RechercherCovoiturage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_RechercherCovoiturage.setText("Rechercher un covoiturage");
        boutton_RechercherCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercherCovoiturageActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(boutton_RechercherCovoiturage, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(boutton_AfficherLesCovoiturages, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(boutton_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(boutton_AjouterCovoiturage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutton_AjouterCovoiturage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_AfficherLesCovoiturages, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_RechercherCovoiturage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AjouterCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AjouterCovoiturageActionPerformed
        AjouterCovoiturage ajouterUnCovoiturage = new AjouterCovoiturage();
        ajouterUnCovoiturage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AjouterCovoiturageActionPerformed

    private void boutton_AfficherLesCovoituragesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherLesCovoituragesActionPerformed
        AfficherLesCovoiturages afficherLesCovoiturages = new AfficherLesCovoiturages();
        afficherLesCovoiturages.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AfficherLesCovoituragesActionPerformed

    private void boutton_RechercherCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercherCovoiturageActionPerformed
        RechercherCovoiturage rechercherUnCovoiturage = new RechercherCovoiturage();
        rechercherUnCovoiturage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RechercherCovoiturageActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCovoiturages().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherLesCovoiturages;
    private javax.swing.JButton boutton_AjouterCovoiturage;
    private javax.swing.JButton boutton_RechercherCovoiturage;
    private javax.swing.JButton boutton_Retour;
    // End of variables declaration//GEN-END:variables
}