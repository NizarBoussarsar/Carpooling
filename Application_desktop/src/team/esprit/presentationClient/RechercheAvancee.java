package team.esprit.presentationClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import team.esprit.dao.CovoiturageDAO;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.dao.VilleDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Ville;

public class RechercheAvancee extends javax.swing.JFrame {

    CovoiturageDAO covoiturageDAO = new CovoiturageDAO();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    VilleDAO villeDAO = new VilleDAO();
    List<Ville> listGouvernoratsDepart;
    List<Ville> listDelegationsDepart;
    List<Ville> ListLocalitesDepart;
    List<Ville> listGouvernoratsArrivee;
    List<Ville> listDelegationsArrivee;
    List<Ville> ListLocalitesArrivee;

    public RechercheAvancee() {
        initComponents();
        setTitle("Recherche avancée");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        remplirGouvernoratDepart();
        remplirDelegationDepart();
        remplirLocaliteDepart();
        remplirGouvernoratArrivee();
        remplirDelegationArrivee();
        remplirLocaliteArrivee();
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

        jLabel1 = new javax.swing.JLabel();
        cb_GouvernoratDepart = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cb_GouvernoratArrivee = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cb_DelegationArrivee = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        dp_Date = new org.jdesktop.swingx.JXDatePicker();
        jLabel10 = new javax.swing.JLabel();
        tf_Prix = new javax.swing.JTextField();
        chb_Fumeur = new javax.swing.JCheckBox();
        chb_Reserve = new javax.swing.JCheckBox();
        boutton_Rechercher = new javax.swing.JButton();
        cb_LocaliteDepart = new javax.swing.JComboBox();
        cb_LocaliteArrivee = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        boutton_Retour = new javax.swing.JButton();
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

        jLabel6.setText("Le:");

        jLabel10.setText("Prix:");

        tf_Prix.setText("0");

        chb_Fumeur.setText("Fumeur");

        chb_Reserve.setText("Réservé aux femmes");

        boutton_Rechercher.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Rechercher.setText("Rechecher");
        boutton_Rechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RechercherActionPerformed(evt);
            }
        });

        jLabel11.setText("Localite:");

        jLabel12.setText("Localite:");

        boutton_Retour.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
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
                    .addComponent(chb_Fumeur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(chb_Reserve)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cb_DelegationArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cb_DelegationDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(23, 23, 23)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tf_Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(boutton_Retour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boutton_Rechercher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_LocaliteDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_LocaliteArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(166, 166, 166))
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
                            .addComponent(cb_DelegationArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_LocaliteDepart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_LocaliteArrivee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(dp_Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tf_Prix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boutton_Rechercher))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chb_Fumeur)
                    .addComponent(chb_Reserve)
                    .addComponent(boutton_Retour))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RechercherActionPerformed
        Covoiturage covoiturage = new Covoiturage();
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
        covoiturage.setPrix((Float.parseFloat(tf_Prix.getText())));
        covoiturage.setFumeur(chb_Fumeur.isSelected());
        covoiturage.setReserveeFemmes(chb_Reserve.isSelected());
        try {
            try {
                if ((tf_Prix.getText().equals("")) == false) {
                    if (dp_Date.getDate().before((dateFormat.parse(systemDate)))) {
                        JOptionPane.showMessageDialog(this, "La date du covoiturage est dépassé.");
                    } else if (dp_Date.getDate().after((dateFormat.parse(systemDate))) || dp_Date.getDate().equals(dateFormat.parse(systemDate))) {
                        RechercherCovoiturage rechercheCovoiturage = new RechercherCovoiturage(covoiturage);
                        this.dispose();
                        rechercheCovoiturage.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "v1");
                }
            } catch (ParseException ex) {
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
        }
    }//GEN-LAST:event_boutton_RechercherActionPerformed

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void cb_GouvernoratDepartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_GouvernoratDepartActionPerformed
        cb_DelegationDepart.removeAllItems();
        cb_LocaliteDepart.removeAllItems();
        remplirDelegationDepart();
        remplirLocaliteDepart();
    }//GEN-LAST:event_cb_GouvernoratDepartActionPerformed

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
                new RechercheAvancee().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Rechercher;
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
    private javax.swing.JTextField tf_Prix;
    // End of variables declaration//GEN-END:variables
}