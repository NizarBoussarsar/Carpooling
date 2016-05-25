/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entites.Covoiturage;
import java.io.DataInputStream;
import java.io.IOException;

import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.io.IOException;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 *
 * @author admin
 */
public class FormContact extends List implements CommandListener {
    
    Displayable testform;
    MIDlet midlet;
    sendSMS sms1 = new sendSMS();
    String[] elm = {"réserver", "envoyer un message", "envoyer un sms", "appeler"};
    List list;//=new List("Contacter",List.IMPLICIT,elm,null);
    public Command exit, next, cmdExit;
    public Image reser, call, sms, message;
    
    public FormContact() {
        super("Form Contact", List.IMPLICIT);
        System.out.println(" test");
        
        try {
            reser = Image.createImage("/book.jpg");
            message = Image.createImage("/message.jpg");
            sms = Image.createImage("/sms.jpg");
            call = Image.createImage("/call.jpg");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("    image");
        Image[] imageElements = {reser, message, sms, call};
        list = new List("contact", List.IMPLICIT, elm, imageElements);
        System.out.println("    list1");
        
        next = new Command("Select", Command.SCREEN, 0);
        exit = new Command("Menu", Command.EXIT, 0);
        System.out.println("    commede");
        list.addCommand(next);
        
        list.addCommand(exit);
        System.out.println("    commecde4");
        list.setCommandListener(this);
//        this.addCommand(cmdExit);
//        this.setCommandListener(this);
        
    }
    
    public void commandAction(Command c, Displayable d) {
        
        if (c == List.SELECT_COMMAND) {
            if (list.getSelectedIndex() == 0) {
                Alert alerta = new Alert("Success", "Votre demande de réservation a été effectué avec succés.", null, AlertType.INFO);
                int idCovoiturage = RechercherCovoiturage.getCovoiturage().getId();
                int idCreateurCovoiturage = RechercherCovoiturage.getCovoiturage().getIdCreateur();
                String contenu = "Vous%20avez%20une%20nouvelle%20demande%20de%20réservation%20de%20la%part%20%de%20Nizar%Boussarsar.";
                Reserver reserver = new Reserver(Midlet.covoitureurConnecte.getId(), idCovoiturage);
                Notifier notifier = new Notifier(Midlet.covoitureurConnecte.getId(), idCreateurCovoiturage, contenu);
                reserver.run();
                if (reserver.test = true) {
                    notifier.run();
                    if (notifier.test = true) {
                        alerta.setTimeout(5000);
                        Midlet.getDisplay().setCurrent(alerta);
                    }
                } else {
                    Midlet.getDisplay().setCurrent(alerta);
                }
            }
            if (list.getSelectedIndex() == 1) {
                Midlet.getDisplay().setCurrent(new EnvoyerUnMessage(null, Midlet.covoitureurConnecte.getId(), RechercherCovoiturage.getCovoiturage().getIdCreateur()));
            }
            
            if (list.getSelectedIndex() == 2) {
                System.out.println(" sms");
                Midlet.getDisplay().setCurrent(sms1.compose);
            }
            
            if (list.getSelectedIndex() == 3) {
                Midlet m = new Midlet();
                System.out.println(" call ");
                m.callme("5550000");
            }
        }
            if (c == exit) {
          Midlet.getDisplay().setCurrent(new Accueil("acceuil", List.IMPLICIT));
            }
        
    }
    
    public class Reserver {
        
        int idCovoitureur, idCovoiturage;
        public boolean test = false;
        
        public Reserver(int idCovoitureur, int idCovoiturage) {
            this.idCovoitureur = idCovoitureur;
            this.idCovoiturage = idCovoiturage;
            Thread th = new Thread();
            th.start();
        }
        
        public void run() {
            HttpConnection hc;
            DataInputStream dis;
            String url = "http://localhost/covoituragej2me/ajouterReservation.php";
            StringBuffer sb = new StringBuffer();
            int ch;
            try {
                hc = (HttpConnection) Connector.open(url + "?idCovoitureur=" + idCovoitureur + "&idCovoiturage=" + idCovoiturage);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                    System.out.println("sb : " + sb);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if ("successfully added".equalsIgnoreCase(sb.toString().trim())) {
                test = true;
            } else {
                test = false;
            }
        }
    }
    
    public class Notifier {
        
        int idExpediteur, idDestinataire;
        String contenu;
        public boolean test = false;
        
        public Notifier(int idExpediteur, int idDestinataire, String contenu) {
            this.idExpediteur = idExpediteur;
            this.idDestinataire = idDestinataire;
            this.contenu = contenu;
            Thread th = new Thread();
            th.start();
        }
        
        public void run() {
            HttpConnection hc;
            DataInputStream dis;
            String url = "http://localhost/covoituragej2me/envoyerNotificationReservation.php";
            StringBuffer sb = new StringBuffer();
            int ch;
            try {
                hc = (HttpConnection) Connector.open(url + "?idExpediteur=" + idExpediteur + "&idDestinataire=" + idDestinataire + "&contenu=" + contenu);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if ("successfully added".equalsIgnoreCase(sb.toString().trim())) {
                test = true;
            } else {
                test = false;
            }
        }
    }
    
}
