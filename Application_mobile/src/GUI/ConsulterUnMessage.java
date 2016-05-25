/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Message;
import GUI.Midlet;
import Handlers.CovoitureurHandler;
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
public class ConsulterUnMessage extends Form implements Runnable, CommandListener {

    TextField tfContenu;
    TextField tfObjet;
    TextField tfExpediteur;
    Message message;
    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    int idExpediteur;
    Command cmdRetour, cmdRepondre;
    String basicURL = "http://localhost/covoituragej2me/";

    public ConsulterUnMessage(String title, Message message) {
        super(title);
        this.message = message;
        cmdRetour = new Command("Vos messages", Command.BACK, 0);
        cmdRepondre = new Command("Repondre", Command.SCREEN, 0);
        Thread thread = new Thread(this);
        thread.start();
        idExpediteur = message.getId_expediteur();
        System.out.println(message.getContenu());
        tfExpediteur = new TextField("De la part de", "", 255, TextField.UNEDITABLE);
        tfObjet = new TextField("Object : ", message.getObjet(), 255, TextField.UNEDITABLE);
        tfContenu = new TextField("Message : ", message.getContenu(), 255, TextField.UNEDITABLE);
        this.append(tfExpediteur);
        this.append(tfObjet);
        this.append(tfContenu);
        this.addCommand(cmdRetour);
        this.addCommand(cmdRepondre);
        this.setCommandListener(this);
        Midlet.getDisplay().setCurrent(this);
    }

    public void run() {
        try {
            http = (HttpConnection) Connector.open(basicURL + "recupererCovoitureurNomPrenom.php?idCocoitureur=" + idExpediteur);
            in = new DataInputStream(http.openDataInputStream());
            int reader;
            String resString;
            while ((reader = in.read()) != -1) {
                sb.append((char) reader);
            }
            resString = sb.toString().trim();
            if ((resString.equals("ERROR"))) {
                tfExpediteur.setString("UNKNWON");
            } else {
                tfExpediteur.setString(resString);
            }

        } catch (Exception e) {
            System.out.println("66666" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdRetour) {
            ConsulterListeDesMessages cf = new ConsulterListeDesMessages("Vos messages", List.IMPLICIT);
        }
        if (c == cmdRepondre) {
            EnvoyerUnMessage em = new EnvoyerUnMessage("Repondre", message.getId_destinataire(), message.getId_expediteur());
            Midlet.getDisplay().setCurrent(em);
        }
    }

}
