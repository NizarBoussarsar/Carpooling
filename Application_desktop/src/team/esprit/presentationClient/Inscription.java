package team.esprit.presentationClient;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import team.esprit.util.MailSender;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;

public class Inscription extends javax.swing.JFrame {

    private static final String _regexNom = "^([a-zA-Z'àâéèêôùûçÀÂÉÈÔÙÛÇ\\s-]{1,30})$";
    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";
    private static final String _regexMdp = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])\\S*$";

    public Inscription() {
        initComponents();
        this.setTitle("Formulaire d'inscription");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private String creerCleAvtivation() {
        return UUID.randomUUID().toString();
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_Pass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tf_NomUtilisateur = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dp_DateNaissance = new org.jdesktop.swingx.JXDatePicker();
        br_Homme = new javax.swing.JRadioButton();
        br_Femme = new javax.swing.JRadioButton();
        boutton_Valider = new javax.swing.JButton();
        boutton_Annuler = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_Prenom = new javax.swing.JTextField();
        tf_Nom = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Adresse E-Mail:");

        jLabel2.setText("Mot de passe:");

        jLabel3.setText("Nom d'utilisateur: ");

        jLabel4.setText("Date de naissance:");

        buttonGroup1.add(br_Homme);
        br_Homme.setText("Homme");

        buttonGroup1.add(br_Femme);
        br_Femme.setText("Femme");

        boutton_Valider.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Valider.setText("Valider");
        boutton_Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ValiderActionPerformed(evt);
            }
        });

        boutton_Annuler.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Annuler.setText("Annuler");
        boutton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AnnulerActionPerformed(evt);
            }
        });

        jLabel5.setText("Prénom:");

        jLabel6.setText("Nom:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(boutton_Valider)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                    .addComponent(boutton_Annuler)
                    .addGap(16, 16, 16))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tf_Pass, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(tf_Email))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(dp_DateNaissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(54, 54, 54)
                                    .addComponent(br_Homme)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(br_Femme)
                                    .addGap(32, 32, 32)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(tf_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dp_DateNaissance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(br_Femme)
                    .addComponent(br_Homme))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Valider)
                    .addComponent(boutton_Annuler))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ValiderActionPerformed
        Covoitureur covoitureur = new Covoitureur();
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        MailSender mailController = new MailSender();
        if (tf_Email.getText().matches(_regexAdressEmail) == false) {
            JOptionPane.showMessageDialog(this, "Adresse E-Mail invalide !", null, 2);
        } else if (tf_Email.getText().matches(_regexAdressEmail)) {
            if (tf_Pass.getText().matches(_regexMdp) == false) {
                JOptionPane.showMessageDialog(this, "Le mot de passe doit contenir 8 caractéres dont au "
                        + "moin une lettre miniscule, une lettre majuscule, un chifre !", null, 2);
            } else if (tf_Pass.getText().matches(_regexMdp)) {
                if (tf_Nom.getText().matches(_regexNom) == false || tf_Prenom.getText().matches(_regexNom) == false) {
                    JOptionPane.showMessageDialog(this, "Nom / Prenom invalide !", null, 2);
                } else if (tf_Nom.getText().matches(_regexNom) || tf_Prenom.getText().matches(_regexNom)) {
                    if (dp_DateNaissance.getDate() == null) {
                        JOptionPane.showMessageDialog(this, "Selectionnez votre date de naissance !", null, 2);
                    } else if (br_Femme.isSelected() == false && br_Homme.isSelected() == false) {
                        JOptionPane.showMessageDialog(this, "Sélectionnez votre sexe !", null, 2);
                    } else {
                        covoitureur.setEmail(tf_Email.getText());
                        covoitureur.setMdp(MD5Crypt(tf_Pass.getPassword()));
                        covoitureur.setNomUtilisateur(tf_NomUtilisateur.getText());
                        covoitureur.setNom(tf_Nom.getText());
                        covoitureur.setPrenom(tf_Prenom.getText());
                        if (br_Homme.isSelected()) {
                            covoitureur.setSexe('H');
                        } else if (br_Femme.isSelected()) {
                            covoitureur.setSexe('F');
                        }
                        covoitureur.setFumeur(false);
                        try {
                            java.util.Date dateUTIL = dp_DateNaissance.getDate();
                            java.sql.Date dateSQL = new java.sql.Date(dateUTIL.getTime());
                            covoitureur.setDateNaissance(dateSQL);
                        } catch (NullPointerException e) {
                            e.getMessage();
                        }
                        covoitureur.setNote(0);
                        covoitureur.setEtat(1);
                        covoitureur.setAvatar(null);
                        covoitureur.setFacebook(null);
                        covoitureur.setDateDerniereVisite(null);
                        covoitureur.setCleActivation(creerCleAvtivation());
                        covoitureur.setIdFacebook(null);
                        if (covoitureurDAO.ajouterCovoitureur1(covoitureur)) {
                            String destinataire = covoitureur.getEmail();
                            String message = "Votre mot de passe est: \n" + tf_Pass.getText()
                                    + "\n\nVotre clé d'activation est la suivante:"
                                    + "\n" + covoitureur.getCleActivation() + ""
                                    + "\n\nVeuillez confirmer votre inscription à partir de lien www.covoiturage-tn.com/activation";
                            mailController.envoyerEmailConfimation(destinataire, message);
                            JOptionPane.showMessageDialog(this, "Inscription effectué avec succés !");
                            Authentification authentification = new Authentification();
                            this.dispose();
                            authentification.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(this, "Votre inscription n'a pas été effectué, réessayer ulturiérement !");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_boutton_ValiderActionPerformed
    private void boutton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AnnulerActionPerformed
        Authentification authentification = new Authentification();
        this.dispose();
        authentification.setVisible(true);
    }//GEN-LAST:event_boutton_AnnulerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inscription().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Annuler;
    private javax.swing.JButton boutton_Valider;
    private javax.swing.JRadioButton br_Femme;
    private javax.swing.JRadioButton br_Homme;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker dp_DateNaissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JTextField tf_Nom;
    private javax.swing.JTextField tf_NomUtilisateur;
    private javax.swing.JPasswordField tf_Pass;
    private javax.swing.JTextField tf_Prenom;
    // End of variables declaration//GEN-END:variables
}