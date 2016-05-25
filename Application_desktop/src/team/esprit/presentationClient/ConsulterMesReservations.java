package team.esprit.presentationClient;

import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.ReservationDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Reservation;
import team.esprit.presentation.Authentification;

public class ConsulterMesReservations extends javax.swing.JFrame {

    Covoitureur covoitureurconnecte = Authentification.covoitureurConnecte;

    public ConsulterMesReservations() {
        initComponents();
        this.setTitle("Consulter mes résetvations");
        initialise();
        table_Reservations.setModel(new ConsulterMesReservationsTable(covoitureurconnecte));
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
        table_Reservations = new javax.swing.JTable();
        boutton_AnnulerReservation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_Reservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "ID", "Conducteur", "Titre", "Description", "Date de reservation", "Etat"
            }));
            jScrollPane1.setViewportView(table_Reservations);

            boutton_AnnulerReservation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
            boutton_AnnulerReservation.setText("Annuler Reservation");
            boutton_AnnulerReservation.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boutton_AnnulerReservationActionPerformed(evt);
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
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addComponent(boutton_AnnulerReservation)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(boutton_AnnulerReservation)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void boutton_AnnulerReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AnnulerReservationActionPerformed
        ReservationDAO reservationDAO = new ReservationDAO();
        NotificationDAO notificationDAO = new NotificationDAO();
        int ligneSelectionne = table_Reservations.getSelectedRow();
        int id = (int) table_Reservations.getValueAt(ligneSelectionne, 0);
        Reservation reservation = reservationDAO.afficherReservation(id);
        Covoiturage covoiturage = reservation.getCovoiturage();
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous annuler votre demande de réservation ?", null, 1);
        if (choix == 0) {
            reservationDAO.annulerReseration(covoiturage);
            String contenu = "Bonjour, j'ai annulé ma réservation";
            notificationDAO.envoyerNotification(covoitureurconnecte, reservation.getCovoitureur(), contenu, 3);
            table_Reservations.setModel(new ConsulterMesReservationsTable(covoitureurconnecte));
        }
    }//GEN-LAST:event_boutton_AnnulerReservationActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMesReservations().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AnnulerReservation;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Reservations;
    // End of variables declaration//GEN-END:variables
}