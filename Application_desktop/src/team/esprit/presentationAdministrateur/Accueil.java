package team.esprit.presentationAdministrateur;

public class Accueil extends javax.swing.JFrame {

    public Accueil() {
        initComponents();
        setTitle("Accueil");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutton_Covoitureurs = new javax.swing.JButton();
        boutton_Covoiturages = new javax.swing.JButton();
        boutton_Reclamations = new javax.swing.JButton();
        boutton_Statistiques = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_Covoitureurs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_Covoitureurs.setText("Gestion des covoitureurs");
        boutton_Covoitureurs.setFocusable(false);
        boutton_Covoitureurs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        boutton_Covoitureurs.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        boutton_Covoitureurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_CovoitureursActionPerformed(evt);
            }
        });

        boutton_Covoiturages.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_Covoiturages.setText("Gestion des covoiturages");
        boutton_Covoiturages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_CovoituragesActionPerformed(evt);
            }
        });

        boutton_Reclamations.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_Reclamations.setText("Gestion des réclamations");
        boutton_Reclamations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ReclamationsActionPerformed(evt);
            }
        });

        boutton_Statistiques.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_Statistiques.setText("Statistiques");
        boutton_Statistiques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_StatistiquesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutton_Reclamations, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(boutton_Covoitureurs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutton_Covoiturages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutton_Statistiques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutton_Covoitureurs, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Covoiturages, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Reclamations, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Statistiques, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_StatistiquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_StatistiquesActionPerformed
        new GenererStatistiques().setVisible(true);
    }//GEN-LAST:event_boutton_StatistiquesActionPerformed

    private void boutton_ReclamationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ReclamationsActionPerformed
        new GestionReclamations().setVisible(true);
    }//GEN-LAST:event_boutton_ReclamationsActionPerformed

    private void boutton_CovoituragesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_CovoituragesActionPerformed
        new GestionCovoiturages().setVisible(true);
    }//GEN-LAST:event_boutton_CovoituragesActionPerformed

    private void boutton_CovoitureursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_CovoitureursActionPerformed
        new GestionCovoitureurs().setVisible(true);
    }//GEN-LAST:event_boutton_CovoitureursActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accueil().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Covoiturages;
    private javax.swing.JButton boutton_Covoitureurs;
    private javax.swing.JButton boutton_Reclamations;
    private javax.swing.JButton boutton_Statistiques;
    // End of variables declaration//GEN-END:variables
}