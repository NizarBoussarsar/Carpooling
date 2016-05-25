package team.esprit.presentationAdministrateur;

import team.esprit.presentation.Authentification;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;

public class ModifierCovoitureur extends javax.swing.JFrame {

    private static final String _regexNom = "^([a-zA-Z'àâéèêôùûçÀÂÉÈÔÙÛÇ\\s-]{1,30})$";
    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";
    private static final String _regexMdp = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])\\S*$";
    Covoitureur covoitureur;
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();

    public ModifierCovoitureur() {
        this.dispose();
        initialise();
    }

    public ModifierCovoitureur(Covoitureur covoitureur) {
        initComponents();
        setTitle("Modifier un Covoitureur");
        initialise();
        this.covoitureur = covoitureur;
        initialiserComposants();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initialiserComposants() {
        tf_Nom.setText(covoitureur.getNom());
        tf_Prenom.setText(covoitureur.getPrenom());
        if (covoitureur.getEtat() == 0) {
            cb_Etat.setSelectedIndex(0);
        } else if (covoitureur.getEtat() == 1) {
            cb_Etat.setSelectedIndex(1);
        } else if (covoitureur.getEtat() == 2) {
            cb_Etat.setSelectedIndex(2);
        }
        tf_NomUtilisateur.setText(covoitureur.getNomUtilisateur());
        dp_Date.setDate(covoitureur.getDateNaissance());
        if (covoitureur.isFumeur() == true) {
            rb_Oui.setSelected(true);
        } else {
            rb_Non.setSelected(true);
        }
        if (covoitureur.getSexe() == 'H') {
            rb_Homme.setSelected(true);
        } else {
            rb_Femme.setSelected(true);
        }
    }

    public String MD5Crypt(char[] textField) {
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tf_NomUtilisateur = new javax.swing.JTextField();
        tf_Nom = new javax.swing.JTextField();
        tf_Prenom = new javax.swing.JTextField();
        rb_Homme = new javax.swing.JRadioButton();
        rb_Femme = new javax.swing.JRadioButton();
        rb_Oui = new javax.swing.JRadioButton();
        rb_Non = new javax.swing.JRadioButton();
        boutton_Retour = new javax.swing.JButton();
        boutton_Modifer = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        dp_Date = new org.jdesktop.swingx.JXDatePicker();
        cb_Etat = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("Nom Utlisateur:");

        jLabel5.setText("Nom:");

        jLabel6.setText("Prenom:");

        jLabel7.setText("Sexe:");

        jLabel13.setText("Fumeur :");

        jLabel14.setText("Date de naissance:");

        buttonGroup1.add(rb_Homme);
        rb_Homme.setText("Homme");

        buttonGroup1.add(rb_Femme);
        rb_Femme.setText("Femme");

        buttonGroup2.add(rb_Oui);
        rb_Oui.setText("Oui");

        buttonGroup2.add(rb_Non);
        rb_Non.setText("Non");

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_Modifer.setText("Modifier");
        boutton_Modifer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModiferActionPerformed(evt);
            }
        });

        jLabel8.setText("Etat:");

        cb_Etat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cb_Etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dp_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_Nom)
                            .addComponent(tf_Prenom)
                            .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boutton_Modifer)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rb_Homme)
                                    .addComponent(rb_Femme))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(boutton_Retour))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rb_Non)
                            .addComponent(rb_Oui))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_NomUtilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_Nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(tf_Prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dp_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rb_Femme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rb_Homme))
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rb_Oui)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rb_Non)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_Etat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Modifer)
                    .addComponent(boutton_Retour))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_ModiferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModiferActionPerformed
//        if (tf_Email.getText().matches(_regexAdressEmail) == false) {
//            JOptionPane.showMessageDialog(this, "Adresse E-Mail invalide !", null, 2);
//        } else {
        if (tf_Nom.getText().matches(_regexNom) == false) {
            JOptionPane.showMessageDialog(this, "Nom invalide !", null, 2);
        } else {
            if (tf_Prenom.getText().matches(_regexNom) == false) {
                JOptionPane.showMessageDialog(this, "Prenom invalide !", null, 2);
            } else {
                if (dp_Date.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Saisissez votre date de naissance !", null, 2);
                } else {
                    //covoitureur.setEmail(tf_Email.getText());
                    covoitureur.setNomUtilisateur(tf_NomUtilisateur.getText());
                    covoitureur.setNom(tf_Nom.getText());
                    covoitureur.setPrenom(tf_Prenom.getText());
                    covoitureur.setEtat(Integer.parseInt(cb_Etat.getSelectedItem().toString()));
                    if (rb_Homme.isSelected()) {
                        covoitureur.setSexe('H');
                    } else {
                        covoitureur.setSexe('F');
                    }
                    java.util.Date dateNaissanceUTIL = dp_Date.getDate();
                    java.sql.Date dateNaissanceSQL = new java.sql.Date(dateNaissanceUTIL.getTime());
                    covoitureur.setDateNaissance(dateNaissanceSQL);
                    if (rb_Oui.isSelected()) {
                        covoitureur.setFumeur(true);
                    } else {
                        covoitureur.setFumeur(false);
                    }
                    if (covoitureurDAO.modifierCovoitureur(covoitureur)) {
                        JOptionPane.showMessageDialog(this, "Modification effectué avec succés.");
                    }
                }
            }
        }
    }//GEN-LAST:event_boutton_ModiferActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        new RechercherCovoitureur().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifierCovoitureur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierCovoitureur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Modifer;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cb_Etat;
    private org.jdesktop.swingx.JXDatePicker dp_Date;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JRadioButton rb_Femme;
    private javax.swing.JRadioButton rb_Homme;
    private javax.swing.JRadioButton rb_Non;
    private javax.swing.JRadioButton rb_Oui;
    private javax.swing.JTextField tf_Nom;
    private javax.swing.JTextField tf_NomUtilisateur;
    private javax.swing.JTextField tf_Prenom;
    // End of variables declaration//GEN-END:variables
}