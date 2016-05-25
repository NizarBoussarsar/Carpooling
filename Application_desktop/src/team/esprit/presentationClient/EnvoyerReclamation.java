package team.esprit.presentationClient;

import javax.swing.JOptionPane;
import team.esprit.dao.ReclamationDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Reclamation;

public class EnvoyerReclamation extends javax.swing.JFrame {

    String email;
    
    public EnvoyerReclamation() {
        initComponents();
        setTitle("Envoyer une réclamation");
        initialise();
        ta_Message.setLineWrap(true);
        ta_Message.setWrapStyleWord(true);
    }
    
    public EnvoyerReclamation(String email) {
        initComponents();
        setTitle("Envoyer une réclamation");
        initialise();
        ta_Message.setLineWrap(true);
        ta_Message.setWrapStyleWord(true);
        this.email = email;
        tf_Email.setText(email);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Message = new javax.swing.JTextArea();
        tf_Email = new javax.swing.JTextField();
        cb_Type = new javax.swing.JComboBox();
        boutton_Envoyer = new javax.swing.JButton();
        boutton_Annuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("E-mail:");

        jLabel2.setText("Type:");

        ta_Message.setColumns(20);
        ta_Message.setRows(5);
        jScrollPane1.setViewportView(ta_Message);

        cb_Type.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Signaler un probléme technique", "Signaler un compte", "Suggérer des améliorations", "Poser des questions" }));

        boutton_Envoyer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Envoyer.setText("Envoyer");
        boutton_Envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_EnvoyerActionPerformed(evt);
            }
        });

        boutton_Annuler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Annuler.setText("Annuler");
        boutton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cb_Type, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_Email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boutton_Envoyer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_Annuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Envoyer))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Annuler))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_AnnulerActionPerformed

    private void boutton_EnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_EnvoyerActionPerformed
        ReclamationDAO reclamationDAO = new ReclamationDAO();
        Reclamation reclamation = new Reclamation();
        Covoitureur covoitureur = new Covoitureur();

        reclamation.setMessage(ta_Message.getText());
        reclamation.setEmail(tf_Email.getText());
        reclamation.setType(cb_Type.getSelectedItem().toString());
        covoitureur.setEmail(tf_Email.getText());
        
        if (reclamationDAO.envoyerReclamation(covoitureur, reclamation) == true) {
            JOptionPane.showMessageDialog(this, "Votre réclamation a été transmise avec succés.");
        } else {
            JOptionPane.showMessageDialog(this, "Votre réclamation n'a pas été transmise.");
        }
    }//GEN-LAST:event_boutton_EnvoyerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnvoyerReclamation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Annuler;
    private javax.swing.JButton boutton_Envoyer;
    private javax.swing.JComboBox cb_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_Message;
    private javax.swing.JTextField tf_Email;
    // End of variables declaration//GEN-END:variables
}
