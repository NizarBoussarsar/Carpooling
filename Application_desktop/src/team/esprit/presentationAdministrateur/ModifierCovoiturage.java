package team.esprit.presentationAdministrateur;

import team.esprit.util.Navigateur;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

@SuppressWarnings("unchecked")
public class ModifierCovoiturage extends javax.swing.JFrame {

    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    VilleDAO villeDAO = new VilleDAO();
    List<Ville> listGouvernoratsDepart, listDelegationsDepart, ListLocalitesDepart, listGouvernoratsArrivee, listDelegationsArrivee, ListLocalitesArrivee;
    Covoiturage covoiturage = new Covoiturage();
    Covoitureur covoitureur = new Covoitureur();
    Ville villeDepart, villeArrivee = new Ville();
    private static final String _regexAdressEmail = "^[^\\W][a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\@[a-zA-Z0-9_]+(\\.[a-zA-Z0-9_]+)*\\.[a-zA-Z]{2,4}$";

    public ModifierCovoiturage() {
        this.dispose();
        initialiser();
    }

    public ModifierCovoiturage(Covoiturage covoiturage) {
        initComponents();
        this.covoiturage=covoiturage;
        setTitle("Modifier un covoiturage");
        initialiser();
        tf_Conducteur.setText(covoiturage.getCreateur().getEmail());
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

    private void initialiser() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void spinnerDateModel() {
        SpinnerDateModel model = new SpinnerDateModel();
        model.setCalendarField(Calendar.HOUR);
        model.setCalendarField(Calendar.MINUTE);
        model.setCalendarField(Calendar.SECOND);
        sp_HeureDepart.setModel(model);
        sp_HeureDepart.setEditor(new JSpinner.DateEditor(sp_HeureDepart, "hh:mm:ss a"));
    }

    private void remplirGouvernoratDepart() {
        listGouvernoratsDepart = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsDepart) {
            cb_GouvernoratDepart.addItem(ville.getGouvernorat());
        }
    }

    private void remplirDelegationDepart() {
        listDelegationsDepart = villeDAO.afficheDelegation(cb_GouvernoratDepart.getSelectedItem().toString());
        for (Ville ville : listDelegationsDepart) {
            cb_DelegationDepart.addItem(ville.getDelegation());
        }
    }

    private void remplirLocaliteDepart() {
        ListLocalitesDepart = villeDAO.afficheLocalite(cb_GouvernoratDepart.getSelectedItem().toString(), cb_DelegationDepart.getSelectedItem().toString());
        for (Ville ville : ListLocalitesDepart) {
            cb_LocaliteDepart.addItem(ville.getLocalite());
        }
    }

    private void remplirGouvernoratArrivee() {
        listGouvernoratsArrivee = villeDAO.afficheGouvernorat();
        for (Ville ville : listGouvernoratsArrivee) {
            cb_GouvernoratArrivee.addItem(ville.getGouvernorat());
        }
    }

    private void remplirDelegationArrivee() {
        listDelegationsArrivee = villeDAO.afficheDelegation(cb_GouvernoratArrivee.getSelectedItem().toString());
        for (Ville ville : listDelegationsArrivee) {
            cb_DelegationArrivee.addItem(ville.getDelegation());
        }
    }

