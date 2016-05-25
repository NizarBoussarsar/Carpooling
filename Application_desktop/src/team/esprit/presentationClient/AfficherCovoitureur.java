package team.esprit.presentationClient;

import java.awt.Toolkit;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.MessageDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;

public class AfficherCovoitureur extends javax.swing.JFrame {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    String informations;
    int idCovoitureur;
    int idCovoiturage;

    public AfficherCovoitureur() {
        this.dispose();
        initialise();
    }
    
    public AfficherCovoitureur(String informations, int idCovoitueur, int idCovoiturage) {
        this.idCovoitureur = idCovoitueur;
        this.idCovoiturage = idCovoiturage;
        this.informations = informations;
        initComponents();
        setTitle("Afficher un covoitureur");
        initialise();
        cb_Score.setSelectedItem(0);
        ta_Covoitureur.setText(informations);
        ta_Covoitureur.setLineWrap(true);
        ta_Covoitureur.setWrapStyleWord(true);
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

        boutton_Retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Covoitureur = new javax.swing.JTextArea();
        Boutton_Evaluer = new javax.swing.JButton();
        cb_Score = new javax.swing.JComboBox();
        boutton_Envoyer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        ta_Covoitureur.setEditable(false);
        ta_Covoitureur.setColumns(20);
        ta_Covoitureur.setRows(5);
        jScrollPane1.setViewportView(ta_Covoitureur);

        Boutton_Evaluer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boutton_Evaluer.setText("Evaluer");
        Boutton_Evaluer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boutton_EvaluerActionPerformed(evt);
            }
        });

        cb_Score.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-3", "-2", "-1", "0", "1", "2", "3", " " }));
        cb_Score.setToolTipText("");

        boutton_Envoyer.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Envoyer.setText("Envoyer message");
        boutton_Envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_EnvoyerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 28, Short.MAX_VALUE)
                        .addComponent(boutton_Retour)
                        .addGap(28, 28, 28)
                        .addComponent(boutton_Envoyer)
                        .addGap(27, 27, 27)
                        .addComponent(Boutton_Evaluer)
                        .addGap(31, 31, 31)
                        .addComponent(cb_Score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(boutton_Retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boutton_Evaluer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_Score, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Envoyer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void Boutton_EvaluerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boutton_EvaluerActionPerformed
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        
        int noteAjoutee = Integer.parseInt(cb_Score.getSelectedItem().toString());
        int ancienneNote = covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNote();
        
        if (idCovoitureur == covoitureurConnecte.getId()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "C'est votre profil !\nVous ne pouvez pas attribuer de note !");
        } else if (covoitureurDAO.participerEnsemble(covoitureurConnecte, covoitureurDAO.afficherCovoitureur_ID(idCovoitureur), covoiturageDAO.afficherCovoiturage_ID(this.idCovoiturage)) != 2) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Vous n'avez pas participé à ce covoiturage avec ces conducteur!\nVous ne pouvez pas le noter !");
        } else if (covoitureurDAO.EvaluerCovoitureur(noteAjoutee, idCovoitureur)) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Vous avez noté\n" + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNom()
                    + "  " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getPrenom()
                    + ".\nIl est passé de  " + ancienneNote + " à " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNote());
            this.informations = "Addresse E-Mail: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getEmail()
                    + "\n\nNom d'Uuilisateur: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNomUtilisateur()
                    + "\n\nNom: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNom()
                    + "\n\nPrénom: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getPrenom()
                    + "\n\nSexe: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getSexe()
                    + "\n\nFumeur: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).isFumeur()
                    + "\n\nDate de naissance: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getDateNaissance()
                    + "\n\nDate d'enregistrement: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getDateEnregistrement()
                    + "\n\nNote: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getNote()
                    + "\n\nEtat: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getEtat()
                    + "\n\nAvatar: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getAvatar()
                    + "\n\nSkype: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getSkype()
                    + "\n\nFacebook: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getFacebook()
                    + "\n\nDate de la derniére visite: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getDateDerniereVisite()
                    + "\n\nID Facebook: " + covoitureurDAO.afficherCovoitureur_ID(idCovoitureur).getIdFacebook();
            this.dispose();
            AfficherCovoitureur afficherUnCovoiturage = new AfficherCovoitureur(informations, idCovoitureur, idCovoiturage);
            afficherUnCovoiturage.setVisible(true);
            
//            tnajem twali haka non ?
//            this.setVisible(true);
//            this.setVisible(false);
        }
    }//GEN-LAST:event_Boutton_EvaluerActionPerformed

    private void boutton_EnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_EnvoyerActionPerformed
        new EnvoyerMessage(new CovoitureurDAO().afficherCovoitureur_ID(idCovoitureur).getEmail()).setVisible(true);
    }//GEN-LAST:event_boutton_EnvoyerActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherCovoitureur().dispose();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boutton_Evaluer;
    private javax.swing.JButton boutton_Envoyer;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JComboBox cb_Score;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea ta_Covoitureur;
    // End of variables declaration//GEN-END:variables
}