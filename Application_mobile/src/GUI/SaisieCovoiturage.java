/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author Hhussein
 */
public class SaisieCovoiturage extends Form implements CommandListener {

    Displayable testListScreen;
    MIDlet midlet;
    private TextField tb1;
    private TextField tb2;
    Command cmdAfficher;
    Command cmdBack;

    public SaisieCovoiturage(MIDlet m, Displayable testListScreen) {
        super("test");
        this.testListScreen = testListScreen;
        this.midlet = m;
        tb1 = new TextField("Depart : ", null, 100, TextField.ANY);
        tb2 = new TextField("Arrivee: ", null, 100, TextField.ANY);
        cmdAfficher = new Command("Rechercher", Command.SCREEN, 0);
        cmdBack = new Command("Back", Command.BACK, 0);

        this.append(tb1);
        this.append(tb2);
        this.addCommand(cmdBack);
        this.addCommand(cmdAfficher);
        this.setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdAfficher) {
            if (this.tb1 != null) {
                Midlet.getDisplay().setCurrent(new RechercherCovoiturage(midlet, testListScreen, tb1.getString(), tb2.getString()));
            }
        }
        if (c == cmdBack) {
            Midlet.getDisplay().setCurrent(new Accueil("Accueil", List.IMPLICIT));
        }
    }
}