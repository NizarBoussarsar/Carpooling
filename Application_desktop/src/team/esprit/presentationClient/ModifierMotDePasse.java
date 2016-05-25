package team.esprit.presentationClient;

import java.awt.Image;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ModifierMotDePasse extends javax.swing.JFrame {

    private static final String _regexMdp = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])\\S*$";
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

    public ModifierMotDePasse() {
        initComponents();
        this.setTitle("Modifier mon mot de passe");
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

    private String MD5Crypt(char[] textField) {
        String mdp = "";
        MessageDigest messageDigest;
        byte[] digest;
        BigInteger bigInt;
        String hashText;
        try {
            for (int i = 0; i < textField.length; i++) {
                mdp = mdp + textField[i];
            }
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(mdp.getBytes());
            digest = messageDigest.digest();
            bigInt = new BigInteger(1, digest);
            hashText = bigInt.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pf_ancienMotdePasse = new javax.swing.JPasswordField();
        pf_nouveauMotdePasse1 = new javax.swing.JPasswordField();
        pf_nouveauMotdePasse2 = new javax.swing.JPasswordField();
        button_Modifier = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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

        button_Modifier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        button_Modifier.setText("Modifier");
        button_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ModifierActionPerformed(evt);
            }
        });

        jLabel1.setText("Ancien mot de passe ");

        jLabel2.setText("Nouveau mot de passe");

        jLabel3.setText("Nouveau mot de passe");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(pf_nouveauMotdePasse2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pf_ancienMotdePasse, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(pf_nouveauMotdePasse1))))
                .addGap(60, 60, 60)
                .addComponent(button_Modifier)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pf_ancienMotdePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pf_nouveauMotdePasse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(button_Modifier))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pf_nouveauMotdePasse2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ModifierActionPerformed
        if (pf_ancienMotdePasse.getText().matches(_regexMdp) == false || pf_nouveauMotdePasse1.getText().matches(_regexMdp) == false || pf_nouveauMotdePasse2.getText().matches(_regexMdp) == false) {
            JOptionPane.showMessageDialog(this, "Le mot de passe doit contenir 8 caractéres dont au "
                    + "moin une lettre miniscule, une lettre majuscule, un chifre !", null, 2);
        } else {
            if (MD5Crypt(pf_ancienMotdePasse.getPassword()).equals(covoitureurConnecte.getMdp())) {
                if (pf_nouveauMotdePasse1.getText().equals(pf_nouveauMotdePasse2.getText())) {
                    String motPasse = pf_nouveauMotdePasse1.getText();
                    char[] password = motPasse.toCharArray();
                    String MD5Pass = MD5Crypt(password);
                    covoitureurDAO.modifierMotPasse(covoitureurConnecte, MD5Pass);
                    JOptionPane.showMessageDialog(null, "Mot de passe est mis a jour !");
                } else {
                    JOptionPane.showMessageDialog(null, "Les deux nouveaux mot de passe ne sont pas egaux !", null, 2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Vérifier votre mot de passe !", null, 2);
            }
        }
    }//GEN-LAST:event_button_ModifierActionPerformed

    private void label_Message2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_Message2MouseClicked
        new ConsulterMesMessagesNonLus(0).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_label_Message2MouseClicked

    private void jMenu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu9MouseClicked
        new AccueilClient().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenu9MouseClicked

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new ConsulterMonProfile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierMotDePasse().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Modifier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPasswordField pf_ancienMotdePasse;
    private javax.swing.JPasswordField pf_nouveauMotdePasse1;
    private javax.swing.JPasswordField pf_nouveauMotdePasse2;
    // End of variables declaration//GEN-END:variables
}