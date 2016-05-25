package team.esprit.presentationClient;

import javax.swing.JOptionPane;
import team.esprit.util.MailSender;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;

public class ValiderInscription extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    
    public ValiderInscription() {
        initComponents();
        this.setTitle("Confirmer votre inscription");
        initialise();
    }
    
    public ValiderInscription(Covoitureur covoitureur) {
        initComponents();
        this.setTitle("Confirmer votre inscription");
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

        tf_Cle = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        boutton_Valider = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Veuillez entrer la clé de confirmation que vous avez reçu par email:");

        boutton_Valider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Valider.setText("Valider");
        boutton_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ValiderActionPerformed(evt);
            }
        });

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
                    .addComponent(tf_Cle)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(boutton_Valider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutton_Retour)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_Cle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Valider)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        Authentification authentification = new Authentification();
        this.dispose();
        authentification.setVisible(true);
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ValiderActionPerformed
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        MailSender reclamationController = new MailSender();
        String destinataire = covoitureurConnecte.getEmail();
        String msg = "Vous pourriez dés maintenant vous procurez de toutes les fonctionnalitées de l'application.";
        
        if (tf_Cle.getText().equals(covoitureurConnecte.getCleActivation())) {
            covoitureurDAO.modifierEtat(covoitureurConnecte);
            JOptionPane.showMessageDialog(this, "Félicitation! Vous pouvez utiliser l'application.");
            reclamationController.envoyerEmailBienvenue(destinataire, msg);
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez vérifier votre clé d'activation !", null, 2);
        }
    }//GEN-LAST:event_boutton_ValiderActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValiderInscription().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JButton boutton_Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tf_Cle;
    // End of variables declaration//GEN-END:variables
}