    private void remplirLocaliteArrivee() {
        ListLocalitesArrivee = villeDAO.afficheLocalite(cb_GouvernoratArrivee.getSelectedItem().toString(), cb_DelegationArrivee.getSelectedItem().toString());
        for (Ville ville : ListLocalitesArrivee) {
            cb_LocaliteArrivee.addItem(ville.getLocalite());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dp_Date = new org.jdesktop.swingx.JXDatePicker();
        sp_NombrePlaces = new javax.swing.JSpinner();
        chb_Fumeur = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        cb_GouvernoratArrivee = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cb_GouvernoratDepart = new javax.swing.JComboBox();
        tf_Conducteur = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        sp_HeureDepart = new javax.swing.JSpinner();
        tf_Prix = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        chb_Reserve = new javax.swing.JCheckBox();
        boutton_Retour = new javax.swing.JButton();
        boutton_Localiser = new javax.swing.JButton();
        cb_LocaliteArrivee = new javax.swing.JComboBox();
        cb_LocaliteDepart = new javax.swing.JComboBox();
        cb_DelegationDepart = new javax.swing.JComboBox();
        cb_DelegationArrivee = new javax.swing.JComboBox();
        boutton_Modifier = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chb_Fumeur.setText("Fumeur");

        jLabel9.setText("Nombre de places:");

        cb_GouvernoratArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratArriveeActionPerformed(evt);
            }
        });

        jLabel3.setText("Vers: ");

        jLabel1.setText("Allant de:");

        cb_GouvernoratDepart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_GouvernoratDepartActionPerformed(evt);
            }
        });

        tf_Conducteur.setToolTipText("");

        jLabel6.setText("Le:");

        jLabel7.setText("à:");

        jLabel10.setText("Prix:");

        chb_Reserve.setText("Réservé aux femmes");

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

        cb_DelegationArrivee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_DelegationArriveeActionPerformed(evt);
            }
        });

        boutton_Modifier.setText("Modifier");
        boutton_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_ModifierActionPerformed(evt);
            }
        });

        jLabel12.setText("Localite:");

        jLabel11.setText("Localite:");

        jLabel4.setText("Délégation:");

        jLabel2.setText("Délégation:");

        jLabel5.setText("E-Mail du conducteur OU Nom du conducteur");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(boutton_Modifier))
                                    .addComponent(boutton_Localiser))))
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(tf_Conducteur, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Conducteur, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
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
                        .addComponent(boutton_Modifier)
                        .addGap(18, 18, 18)
                        .addComponent(boutton_Retour)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_GouvernoratArriveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratArriveeActionPerformed
        cb_DelegationArrivee.removeAllItems();
        cb_LocaliteArrivee.removeAllItems();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
    }//GEN-LAST:event_cb_GouvernoratArriveeActionPerformed

    private void cb_GouvernoratDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratDepartActionPerformed
        cb_DelegationDepart.removeAllItems();
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_GouvernoratDepartActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
        new RechercherCovoiturage().setVisible(true);
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_LocaliserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_LocaliserActionPerformed
        Ville depart = new Ville(), arrivee = new Ville();
        depart.setGouvernorat(cb_GouvernoratDepart.getSelectedItem().toString());
        depart.setDelegation(cb_DelegationDepart.getSelectedItem().toString());
        depart.setLatitude(villeDAO.localiserVille_nom(depart.getGouvernorat()).getLatitude());
        depart.setLongitude(villeDAO.localiserVille_nom(depart.getGouvernorat()).getLongitude());
        arrivee.setGouvernorat(cb_GouvernoratArrivee.getSelectedItem().toString());
        arrivee.setDelegation(cb_DelegationArrivee.getSelectedItem().toString());
        arrivee.setLatitude(villeDAO.localiserVille_nom(arrivee.getGouvernorat()).getLatitude());
        arrivee.setLongitude(villeDAO.localiserVille_nom(arrivee.getGouvernorat()).getLongitude());
        Navigateur.main(depart, arrivee);
    }//GEN-LAST:event_boutton_LocaliserActionPerformed

    private void cb_DelegationDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DelegationDepartActionPerformed
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_DelegationDepartActionPerformed

    private void cb_DelegationArriveeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_DelegationArriveeActionPerformed
        cb_LocaliteArrivee.removeAllItems();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
    }//GEN-LAST:event_cb_DelegationArriveeActionPerformed

    private void boutton_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_ModifierActionPerformed
        if (tf_Conducteur.getText().matches(_regexAdressEmail)) {
            covoitureur = covoitureurDAO.afficherCovoitureurEMAIL(tf_Conducteur.getText());
        } else {
            covoitureur = covoitureurDAO.afficherCovoitureur_NomUtilisateur(tf_Conducteur.getText());
        }
//        Covoiturage covoiturage = new Covoiturage();
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
                        if (covoiturageDAO.modifierCovoiturage(covoiturage)) {
                            System.out.println(" test covoiturage   " + covoiturage.toString());
                            JOptionPane.showMessageDialog(this, "Le covoiturage a été mis à jour avec succés.");
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Le covoiturage n'a pas été mis à jour !", null, 2);
                        }
//                        System.out.println("test 1 id  ; " + covoiturage);
//                        Covoiturage covoiturage1 = covoiturageDAO.modifierCovoiturage(covoiturage);
//                        System.out.println("test 2 id ; " + covoiturage1);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !", null, 2);
                }
            } catch (ParseException ex) {
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !", null, 2);
        }
    }//GEN-LAST:event_boutton_ModifierActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifierCovoiturage().setVisible(true);
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