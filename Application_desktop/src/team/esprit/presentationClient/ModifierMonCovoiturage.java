package team.esprit.presentationClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.NotificationDAO;
import team.esprit.dao.VilleDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;
import team.esprit.presentation.Authentification;
import team.esprit.util.Navigateur;

public class ModifierMonCovoiturage extends javax.swing.JFrame {

    Covoiturage covoiturage = new Covoiturage();
    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    NotificationDAO notificationDAO = new NotificationDAO();
    VilleDAO villeDAO = new VilleDAO();
    List<Ville> listGouvernoratsDepart;
    List<Ville> listDelegationsDepart;
    List<Ville> ListLocalitesDepart;
    List<Ville> listGouvernoratsArrivee;
    List<Ville> listDelegationsArrivee;
    List<Ville> ListLocalitesArrivee;
    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;

    public ModifierMonCovoiturage() {
        this.dispose();
        initialiser();
    }

    public ModifierMonCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
        initComponents();
        setTitle("Modifier un Covoiturage");
        initialiser();
        remplirGouvernoratDepart();
        cb_GouvernoratDepart.setSelectedItem(covoiturage.getVilleDepart().getGouvernorat());
        remplirDelegationDepart();
        cb_DelegationDepart.setSelectedItem(covoiturage.getVilleDepart().getDelegation());
        remplirLocaliteDepart();
        cb_LocaliteDepart.setSelectedItem(covoiturage.getVilleDepart().getLocalite());
        remplirGouvernoratArrivee();
        cb_GouvernoratArrivee.setSelectedItem(covoiturage.getVilleArrivee().getGouvernorat());
        remplirDelegationArrivee();
        cb_DelegationArrivee.setSelectedItem(covoiturage.getVilleArrivee().getDelegation());
        remplirLocaliteArrivee();
        cb_LocaliteArrivee.setSelectedItem(covoiturage.getVilleArrivee().getLocalite());
        sp_NombrePlaces.setValue(covoiturage.getNombrePlaces());

        spinnerDateModel();
        //sp_HeureDepart.setValue(covoiturage.getHeureDepart() + " AM");
        //Il y'a un probléme ici, il prend la date systéme et la solution ci dessus ne marche pas
        sp_HeureDepart.setToolTipText(covoiturage.getHeureDepart());

