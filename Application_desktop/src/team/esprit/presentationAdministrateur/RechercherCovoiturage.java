package team.esprit.presentationAdministrateur;

import java.util.List;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.DetourDAO;
import team.esprit.dao.ParticipantDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;

public class RechercherCovoiturage extends javax.swing.JFrame {

    public RechercherCovoiturage() {
        initComponents();
        setTitle("Rechercher un covoiturage");
        initialiser();
    }

    public void initialiser() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf_Critere = new javax.swing.JTextField();
        label_Critere = new javax.swing.JLabel();
        cb_Critere = new javax.swing.JComboBox();
        boutton_Rechercher = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ListCovoiturages = new javax.swing.JTable();
        boutton_SupprimerCovoiturage = new javax.swing.JButton();
        boutton_AfficherCovoiturage = new javax.swing.JButton();
        boutton_ModifierCovoiturage = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_Critere.setText("Critere :");

        cb_Critere.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"Ville de départ", "Ville d'arrivée"}));

        boutton_Rechercher.setText("Rechercher");
        boutton_Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercherActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        table_ListCovoiturages.setModel(new AfficherLesCovoituragesTable());
        jScrollPane1.setViewportView(table_ListCovoiturages);

        boutton_SupprimerCovoiturage.setText("Supprimer un covoiturage");
        boutton_SupprimerCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_SupprimerCovoiturageActionPerformed(evt);
            }
        });

        boutton_AfficherCovoiturage.setText("Plus de détails");
        boutton_AfficherCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherCovoiturageActionPerformed(evt);
            }
        });

        boutton_ModifierCovoiturage.setText("Modifier un covoiturage");
        boutton_ModifierCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierCovoiturageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(label_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cb_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(tf_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(boutton_Rechercher))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(boutton_ModifierCovoiturage, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boutton_Retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boutton_SupprimerCovoiturage, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boutton_AfficherCovoiturage, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Rechercher)
                    .addComponent(cb_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Critere)
                    .addComponent(tf_Critere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_ModifierCovoiturage)
                    .addComponent(boutton_SupprimerCovoiturage)
                    .addComponent(boutton_AfficherCovoiturage))
                .addGap(18, 18, 18)
                .addComponent(boutton_Retour)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AfficherCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherCovoiturageActionPerformed
        int ligneSelectionne = table_ListCovoiturages.getSelectedRow();
        int idCovoiturage = (int) table_ListCovoiturages.getValueAt(ligneSelectionne, 0);

        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        ParticipantDAO participantDAO = new ParticipantDAO();
        DetourDAO detourDAO = new DetourDAO();

        String nom_utilisateur = table_ListCovoiturages.getValueAt(ligneSelectionne, 1).toString();

        Covoiturage covoiturage = covoiturageDAO.afficherCovoiturage_ID(idCovoiturage);

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

        informations = "ID:  " + covoiturage.getId()
                + "\n\nTitre: " + covoiturage.getTitre()
                + "\n\nDescription: " + covoiturage.getDescription()
                + "\n\nVille de départ: " + covoiturage.getVilleDepart().getGouvernorat() + ", " + covoiturage.getVilleDepart().getDelegation() + ", " + covoiturage.getVilleDepart().getLocalite()
                + "\n\nVille d'arrivée: " + covoiturage.getVilleArrivee().getGouvernorat() + ", " + covoiturage.getVilleArrivee().getDelegation() + ", " + covoiturage.getVilleArrivee().getLocalite()
                + "\n\nCréateur: " + nom_utilisateur
                + "\n\nDate de départ: " + covoiturage.getDateDepart()
                + "\n\nHeure de départ: " + covoiturage.getHeureDepart()
                + "\n\nNombre de places disponibles: " + covoiturage.getNombrePlaces()
                + "\n\nFumeur: " + f
                + "\n\nRéservé aux femmes: " + r
                + "\n\nVilles de détours: " + d
                + "\n\nLes participants: " + p;

        AfficherUnCovoiturage1 afficherUnCovoiturage1 = new AfficherUnCovoiturage1(informations);
        afficherUnCovoiturage1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AfficherCovoiturageActionPerformed

    private void boutton_ModifierCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierCovoiturageActionPerformed
        int ligneSelectionne = table_ListCovoiturages.getSelectedRow();
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        int id = (int) table_ListCovoiturages.getValueAt(ligneSelectionne, 0);
        System.out.println("    test id : " + id );
        Covoiturage covoiturage = covoiturageDAO.afficherCovoiturage_ID(id);
        System.out.println("  test covoiturage 1" + covoiturage.toString());
        ModifierCovoiturage modifierCovoiturage = new ModifierCovoiturage(covoiturage);
        System.out.println("  test covoiturage 2" + covoiturage.toString());
        modifierCovoiturage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_ModifierCovoiturageActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        GestionCovoiturages gestionCovoiturages = new GestionCovoiturages();
        this.dispose();
        gestionCovoiturages.setVisible(true);
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_SupprimerCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_SupprimerCovoiturageActionPerformed
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        int ligneSelectionne = table_ListCovoiturages.getSelectedRow();
        int id = (int) table_ListCovoiturages.getValueAt(ligneSelectionne, 0);
        int choix = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer ce covoiturage ?", null, 1, QUESTION_MESSAGE);
        if (choix == 0) {
            if (covoiturageDAO.supprimerCovoiturage(id)) {
                JOptionPane.showMessageDialog(this, "Le covoiturage a été supprimé avec succés !");
                table_ListCovoiturages.setModel(new AfficherLesCovoituragesTable());
            } else {
                JOptionPane.showMessageDialog(this, "Le covoiturage n'a été supprimé !");
            }
        }
    }//GEN-LAST:event_boutton_SupprimerCovoiturageActionPerformed

    private void boutton_RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercherActionPerformed
        CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
        List<Covoiturage> listCovoiturages;

        listCovoiturages = covoiturageDAO.rechercherCovoiturages(tf_Critere.getText());
        if (listCovoiturages.size() <= 0) {
            JOptionPane.showMessageDialog(this, "Il n y'a aucun covoiturage correspendant à votre recherche");
        } else {
            table_ListCovoiturages.setModel(new RechercherCovoiturageTable(tf_Critere.getText()));
        }
    }//GEN-LAST:event_boutton_RechercherActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherCovoiturage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherCovoiturage;
    private javax.swing.JButton boutton_ModifierCovoiturage;
    private javax.swing.JButton boutton_Rechercher;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JButton boutton_SupprimerCovoiturage;
    private javax.swing.JComboBox cb_Critere;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_Critere;
    private javax.swing.JTable table_ListCovoiturages;
    private javax.swing.JTextField tf_Critere;
    // End of variables declaration//GEN-END:variables
}