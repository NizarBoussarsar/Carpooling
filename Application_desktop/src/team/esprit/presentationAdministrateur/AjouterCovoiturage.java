package team.esprit.presentationAdministrateur;

import team.esprit.util.Navigateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.VilleDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;

public class AjouterCovoiturage extends javax.swing.JFrame {

    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    VilleDAO villeDAO = new VilleDAO();
    List<Ville> listGouvernoratsDepart, listDelegationsDepart, ListLocalitesDepart, listGouvernoratsArrivee, listDelegationsArrivee, ListLocalitesArrivee;
    Covoiturage covoiturage = new Covoiturage();
    Covoitureur covoitureur = new Covoitureur();
    Ville villeDepart, villeArrivee = new Ville();
    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";

    public AjouterCovoiturage() {
        initComponents();
        setTitle("Ajouter un covoiturage");
        initialise();
    }

    private void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        spinnerDateModel();
        remplirGouvernoratDepart();
        remplirDelegationDepart();
        remplirLocaliteDepart();
        remplirGouvernoratArrivee();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
    }

    private void spinnerDateModel() {
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.HOUR);
        model.setCalendarField(Calendar.MINUTE);
        model.setCalendarField(Calendar.SECOND);
        sp_HeureDepart.setModel(model);
        sp_HeureDepart.setEditor(new JSpinner.DateEditor(sp_HeureDepart, "hh:mm:ss a"));
    }

    @SuppressWarnings("unchecked")
    private void remplirGouvernoratDepart() {
        listGouvernoratsDepart = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsDepart) {
            cb_GouvernoratDepart.addItem(ville.getGouvernorat());
        }
    }

    @SuppressWarnings("unchecked")
    private void remplirDelegationDepart() {
        listDelegationsDepart = villeDAO.afficheDelegation(cb_GouvernoratDepart.getSelectedItem().toString());
        for (Ville ville : listDelegationsDepart) {
            cb_DelegationDepart.addItem(ville.getDelegation());
        }
    }

    @SuppressWarnings("unchecked")
    private void remplirLocaliteDepart() {
        ListLocalitesDepart = villeDAO.afficheLocalite(cb_GouvernoratDepart.getSelectedItem().toString(), cb_DelegationDepart.getSelectedItem().toString());
        for (Ville ville : ListLocalitesDepart) {
            cb_LocaliteDepart.addItem(ville.getLocalite());
        }
    }

    @SuppressWarnings("unchecked")
    private void remplirGouvernoratArrivee() {
        listGouvernoratsArrivee = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsArrivee) {
            cb_GouvernoratArrivee.addItem(ville.getGouvernorat());
        }
    }

    @SuppressWarnings("unchecked")
    private void remplirDelegationArrivee() {
        listDelegationsArrivee = villeDAO.afficheDelegation(cb_GouvernoratArrivee.getSelectedItem().toString());
        for (Ville ville : listDelegationsArrivee) {
            cb_DelegationArrivee.addItem(ville.getDelegation());
        }
    }

    @SuppressWarnings("unchecked")
    private void remplirLocaliteArrivee() {
        ListLocalitesArrivee = villeDAO.afficheLocalite(cb_GouvernoratArrivee.getSelectedItem().toString(), cb_DelegationArrivee.getSelectedItem().toString());
        for (Ville ville : ListLocalitesArrivee) {
            cb_LocaliteArrivee.addItem(ville.getLocalite());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cb_GouvernoratDepart = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_GouvernoratArrivee = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cb_DelegationArrivee = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tf_Conducteur = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dp_Date = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sp_NombrePlaces = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        tf_Prix = new javax.swing.JTextField();
        chb_Fumeur = new javax.swing.JCheckBox();
        chb_Reserve = new javax.swing.JCheckBox();
        boutton_Ajouter = new javax.swing.JButton();
        cb_LocaliteDepart = new javax.swing.JComboBox();
        cb_LocaliteArrivee = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sp_HeureDepart = new javax.swing.JSpinner();
        boutton_Retour = new javax.swing.JButton();
        boutton_Localiser = new javax.swing.JButton();
        cb_DelegationDepart = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Allant de:");

        cb_GouvernoratDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratDepartActionPerformed(evt);
            }
        });

        jLabel2.setText("Délégation:");

        jLabel3.setText("Vers: ");

        cb_GouvernoratArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratArriveeActionPerformed(evt);
            }
        });

        jLabel4.setText("Délégation:");

        cb_DelegationArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DelegationArriveeActionPerformed(evt);
            }
        });

        jLabel5.setText("E-Mail du conducteur OU Nom du conducteur");

        tf_Conducteur.setToolTipText("");

        jLabel6.setText("Le:");

        jLabel7.setText("à:");

        jLabel9.setText("Nombre de places:");

        jLabel10.setText("Prix:");

        tf_Prix.setText("0");

        chb_Fumeur.setText("Fumeur");

        chb_Reserve.setText("Réservé aux femmes");

        boutton_Ajouter.setText("Ajouter");
        boutton_Ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AjouterActionPerformed(evt);
            }
        });

        jLabel11.setText("Localite:");

        jLabel12.setText("Localite:");

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        boutton_Localiser.setText("Localiser");
        boutton_Localiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_LocaliserActionPerformed(evt);
            }
        });

        cb_DelegationDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DelegationDepartActionPerformed(evt);
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
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tf_Conducteur, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                        .addComponent(boutton_Ajouter))
                                    .addComponent(boutton_Localiser))))
                        .addGap(102, 102, 102))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_Conducteur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
                        .addComponent(boutton_Ajouter)
                        .addGap(18, 18, 18)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AjouterActionPerformed
        if (tf_Conducteur.getText().matches(_regexAdressEmail)) {
            covoitureur = covoitureurDAO.afficherCovoitureurEMAIL(tf_Conducteur.getText());
        } else {
            covoitureur = covoitureurDAO.afficherCovoitureur_NomUtilisateur(tf_Conducteur.getText());
        }
        covoiturage.setCreateur(covoitureur);
        villeDepart = villeDAO.afficherVille_Localite(cb_LocaliteDepart.getSelectedItem().toString());
        covoiturage.setVilleDepart(villeDepart);
        villeArrivee = villeDAO.afficherVille_Localite(cb_LocaliteArrivee.getSelectedItem().toString());
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
                if ((!tf_Conducteur.getText().isEmpty()) && (!tf_Prix.getText().isEmpty())
                        && ((int) sp_NombrePlaces.getValue() != 0)) {
                    if (dp_Date.getDate().before((dateFormat.parse(systemDate)))) {
                        JOptionPane.showMessageDialog(this, "La date du covoiturage est dépassé.");
                    } else if (dp_Date.getDate().after((dateFormat.parse(systemDate))) || dp_Date.getDate().equals(dateFormat.parse(systemDate))) {
                        if (covoiturageDAO.ajouterCovoiturage(covoiturage)) {
                            JOptionPane.showMessageDialog(this, "Le covoiturage a été ajouté avec succés.");
                        } else {
                            JOptionPane.showMessageDialog(this, "Le covoiturage n'a pas été ajouté !", null, 1);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
                }
            } catch (ParseException ex) {
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        }
    }//GEN-LAST:event_boutton_AjouterActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        GestionCovoiturages gestionDesCovoiturages = new GestionCovoiturages();
        this.dispose();
        gestionDesCovoiturages.setVisible(true);
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void cb_GouvernoratDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratDepartActionPerformed
        cb_DelegationDepart.removeAllItems();
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_GouvernoratDepartActionPerformed

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

    private void cb_DelegationDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DelegationDepartActionPerformed
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_DelegationDepartActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterCovoiturage().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Ajouter;
    private javax.swing.JButton boutton_Localiser;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner sp_HeureDepart;
    private javax.swing.JSpinner sp_NombrePlaces;
    private javax.swing.JTextField tf_Conducteur;
    private javax.swing.JTextField tf_Prix;
    // End of variables declaration//GEN-END:variables
}