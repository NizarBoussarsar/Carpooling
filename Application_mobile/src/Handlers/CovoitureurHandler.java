/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entites.Covoitureur;
import java.util.Vector;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author RayzerCoder
 */
public class CovoitureurHandler extends DefaultHandler {

    private Vector covoitureurs;
    String idTag = "close";
    String id_facebookTag = "close";
    String emailTag = "close";
    String mdpTag = "close";
    String nom_utilisateurTag = "close";
    String nomTag = "close";
    String prenomTag = "close";
    String sexeTag = "close";
    String fumeurTag = "close";
    String date_naissanceTag = "close";
    String date_enregistrementTag = "close";
    String noteTag = "close";
    String etatTag = "close";
    String avatarTag = "close";
    String skypeTag = "close";
    String facebookTag = "close";
    String date_derniere_visiteTag = "close";
    String cle_activationTag = "close";
    String latitudeTag = "close";
    String longitudeTag = "close";
    String connecteTag = "close";

    public CovoitureurHandler() {
        covoitureurs = new Vector();
    }

    public Covoitureur[] getCovoitureurs() {
        Covoitureur[] listeCovoitureurs = new Covoitureur[covoitureurs.size()];
        covoitureurs.copyInto(listeCovoitureurs);
        return listeCovoitureurs;
    }
    private Covoitureur currentCovoitureur;

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("covoitureur")) {
            if (currentCovoitureur != null) {
                System.out.println("Already working on person");
            }
            currentCovoitureur = new Covoitureur();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("id_facebook")) {
            id_facebookTag = "open";
        } else if (qName.equals("email")) {
            emailTag = "open";
        } else if (qName.equals("mdp")) {
            mdpTag = "open";
        } else if (qName.equals("nom_utilisateur")) {
            nom_utilisateurTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenomTag = "open";
        } else if (qName.equals("sexe")) {
            sexeTag = "open";
        } else if (qName.equals("fumeur")) {
            fumeurTag = "open";
        } else if (qName.equals("date_naissance")) {
            date_naissanceTag = "open";
        } else if (qName.equals("date_naissance")) {
            date_naissanceTag = "open";
        } else if (qName.equals("date_enregistrement")) {
            date_enregistrementTag = "open";
        } else if (qName.equals("note")) {
            noteTag = "open";
        } else if (qName.equals("etat")) {
            etatTag = "open";
        } else if (qName.equals("avatar")) {
            avatarTag = "open";
        } else if (qName.equals("skype")) {
            skypeTag = "open";
        } else if (qName.equals("facebook")) {
            facebookTag = "open";
        } else if (qName.equals("date_derniere_visite")) {
            date_derniere_visiteTag = "open";
        } else if (qName.equals("cle_activation")) {
            cle_activationTag = "open";
        } else if (qName.equals("latitude")) {
            latitudeTag = "open";
        } else if (qName.equals("longitude")) {
            longitudeTag = "open";
        } else if (qName.equals("connecte")) {
            connecteTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("covoitureur")) {
            System.out.println("addddd" + currentCovoitureur.getEmail());
            covoitureurs.addElement(currentCovoitureur);
            currentCovoitureur = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("id_facebook")) {
            id_facebookTag = "close";
        } else if (qName.equals("email")) {
            emailTag = "close";
        } else if (qName.equals("mdp")) {
            mdpTag = "close";
        } else if (qName.equals("nom_utilisateur")) {
            nom_utilisateurTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenomTag = "close";
        } else if (qName.equals("sexe")) {
            sexeTag = "close";
        } else if (qName.equals("fumeur")) {
            fumeurTag = "close";
        } else if (qName.equals("date_naissance")) {
            date_naissanceTag = "close";
        } else if (qName.equals("date_enregistrement")) {
            date_enregistrementTag = "close";
        } else if (qName.equals("note")) {
            noteTag = "close";
        } else if (qName.equals("etat")) {
            etatTag = "close";
        } else if (qName.equals("avatar")) {
            avatarTag = "close";
        } else if (qName.equals("skype")) {
            skypeTag = "close";
        } else if (qName.equals("facebook")) {
            facebookTag = "close";
        } else if (qName.equals("date_derniere_visite")) {
            date_derniere_visiteTag = "close";
        } else if (qName.equals("cle_activation")) {
            cle_activationTag = "close";
        } else if (qName.equals("latitude")) {
            latitudeTag = "close";
        } else if (qName.equals("longitude")) {
            longitudeTag = "close";
        } else if (qName.equals("connecte")) {
            connecteTag = "close";
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentCovoitureur != null) {
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentCovoitureur.setId(Integer.parseInt(id));
                System.out.println("********************" + currentCovoitureur.getId());
            } else if (id_facebookTag.equals("open")) {
                System.out.println("jeeee55");
                String id_facebook = new String(ch, start, length).trim();
                currentCovoitureur.setId_facebook(id_facebook);
                System.out.println("********************" + currentCovoitureur.getId_facebook());
            } else if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                currentCovoitureur.setEmail(email);
                System.out.println("********************" + currentCovoitureur.getEmail());
            } else if (mdpTag.equals("open")) {
                String Mdp = new String(ch, start, length).trim();
                currentCovoitureur.setMdp(Mdp);
                System.out.println("********************" + currentCovoitureur.getMdp());
            } else if (nom_utilisateurTag.equals("open")) {
                String nom_utilisateur = new String(ch, start, length).trim();
                currentCovoitureur.setNom_utilisateur(nom_utilisateur);
                System.out.println("********************" + currentCovoitureur.getNom_utilisateur());
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentCovoitureur.setNom(nom);
                System.out.println("********************" + currentCovoitureur.getNom());
            } else if (prenomTag.equals("open")) {
                String prenom = new String(ch, start, length).trim();
                currentCovoitureur.setPrenom(prenom);
                System.out.println("********************" + currentCovoitureur.getPrenom());
            } else if (sexeTag.equals("open")) {
                String sexe = new String(ch, start, length).trim();
                currentCovoitureur.setSexe(sexe.charAt(0));
                System.out.println("********************" + currentCovoitureur.getSexe());
            } else if (fumeurTag.equals("open")) {
                String fumuer = new String(ch, start, length).trim();
                currentCovoitureur.setFumeur(Integer.parseInt(fumuer));
                System.out.println("********************" + currentCovoitureur.getFumeur());
            } else if (date_naissanceTag.equals("open")) {
                String date_naissance = new String(ch, start, length).trim();
                currentCovoitureur.setDate_naissance(date_naissance);
                System.out.println("********************" + currentCovoitureur.getDate_naissance());
            } else if (date_enregistrementTag.equals("open")) {
                String date_enregistrement = new String(ch, start, length).trim();
                currentCovoitureur.setDate_enregistrement(date_enregistrement);
                System.out.println("********************" + currentCovoitureur.getDate_enregistrement());
            } else if (noteTag.equals("open")) {
                String note = new String(ch, start, length).trim();
                currentCovoitureur.setNote(Integer.parseInt(note));
                System.out.println("********************" + currentCovoitureur.getNote());
            } else if (etatTag.equals("open")) {
                String etat = new String(ch, start, length).trim();
                currentCovoitureur.setEtat(Integer.parseInt(etat));
                System.out.println("********************" + currentCovoitureur.getEtat());
            } else if (avatarTag.equals("open")) {
                String avatar = new String(ch, start, length).trim();
                currentCovoitureur.setAvatar(avatar);
                System.out.println("********************" + currentCovoitureur.getAvatar());
            } else if (skypeTag.equals("open")) {
                String skype = new String(ch, start, length).trim();
                currentCovoitureur.setSkype(skype);
                System.out.println("********************" + currentCovoitureur.getSkype());
            } else if (facebookTag.equals("open")) {
                String facebook = new String(ch, start, length).trim();
                currentCovoitureur.setFacebook(facebook);
                System.out.println("********************" + currentCovoitureur.getFacebook());
            } else if (date_derniere_visiteTag.equals("open")) {
                String date_derniere_visite = new String(ch, start, length).trim();
                currentCovoitureur.setDate_derniere_visite(date_derniere_visite);
                System.out.println("********************" + currentCovoitureur.getDate_derniere_visite());
            } else if (cle_activationTag.equals("open")) {
                String cle_activation = new String(ch, start, length).trim();
                currentCovoitureur.setCle_activation(cle_activation);
                System.out.println("********************" + currentCovoitureur.getCle_activation());
            } else if (latitudeTag.equals("open")) {
                String latitude = new String(ch, start, length).trim();
                System.out.println(latitude);
                currentCovoitureur.setLatitude(Double.parseDouble(latitude));
            } else if (longitudeTag.equals("open")) {
                String longitude = new String(ch, start, length).trim();
                currentCovoitureur.setLongitude(Double.parseDouble(longitude));
            } else if (connecteTag.equals("open")) {
                String connecte = new String(ch, start, length).trim();
                if (connecte.equals("1")) {
                    currentCovoitureur.setConnecte(true);
                } else {
                    currentCovoitureur.setConnecte(false);
                }
            }
        }
    }
}
