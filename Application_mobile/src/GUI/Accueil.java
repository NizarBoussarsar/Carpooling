/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.*;

/**
 *
 * @author RayzerCoder
 */
public class Accueil extends List implements CommandListener {

    public Accueil(String title, int listType) {
      
        super(title, listType);
        this.append("Consulter mon profil", null); //0
        this.append("Consulter mes messages", null); //1
        this.append("Consulter mes notifications", null); //2
        this.append("Rechercher un covoiturage", null); //3
        this.append("Rechercher un covoitureur", null); //4
        this.append("Geolocalisation", null); //5
        this.append("Afficher les 10 plus récents covoiturages", null); //6
        this.append("Afficher mes statistiques", null); //7
        this.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        System.out.println(" le covoitureuur connzxte"+Midlet.covoitureurConnecte.getNom_utilisateur());
        if (c == List.SELECT_COMMAND) {
            if (this.getSelectedIndex() == 0) {
                ConsulterMonProfile consulterMonProfile = new ConsulterMonProfile("Mon profil");
            }
            if (this.getSelectedIndex() == 1) {
                ConsulterListeDesMessages consulterListeDesMessages = new ConsulterListeDesMessages("Vos messages", IMPLICIT);
            }
            if (this.getSelectedIndex() == 2) {
                Midlet.getDisplay().setCurrent(new notificationForm(Midlet.covoitureurConnecte.getId()));
            }
            if (this.getSelectedIndex() == 3) {
                Midlet.getDisplay().setCurrent(new SaisieCovoiturage(null, d));
            }
            if (this.getSelectedIndex() == 4) {
                Midlet.getDisplay().setCurrent(new RechercheCovoitureur("Rechercher un Covoitureur"));
            }
            if (this.getSelectedIndex() == 5) {
                Midlet.getDisplay().setCurrent(new CovoitureurConnecteList(null, IMPLICIT).lst);
            }
            if (this.getSelectedIndex() == 6) {
                Midlet.getDisplay().setCurrent(new CovoituragesRecents().accueilForm);
            }
            if (this.getSelectedIndex() == 7) {
                Midlet.getDisplay().setCurrent(new statistiquesForm(Midlet.covoitureurConnecte.getId()));
            }
        }
    }

}
