package team.esprit.presentationClient;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.DetourDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;

public class RechercherCovoiturage extends javax.swing.JFrame {

    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    RechercheAvancee rechercheAvancee = new RechercheAvancee();
    //RechercherCovoiturageTable rechercherCovoiturageTableRechercheAvancee = new RechercherCovoiturageTable();
    DetourDAO detourDAO = new DetourDAO();
    Covoiturage covoiturage;

    public RechercherCovoiturage() {
        initComponents();
        initialise();
    }

    public RechercherCovoiturage(Covoiturage covoiturage) {
        initComponents();
        initialise();
        //table_ListCovoiturages.setModel(rechercherCovoiturageTableRechercheAvancee);
        table_ListCovoiturages.setModel(new RechercherCovoiturageTable(covoiturage));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_Depart = new javax.swing.JTextField();
        tf_Arrivee = new javax.swing.JTextField();
        boutton_Recherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ListCovoiturages = new javax.swing.JTable();
        boutton_Details = new javax.swing.JButton();
        boutton_ProfilCovoitureur = new javax.swing.JButton();
        boutton_RechercheAvancee = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recherche Covoiturage");

        jLabel1.setText("Ville de départ");

        jLabel2.setText("Ville d'arrivée");

        boutton_Recherche.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Recherche.setText("Recherche");
        boutton_Recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercheActionPerformed(evt);
            }
        });

        table_ListCovoiturages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Conducteur", "Date de départ", "Ville de départ", "Ville d'arrivée", "Nombres de places restantes"
            }
        ));
        table_ListCovoiturages.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(table_ListCovoiturages);

        boutton_Details.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Details.setText("Plus de Détails");
        boutton_Details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_DetailsActionPerformed(evt);
            }
        });

        boutton_ProfilCovoitureur.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_ProfilCovoitureur.setText("Profil du conducteur");
        boutton_ProfilCovoitureur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ProfilCovoitureurActionPerformed(evt);
            }
        });

        boutton_RechercheAvancee.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_RechercheAvancee.setText("Recherche avancée");
        boutton_RechercheAvancee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercheAvanceeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tf_Depart, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf_Arrivee, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutton_Recherche)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(boutton_Details)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boutton_ProfilCovoitureur)
                .addGap(94, 94, 94)
                .addComponent(boutton_RechercheAvancee)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Depart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Recherche)
                    .addComponent(jLabel2)
                    .addComponent(tf_Arrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Details)
                    .addComponent(boutton_ProfilCovoitureur)
                    .addComponent(boutton_RechercheAvancee))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercheActionPerformed
        CovoiturageDAO covoituragedao = new CovoiturageDAO();
        List<Covoiturage> listCovoiturages = new ArrayList<Covoiturage>();
        listCovoiturages = covoituragedao.afficherCovoituragesRecherche(tf_Depart.getText(), tf_Arrivee.getText());
        if (tf_Arrivee.getText().isEmpty() && tf_Depart.getText().isEmpty()) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Affichage des covoiturages ajoutés récemments et encore disponible.");
            table_ListCovoiturages.setModel(new RechercherCovoiturageTable());
        } else {
            if (listCovoiturages.size() <= 0) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Pas de covoiturages convenables à votre recherche.");
            } else if (!(tf_Depart.getText().isEmpty()) || !(tf_Arrivee.getText().isEmpty())) {
                table_ListCovoiturages.setModel(new RechercherCovoiturageTable(tf_Depart.getText(), tf_Arrivee.getText()));
            }
        }
    }//GEN-LAST:event_boutton_RechercheActionPerformed

    private void boutton_ProfilCovoitureurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ProfilCovoitureurActionPerformed
        int ligneSelectionne = table_ListCovoiturages.getSelectedRow();
        Covoiturage covoiturage = new Covoiturage();
        try {
            int idCovoiturage = (int) table_ListCovoiturages.getValueAt(ligneSelectionne, 0);
            Covoitureur covoitureur = covoitureurDAO.afficherCovoitureur_ID(covoitureurDAO.IDCovoitureur_IDCovoiturage(idCovoiturage));
            covoiturage.setId(idCovoiturage);
            String informations = "";
            informations = "Addresse E-Mail: " + covoitureur.getEmail()
                    + "\n\nNom d'Uuilisateur: " + covoitureur.getNomUtilisateur()
                    + "\n\nNom: " + covoitureur.getNom()
                    + "\n\nPrénom: " + covoitureur.getPrenom()
                    + "\n\nSexe: " + covoitureur.getSexe()
                    + "\n\nFumeur: " + covoitureur.isFumeur()
                    + "\n\nDate de naissance: " + covoitureur.getDateNaissance()
                    + "\n\nDate d'enregistrement: " + covoitureur.getDateEnregistrement()
                    + "\n\nNote: " + covoitureur.getNote()
                    + "\n\nEtat: " + covoitureur.getEtat()
                    + "\n\nAvatar: " + covoitureur.getAvatar()
                    + "\n\nSkype: " + covoitureur.getSkype()
                    + "\n\nFacebook: " + covoitureur.getFacebook()
                    + "\n\nDate de la derniére visite: " + covoitureur.getDateDerniereVisite()
                    + "\n\nCle activation: " + covoitureur.getCleActivation()
                    + "\n\nID Facebook: " + covoitureur.getIdFacebook();
            AfficherCovoitureur afficherUnCovoitureur = new AfficherCovoitureur(informations, covoitureur.getId(), covoiturage.getId());
            afficherUnCovoitureur.setVisible(true);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner un covoiturage");
        }
    }//GEN-LAST:event_boutton_ProfilCovoitureurActionPerformed

    private void boutton_DetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_DetailsActionPerformed
        int ligneSelectionne = table_ListCovoiturages.getSelectedRow();
        try {
            int idCovoiturage = (int) table_ListCovoiturages.getValueAt(ligneSelectionne, 0);
            covoiturage = covoiturageDAO.afficherCovoiturage_ID(idCovoiturage);
            String informations = null;
            informations = "Titre: " + covoiturage.getTitre()
                    + "\n\nDescription: " + covoiturage.getDescription()
                    + "\n\nVille de départ: " + covoiturage.getVilleDepart().getGouvernorat() + ", " + covoiturage.getVilleDepart().getDelegation() + ", " + covoiturage.getVilleDepart().getLocalite()
                    + "\n\nVille d'arrivée: " + covoiturage.getVilleArrivee().getGouvernorat() + ", " + covoiturage.getVilleArrivee().getDelegation() + ", " + covoiturage.getVilleArrivee().getLocalite()
                    + "\n\nLes villes de détours:" + detourDAO.afficherDetours(covoiturage)
                    + "\n\nCréateur: " + covoitureurDAO.afficherCovoitureur_ID(covoitureurDAO.IDCovoitureur_IDCovoiturage(idCovoiturage)).getNom() + " " + covoitureurDAO.afficherCovoitureur_ID(covoitureurDAO.IDCovoitureur_IDCovoiturage(idCovoiturage)).getPrenom()
                    + "\n\nNote Créateur:" + covoitureurDAO.afficherCovoitureur_ID(covoitureurDAO.IDCovoitureur_IDCovoiturage(idCovoiturage)).getNote()
                    + "\n\nDate Creétion: " + covoiturage.getDateCreation()
                    + "\n\nDate Mise a jour: " + covoiturage.getDateMiseAJour()
                    + "\n\nDate Départ: " + covoiturage.getDateDepart()
                    + "\n\nHeure départ: " + covoiturage.getHeureDepart()
                    + "\n\nNombre Places restantes: " + covoiturage.getNombrePlaces()
                    + "\n\nPrix: " + covoiturage.getPrix()
                    + "\n\nFumeur: " + covoiturage.isFumeur()
                    + "\n\nReservé aux femmes: " + covoiturage.isReserveeFemmes();
            AfficherCovoiturage afficherCovoiturage = new AfficherCovoiturage(informations, idCovoiturage);
            afficherCovoiturage.setVisible(true);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Vous devez sélectionner un covoiturage !", null, 2);
        }
    }//GEN-LAST:event_boutton_DetailsActionPerformed

    private void boutton_RechercheAvanceeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercheAvanceeActionPerformed
        this.dispose();
        rechercheAvancee.setVisible(true);
    }//GEN-LAST:event_boutton_RechercheAvanceeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RechercherCovoiturage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Details;
    private javax.swing.JButton boutton_ProfilCovoitureur;
    private javax.swing.JButton boutton_Recherche;
    private javax.swing.JButton boutton_RechercheAvancee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_ListCovoiturages;
    private javax.swing.JTextField tf_Arrivee;
    private javax.swing.JTextField tf_Depart;
    // End of variables declaration//GEN-END:variables
}