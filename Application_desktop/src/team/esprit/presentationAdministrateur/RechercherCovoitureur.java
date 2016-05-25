package team.esprit.presentationAdministrateur;

import java.util.List;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;

public class RechercherCovoitureur extends javax.swing.JFrame {

    public RechercherCovoitureur() {
        initComponents();
        setTitle("Rechercher un Covoitureur");
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

        boutton_ModifierUnCovoitureur = new javax.swing.JButton();
        boutton_BloquerUnCovoitureur = new javax.swing.JButton();
        boutton_AfficherUnCovoitureur = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ListCovoitureurs = new javax.swing.JTable();
        boutton_Rechercher = new javax.swing.JButton();
        cb_Critere = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        tf_Critere = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_ModifierUnCovoitureur.setText("Modifier un covoitureur");
        boutton_ModifierUnCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierUnCovoitureurActionPerformed(evt);
            }
        });

        boutton_BloquerUnCovoitureur.setText("Bloquer un covoitureur");
        boutton_BloquerUnCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_BloquerUnCovoitureurActionPerformed(evt);
            }
        });

        boutton_AfficherUnCovoitureur.setText("Plus de détails");
        boutton_AfficherUnCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherUnCovoitureurActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        table_ListCovoitureurs.setModel(new AfficherLesCovoitureursTable());
        jScrollPane1.setViewportView(table_ListCovoitureurs);

        boutton_Rechercher.setText("Rechercher");
        boutton_Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercherActionPerformed(evt);
            }
        });

        cb_Critere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nom","Prenom","Email","Nom d'utilisateur" }));

        jLabel2.setText("Critere :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(boutton_ModifierUnCovoitureur, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(boutton_Retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_BloquerUnCovoitureur, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_AfficherUnCovoitureur, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(tf_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutton_Rechercher)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Rechercher)
                    .addComponent(cb_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tf_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_ModifierUnCovoitureur)
                    .addComponent(boutton_BloquerUnCovoitureur)
                    .addComponent(boutton_AfficherUnCovoitureur))
                .addGap(18, 18, 18)
                .addComponent(boutton_Retour)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_BloquerUnCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_BloquerUnCovoitureurActionPerformed
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        int ligneSelectionne = table_ListCovoitureurs.getSelectedRow();
        int id = (int) table_ListCovoitureurs.getValueAt(ligneSelectionne, 0);
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment bloquer ce covotireur ?", "", 0);
        if (choix == 0) {
            if (covoitureurDAO.bloquerCovoitureur(id)) {
                JOptionPane.showMessageDialog(this, "Le covoitureur a été bloqué avec succés.");
                table_ListCovoitureurs.setModel(new AfficherLesCovoitureursTable());
            } else {
                JOptionPane.showMessageDialog(this, "Le covoitureur n'a pas été bloqué.");
            }
        }
    }//GEN-LAST:event_boutton_BloquerUnCovoitureurActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        GestionCovoitureurs gestionDescovoitueurs = new GestionCovoitureurs();
        gestionDescovoitueurs.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_AfficherUnCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherUnCovoitureurActionPerformed
        int ligneSelectionne = table_ListCovoitureurs.getSelectedRow();
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        Covoitureur covoitureur;

        int id = (int) table_ListCovoitureurs.getValueAt(ligneSelectionne, 0);
        covoitureur = covoitureurDAO.afficherCovoitureur_ID(id);
        String valueAt = null;

        valueAt = "ID: " + covoitureur.getId()
                + "\nAddresse E-Mail: " + covoitureur.getEmail()
                + "\nNom d'Uuilisateur: " + covoitureur.getNomUtilisateur()
                + "\nNom: " + covoitureur.getNom()
                + "\nPrénom: " + covoitureur.getPrenom()
                + "\nSexe: " + covoitureur.getSexe()
                + "\nFumeur: " + covoitureur.isFumeur()
                + "\nDate de naissance: " + covoitureur.getDateNaissance()
                + "\nDate d'enregistrement: " + covoitureur.getDateEnregistrement()
                + "\nNote: " + covoitureur.getNote()
                + "\nEtat: " + covoitureur.getEtat()
                + "\nAvatar: " + covoitureur.getAvatar()
                + "\nSkype: " + covoitureur.getSkype()
                + "\nFacebook: " + covoitureur.getFacebook()
                + "\nDate de la derniére visite: " + covoitureur.getDateDerniereVisite()
                + "\nCle activation: " + covoitureur.getCleActivation()
                + "\nID Facebook: " + covoitureur.getIdFacebook();

        AfficherUnCovoitureur1 afficherUnCovoitureur1 = new AfficherUnCovoitureur1(valueAt);
        afficherUnCovoitureur1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AfficherUnCovoitureurActionPerformed

    private void boutton_ModifierUnCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierUnCovoitureurActionPerformed
        int ligneSelectionne = table_ListCovoitureurs.getSelectedRow();
        int id = (int) table_ListCovoitureurs.getValueAt(ligneSelectionne, 0);
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        Covoitureur covoitureur;
        covoitureur = covoitureurDAO.afficherCovoitureur_ID(id);
        ModifierCovoitureur modifieruncovoitureur = new ModifierCovoitureur(covoitureur);
        modifieruncovoitureur.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_ModifierUnCovoitureurActionPerformed
    private void boutton_RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercherActionPerformed
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        List<Covoitureur> listCovoitureurs;

        listCovoitureurs = covoitureurDAO.rechercherCovoitureurs(tf_Critere.getText());
        if (listCovoitureurs.size() <= 0) {
            JOptionPane.showMessageDialog(this, "Il n y'a aucun covoitureur correspendant à votre recherche.");
        } else {
            table_ListCovoitureurs.setModel(new RechercherCovoitureurTable(tf_Critere.getText()));
        }
    }//GEN-LAST:event_boutton_RechercherActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherCovoitureur().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherUnCovoitureur;
    private javax.swing.JButton boutton_BloquerUnCovoitureur;
    private javax.swing.JButton boutton_ModifierUnCovoitureur;
    private javax.swing.JButton boutton_Rechercher;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JComboBox cb_Critere;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_ListCovoitureurs;
    private javax.swing.JTextField tf_Critere;
    // End of variables declaration//GEN-END:variables
}