        dp_Date.setDate(covoiturage.getDateDepart());
        String prix = "" + covoiturage.getPrix();
        tf_Prix.setText(prix);
        chb_Fumeur.setSelected(covoiturage.isFumeur());
        chb_Reserve.setSelected(covoiturage.isReserveeFemmes());
    }

    public void initialiser() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public final void spinnerDateModel() {
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.HOUR);
        model.setCalendarField(Calendar.MINUTE);
        model.setCalendarField(Calendar.SECOND);
        sp_HeureDepart.setModel(model);
        sp_HeureDepart.setEditor(new JSpinner.DateEditor(sp_HeureDepart, "hh:mm:ss a"));
    }

    public void remplirGouvernoratDepart() {
        listGouvernoratsDepart = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsDepart) {
            cb_GouvernoratDepart.addItem(ville.getGouvernorat());
        }
    }

    public void remplirDelegationDepart() {
        listDelegationsDepart = villeDAO.afficheDelegation(cb_GouvernoratDepart.getSelectedItem().toString());
        for (Ville ville : listDelegationsDepart) {
            cb_DelegationDepart.addItem(ville.getDelegation());
        }
    }

    public void remplirLocaliteDepart() {
        ListLocalitesDepart = villeDAO.afficheLocalite(cb_GouvernoratDepart.getSelectedItem().toString(), cb_DelegationDepart.getSelectedItem().toString());
        for (Ville ville : ListLocalitesDepart) {
            cb_LocaliteDepart.addItem(ville.getLocalite());
        }
    }

    public void remplirGouvernoratArrivee() {
        listGouvernoratsArrivee = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsArrivee) {
            cb_GouvernoratArrivee.addItem(ville.getGouvernorat());
        }
    }

    public void remplirDelegationArrivee() {
        listDelegationsArrivee = villeDAO.afficheDelegation(cb_GouvernoratArrivee.getSelectedItem().toString());
        for (Ville ville : listDelegationsArrivee) {
            cb_DelegationArrivee.addItem(ville.getDelegation());
        }
    }

    public void remplirLocaliteArrivee() {
        ListLocalitesArrivee = villeDAO.afficheLocalite(cb_GouvernoratArrivee.getSelectedItem().toString(), cb_DelegationArrivee.getSelectedItem().toString());
        for (Ville ville : ListLocalitesArrivee) {
            cb_LocaliteArrivee.addItem(ville.getLocalite());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        boutton_Retour = new javax.swing.JButton();
        boutton_Localiser = new javax.swing.JButton();
        dp_Date = new org.jdesktop.swingx.JXDatePicker();
        sp_NombrePlaces = new javax.swing.JSpinner();
        cb_GouvernoratArrivee = new javax.swing.JComboBox();
        chb_Reserve = new javax.swing.JCheckBox();
        chb_Fumeur = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        cb_DelegationArrivee = new javax.swing.JComboBox();
        cb_GouvernoratDepart = new javax.swing.JComboBox();
        cb_DelegationDepart = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        cb_LocaliteDepart = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cb_LocaliteArrivee = new javax.swing.JComboBox();
        sp_HeureDepart = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        boutton_Modifier = new javax.swing.JButton();
        tf_Prix = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Nombre de places:");

        jLabel4.setText("Délégation:");

        jLabel2.setText("Délégation:");

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_Localiser.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Localiser.setText("Localiser");
        boutton_Localiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_LocaliserActionPerformed(evt);
            }
        });

        cb_GouvernoratArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratArriveeActionPerformed(evt);
            }
        });

        chb_Reserve.setText("Réservé aux femmes");

        chb_Fumeur.setText("Fumeur");

        jLabel3.setText("Vers: ");

        cb_DelegationArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DelegationArriveeActionPerformed(evt);
            }
        });

        cb_GouvernoratDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratDepartActionPerformed(evt);
            }
        });

        cb_DelegationDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DelegationDepartActionPerformed(evt);
            }
        });

        jLabel1.setText("Allant de:");

        jLabel6.setText("Le:");

        jLabel11.setText("Localite:");

        jLabel7.setText("à:");

        jLabel12.setText("Localite:");

        jLabel10.setText("Prix:");

        boutton_Modifier.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Modifier.setText("Modifier");
        boutton_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cb_GouvernoratDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_GouvernoratArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dp_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(chb_Fumeur))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(sp_NombrePlaces, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(chb_Reserve))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sp_HeureDepart)
                                    .addComponent(tf_Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_DelegationArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_DelegationDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_LocaliteDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_LocaliteArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boutton_Retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boutton_Modifier))
                            .addComponent(boutton_Localiser))))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cb_GouvernoratDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cb_DelegationDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cb_GouvernoratArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cb_DelegationArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(dp_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(sp_HeureDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sp_NombrePlaces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(tf_Prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chb_Fumeur)
                            .addComponent(chb_Reserve)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_LocaliteDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_LocaliteArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(34, 34, 34)
                        .addComponent(boutton_Localiser)
                        .addGap(18, 18, 18)
                        .addComponent(boutton_Modifier)
                        .addGap(18, 18, 18)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_LocaliserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_LocaliserActionPerformed
        Ville depart = new Ville(), arrivee = new Ville();
        depart.setGouvernorat(cb_GouvernoratDepart.getSelectedItem().toString());
        depart.setDelegation(cb_DelegationDepart.getSelectedItem().toString());
        arrivee.setGouvernorat(cb_GouvernoratArrivee.getSelectedItem().toString());
        arrivee.setDelegation(cb_DelegationArrivee.getSelectedItem().toString());
        Navigateur.main(depart, arrivee);
    }//GEN-LAST:event_boutton_LocaliserActionPerformed

    private void cb_GouvernoratArriveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratArriveeActionPerformed
        cb_DelegationArrivee.removeAllItems();
        cb_LocaliteArrivee.removeAllItems();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
    }//GEN-LAST:event_cb_GouvernoratArriveeActionPerformed

    private void cb_DelegationArriveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DelegationArriveeActionPerformed
        cb_LocaliteArrivee.removeAllItems();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
    }//GEN-LAST:event_cb_DelegationArriveeActionPerformed

    private void cb_GouvernoratDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratDepartActionPerformed
        cb_DelegationDepart.removeAllItems();
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_GouvernoratDepartActionPerformed

    private void cb_DelegationDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DelegationDepartActionPerformed
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_DelegationDepartActionPerformed

    private void boutton_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierActionPerformed
        covoiturage.setCreateur(covoitureurConnecte);
        Ville villeDepart = villeDAO.afficherVille_Localite(cb_LocaliteDepart.getSelectedItem().toString());
        covoiturage.setVilleDepart(villeDepart);
        Ville villeArrivee = villeDAO.afficherVille_Localite(cb_LocaliteArrivee.getSelectedItem().toString());
        covoiturage.setVilleArrivee(villeArrivee);
        try {
            java.util.Date dateDepartUTIL = dp_Date.getDate();
            java.sql.Date dateDepartSQL = new java.sql.Date(dateDepartUTIL.getTime());
            covoiturage.setDateDepart(dateDepartSQL);
        } catch (NullPointerException e) {
            e.getMessage();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String systemDate = dateFormat.format(date);
        String heureDepart = sp_HeureDepart.getValue().toString();
        heureDepart = heureDepart.substring(11, 20);
        covoiturage.setHeureDepart(heureDepart);
        covoiturage.setNombrePlaces((int) sp_NombrePlaces.getValue());
        covoiturage.setPrix((Float.parseFloat(tf_Prix.getText())));
        covoiturage.setFumeur(chb_Fumeur.isSelected());
        covoiturage.setReserveeFemmes(chb_Reserve.isSelected());
        try {
            try {
                if ((!tf_Prix.getText().isEmpty()) && ((int) sp_NombrePlaces.getValue() != 0)) {
                    if (dp_Date.getDate().before((dateFormat.parse(systemDate)))) {
                        JOptionPane.showMessageDialog(this, "La date du covoiturage est dépassé.");
                    } else if (dp_Date.getDate().after((dateFormat.parse(systemDate))) || dp_Date.getDate().equals(dateFormat.parse(systemDate))) {
                        String contenu = "Le covoiturage qui part de " + covoiturage.getVilleDepart().getGouvernorat() + " vers " + covoiturage.getVilleArrivee().getGouvernorat() + " à " + covoiturage.getHeureDepart() + " a été modifié.";
                        if (covoiturageDAO.modifierCovoiturage(covoiturage)) {
                            List<Covoitureur> listParticipants = covoiturage.getParticipants();
                            for (Covoitureur covoitureur : listParticipants) {
                                if (notificationDAO.envoyerNotification(covoitureurConnecte, covoitureur, contenu, 5)) {
                                    JOptionPane.showMessageDialog(this, "Une notification a été envoyé à : " + covoitureur.getNomUtilisateur());
                                }
                            }
                            JOptionPane.showMessageDialog(this, "Le covoiturage a été mis à jour avec succés.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Le covoiturage n'a pas été mis à jour !", null, 1);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
                }
            } catch (ParseException ex) {
                Logger.getLogger(ModifierMonCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir .");
        }
    }//GEN-LAST:event_boutton_ModifierActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierMonCovoiturage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Localiser;
    private javax.swing.JButton boutton_Modifier;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JComboBox cb_DelegationArrivee;
    private javax.swing.JComboBox cb_DelegationDepart;
    private javax.swing.JComboBox cb_GouvernoratArrivee;
    private javax.swing.JComboBox cb_GouvernoratDepart;
    private javax.swing.JComboBox cb_LocaliteArrivee;
    private javax.swing.JComboBox cb_LocaliteDepart;
    private javax.swing.JCheckBox chb_Fumeur;
    private javax.swing.JCheckBox chb_Reserve;
    private org.jdesktop.swingx.JXDatePicker dp_Date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner sp_HeureDepart;
    private javax.swing.JSpinner sp_NombrePlaces;
    private javax.swing.JTextField tf_Prix;
    // End of variables declaration//GEN-END:variables
}