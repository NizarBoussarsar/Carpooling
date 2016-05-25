package team.esprit.presentationAdministrateur;

public class GenererStatistiques extends javax.swing.JFrame {

    public GenererStatistiques() {
        initComponents();
        setTitle("Générer Statistiques");
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

        boutton_StatistiqueCovoitureur = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        boutton_StatistiqueCovoiturage = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_StatistiqueCovoitureur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_StatistiqueCovoitureur.setText("Statistiques des covoitureurs");
        boutton_StatistiqueCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_StatistiqueCovoitureurActionPerformed(evt);
            }
        });

        jButton2.setText("Statistique Covoitureur");

        boutton_StatistiqueCovoiturage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        boutton_StatistiqueCovoiturage.setText("Statistiques des covoiturages");
        boutton_StatistiqueCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_StatistiqueCovoiturageActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutton_StatistiqueCovoitureur, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(boutton_StatistiqueCovoiturage, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(boutton_Retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(44, Short.MAX_VALUE)
                    .addComponent(jButton2)
                    .addGap(123, 123, 123)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutton_StatistiqueCovoitureur, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_StatistiqueCovoiturage, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Retour)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(107, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_StatistiqueCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_StatistiqueCovoitureurActionPerformed
        StatistiqueCovoitureurs statistiqueCovoitureurs = new StatistiqueCovoitureurs();
        statistiqueCovoitureurs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_StatistiqueCovoitureurActionPerformed

    private void boutton_StatistiqueCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_StatistiqueCovoiturageActionPerformed
        StatistiqueCovoiturages statistiqueCovoiturage = new StatistiqueCovoiturages();
        statistiqueCovoiturage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_StatistiqueCovoiturageActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        new Accueil().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenererStatistiques().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JButton boutton_StatistiqueCovoiturage;
    private javax.swing.JButton boutton_StatistiqueCovoitureur;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}