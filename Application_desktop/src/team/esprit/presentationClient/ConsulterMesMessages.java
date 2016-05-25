package team.esprit.presentationClient;

import team.esprit.dao.MessageDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Message;
import team.esprit.presentation.Authentification;

public class ConsulterMesMessages extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    AfficherMessage afficherMessage;
    MessageDAO messageDAO = new MessageDAO();
    Message message;
    int ligneSelectionne;
    int id;
    String destinataire;
    String expediteur;
    String informations;

    public ConsulterMesMessages() {
        initComponents();
        setTitle("Mes Messages");
        initialise();
    }

    public ConsulterMesMessages(Covoitureur covoitureurConnecte) {
        initComponents();
        setTitle("Mes Messages");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_MesMessage = new javax.swing.JTable();
        boutton_RepondreMessage = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        boutton_AfficherMessage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_MesMessage.setModel(new team.esprit.presentationClient.ConsulterMesMessageTable());
        jScrollPane1.setViewportView(table_MesMessage);

        boutton_RepondreMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_RepondreMessage.setText("Repondre");
        boutton_RepondreMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RepondreMessageActionPerformed(evt);
            }
        });

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_AfficherMessage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_AfficherMessage.setText("Afficher message");
        boutton_AfficherMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boutton_RepondreMessage)
                        .addGap(40, 40, 40)
                        .addComponent(boutton_AfficherMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_RepondreMessage)
                    .addComponent(boutton_AfficherMessage)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AfficherMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherMessageActionPerformed
        ligneSelectionne = table_MesMessage.getSelectedRow();
        id = (int) table_MesMessage.getValueAt(ligneSelectionne, 0);
        message = messageDAO.afficherUnMessage(id);
        expediteur = message.getExpediteur().getEmail();
        informations = null;
        informations = "Nom Expediteur: " + message.getExpediteur().getNom()
                + "\n\nObjet: " + message.getObjet()
                + "\n\nContenu: " + message.getContenu()
                + "\n\ndate d'envoie" + message.getDateEnvoie();
        afficherMessage = new AfficherMessage(informations, expediteur);
        afficherMessage.setVisible(true);
        messageDAO.rendreLu(message);
        this.dispose();
    }//GEN-LAST:event_boutton_AfficherMessageActionPerformed

    private void boutton_RepondreMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RepondreMessageActionPerformed
        ligneSelectionne = table_MesMessage.getSelectedRow();
        id = (int) table_MesMessage.getValueAt(ligneSelectionne, 0);
        message = messageDAO.afficherUnMessage(id);
        expediteur = message.getExpediteur().getEmail();
        RepondreMessage repondreMessage = new RepondreMessage(expediteur);
        this.dispose();
        repondreMessage.setVisible(true);
    }//GEN-LAST:event_boutton_RepondreMessageActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMesMessages().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherMessage;
    private javax.swing.JButton boutton_RepondreMessage;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_MesMessage;
    // End of variables declaration//GEN-END:variables
}