package team.esprit.presentationAdministrateur;

public class GestionReclamations extends javax.swing.JFrame {

    public GestionReclamations() {
        initComponents();
        this.setTitle("Gestion des réclamations");
        initialise();
    }
    
    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ta_Reclamation.setLineWrap(true);
        ta_Reclamation.setWrapStyleWord(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Reclamation = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_Reclamation = new javax.swing.JTextArea();
        boutton_Repondre = new javax.swing.JButton();
        boutton_Consulter = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_Reclamation.setModel(new team.esprit.presentationAdministrateur.GestionReclamationsTable());
        jScrollPane1.setViewportView(table_Reclamation);

        ta_Reclamation.setEditable(false);
        ta_Reclamation.setColumns(20);
        ta_Reclamation.setRows(5);
        jScrollPane2.setViewportView(ta_Reclamation);

        boutton_Repondre.setText("Répondre");
        boutton_Repondre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RepondreActionPerformed(evt);
            }
        });

        boutton_Consulter.setText("Consulter");
        boutton_Consulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ConsulterActionPerformed(evt);
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
                        .addGap(51, 51, 51)
                        .addComponent(boutton_Repondre)
                        .addGap(70, 70, 70)
                        .addComponent(boutton_Consulter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_Retour)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Repondre)
                    .addComponent(boutton_Consulter)
                    .addComponent(boutton_Retour))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RepondreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RepondreActionPerformed
        int ligneSelectionne = table_Reclamation.getSelectedRow();
        int idReclamation = (int) table_Reclamation.getValueAt(ligneSelectionne, 0);
        this.dispose();
        new RepondreReclamation(idReclamation).setVisible(true);
    }//GEN-LAST:event_boutton_RepondreActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_ConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ConsulterActionPerformed
        int ligneSelectionne = table_Reclamation.getSelectedRow();
        ta_Reclamation.setText(table_Reclamation.getValueAt(ligneSelectionne, 1).toString()
                + " : " + table_Reclamation.getValueAt(ligneSelectionne, 2).toString()
                + "\n \n" + table_Reclamation.getValueAt(ligneSelectionne, 4).toString());
    }//GEN-LAST:event_boutton_ConsulterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionReclamations().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Consulter;
    private javax.swing.JButton boutton_Repondre;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea ta_Reclamation;
    private javax.swing.JTable table_Reclamation;
    // End of variables declaration//GEN-END:variables
}