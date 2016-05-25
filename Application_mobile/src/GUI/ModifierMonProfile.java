/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;

/**
 *
 * @author RayzerCoder
 */
public class ModifierMonProfile extends Form implements Runnable, CommandListener {

    TextField tfNom;
    TextField tfPrenom;
    TextField tfEmail;
    TextField tfMdp;
    TextField tfNomUtilisateur;
    TextField tfSkype;
    TextField tfFacebook;
    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    Alert alert;
    String basicURL = "http://localhost/covoituragej2me/";
    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;
    Command cmdValider;
    Command cmdRetour;

    public ModifierMonProfile(String title) {
        super(title);
        cmdValider = new Command("Valider", Command.SCREEN, 0);
        cmdRetour = new Command("Retour", Command.BACK, 0);
        tfNom = new TextField("Nom", covoitureurConnecte.getNom(), 255, TextField.ANY);
        tfPrenom = new TextField("Prenom", covoitureurConnecte.getPrenom(), 255, TextField.ANY);
        tfEmail = new TextField("Email", covoitureurConnecte.getEmail(), 255, TextField.EMAILADDR);

        tfNomUtilisateur = new TextField("Nom utilisateur", covoitureurConnecte.getNom_utilisateur(), 255, TextField.ANY);

        this.append(tfNom);
        this.append(tfPrenom);
        this.append(tfNomUtilisateur);
        this.append(tfEmail);
        this.addCommand(cmdValider);
        this.addCommand(cmdRetour);
        this.setCommandListener(this);
        Midlet.getDisplay().setCurrent(this);
    }

    public void run() {
        try {
            http = (HttpConnection) Connector.open(basicURL + "modifierProfil.php?id=" + covoitureurConnecte.getId() + "&nom=" + tfNom.getString() + "&prenom=" + tfPrenom.getString() + "&email=" + tfEmail.getString() + "&nom_utilisateur=" + tfNomUtilisateur.getString());
            in = new DataInputStream(http.openDataInputStream());
            String resString;
            int reader;
            while ((reader = in.read()) != -1) {
                sb.append((char) reader);
            }
            resString = sb.toString().trim();
            InputStream inRes = new ByteArrayInputStream(resString.getBytes());
            System.out.println("RESULT-" + sb.toString().trim());
            if ("ERROR".equalsIgnoreCase(sb.toString().trim())) {
                System.out.println("ERROR");
            } else {
                System.out.println("OK");
            }

        } catch (Exception e) {
            System.out.println("66666" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdValider) {
            Thread thread = new Thread(this);
            thread.start();
        }
        if (c == cmdRetour) {
            ConsulterMonProfile cf = new ConsulterMonProfile("Votre profil");
        }
    }
}
