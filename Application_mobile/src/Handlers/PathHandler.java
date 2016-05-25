/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entites.Ville;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PathHandler extends DefaultHandler {

    private Vector Villes;
    String idTag = "close";
    String latitudeTag = "close";
    String longitudeTag = "close";

    public PathHandler() {
        Villes = new Vector();
    }

    public Ville[] getville() {
        Ville[] Villess = new Ville[Villes.size()];
        Villes.copyInto(Villess);
        return Villess;
    }
    private Ville currentVille;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Ville")) {

            if (currentVille != null) {
                throw new IllegalStateException("already processing a Covoiturage");
            }
            currentVille = new Ville();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("latitude")) {
            latitudeTag = "open";
        } else if (qName.equals("longitude")) {
            longitudeTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("Ville")) {
            // we are no longer processing a <reg.../> tag
            Villes.addElement(currentVille);
            currentVille = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("longitude")) {
            longitudeTag = "close";
        } else if (qName.equals("latitude")) {
            latitudeTag = "close";
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentVille != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentVille.setId((Integer.parseInt(id)));
            } else if (longitudeTag.equals("open")) {
                String Latitude = new String(ch, start, length).trim();
                currentVille.setLatitude((Double.parseDouble(Latitude)));
            } else if (latitudeTag.equals("open")) {
                String Longitude = new String(ch, start, length).trim();
                currentVille.setLongitude((Double.parseDouble(Longitude)));
            }
        }
    }
}
