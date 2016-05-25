package team.esprit.presentationClient;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
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

public class ModifierMonProfile extends javax.swing.JFrame {

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
    File file;

    public ModifierMonProfile() {
        initComponents();
        this.setTitle("Modifier mon profile");
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

        bg_Sexe = new javax.swing.ButtonGroup();
        bg_fumeur = new javax.swing.ButtonGroup();
        tf_Prenom = new javax.swing.JTextField();
        tf_Email = new javax.swing.JTextField();
        tf_Nom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dp_DateNaissance = new org.jdesktop.swingx.JXDatePicker();
        tf_Facebook = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tf_NomUtilisateur = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rb_oui = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        rb_non = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rb_homme = new javax.swing.JRadioButton();
        rb_femme = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        button_enregistrer = new javax.swing.JButton();
        button_ChoisirUneImage = new javax.swing.JButton();
        tf_AvatarPath = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        label_PrenomNom = new javax.swing.JLabel();
        label_Photo = new javax.swing.JLabel();
        label_Message1 = new javax.swing.JLabel();
        label_Message2 = new javax.swing.JLabel();
        label_Message3 = new javax.swing.JLabel();
        label_Notification1 = new javax.swing.JLabel();
        label_Notification2 = new javax.swing.JLabel();
        label_Notification3 = new javax.swing.JLabel();
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

        jLabel9.setText("Email");

        jLabel8.setText("Fumeur");

        jLabel1.setText("Nom:");

        jLabel2.setText("Prénom");

        jLabel3.setText("Sexe");

        bg_fumeur.add(rb_oui);
        rb_oui.setText("Oui");

        jLabel4.setText("Nom d'utilisateur");

        bg_fumeur.add(rb_non);
        rb_non.setText("Non");

        jLabel5.setText("Date de naissance");

        bg_Sexe.add(rb_homme);
        rb_homme.setText("Homme");

        bg_Sexe.add(rb_femme);
        rb_femme.setText("Femme");

        jLabel7.setText("Facebook");

        button_enregistrer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_enregistrer.setText("Enregistrer");
        button_enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_enregistrerActionPerformed(evt);
            }
        });

        button_ChoisirUneImage.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_ChoisirUneImage.setText("Choisir une image");
        button_ChoisirUneImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ChoisirUneImageActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_PrenomNom)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_Notification1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Notification2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Notification3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_Message1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Message2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_Message3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(label_PrenomNom)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Message1)
                    .addComponent(label_Message2)
                    .addComponent(label_Message3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Notification1)
                    .addComponent(label_Notification2)
                    .addComponent(label_Notification3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label_Photo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu9.setText("Accueil");
        jMenu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu9MouseClicked(evt);
            }
        });
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dp_DateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rb_homme)
                            .addGap(18, 18, 18)
                            .addComponent(rb_femme))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_Nom)
                            .addComponent(tf_Prenom)
                            .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rb_oui)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rb_non))
                        .addComponent(tf_Facebook, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addComponent(tf_Email)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_enregistrer)
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tf_AvatarPath, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(button_ChoisirUneImage)
                        .addGap(43, 43, 43))))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tf_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(rb_femme)
                            .addComponent(rb_homme)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tf_AvatarPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_ChoisirUneImage)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dp_DateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_Facebook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(rb_oui)
                            .addComponent(rb_non)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(button_enregistrer)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
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
    }//GEN-LAST:event_formWindowOpened

    private void button_ChoisirUneImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ChoisirUneImageActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            tf_AvatarPath.setText(path);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_button_ChoisirUneImageActionPerformed

    private void label_Message2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Message2MouseClicked
        new ConsulterMesMessagesNonLus(0).setVisible(true);
    }//GEN-LAST:event_label_Message2MouseClicked

    private void button_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_enregistrerActionPerformed
        try {
            FileInputStream fis = new FileInputStream(file);
            int len = (int) file.length();
            covoitureurDAO.modifierAvatar(covoitureurConnecte.getId(), fis, len);
            java.util.Date dateUTIL = dp_DateNaissance.getDate();
            java.sql.Date dateSQL = new java.sql.Date(dateUTIL.getTime());
            covoitureurConnecte.setDateNaissance(dateSQL);
            covoitureurConnecte.setEmail(tf_Email.getText());
            covoitureurConnecte.setNom(tf_Nom.getText());
            covoitureurConnecte.setPrenom(tf_Prenom.getText());
            if (rb_oui.isSelected()) {
                covoitureurConnecte.setFumeur(true);
            }
            if (rb_non.isSelected()) {
                covoitureurConnecte.setFumeur(false);
            }
            if (rb_femme.isSelected()) {
                covoitureurConnecte.setSexe('F');
            }
            if (rb_homme.isSelected()) {
                covoitureurConnecte.setSexe('H');
            }
            covoitureurConnecte.setFacebook(tf_Facebook.getText());
            covoitureurDAO.modifierCovoitureur(covoitureurConnecte);
            covoitureurConnecte.setAvatar(covoitureurDAO.getAvatar(covoitureurConnecte.getId()));
            this.dispose();
            new AccueilClient().setVisible(true);
        } catch (Exception e) {
            System.out.println("boutton error " + e.getMessage());
        }
    }//GEN-LAST:event_button_enregistrerActionPerformed

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        new AccueilClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu9MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ConsulterMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new CreerCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new RechercherCovoiturage().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ConsulterMesCovoiturages(covoitureurConnecte).setVisible(true);
        this.setVisible(true);
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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new ModifierMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierMonProfile().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_Sexe;
    private javax.swing.ButtonGroup bg_fumeur;
    private javax.swing.JButton button_ChoisirUneImage;
    private javax.swing.JButton button_enregistrer;
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
    private javax.swing.JPanel jPanel2;
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
    private javax.swing.JTextField tf_AvatarPath;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_Facebook;
    private javax.swing.JTextField tf_Nom;
    private javax.swing.JTextField tf_NomUtilisateur;
    private javax.swing.JTextField tf_Prenom;
    // End of variables declaration//GEN-END:variables
}