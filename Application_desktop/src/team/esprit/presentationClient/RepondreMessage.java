package team.esprit.presentationClient;

import javax.swing.JOptionPane;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.MessageDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Message;
import team.esprit.presentation.Authentification;

public class RepondreMessage extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    ConsulterMesMessages consulterMesMessages = new ConsulterMesMessages();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    MessageDAO messageDAO = new MessageDAO();
    Message message = new Message();
    Covoitureur destinataire;
    String mailTo, contenu;

    public RepondreMessage() {
        this.dispose();
        initialise();
    }

    public RepondreMessage(String mailTo) {
        initComponents();
        setTitle("Répondre à un message");
        initialise();
        ta_Message.setLineWrap(true);
        ta_Message.setWrapStyleWord(true);
        tf_Email.setText(mailTo);
    }
    
    private void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boutton_Annuler = new javax.swing.JButton();
        boutton_Envoyer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Message = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_Annuler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Annuler.setText("Annuler");
        boutton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AnnulerActionPerformed(evt);
            }
        });

        boutton_Envoyer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Envoyer.setText("Envoyer");
        boutton_Envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_EnvoyerActionPerformed(evt);
            }
        });

        ta_Message.setColumns(20);
        ta_Message.setRows(5);
        jScrollPane1.setViewportView(ta_Message);

        jLabel1.setText("To : ");

        tf_Email.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(boutton_Envoyer)
                .addGap(54, 54, 54)
                .addComponent(boutton_Annuler)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Envoyer)
                    .addComponent(boutton_Annuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_AnnulerActionPerformed

    private void boutton_EnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_EnvoyerActionPerformed
        mailTo = tf_Email.getText();
        destinataire = covoitureurDAO.afficherCovoitureurEMAIL(mailTo);
        contenu = ta_Message.getText();
        message.setContenu(contenu);
        message.setExpediteur(covoitureurConnecte);
        message.setDestinataire(destinataire);
        if (messageDAO.envoyerMessage(destinataire, message) == true) {
            JOptionPane.showMessageDialog(this, "Votre message a été transmis vers l'adresse: " + mailTo);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Votre message n'a pas été transmis vers l'adresse: " + mailTo);
        }
    }//GEN-LAST:event_boutton_EnvoyerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepondreMessage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Annuler;
    private javax.swing.JButton boutton_Envoyer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_Message;
    private javax.swing.JTextField tf_Email;
    // End of variables declaration//GEN-END:variables
}