package team.esprit.presentationClient;

import team.esprit.dao.MessageDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Message;
import team.esprit.presentation.Authentification;

public class ConsulterMesMessagesNonLus extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    AfficherMessage afficherMessage;
    MessageDAO messageDAO = new MessageDAO();
    Message message;
    int ligneSelectionne;
    int id;
    String destinataire;
    String expediteur;
    String informations;

    public ConsulterMesMessagesNonLus() {
        initComponents();
        setTitle("Mes messages non lus");
        initialise();
    }
    
    public ConsulterMesMessagesNonLus(int x) {
        initComponents();
        setTitle("Mes messages non lus");
        initialise();
        table_MesMessage.setModel(new ConsulterMesMessagesNonLusTable());
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

        boutton_RepondreMessage = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        boutton_AfficherMessage = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_MesMessage = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_RepondreMessage.setText("Repondre");
        boutton_RepondreMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RepondreMessageActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_AfficherMessage.setText("Afficher message");
        boutton_AfficherMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherMessageActionPerformed(evt);
            }
        });

        table_MesMessage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Nom de l'expéditeur", "Objet du message", "Contenu du message ", "Date d'envoie"
            }
        ));
        jScrollPane2.setViewportView(table_MesMessage);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(boutton_RepondreMessage)
                        .addGap(53, 53, 53)
                        .addComponent(boutton_AfficherMessage)
                        .addGap(63, 63, 63)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        informations = "Nom Expediteur: " + message.getExpediteur().getNomUtilisateur()
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
                new ConsulterMesMessagesNonLus().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherMessage;
    private javax.swing.JButton boutton_RepondreMessage;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_MesMessage;
    // End of variables declaration//GEN-END:variables
}