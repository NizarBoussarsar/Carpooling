package team.esprit.presentationClient;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import team.esprit.dao.AbonnementDAO;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.DetourDAO;
import team.esprit.dao.MessageDAO;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.ParticipantDAO;
import team.esprit.dao.ReservationDAO;
import team.esprit.entities.Abonnement;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;
import team.esprit.presentation.Authentification;

public class ConsulterMesCovoiturages extends javax.swing.JFrame {

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

    public ConsulterMesCovoiturages() {
        this.dispose();
        initialise();
    }

    public ConsulterMesCovoiturages(Covoitureur covoitureur) {
        initComponents();
        this.setTitle("Consulter mes covoiturages");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Covoiturages = new javax.swing.JTable();
        boutton_Supprimer = new javax.swing.JButton();
        boutton_Modifier = new javax.swing.JButton();
        boutton_Details = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_PrenomNom = new javax.swing.JLabel();
        label_Photo = new javax.swing.JLabel();
        label_Message1 = new javax.swing.JLabel();
        label_Message2 = new javax.swing.JLabel();
        label_Message3 = new javax.swing.JLabel();
        label_Notification1 = new javax.swing.JLabel();
        label_Notification2 = new javax.swing.JLabel();
        label_Notification3 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu10 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ta_Covoiturages.setModel(new ConsulterMesCovoituragesTable());
        jScrollPane1.setViewportView(ta_Covoiturages);

        boutton_Supprimer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Supprimer.setText("Supprimer");
        boutton_Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_SupprimerActionPerformed(evt);
            }
        });

        boutton_Modifier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Modifier.setText("Modifier");
        boutton_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierActionPerformed(evt);
            }
        });

        boutton_Details.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Details.setText("Plus de détails");
        boutton_Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_DetailsActionPerformed(evt);
            }
        });

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

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

        label_Notification3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Notification3.setText("notifications non lues.");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Message1)
                            .addComponent(label_Message2)
                            .addComponent(label_Message3))
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

        jMenu10.setText("Accueil");
        jMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu10ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu10);

        jMenu1.setText("Profil");

        jMenuItem1.setText("Consulter profil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modifier profil");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Modifier mot de passe");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar2.add(jMenu1);

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

        jMenuBar2.add(jMenu2);

        jMenu3.setText("Réservations");

        jMenuItem10.setText("Confirmer");
        jMenu3.add(jMenuItem10);

        jMenuItem9.setText("Consulter");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar2.add(jMenu3);

        jMenu4.setText("Messages");

        jMenuItem11.setText("Envoyer");
        jMenu4.add(jMenuItem11);

        jMenuItem12.setText("Consulter");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar2.add(jMenu4);

        jMenu5.setText("Notifications");
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Plus");

        jMenuItem7.setText("Envoyer une réclamation");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem7);

        jMenuItem8.setText("A propos");
        jMenu6.add(jMenuItem8);

        jMenuBar2.add(jMenu6);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boutton_Supprimer)
                        .addGap(50, 50, 50)
                        .addComponent(boutton_Modifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_Details)
                        .addGap(30, 30, 30)
                        .addComponent(boutton_Retour)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Supprimer)
                    .addComponent(boutton_Modifier)
                    .addComponent(boutton_Details)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_DetailsActionPerformed
        int ligneSelectionne = ta_Covoiturages.getSelectedRow();
        int id = (int) ta_Covoiturages.getValueAt(ligneSelectionne, 0);
        covoiturage = covoiturageDAO.afficherCovoiturage_ID(id);

        String informations = null;

        String p = "";
        List<Covoitureur> listCovoitureurs = participantDAO.afficherParticipants(covoiturage);
        for (Covoitureur participant : listCovoitureurs) {
            p = p + participant.getNomUtilisateur() + ", ";
        }

        String d = "";
        List<Ville> listDetours = detourDAO.afficherDetours(covoiturage);
        for (Ville ville : listDetours) {
            d = d + ville.getGouvernorat() + ", " + ville.getDelegation() + ", " + ville.getLocalite() + ". ";
        }

        boolean reserve = covoiturage.isReserveeFemmes();
        String r;
        if (reserve) {
            r = "Oui";
        } else {
            r = "Non";
        }

        boolean fumeur = covoiturage.isFumeur();
        String f;
        if (fumeur) {
            f = "Oui";
        } else {
            f = "Non";
        }

        informations = "Titre: " + covoiturage.getTitre()
                + "\nDescription: " + covoiturage.getDescription()
                + "\nVille de départ: " + covoiturage.getVilleDepart().getGouvernorat() + ", " + covoiturage.getVilleDepart().getDelegation() + ", " + covoiturage.getVilleDepart().getLocalite()
                + "\nVille d'arrivée: " + covoiturage.getVilleArrivee().getGouvernorat() + ", " + covoiturage.getVilleArrivee().getDelegation() + ", " + covoiturage.getVilleArrivee().getLocalite()
                + "\nDate de départ: " + covoiturage.getDateDepart()
                + "\nHeure de départ: " + covoiturage.getHeureDepart()
                + "\nNombre de places disponibles: " + covoiturage.getNombrePlaces()
                + "\nFumeur: " + f
                + "\nRéservé aux femmes: " + r
                + "\nVilles de détours: " + d
                + "\nLes participants: " + p;

        ConsulterCovoiturage consulterCovoiturage = new ConsulterCovoiturage(covoiturage, informations);
        this.dispose();
        consulterCovoiturage.setVisible(true);
    }//GEN-LAST:event_boutton_DetailsActionPerformed

    private void boutton_SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_SupprimerActionPerformed
        int ligneSelectionne = ta_Covoiturages.getSelectedRow();
        int id = (int) ta_Covoiturages.getValueAt(ligneSelectionne, 0);
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce covoiturage ?", null, 1, 2);
        if (choix == 0) {
            if (covoiturageDAO.supprimerCovoiturage(id)) {
                JOptionPane.showMessageDialog(this, "Le covoiturage a été supprimé avec succés.");
            } else {
                JOptionPane.showMessageDialog(this, "Le covoiturage n'a pas été supprimé.");
            }
        }
    }//GEN-LAST:event_boutton_SupprimerActionPerformed

    private void boutton_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierActionPerformed
        int ligneSelectionne = ta_Covoiturages.getSelectedRow();
        int id = (int) ta_Covoiturages.getValueAt(ligneSelectionne, 0);
        covoiturage = covoiturageDAO.afficherCovoiturage_ID(id);
        ModifierMonCovoiturage modifierMonCovoiturage = new ModifierMonCovoiturage(covoiturage);
        modifierMonCovoiturage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_ModifierActionPerformed

    private void jMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu10ActionPerformed
        new AccueilClient().setVisible(true);
    }//GEN-LAST:event_jMenu10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ConsulterMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new ModifierMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ModifierMotDePasse().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new CreerCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new RechercheAvancee().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ConsulterMesCovoiturages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new ConsulterMesReservations().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new ConsulterMesMessages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        new ConsulterMesNotifications().setVisible(true);
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EnvoyerReclamation(covoitureurConnecte.getEmail()).setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void label_Message2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Message2MouseClicked
        new ConsulterMesMessagesNonLus(0).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_Message2MouseClicked

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        new AccueilClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMesCovoiturages().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Details;
    private javax.swing.JButton boutton_Modifier;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JButton boutton_Supprimer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Message1;
    private javax.swing.JLabel label_Message2;
    private javax.swing.JLabel label_Message3;
    private javax.swing.JLabel label_Notification1;
    private javax.swing.JLabel label_Notification2;
    private javax.swing.JLabel label_Notification3;
    private javax.swing.JLabel label_Photo;
    private javax.swing.JLabel label_PrenomNom;
    private javax.swing.JTable ta_Covoiturages;
    // End of variables declaration//GEN-END:variables
}