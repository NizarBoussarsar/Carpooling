package team.esprit.presentationClient;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import team.esprit.dao.AbonnementDAO;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.DetourDAO;
import team.esprit.dao.MessageDAO;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.ParticipantDAO;
import team.esprit.dao.ReservationDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Notification;
import team.esprit.presentation.Authentification;

public class ConsulterMesNotificationsNonLues extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    ReservationDAO reservationDAO = new ReservationDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    AbonnementDAO abonnementDAO = new AbonnementDAO();
    NotificationDAO notificationDAO = new NotificationDAO();
    ParticipantDAO participantDAO = new ParticipantDAO();
    MessageDAO messageDAO = new MessageDAO();
    DetourDAO detourDAO = new DetourDAO();
    Covoiturage covoiturage = new Covoiturage();

    public ConsulterMesNotificationsNonLues() {
        initComponents();
        this.setTitle("Consulter mes notifications non lues");
        initialise();
        table_Notifications.setModel(new ConsulterMesNotificationsNonLuesTable());
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

        jScrollPane2 = new javax.swing.JScrollPane();
        table_Notifications = new javax.swing.JTable();
        boutton_Afficher = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_Notifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Notification"
            }
        ));
        jScrollPane2.setViewportView(table_Notifications);

        boutton_Afficher.setText("Afficher");
        boutton_Afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherActionPerformed(evt);
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(boutton_Afficher)
                        .addGap(107, 107, 107)
                        .addComponent(boutton_Retour)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Afficher)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AfficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherActionPerformed
        int ligneSelectionne = table_Notifications.getSelectedRow();
        int id = (int) table_Notifications.getValueAt(ligneSelectionne, 0);
        Notification notification = notificationDAO.afficherUneNotification(id);
        String expediteur = notification.getExpediteur().getNomUtilisateur();
        String informations = null;
        informations = "Nom Expediteur: " + expediteur
                + "\n\nContenu: " + notification.getContenu();
        notificationDAO.rendreLu(notification);
        new AfficherNotification(informations).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AfficherActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMesNotificationsNonLues().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Afficher;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_Notifications;
    // End of variables declaration//GEN-END:variables
}