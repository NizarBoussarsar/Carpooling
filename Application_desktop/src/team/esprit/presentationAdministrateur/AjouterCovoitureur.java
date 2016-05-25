package team.esprit.presentationAdministrateur;

import team.esprit.presentation.Authentification;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import team.esprit.util.MailSender;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;

public class AjouterCovoitureur extends javax.swing.JFrame {

    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";
    private static final String _regexMdp = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])\\S*$";
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    MailSender reclamationController = new MailSender();
    Covoitureur covoitureur = new Covoitureur();

    public AjouterCovoitureur() {
        initComponents();
        setTitle("Ajouter un Covoitureur");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public String creerCleAvtivation() {
        return UUID.randomUUID().toString();
    }

    public String MD5Crypt(char[] textField) {
        String mdp = "", hashText;
        MessageDigest messageDigest;
        byte[] digest;
        BigInteger bigInt;
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

        boutton_Ajouter = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        label_Login = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();
        label_Login1 = new javax.swing.JLabel();
        tf_MotDePasse = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_Ajouter.setText("Ajouter");
        boutton_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AjouterActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        label_Login.setText("Adresse E-Mail:");

        label_Login1.setText("Mot de passe :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_Login1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_MotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boutton_Ajouter)
                        .addGap(49, 49, 49)
                        .addComponent(boutton_Retour)
                        .addGap(64, 64, 64)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Login)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_Login1)
                    .addComponent(tf_MotDePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Retour)
                    .addComponent(boutton_Ajouter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        new GestionCovoitureurs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    @SuppressWarnings("deprecated")
    private void boutton_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AjouterActionPerformed
        if (tf_Email.getText().matches(_regexAdressEmail) == false) {
            JOptionPane.showMessageDialog(this, "Adresse E-Mail invalide !", null, 2);
        } else if (tf_Email.getText().matches(_regexAdressEmail) == true) {
            if (tf_MotDePasse.getText().matches(_regexMdp) == false) {
                JOptionPane.showMessageDialog(this, "Le mot de passe doit contenir 8 caractéres dont au moin une lettre miniscule, une lettre majuscule, un chifre !", null, 2);
            } else if (tf_MotDePasse.getText().matches(_regexMdp) == true) {
                covoitureur.setEmail(tf_Email.getText());
                covoitureur.setMdp(MD5Crypt(tf_MotDePasse.getPassword()));
                covoitureur.setNomUtilisateur(null);
                covoitureur.setNom(null);
                covoitureur.setPrenom(null);
                //char sexe = 'X';
                covoitureur.setSexe('X');
                covoitureur.setFumeur(false);
                covoitureur.setDateNaissance(Date.valueOf("1991-01-01"));
                covoitureur.setNote(0);
                covoitureur.setEtat(1);
                covoitureur.setAvatar(null);
                covoitureur.setFacebook(null);
                covoitureur.setDateDerniereVisite(null);
                covoitureur.setCleActivation(creerCleAvtivation());
                covoitureur.setIdFacebook(null);
                if (covoitureurDAO.ajouterCovoitureur1(covoitureur) == true) {
                    String destinataire = covoitureur.getEmail();
                    String message = "Votre mot de passe est: \n" + tf_MotDePasse.getText()
                            + "\n\nVotre clé d'activation est la suivante:"
                            + "\n" + covoitureur.getCleActivation() + ""
                            + "\n\nVeuillez confirmer votre inscription à partir de lien www.covoiturage-tn.com/activation";
                    reclamationController.envoyerEmailConfimation(destinataire, message);
                    JOptionPane.showMessageDialog(this, "Ajout effectué avec succés ");
                }
            }
        }
    }//GEN-LAST:event_boutton_AjouterActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterCovoitureur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Ajouter;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JLabel label_Login;
    private javax.swing.JLabel label_Login1;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JPasswordField tf_MotDePasse;
    // End of variables declaration//GEN-END:variables
}