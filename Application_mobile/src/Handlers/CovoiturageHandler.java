package Handlers;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import Entites.Covoiturage;

/**
 *
 * @author Nizar
 */
public class CovoiturageHandler extends DefaultHandler {

    private Vector covoiturages;
    String idTag = "close";
    String titreTag = "close";
    String descriptionTag = "close";
    String gouvernoratDepartTag = "close";
    String delegationDepartTag = "close";
    String localiteDepartTag = "close";
    String gouvernoratArriveeTag = "close";
    String delegationArriveeTag = "close";
    String localiteArriveeTag = "close";
    String conducteurTag = "close";
    String idConducteurTag = "close";
    String dateDepartTag = "close";
    String heureDepartTag = "close";
    String nombrePlacesTag = "close";
    String prixTag = "close";
    String fumeurTag = "close";
    String reserveeFemmesTag = "close";

    public CovoiturageHandler() {
        covoiturages = new Vector();
    }

    public Covoiturage[] getCovoiturage() {
        Covoiturage[] covoiturage = new Covoiturage[covoiturages.size()];
        covoiturages.copyInto(covoiturage);
        return covoiturage;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Covoiturage currentCovoiturage;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("covoiturage")) {
            if (currentCovoiturage != null) {
                throw new IllegalStateException("already processing a covoiturage");
            }
            currentCovoiturage = new Covoiturage();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("titre")) {
            titreTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";
        } else if (qName.equals("gouvernorat_depart")) {
            gouvernoratDepartTag = "open";
        } else if (qName.equals("delegation_depart")) {
            delegationDepartTag = "open";
        } else if (qName.equals("localite_depart")) {
            localiteDepartTag = "open";
        } else if (qName.equals("gouvernorat_arrivee")) {
            gouvernoratArriveeTag = "open";
        } else if (qName.equals("delegation_arrivee")) {
            delegationArriveeTag = "open";
        } else if (qName.equals("localite_arrivee")) {
            localiteArriveeTag = "open";
        } else if (qName.equals("conducteur")) {
            conducteurTag = "open";
        } else if (qName.equals("id_createur")) {
            idConducteurTag = "open";
        } else if (qName.equals("date_depart")) {
            dateDepartTag = "open";
        } else if (qName.equals("heure_depart")) {
            heureDepartTag = "open";
        } else if (qName.equals("nombre_places")) {
            nombrePlacesTag = "open";
        } else if (qName.equals("prix")) {
            prixTag = "open";
        } else if (qName.equals("fumeur")) {
            fumeurTag = "open";
        } else if (qName.equals("reservee_femmes")) {
            reserveeFemmesTag = "open";
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
        } else if (qName.equals("gouvernorat_depart")) {
            gouvernoratDepartTag = "close";
        } else if (qName.equals("delegation_depart")) {
            delegationDepartTag = "close";
        } else if (qName.equals("localite_depart")) {
            localiteDepartTag = "close";
        } else if (qName.equals("gouvernorat_arrivee")) {
            gouvernoratArriveeTag = "close";
        } else if (qName.equals("delegation_arrivee")) {
            delegationArriveeTag = "close";
        } else if (qName.equals("localite_arrivee")) {
            localiteArriveeTag = "close";
        } else if (qName.equals("conducteur")) {
            conducteurTag = "close";
        } else if (qName.equals("id_createur")) {
            idConducteurTag = "close";
        } else if (qName.equals("date_depart")) {
            dateDepartTag = "close";
        } else if (qName.equals("heure_depart")) {
            heureDepartTag = "close";
        } else if (qName.equals("nombre_places")) {
            nombrePlacesTag = "close";
        } else if (qName.equals("prix")) {
            prixTag = "close";
        } else if (qName.equals("fumeur")) {
            fumeurTag = "close";
        } else if (qName.equals("reservee_femmes")) {
            reserveeFemmesTag = "close";
        }
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentCovoiturage != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                //System.out.println("tahtouh : " + id);
                currentCovoiturage.setId(Integer.parseInt(id));
            } else if (titreTag.equals("open")) {
                String titre = new String(ch, start, length).trim();
                //System.out.println("titre : " + titre);
                currentCovoiturage.setTitre(titre);
            } else if (descriptionTag.equals("open")) {
                String description = new String(ch, start, length).trim();
                currentCovoiturage.setDescription(description);
            } else if (gouvernoratDepartTag.equals("open")) {
                String gouvernoratDepart = new String(ch, start, length).trim();
                currentCovoiturage.setGouvernoratDepart(gouvernoratDepart);
            } else if (delegationDepartTag.equals("open")) {
                String delegationDepart = new String(ch, start, length).trim();
                currentCovoiturage.setDelegationDepart(delegationDepart);
            } else if (localiteDepartTag.equals("open")) {
                String localiteDepart = new String(ch, start, length).trim();
                currentCovoiturage.setLocaliteDepart(localiteDepart);
            } else if (gouvernoratArriveeTag.equals("open")) {
                String gouvernoratArrivee = new String(ch, start, length).trim();
                currentCovoiturage.setGouvernoratArrivee(gouvernoratArrivee);
            } else if (delegationArriveeTag.equals("open")) {
                String delegationArrivee = new String(ch, start, length).trim();
                currentCovoiturage.setDelegationArrivee(delegationArrivee);
            } else if (localiteArriveeTag.equals("open")) {
                String localiteArrivee = new String(ch, start, length).trim();
                currentCovoiturage.setLocaliteArrivee(localiteArrivee);
            } else if (conducteurTag.equals("open")) {
                String conducteur = new String(ch, start, length).trim();
                currentCovoiturage.setNomUtilisateurCreateur(conducteur);
            } else if (idConducteurTag.equals("open")) {
                String idConducteur = new String(ch, start, length).trim();
                currentCovoiturage.setIdCreateur(Integer.parseInt(idConducteur));
            } else if (dateDepartTag.equals("open")) {
                String dateDepart = new String(ch, start, length).trim();
                currentCovoiturage.setDateDepart(dateDepart);

//                String dyStr = dateCreation.substring(9, 2);
//                String mtStr = dateCreation.substring(6, 2);
//                String yrStr = dateCreation.substring(4);
//                System.out.println(yrStr);
//                System.out.println(mtStr);
//                System.out.println(dyStr);
//                Calendar cal = Calendar.getInstance();
//                int dy = Integer.parseInt(dyStr);
//                int mt = Integer.parseInt(mtStr);
//                int yr = Integer.parseInt(yrStr);
//                cal.set(Calendar.DAY_OF_MONTH, dy);
//                cal.set(Calendar.MONTH, mt);
//                cal.set(Calendar.YEAR, yr);

            } else if (heureDepartTag.equals("open")) {
                String heureDepart = new String(ch, start, length).trim();
                currentCovoiturage.setHeureDepart(heureDepart);
            } else if (nombrePlacesTag.equals("open")) {
                String nombrePlaces = new String(ch, start, length).trim();
                currentCovoiturage.setNombrePlaces(Integer.parseInt(nombrePlaces));
            } else if (prixTag.equals("open")) {
                String prix = new String(ch, start, length).trim();
                currentCovoiturage.setPrix(Float.parseFloat(prix));
            } else if (fumeurTag.equals("open")) {
                String fumeur = new String(ch, start, length).trim();
                if (fumeur.equals("0")) {
                    currentCovoiturage.setFumeur(false);
                } else {
                    currentCovoiturage.setFumeur(true);
                }
            } else if (reserveeFemmesTag.equals("open")) {
                String reserveeFemmes = new String(ch, start, length).trim();
                if (reserveeFemmes.equals("0")) {
                    currentCovoiturage.setReserveeFemmes(false);
                } else {
                    currentCovoiturage.setReserveeFemmes(true);
                }
            }
            //System.out.println(currentCovoiturage.toString());
        }
    }
}