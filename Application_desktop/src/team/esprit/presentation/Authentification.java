package team.esprit.presentation;

import team.esprit.util.FacebookGraph;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import team.esprit.util.MailSender;
import team.esprit.util.RandomString;
import team.esprit.dao.AdministrateurDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Administrateur;
import team.esprit.entities.Covoitureur;
import team.esprit.presentationAdministrateur.Accueil;
import team.esprit.presentationClient.AccueilClient;
import team.esprit.presentationClient.ValiderInscription;
import team.esprit.presentationClient.EnvoyerReclamation;
import team.esprit.presentationClient.Inscription;

public class Authentification extends javax.swing.JFrame {

    public static String API_KEY = "223128054546213";
    public static String SECRET = "16806cd00a4bc86473e9bca451b78d0d";
    public static String firstRequest = "https://graph.facebook.com/oauth/authorize?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";
    public static String secondRequest = "https://graph.facebook.com/oauth/access_token?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "client_secret=" + SECRET + "&code=";
    public static String access_token = "";
    public static boolean firstRequestDone = false;
    public static boolean secondRequestDone = false;
    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";
    private static final String _regexMdp = "^\\S*(?=\\S{8,})(?=\\S*[a-z])(?=\\S*[A-Z])(?=\\S*[\\d])\\S*$";
    public static Covoitureur covoitureurConnecte;

