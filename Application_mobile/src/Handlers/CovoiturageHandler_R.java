/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entites.Covoiturage;
import Entites.Ville;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Hhussein
 */
public class CovoiturageHandler_R extends DefaultHandler {

    private Vector covoiturages;
    String idTag = "close";
    String titreTag = "close";
    String descriptionTag = "close";
    String id_ville_departTag = "close";
    String id_ville_arriveeTag = "close";
    String conducteurTag = "close";

    public CovoiturageHandler_R() {
        covoiturages = new Vector();
    }

    public Covoiturage[] getCovoiturage() {
        Covoiturage[] covoituragess = new Covoiturage[covoiturages.size()];
        covoiturages.copyInto(covoituragess);
        return covoituragess;
    }
    private Covoiturage currentCovoiturage;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("covoiturage")) {
            if (currentCovoiturage != null) {
                throw new IllegalStateException("already processing a Covoiturage");
            }
            currentCovoiturage = new Covoiturage();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("titre")) {
            titreTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        } else if (qName.equals("id_ville_depart")) {
            id_ville_departTag = "open";
        } else if (qName.equals("id_ville_arrivee")) {
            id_ville_arriveeTag = "open";
        } else if (qName.equals("id_createur")) {
            conducteurTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("covoiturage")) {
            // we are no longer processing a <reg.../> tag
            covoiturages.addElement(currentCovoiturage);
            currentCovoiturage = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("titre")) {
            titreTag = "close";
        } else if (qName.equals("description")) {
            descriptionTag = "close";
        } else if (qName.equals("id_ville_depart")) {
            id_ville_departTag = "close";
        } else if (qName.equals("id_ville_arrivee")) {
            id_ville_arriveeTag = "close";
        } else if (qName.equals("id_conducteur")) {
            conducteurTag = "close";
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentCovoiturage != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentCovoiturage.setId((Integer.parseInt(id)));
            } else if (titreTag.equals("open")) {
                String titre = new String(ch, start, length).trim();
                currentCovoiturage.setTitre(titre);
            } else if (descriptionTag.equals("open")) {
                String desc = new String(ch, start, length).trim();
                currentCovoiturage.setDescription(desc);
            } else if (id_ville_departTag.equals("open")) {
                String idd = new String(ch, start, length).trim();
                Ville v = new Ville();
                v.setId(Integer.parseInt(idd));
                currentCovoiturage.setVilleDepart(v);
            } else if (id_ville_arriveeTag.equals("open")) {
                String idd = new String(ch, start, length).trim();
                Ville v = new Ville();
                v.setId(Integer.parseInt(idd));
                currentCovoiturage.setVilleArrivee(v);
            } else if (conducteurTag.equals("open")) {
                String conducteur = new String(ch, start, length).trim();
                currentCovoiturage.setIdCreateur(Integer.parseInt(conducteur));
            }
        }
    }
}