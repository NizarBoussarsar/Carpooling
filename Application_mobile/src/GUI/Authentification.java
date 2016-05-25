package GUI;

import Entites.Covoitureur;
import Handlers.CovoitureurHandler;
import java.io.*;
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author RayzerCoder
 */
public class Authentification extends Form implements CommandListener, Runnable {

    Command cmdAuthentifier;
    TextField tfEmail;
    TextField tfMdp;

    HttpConnection http;
    InputStream in;
    OutputStream out;
    StringBuffer sb = new StringBuffer();
    int rc;
    Alert alertAuthentification;
    Covoitureur[] covoitureurs;

    List lst = new List("Covoitureurs", List.IMPLICIT);

    String basicURL = "http://localhost/covoituragej2me/";

    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;

    public Authentification(String title) {
        super(title);
        tfEmail = new TextField("Adresse email", null, 100, TextField.EMAILADDR);
        tfMdp = new TextField("Mot de passe", null, 100, TextField.PASSWORD);
        cmdAuthentifier = new Command("Authentifier", Command.SCREEN, 0);
        this.append(tfEmail);
        this.append(tfMdp);
        this.addCommand(cmdAuthentifier);
        this.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdAuthentifier) {
            if (tfEmail.getString().equals("") || tfMdp.getString().equals("")) {
                alertAuthentification = new Alert("Erreur d'authentification", "Sasir votre email et vote mot de passe", null, AlertType.ERROR);
                Midlet.getDisplay().setCurrent(alertAuthentification);
            } else {
                Thread thread = new Thread(this);
                thread.start();
            }
        }
    }

    public void run() {
        try {
            http = (HttpConnection) Connector.open(basicURL + "authentification.php?email=" + tfEmail.getString() + "&password=" + tfMdp.getString());
            in = new DataInputStream(http.openDataInputStream());
            int reader;
            String resString;
            while ((reader = in.read()) != -1) {
                sb.append((char) reader);
            }
            resString = sb.toString().trim();
            InputStream inRes = new ByteArrayInputStream(resString.getBytes());
            System.out.println("RESULT-" + sb.toString().trim());
            if ("ERROR".equalsIgnoreCase(sb.toString().trim())) {
                alertAuthentification = new Alert("Erreur d'authentification", "Une erreur s'est produite pendant l'authentification", null, AlertType.ERROR);
                Midlet.getDisplay().setCurrent(alertAuthentification);
            } else {
                CovoitureurHandler covoitureurHandler = new CovoitureurHandler();
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                parser.parse(inRes, covoitureurHandler);
                covoitureurs = covoitureurHandler.getCovoitureurs();
                if (covoitureurs.length == 1) {
                    covoitureurConnecte = covoitureurs[0];
                    System.out.println(covoitureurConnecte.toString());
                    System.out.println(covoitureurs[0].getEmail());
                    Midlet.covoitureurConnecte = covoitureurs[0];
                    lst.append(covoitureurs[0].getEmail(), null);
                    Midlet.getDisplay().setCurrent(new Accueil("Acceuil", List.IMPLICIT));
                }
            }

        } catch (Exception e) {
            System.out.println("66666" + e.getMessage());
        }
    }

}