    public Authentification() {
        initComponents();
        setTitle("Authentification");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        try {
//            UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    private void close() {
        JOptionPane.showMessageDialog(this, "Bienvenue " + covoitureurConnecte.getPrenom() + " " + covoitureurConnecte.getNom() + " :)");
        new AccueilClient().setVisible(true);
        this.dispose();
    }

    private String creerNouveauMotPasse() {
        RandomString randomString = new RandomString(8);
        String motPass = randomString.nextString();
        StringBuilder newMotPass = new StringBuilder(motPass);
        newMotPass.setCharAt(0, '0');
        newMotPass.setCharAt(3, 'x');
        newMotPass.setCharAt(7, 'X');
        return newMotPass.toString();
    }

    private String MD5Crypt(char[] textField) {
        String mdp = "";
        try {
            for (int i = 0; i < textField.length; i++) {
                mdp = mdp + textField[i];
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(mdp.getBytes());
            byte[] digest = messageDigest.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            String hashText = bigInt.toString(16);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_Email = new javax.swing.JTextField();
        boutton_Authentifier = new javax.swing.JButton();
        tf_Pass = new javax.swing.JPasswordField();
        boutton_Reinitialiser = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        boutton_LoginFacebook = new javax.swing.JButton();
        boutton_Inscription = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        boutton_Reclamation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Adresse E-Mail:");

        jLabel2.setText("Mot de passe:");

        boutton_Authentifier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Authentifier.setText("M'authentifier");
        boutton_Authentifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AuthentifierActionPerformed(evt);
            }
        });

        boutton_Reinitialiser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Reinitialiser.setText("Réinitialiser mon mot de passe");
        boutton_Reinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ReinitialiserActionPerformed(evt);
            }
        });

        boutton_LoginFacebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/team/esprit/presentation/facebook.jpg"))); // NOI18N
        boutton_LoginFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_LoginFacebookActionPerformed(evt);
            }
        });

        boutton_Inscription.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        boutton_Inscription.setText("Je m'inscris !");
        boutton_Inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_InscriptionActionPerformed(evt);
            }
        });

        boutton_Reclamation.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Reclamation.setText("Envoyer une réclamation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(boutton_Authentifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_LoginFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(boutton_Reclamation, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boutton_Reinitialiser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_Inscription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(boutton_LoginFacebook, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Authentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_Reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(boutton_Reclamation, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AuthentifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AuthentifierActionPerformed
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        covoitureurConnecte = covoitureurDAO.afficherCovoitureurEMAIL(tf_Email.getText());
        covoitureurDAO.modifierConnecte(covoitureurConnecte);
        Administrateur administrateur = administrateurDAO.afficherInformations();
        if (tf_Email.getText().matches(_regexAdressEmail) == false) {
            JOptionPane.showMessageDialog(this, "Adresse E-Mail invalide !", null, 2);
        } else {
            if (tf_Pass.getText().matches(_regexMdp) == false) {
                JOptionPane.showMessageDialog(this, "Le mot de passe doit contenir 8 caractéres dont au "
                        + "moin une lettre miniscule, une lettre majuscule ets un chifre !", null, 2);
            } else {
                if (tf_Email.getText().equals(administrateur.getEmail()) && (((MD5Crypt(tf_Pass.getPassword()).equals(administrateur.getMdp()))))) {
                    JOptionPane.showMessageDialog(this, "Bienvenue Administrateur :)");
                    this.dispose();
                    Accueil accueil = new Accueil();
                    accueil.setVisible(true);
                } else if ((tf_Email.getText().equals(covoitureurConnecte.getEmail())) && ((MD5Crypt(tf_Pass.getPassword()).equals(covoitureurConnecte.getMdp())))) {
                    if (covoitureurConnecte.getEtat() == 1) {
                        if (covoitureurConnecte.getSexe() == 'X') {
                            int choix = JOptionPane.showConfirmDialog(this, "Bonjour " + covoitureurConnecte.getEmail() + ", "
                                    + "veuillez valider votre inscription afin "
                                    + "de pouvoir accéder à notre application. Merci", null, 2, 3);
                            if (choix == 0) {
                                ValiderInscription validerInscription =
                                        new ValiderInscription(covoitureurConnecte);
                                validerInscription.setVisible(true);
                            }
                        } else if (covoitureurConnecte.getSexe() == 'F') {
                            int choix = JOptionPane.showConfirmDialog(this, "Bonjour Madame, "
                                    + "veuillez valider votre inscription afin"
                                    + " de pouvoir accéder à notre application. Merci", null, 2, 3);
                            if (choix == 0) {
                                ValiderInscription validerInscription = new ValiderInscription(covoitureurConnecte);
                                validerInscription.setVisible(true);
                            }
                        } else if (covoitureurConnecte.getSexe() == 'H') {
                            int choix = JOptionPane.showConfirmDialog(this, "Bonjour Monsieur, "
                                    + "veuillez valider votre inscription afin"
                                    + " de pouvoir accéder à notre application. Merci", null, 2, 3);
                            if (choix == 0) {
                                ValiderInscription validerInscription =
                                        new ValiderInscription(covoitureurConnecte);
                                this.dispose();
                                validerInscription.setVisible(true);
                            }
                        }
                    } else if (covoitureurConnecte.getEtat() == 0) {
                        if (covoitureurConnecte.getSexe() == 'X') {
                            int choix = JOptionPane.showConfirmDialog(this, "Désolé " + covoitureurConnecte.getEmail()
                                    + ", vous etes bloquée par l'Administrateur. "
                                    + "Vous pouvez lui envoyer une réclamation.", null, 2, 3);
                            if (choix == 0) {
                                EnvoyerReclamation envoyerReclamation =
                                        new EnvoyerReclamation(covoitureurConnecte.getEmail());
                                this.dispose();
                                envoyerReclamation.setVisible(true);
                            }
                        } else if (covoitureurConnecte.getSexe() == 'F') {
                            int choix = JOptionPane.showConfirmDialog(this, "Désolé Madame "
                                    + covoitureurConnecte.getPrenom()
                                    + " " + covoitureurConnecte.getNom() + ", vous etes bloquée par l'Administrateur. "
                                    + "Vous pouvez lui envoyer une réclamation.", null, 2, 3);
                            if (choix == 0) {
                                EnvoyerReclamation envoyerReclamation = new EnvoyerReclamation(covoitureurConnecte.getEmail());
                                this.dispose();
                                envoyerReclamation.setVisible(true);
                            }
                        } else if (covoitureurConnecte.getSexe() == 'H') {
                            int choix = JOptionPane.showConfirmDialog(this, "Désolé Monsieur "
                                    + covoitureurConnecte.getPrenom()
                                    + " " + covoitureurConnecte.getNom() + ", vous etes bloquée par l'Administrateur. "
                                    + "Vous pouvez lui envoyer une réclamation.", "Bloqué", 2, 3);
                            if (choix == 0) {
                                EnvoyerReclamation envoyerReclamation = new EnvoyerReclamation(covoitureurConnecte.getEmail());
                                this.dispose();
                                envoyerReclamation.setVisible(true);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Bienvenue " + covoitureurConnecte.getPrenom()
                                + " " + covoitureurConnecte.getNom() + " :)");
                        this.dispose();
                        new AccueilClient().setVisible(true);
                    }
                    if ((covoitureurConnecte.getSexe() == 'X')
                            || (covoitureurConnecte.getNom() == null)
                            || (covoitureurConnecte.getPrenom() == null)) {
                        JOptionPane.showMessageDialog(this, "Veuillez mettre à jour votre profil. Vérifier votre sexe, votre nom et votre prénom.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Combinaison Email - Mot de passe invalide ! Veuillez vérifier vos coordonnées !", null, 2);
                }
            }
        }
    }//GEN-LAST:event_boutton_AuthentifierActionPerformed
    private void boutton_ReinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ReinitialiserActionPerformed
        MailSender mailController = new MailSender();
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        AdministrateurDAO administrateurDAO = new AdministrateurDAO();
        Administrateur administrateur = administrateurDAO.afficherInformations();
        covoitureurConnecte = covoitureurDAO.afficherCovoitureurEMAIL(tf_Email.getText());
        if (tf_Email.getText().matches(_regexAdressEmail) == false) {
            JOptionPane.showMessageDialog(this, "Adresse E-Mail invalide !", null, 2);
        } else {
            int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment réinitialiser votre mot de passe ?", null, 2);
            if (choix == 0) {
                String motPasse = creerNouveauMotPasse();
                String destinataire = tf_Email.getText();
                String msg = "Votre nouveau mot de passe est:\n\n" + motPasse;
                char[] password = motPasse.toCharArray();
                String MD5Pass = MD5Crypt(password);
                System.out.println(motPasse);
                System.out.println(MD5Pass);
                if (tf_Email.getText().equals(administrateur.getEmail())) {
                    if (mailController.envoyerEmailReinitialisationMotPasse(destinataire, msg)
                            && administrateurDAO.modifierMotPasse(administrateur, MD5Pass)) {
                        JOptionPane.showMessageDialog(this, "Votre mot de passe a été réinitialisé. Vérifiez votre boite e-mail.");
                    }
                } else if (tf_Email.getText().equals(covoitureurConnecte.getEmail())) {
                    if (mailController.envoyerEmailReinitialisationMotPasse(destinataire, msg)
                            && covoitureurDAO.modifierMotPasse(covoitureurConnecte, MD5Pass)) {
                        JOptionPane.showMessageDialog(this, "Votre mot de passe a été réinitialisé. Vérifiez votre boite e-mail.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Votre mot de passe n'a pas été réinitialisé !", null, 2);
                }
            }
        }
    }//GEN-LAST:event_boutton_ReinitialiserActionPerformed

    private void boutton_InscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_InscriptionActionPerformed
        Inscription inscription = new Inscription();
        this.dispose();
        inscription.setVisible(true);
    }//GEN-LAST:event_boutton_InscriptionActionPerformed

    private void boutton_LoginFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_LoginFacebookActionPerformed
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                NativeInterface.open();
                NativeInterface.initialize();
                final JFrame authFrame = new JFrame();
                JPanel webBrowserPanel = new JPanel(new BorderLayout());
                final JWebBrowser webBrowser = new JWebBrowser();
                webBrowser.setMenuBarVisible(false);
                webBrowser.setButtonBarVisible(false);
                webBrowser.setLocationBarVisible(false);
                webBrowser.navigate(firstRequest);
                webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
                    @Override
                    public void locationChanged(WebBrowserNavigationEvent e) {
                        super.locationChanged(e);
                        if (!firstRequestDone) {
                            if (e.getNewResourceLocation().contains("http://www.facebook.com/connect/login_success.html?code=")) {
                                authFrame.setVisible(false);
                                String[] splits = e.getNewResourceLocation().split("=");
                                String stage2temp = secondRequest + splits[1];
                                webBrowser.navigate(stage2temp);
                                firstRequestDone = true;
                            }
                        } else {
                            if (!secondRequestDone) {
                                StringReader readerSTR = new StringReader(webBrowser.getHTMLContent());
                                HTMLEditorKit.ParserCallback callback = new HTMLEditorKit.ParserCallback() {
                                    @Override
                                    public void handleText(char[] data, int pos) {
                                        webBrowser.disposeNativePeer();
                                        String string = new String(data);
                                        String[] temp1 = string.split("&");
                                        String[] temp2 = temp1[0].split("=");
                                        access_token = temp2[1];
                                        try {
                                            covoitureurConnecte = new FacebookGraph(access_token).fetchObject();
                                        } catch (SQLException ex) {
                                            Logger.getLogger(Authentification.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        close();
                                    }
                                };
                                try {
                                    new ParserDelegator().parse(readerSTR, callback, false);
                                } catch (IOException e1) {
                                    System.out.println(e1);
                                }
                                authFrame.dispose();
                            }
                        }
                    }
                });
                webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
                authFrame.add(webBrowserPanel);
                authFrame.setSize(550, 400);
                authFrame.setVisible(true);
                authFrame.setLocationRelativeTo(null);
                authFrame.pack();
            }
        });
    }//GEN-LAST:event_boutton_LoginFacebookActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Authentifier;
    private javax.swing.JButton boutton_Inscription;
    private javax.swing.JButton boutton_LoginFacebook;
    private javax.swing.JButton boutton_Reclamation;
    private javax.swing.JButton boutton_Reinitialiser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tf_Email;
    private javax.swing.JPasswordField tf_Pass;
    // End of variables declaration//GEN-END:variables
}