package Handlers;

import Entites.notification;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wael Mallek
 */
public class NotificationHandler extends DefaultHandler {

    private Vector personnes;
    String nomTag = "close";
    String idTag = "close";
    String id_expediteurTag = "close";
    String id_destinataireTag = "close";
    String luTag = "close";
    String contenuTag = "close";

    public NotificationHandler() {
        personnes = new Vector();
    }

    public notification[] getPersonne() {
        notification[] personness = new notification[personnes.size()];
        personnes.copyInto(personness);
        return personness;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private notification currentPersonne;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("notification")) {

            if (currentPersonne != null) {
                throw new IllegalStateException("already processing a personnes");
            }

            currentPersonne = new notification();
        } else if (qName.equals("nom_utilisateur")) {
            nomTag = "open";

        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("id_expediteur")) {
            id_expediteurTag = "open";
        } else if (qName.equals("id_destinataire")) {
            id_destinataireTag = "open";
        } else if (qName.equals("contenu")) {
            contenuTag = "open";
        } else if (qName.equals("lu")) {
            luTag = "open";

        }


    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("notification")) {
            // we are no longer processing a <reg.../> tag
            personnes.addElement(currentPersonne);
            currentPersonne = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("id_expediteur")) {
            id_expediteurTag = "close";
        } else if (qName.equals("id_destinataire")) {
            id_destinataireTag = "close";
        } else if (qName.equals("contenu")) {
            contenuTag = "close";
        } else if (qName.equals("lu")) {
            luTag = "close";
        } else if (qName.equals("nom_utilisateur")) {
            nomTag = "close";

        }
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentPersonne != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentPersonne.setId(Integer.parseInt(id));
            } else if (id_expediteurTag.equals("open")) {
                String id_dest = new String(ch, start, length).trim();
                currentPersonne.setId_destinataire(Integer.parseInt(id_dest));
            } else if (id_destinataireTag.equals("open")) {
                String id_exp = new String(ch, start, length).trim();
                currentPersonne.setId_expediteur(Integer.parseInt(id_exp));
            } else if (luTag.equals("open")) {
                String lu = new String(ch, start, length).trim();
                currentPersonne.setLu(Integer.parseInt(lu));
            } else if (contenuTag.equals("open")) {
                String cont = new String(ch, start, length).trim();
                currentPersonne.setContenu(cont);
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentPersonne.setNom(nom);
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentPersonne.setNom(nom);
            }
        }
    }
}
