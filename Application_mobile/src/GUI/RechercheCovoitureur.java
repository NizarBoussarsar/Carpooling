package GUI;

import javax.microedition.lcdui.*;

/**
 *
 * @author RayzerCoder
 */
public class RechercheCovoitureur extends Form implements CommandListener {

    Command cmdRecherche;
    Command cmdRetour;
    TextField tfCritere;
    ResultatRechercheCovoitureur resultatRecherche;
    Accueil acceuil;

    public RechercheCovoitureur(String title) {
        super(title);
        cmdRecherche = new Command("Recherche", Command.SCREEN, 0);
        cmdRetour = new Command("Retour", Command.BACK, 0);
        tfCritere = new TextField("Recherche :", "", 255, TextField.ANY);
        this.append(tfCritere);
        this.addCommand(cmdRecherche);
        this.addCommand(cmdRetour);
        this.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdRecherche) {
            resultatRecherche = new ResultatRechercheCovoitureur("Resultat de la recherche", List.IMPLICIT, tfCritere.getString());
            Midlet.getDisplay().setCurrent(resultatRecherche);
        }
        if (c == cmdRetour) {
            Midlet.getDisplay().setCurrent(new Accueil("Accueil", List.IMPLICIT));
        }
    }

}
