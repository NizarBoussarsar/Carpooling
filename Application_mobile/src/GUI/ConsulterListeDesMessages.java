/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import Entites.Message;
import GUI.Midlet;
import Handlers.MessageHandler;
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author RayzerCoder
 */
public class ConsulterListeDesMessages extends List implements Runnable, CommandListener {

    String basicURL = "http://localhost/covoituragej2me/";
    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;
    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    Alert alertMessages;
    Message[] messages;
    ConsulterUnMessage consulterUnMessage;
    Command cmdRetour;

    public ConsulterListeDesMessages(String title, int listType) {
        super(title, listType);
        cmdRetour = new Command("Menu", Command.BACK, 0);
        Thread thread = new Thread(this);
        thread.start();
        this.addCommand(cmdRetour);
        this.setCommandListener(this);

    }

    public void run() {
        try {
            http = (HttpConnection) Connector.open(basicURL + "recupererListedesMessages.php?idDestinataire=1");
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
                alertMessages = new Alert("Boite reception vide", "Aucun message DSL", null, AlertType.ERROR);
                Midlet.getDisplay().setCurrent(alertMessages);
            } else {
                MessageHandler messageHandler = new MessageHandler();
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                parser.parse(inRes, messageHandler);
                messages = messageHandler.getMessages();
                System.out.println("lonegru" + messages.length);
                if (messages.length > 0) {
                    for (int i = 0; i < messages.length; i++) {
                        System.out.println(messages[i].getObjet() + ">>>");
                        this.append(messages[i].getObjet() + "", null);
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
            System.out.println("wwwwwwwwwwwwwwwwww" + messages[this.getSelectedIndex()].getContenu());
            consulterUnMessage = new ConsulterUnMessage("Message", messages[this.getSelectedIndex()]);
        }
        if (c == cmdRetour) {
            Midlet.getDisplay().setCurrent(new Accueil("Accueil", IMPLICIT));
        }
    }

}
