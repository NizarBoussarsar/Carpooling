package team.esprit.presentationClient;

import team.esprit.presentation.Authentification;
import java.awt.Toolkit;
import team.esprit.util.Navigateur;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.ReservationDAO;
import team.esprit.dao.VilleDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;

public class AfficherCovoiturage extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    Covoiturage covoiturage;
    VilleDAO villedao = new VilleDAO();
    Ville villeDepart = new Ville();
    Ville villeArrivee = new Ville();
    ReservationDAO reservationDAO = new ReservationDAO();
    NotificationDAO notificationDAO = new NotificationDAO();
    String informations;
    int idCovoiturage;

    public AfficherCovoiturage() {
        this.dispose();
        initialise();
    }

    public AfficherCovoiturage(String informations, int idCovoiturage) {
        this.informations = informations;
        this.idCovoiturage = idCovoiturage;
        initComponents();
        setTitle("Afficher un covoiturage");
        initialise();
        ta_Afficher.setLineWrap(true);
        ta_Afficher.setWrapStyleWord(true);
        ta_Afficher.setText(informations);
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
        ta_Afficher = new javax.swing.JTextArea();
        boutton_Retour = new javax.swing.JButton();
        boutton_Reserver = new javax.swing.JToggleButton();
        boutton_Localiser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta_Afficher.setEditable(false);
        ta_Afficher.setColumns(20);
        ta_Afficher.setRows(5);
        jScrollPane1.setViewportView(ta_Afficher);

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_Reserver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Reserver.setText("Reserver une place");
        boutton_Reserver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ReserverActionPerformed(evt);
            }
        });

        boutton_Localiser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Localiser.setText("Localiser");
        boutton_Localiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_LocaliserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(boutton_Retour)
                .addGap(56, 56, 56)
                .addComponent(boutton_Reserver, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutton_Localiser)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Retour)
                    .addComponent(boutton_Reserver)
                    .addComponent(boutton_Localiser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_ReserverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ReserverActionPerformed
        covoiturage = new CovoiturageDAO().afficherCovoiturage_ID(idCovoiturage);
        if (covoiturage.getNombrePlaces() <= 0) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Il n'y a plus de places dans ce covoiturage !");
        } else if (reservationDAO.reservationParCovoitureur(covoitureurConnecte, covoiturage) >= 1) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Vous avez déja envoyé une demande conçernant ce covoiturage !");
        } else {
            if (reservationDAO.envoyerDemande(covoitureurConnecte, covoiturage) && (notificationDAO.notificationReservation(covoitureurConnecte, covoiturage.getCreateur()))) {
                JOptionPane.showMessageDialog(this, "Une demande de réservation vient d'être envoyées à " + covoiturage.getCreateur().getNom()
                        + " " + covoiturage.getCreateur().getPrenom() + ". Veuillez attendre sa confirmation !");
            }
        }
    }//GEN-LAST:event_boutton_ReserverActionPerformed

    private void boutton_LocaliserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_LocaliserActionPerformed
        covoiturage = new CovoiturageDAO().afficherCovoiturage_ID(idCovoiturage);
        villeDepart.setGouvernorat(covoiturage.getVilleDepart().getGouvernorat());
        villeArrivee.setGouvernorat(covoiturage.getVilleArrivee().getGouvernorat());
        villeDepart.setDelegation(covoiturage.getVilleDepart().getDelegation());
        villeArrivee.setDelegation(covoiturage.getVilleArrivee().getDelegation());
        Navigateur.main(villeDepart, villeArrivee);
    }//GEN-LAST:event_boutton_LocaliserActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherCovoiturage().dispose();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Localiser;
    private javax.swing.JToggleButton boutton_Reserver;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_Afficher;
    // End of variables declaration//GEN-END:variables
}