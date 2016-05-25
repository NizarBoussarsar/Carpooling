package team.esprit.presentationClient;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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

public class ConsulterMonProfile extends javax.swing.JFrame {

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

    public ConsulterMonProfile() {
        initComponents();
        this.setTitle("Consulter Mon Profile");
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

        bg_Sexe = new javax.swing.ButtonGroup();
        bg_fumeur = new javax.swing.ButtonGroup();
        boutton_Modifier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_Nom = new javax.swing.JTextField();
        tf_Prenom = new javax.swing.JTextField();
        tf_NomUtilisateur = new javax.swing.JTextField();
        tf_Facebook = new javax.swing.JTextField();
        rb_homme = new javax.swing.JRadioButton();
        rb_femme = new javax.swing.JRadioButton();
        rb_oui = new javax.swing.JRadioButton();
        rb_non = new javax.swing.JRadioButton();
        dp_DateNaissance = new org.jdesktop.swingx.JXDatePicker();
        tf_Email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label_PrenomNom = new javax.swing.JLabel();
        label_Photo = new javax.swing.JLabel();
        label_Message1 = new javax.swing.JLabel();
        label_Message2 = new javax.swing.JLabel();
        label_Message3 = new javax.swing.JLabel();
        label_Notification1 = new javax.swing.JLabel();
        label_Notification2 = new javax.swing.JLabel();
        label_Notification3 = new javax.swing.JLabel();
        boutton_Retour = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        boutton_Modifier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Modifier.setText("Modifier");
        boutton_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierActionPerformed(evt);
            }
        });

        jLabel1.setText("Nom");

        jLabel2.setText("Prénom");

        jLabel3.setText("Sexe");

        jLabel4.setText("Nom d'utilisateur");

        jLabel5.setText("Date de naissance");

        jLabel7.setText("Facebook");

        jLabel8.setText("Fumeur");

        tf_Nom.setEditable(false);

        tf_Prenom.setEditable(false);

        tf_NomUtilisateur.setEditable(false);

        tf_Facebook.setEditable(false);

        bg_Sexe.add(rb_homme);
        rb_homme.setText("Homme");
        rb_homme.setEnabled(false);

        bg_Sexe.add(rb_femme);
        rb_femme.setText("Femme");
        rb_femme.setEnabled(false);

        bg_fumeur.add(rb_oui);
        rb_oui.setText("Oui");
        rb_oui.setEnabled(false);

        bg_fumeur.add(rb_non);
        rb_non.setText("Non");
        rb_non.setEnabled(false);

        dp_DateNaissance.setEnabled(false);

        tf_Email.setEnabled(false);

        jLabel9.setText("Email");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                    .addComponent(label_Notification3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        jMenu9.setText("Accueil");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu9);

        jMenu1.setText("Profil");

        jMenuItem1.setText("Consulter profil");
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(88, 88, 88)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_Facebook, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rb_oui)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_non))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(110, 110, 110)
                                .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel2))
                                    .addGap(55, 55, 55)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_Nom)
                                        .addComponent(tf_Prenom)
                                        .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(rb_homme)
                                            .addGap(18, 18, 18)
                                            .addComponent(rb_femme))
                                        .addComponent(dp_DateNaissance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(boutton_Modifier)
                        .addGap(40, 40, 40)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_homme)
                        .addComponent(rb_femme)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(dp_DateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_Facebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rb_oui)
                        .addComponent(rb_non))
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Modifier)
                    .addComponent(boutton_Retour))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierActionPerformed

        ModifierMonProfile modifierProfile = new ModifierMonProfile();
        modifierProfile.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_ModifierActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        tf_Nom.setText(covoitureurConnecte.getNom());
        tf_Prenom.setText(covoitureurConnecte.getPrenom());
        tf_Facebook.setText(covoitureurConnecte.getFacebook());
        tf_NomUtilisateur.setText(covoitureurConnecte.getNomUtilisateur());
        tf_Email.setText(covoitureurConnecte.getEmail());
        if (covoitureurConnecte.isFumeur() == true) {
            bg_Sexe.setSelected(rb_oui.getModel(), true);
        } else if ((covoitureurConnecte.isFumeur() == false)) {
            bg_Sexe.setSelected(rb_non.getModel(), true);
        }
        if (covoitureurConnecte.getSexe() == 'H') {
            bg_Sexe.setSelected(rb_homme.getModel(), true);
        } else if (covoitureurConnecte.getSexe() == 'F') {
            bg_Sexe.setSelected(rb_femme.getModel(), true);
        }
        dp_DateNaissance.setFormats(new String[]{"MM/dd/yyyy"});
        dp_DateNaissance.setDate(covoitureurConnecte.getDateNaissance());
    }//GEN-LAST:event_formWindowOpened

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        new AccueilClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void label_Message2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Message2MouseClicked
        new ConsulterMesMessagesNonLus(0).setVisible(true);
    }//GEN-LAST:event_label_Message2MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        new AccueilClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ModifierMotDePasse().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new CreerCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new RechercherCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ConsulterMesCovoiturages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new ConsulterMesReservations().setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new ConsulterMesMessages(covoitureurConnecte).setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new ConsulterMesNotifications().setVisible(true);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new EnvoyerReclamation(covoitureurConnecte.getEmail()).setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new APropos().setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsulterMonProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_Sexe;
    private javax.swing.ButtonGroup bg_fumeur;
    private javax.swing.JButton boutton_Modifier;
    private javax.swing.JButton boutton_Retour;
    private org.jdesktop.swingx.JXDatePicker dp_DateNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
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
    private javax.swing.JLabel label_Message1;
    private javax.swing.JLabel label_Message2;
    private javax.swing.JLabel label_Message3;
    private javax.swing.JLabel label_Notification1;
    private javax.swing.JLabel label_Notification2;
    private javax.swing.JLabel label_Notification3;
    private javax.swing.JLabel label_Photo;
    private javax.swing.JLabel label_PrenomNom;
    private javax.swing.JRadioButton rb_femme;
    private javax.swing.JRadioButton rb_homme;
    private javax.swing.JRadioButton rb_non;
    private javax.swing.JRadioButton rb_oui;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_Facebook;
    private javax.swing.JTextField tf_Nom;
    private javax.swing.JTextField tf_NomUtilisateur;
    private javax.swing.JTextField tf_Prenom;
    // End of variables declaration//GEN-END:variables
}