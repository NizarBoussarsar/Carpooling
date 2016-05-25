/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import Entites.Message;
import GUI.Midlet;
import Handlers.CovoitureurHandler;
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
public class ResultatRechercheCovoitureur extends List implements Runnable, CommandListener {

    String basicURL = "http://localhost/covoituragej2me/";
    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;
    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    Alert alertPasDeCovoitureur;
    Covoitureur[] covoitureurs;
    ConsulterUnProfile consulterUnProfile;
    String critere;

    public ResultatRechercheCovoitureur(String title, int listType,String critere) {
        super(title, listType);
        this.critere = critere;
        Thread thread = new Thread(this);
        thread.start();

    }

    public void run() {
        try {

            http = (HttpConnection) Connector.open(basicURL + "rechercheCovoitureur.php?critere="+this.critere);
            in = new DataInputStream(http.openDataInputStream());
            int reader;
            String resString;
            while ((reader = in.read()) != -1) {
                sb.append((char) reader);
            }
            resString = sb.toString().trim();
            InputStream inRes = new ByteArrayInputStream(resString.getBytes());
            System.out.println("RESULT-" + sb.toString().trim());
            if ("No Message".equalsIgnoreCase(sb.toString().trim())) {
                alertPasDeCovoitureur = new Alert("Pas de covoitureur trouver", "Aucun covoitureur est trouver selon critere de recherche", null, AlertType.ERROR);
                Midlet.getDisplay().setCurrent(alertPasDeCovoitureur);
            } else {
                CovoitureurHandler covoitureurHandler = new CovoitureurHandler();
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                parser.parse(inRes, covoitureurHandler);
                covoitureurs = covoitureurHandler.getCovoitureurs();
                System.out.println("lonegru" + covoitureurs.length);
                if (covoitureurs.length > 0) {
                    for (int i = 0; i < covoitureurs.length; i++) {
                        System.out.println(covoitureurs[i].getNom() + " " + covoitureurs[i].getPrenom());
                        this.append(covoitureurs[i].getNom() + " " + covoitureurs[i].getPrenom(), null);
                    }
                }
                this.setCommandListener(this);
                Midlet.getDisplay().setCurrent(this);
            }
        } catch (Exception e) {
            System.out.println("e-->" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND) {
            //System.out.println("wwwwwwwwwwwwwwwwww" + covoitureurs[this.getSelectedIndex()].getContenu());
            consulterUnProfile = new ConsulterUnProfile("Consuler Profile de" + covoitureurs[this.getSelectedIndex()].getNom() + " " + covoitureurs[this.getSelectedIndex()].getPrenom(), covoitureurs[this.getSelectedIndex()]);
        }
    }

}
