package team.esprit.presentationAdministrateur;

public class GestionCovoitureurs extends javax.swing.JFrame {

    public GestionCovoitureurs() {
        setTitle("Gestion des covoitureurs");
        initComponents();
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

        boutton_AjouterCovoitureur = new javax.swing.JButton();
        boutton_AfficherLesCovoitureurs = new javax.swing.JButton();
        boutton_RechercheUnCovoitureur = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_AjouterCovoitureur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_AjouterCovoitureur.setText("Ajouter un covoitureur");
        boutton_AjouterCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AjouterCovoitureurActionPerformed(evt);
            }
        });

        boutton_AfficherLesCovoitureurs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_AfficherLesCovoitureurs.setText("Afficher les covoitureurs");
        boutton_AfficherLesCovoitureurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherLesCovoitureursActionPerformed(evt);
            }
        });

        boutton_RechercheUnCovoitureur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_RechercheUnCovoitureur.setText("Recherche un covoitureur");
        boutton_RechercheUnCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercheUnCovoitureurActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boutton_RechercheUnCovoitureur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                            .addComponent(boutton_AfficherLesCovoitureurs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_AjouterCovoitureur, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutton_AjouterCovoitureur, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_AfficherLesCovoitureurs, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_RechercheUnCovoitureur, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AjouterCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AjouterCovoitureurActionPerformed
        new AjouterCovoitureur().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AjouterCovoitureurActionPerformed

    private void boutton_AfficherLesCovoitureursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherLesCovoitureursActionPerformed
        new AfficherLesCovoitureurs().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_boutton_AfficherLesCovoitureursActionPerformed

    private void boutton_RechercheUnCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercheUnCovoitureurActionPerformed
        new RechercherCovoitureur().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_boutton_RechercheUnCovoitureurActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionCovoitureurs().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherLesCovoitureurs;
    private javax.swing.JButton boutton_AjouterCovoitureur;
    private javax.swing.JButton boutton_RechercheUnCovoitureur;
    private javax.swing.JButton boutton_Retour;
    // End of variables declaration//GEN-END:variables
}