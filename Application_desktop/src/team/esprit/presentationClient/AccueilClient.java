package team.esprit.presentationClient;

import java.awt.Image;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.List;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import team.esprit.controllers.StatCovoiturageController;
import team.esprit.dao.AbonnementDAO;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.MessageDAO;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.ParticipantDAO;
import team.esprit.dao.ReservationDAO;
import team.esprit.entities.Abonnement;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;

public class AccueilClient extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    ConsulterMesCovoiturages consulterMesCovoiturages = new ConsulterMesCovoiturages(covoitureurConnecte);
    ReservationDAO reservationDAO = new ReservationDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    AbonnementDAO abonnementDAO = new AbonnementDAO();
    NotificationDAO notificationDAO = new NotificationDAO();
    ParticipantDAO participantDAO = new ParticipantDAO();
    MessageDAO messageDAO = new MessageDAO();
    Covoiturage covoiturage = new Covoiturage();

    public AccueilClient() {
        initComponents();
        this.setTitle("Page d'accueil");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        if (covoitureurConnecte.getAvatar() == null) {
            if (covoitureurConnecte.getSexe() == 'H') {
                label_Photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team/esprit/presentationClient/AvatarHomme.jpg")));
            } else if (covoitureurConnecte.getSexe() == 'F') {
                label_Photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team/esprit/presentationClient/AvatarFemme.jpg")));
            }
        } else {
            String imageBytes = covoitureurConnecte.getAvatar();
            Image image = getToolkit().createImage(imageBytes);
            ImageIcon iconAvatar = new ImageIcon(image);
            label_Photo.setIcon(iconAvatar);
        }
        label_PrenomNom.setText(covoitureurConnecte.getPrenom() + " " + covoitureurConnecte.getNom());

        System.out.println(covoitureurConnecte.getPrenom() + " " + covoitureurConnecte.getNom());
        label_Message2.setText(String.valueOf(messageDAO.afficherNombreMessagesNonLus(covoitureurConnecte)));
        if (messageDAO.afficherNombreMessagesNonLus(covoitureurConnecte) <= 1) {
            label_Message3.setText("message non lu.");
        }
        label_Notification2.setText(String.valueOf(notificationDAO.afficherNombreNotificationsNonLus(covoitureurConnecte)));
        if (notificationDAO.afficherNombreNotificationsNonLus(covoitureurConnecte) <= 1) {
            label_Notification3.setText("notification non lue.");
        }
        List<CovoiturageDAO.Resultat> listResultat;
        listResultat = covoiturageDAO.afficherFrequenceVilleCovoitureurSupDix(covoitureurConnecte);
        List<Abonnement> listAbonnement;
        if (!listResultat.isEmpty()) {
            listAbonnement = abonnementDAO.afficherAbonnement(covoitureurConnecte);
            boolean b = false;
            for (CovoiturageDAO.Resultat resultat : listResultat) {
                for (Abonnement abonnement : listAbonnement) {
                    if ((abonnement.getVilleDepart().getId() == resultat.getVilleDepart().getId()) && (abonnement.getVilleArrivee().getId() == resultat.getVilleArrivee().getId())) {
                        b = true;
                    }
                }
                if (b == false) {
                    int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vous abonner au parcour : " + resultat.getVilleDepart().getGouvernorat() + " à " + resultat.getVilleArrivee().getGouvernorat() + " ?", null, 2);
                    if (choix == 0) {
                        abonnementDAO.ajouterAbonnement(covoitureurConnecte, resultat);
                    }
                }
            }
        }
        if (messageDAO.afficherNombreMessagesNonLus(covoitureurConnecte) > 0) {
            label_Message2.setText("" + messageDAO.afficherNombreMessagesNonLus(covoitureurConnecte));
        }
        if (notificationDAO.afficherNombreNotificationsNonLus(covoitureurConnecte) > 0) {
            label_Notification2.setText("" + notificationDAO.afficherNombreNotificationsNonLus(covoitureurConnecte));
        }
        StatCovoiturageController statistique = new StatCovoiturageController();
        JFreeChart chart = statistique.statistiqueCovoiturageFrequenceVilleCovoitureur(Authentification.covoitureurConnecte);
        ChartPanel frame = new ChartPanel(chart);
        jPanel3.add(frame);
        frame.setSize(500, 300);
        frame.setLocation(WIDTH + 50, HEIGHT + 50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        label_PrenomNom = new javax.swing.JLabel();
        label_Photo = new javax.swing.JLabel();
        label_Message1 = new javax.swing.JLabel();
        label_Message2 = new javax.swing.JLabel();
        label_Message3 = new javax.swing.JLabel();
        label_Notification1 = new javax.swing.JLabel();
        label_Notification2 = new javax.swing.JLabel();
        label_Notification3 = new javax.swing.JLabel();
        deconnecter = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenu7.setText("File");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar2.add(jMenu8);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_PrenomNom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_PrenomNom.setText("Votre Prénom & Nom");

        label_Message1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Message1.setText("Vous avez");

        label_Message2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Message2.setForeground(new java.awt.Color(255, 0, 51));
        label_Message2.setText("jLabel2");
        label_Message2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_Message2MouseClicked(evt);
            }
        });

        label_Message3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Message3.setText("messages non lus.");

        label_Notification1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Notification1.setText("Vous avez");

        label_Notification2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Notification2.setForeground(new java.awt.Color(255, 0, 51));
        label_Notification2.setText("jLabel1");
        label_Notification2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_Notification2MouseClicked(evt);
            }
        });

        label_Notification3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Notification3.setText("notifications non lues.");

        deconnecter.setActionCommand("deconnecter");
        deconnecter.setLabel("Deconnexion");
        deconnecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deconnecterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_PrenomNom)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_Notification1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Notification2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Notification3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_Message1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Message2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Message3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(deconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(label_PrenomNom)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_Message1)
                                    .addComponent(label_Message2)
                                    .addComponent(label_Message3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(deconnecter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Notification1)
                            .addComponent(label_Notification2)
                            .addComponent(label_Notification3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(432, 432, 432))
        );

        deconnecter.getAccessibleContext().setAccessibleName("Deconnecter");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Votre état est : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setText("Actif.");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(412, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        jMenu9.setText("Accueil");
        jMenuBar1.add(jMenu9);

        jMenu1.setText("Profil");

        jMenuItem1.setText("Consulter profil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Modifier mot de passe");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Covoiturages");

        jMenuItem5.setText("Ajouter");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem4.setText("Rechercher");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem6.setText("Consulter");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Réservations");

        jMenuItem9.setText("Consulter");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Messages");

        jMenuItem10.setText("Consulter");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem10);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Notifications");

        jMenuItem11.setText("Consulter");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Plus");

        jMenuItem7.setText("Envoyer une réclamation");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("A propos");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void label_Message2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Message2MouseClicked
        new ConsulterMesMessagesNonLus().setVisible(true);
    }//GEN-LAST:event_label_Message2MouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new CreerCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ConsulterMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ModifierMotDePasse().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new RechercherCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ConsulterMesCovoiturages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new ConsulterMesReservations().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EnvoyerReclamation(covoitureurConnecte.getEmail()).setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void label_Notification2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Notification2MouseClicked
        new ConsulterMesNotificationsNonLues().setVisible(true);
    }//GEN-LAST:event_label_Notification2MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new APropos().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new ConsulterMesMessages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new ConsulterMesNotifications().setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void deconnecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deconnecterActionPerformed
        covoitureurDAO.modifierConnecte1(covoitureurConnecte);
        this.dispose();
        new Authentification().setVisible(true);
    }//GEN-LAST:event_deconnecterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilClient().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button deconnecter;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel label_Message1;
    private javax.swing.JLabel label_Message2;
    private javax.swing.JLabel label_Message3;
    private javax.swing.JLabel label_Notification1;
    private javax.swing.JLabel label_Notification2;
    private javax.swing.JLabel label_Notification3;
    private javax.swing.JLabel label_Photo;
    private javax.swing.JLabel label_PrenomNom;
    // End of variables declaration//GEN-END:variables
}
