package team.esprit.presentationAdministrateur;

import java.util.List;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.DetourDAO;
import team.esprit.dao.ParticipantDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;

public class AfficherLesCovoiturages extends javax.swing.JFrame {

    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    ParticipantDAO participantDAO = new ParticipantDAO();
    DetourDAO detourDAO = new DetourDAO();
    List<Covoitureur> listCovoitureurs;
    List<Ville> listDetours;
    Covoiturage covoiturage;

    public AfficherLesCovoiturages() {
        initComponents();
        setTitle("Afficher les covoiturages");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Covoiturages = new javax.swing.JTable();
        boutton_AfficherCovoiturage = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table_Covoiturages.setModel(new AfficherLesCovoituragesTable());
        jScrollPane1.setViewportView(table_Covoiturages);

        boutton_AfficherCovoiturage.setText("Plus de détails");
        boutton_AfficherCovoiturage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AfficherCovoiturageActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(boutton_AfficherCovoiturage)
                .addGap(111, 111, 111)
                .addComponent(boutton_Retour, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_AfficherCovoiturage)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AfficherCovoiturageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AfficherCovoiturageActionPerformed
        int ligneSelectionne = table_Covoiturages.getSelectedRow();
        int idCovoiturage = (int) table_Covoiturages.getValueAt(ligneSelectionne, 0);
        covoiturage = covoiturageDAO.afficherCovoiturage_ID(idCovoiturage);
        String f = "", r = "", d = "", informations = "", p = "", nomUtilisateur = table_Covoiturages.getValueAt(ligneSelectionne, 1).toString();
        listCovoitureurs = participantDAO.afficherParticipants(covoiturage);
        for (Covoitureur participant : listCovoitureurs) {
            p = p + participant.getNomUtilisateur() + ", ";
        }
        listDetours = detourDAO.afficherDetours(covoiturage);
        for (Ville ville : listDetours) {
            d = d + ville.getGouvernorat() + ", " + ville.getDelegation() + ", " + ville.getLocalite() + ". ";
        }
        boolean reserve = covoiturage.isReserveeFemmes();
        if (reserve) {
            r = "Oui";
        } else {
            r = "Non";
        }
        boolean fumeur = covoiturage.isFumeur();
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
                + "\n\nCréateur: " + nomUtilisateur
                + "\n\nDate de départ: " + covoiturage.getDateDepart()
                + "\n\nHeure de départ: " + covoiturage.getHeureDepart()
                + "\n\nNombre de places disponibles: " + covoiturage.getNombrePlaces()
                + "\n\nFumeur: " + f
                + "\n\nRéservé aux femmes: " + r
                + "\n\nVilles de détours: " + d
                + "\n\nLes participants: " + p;
        this.dispose();
        new AfficherUnCovoiturage(informations).setVisible(true);
    }//GEN-LAST:event_boutton_AfficherCovoiturageActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
        new GestionCovoiturages().setVisible(true);
    }//GEN-LAST:event_boutton_RetourActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherLesCovoiturages().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_AfficherCovoiturage;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_Covoiturages;
    // End of variables declaration//GEN-END:variables
}