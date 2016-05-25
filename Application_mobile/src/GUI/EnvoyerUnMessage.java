/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import GUI.Midlet;
import Handlers.MessageHandler;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author RayzerCoder
 */
public class EnvoyerUnMessage extends Form implements Runnable, CommandListener {

    String basicURL = "http://localhost/covoituragej2me/";
    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;
    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    Alert alertMessage;
    TextField tf;
    Command cmdEnvoyer;
    Command cmdRetour;
    int idExpediteur;
    int idDestinataire;

    public EnvoyerUnMessage(String title, int idExpediteur, int idDestinataire) {
        super(title);
        cmdEnvoyer = new Command("Envoyer", Command.SCREEN, 0);
        cmdRetour = new Command("Retour", Command.BACK, 0);
        tf = new TextField("Message à envoyer", null, 255, TextField.ANY);
        this.idDestinataire = idDestinataire;
        this.idExpediteur = idExpediteur;
        this.append(tf);
        this.addCommand(cmdRetour);
        this.addCommand(cmdEnvoyer);
        this.setCommandListener(this);
    }

    public void run() {
        try {
            String str = "cc";
            http = (HttpConnection) Connector.open(basicURL + "envoyerUnMessage.php?idDestinataire=" + idDestinataire + "&idExpediteur=" + idExpediteur + "&objet=test&contenu=" + tf.getString() + "");
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
            System.out.println("e-->" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdEnvoyer) {
            Thread thread = new Thread(this);
            thread.start();
            Midlet.getDisplay().setCurrent(new Accueil("Acceui", List.IMPLICIT));
        }
        if (c == cmdRetour) {
            Midlet.getDisplay().setCurrent(new ConsulterListeDesMessages("Vos messages", List.IMPLICIT));
        }
    }
}
