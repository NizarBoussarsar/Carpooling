package Handlers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Entites.Message;
import Entites.Message;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author RayzerCoder
 */
public class MessageHandler extends DefaultHandler {

    private Vector messages;

    String idTag = "close";
    String id_expediteurTag = "close";
    String id_destinataireTag = "close";
    String objetTag = "close";
    String contenuTag = "close";
    String date_envoieTag = "close";
    String luTag = "close";

    public MessageHandler() {
        messages = new Vector();
    }

    public Message[] getMessages() {
        Message[] listeMessages = new Message[messages.size()];
        messages.copyInto(listeMessages);
        return listeMessages;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Message currentMessage;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("message")) {
            if (currentMessage != null) {
                throw new IllegalStateException("already processing a message");
            }
            currentMessage = new Message();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("id_expediteur")) {
            id_expediteurTag = "open";
        } else if (qName.equals("id_destinataire")) {
            id_destinataireTag = "open";
        } else if (qName.equals("objet")) {
            objetTag = "open";
        } else if (qName.equals("contenu")) {
            contenuTag = "open";
        } else if (qName.equals("date_envoie")) {
            date_envoieTag = "open";
        } else if (qName.equals("date_envoie")) {
            date_envoieTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("message")) {
            // we are no longer processing a <reg.../> tag
            System.out.println(currentMessage.getId() + "yesssssss");
            messages.addElement(currentMessage);

            currentMessage = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("id_expediteur")) {
            id_expediteurTag = "close";
        } else if (qName.equals("id_destinataire")) {
            id_destinataireTag = "close";
        } else if (qName.equals("objet")) {
            objetTag = "close";
        } else if (qName.equals("contenu")) {
            contenuTag = "close";
        } else if (qName.equals("date_envoie")) {
            date_envoieTag = "close";
        } else if (qName.equals("lu")) {
            luTag = "close";
        }
    }

    // "characters" are the text inbetween tags
    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentMessage != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentMessage.setId(Integer.parseInt(id));
            } else if (id_expediteurTag.equals("open")) {
                String id_expediteur = new String(ch, start, length).trim();
                currentMessage.setId_expediteur(Integer.parseInt(id_expediteur));
            } else if (id_destinataireTag.equals("open")) {
                String id_destinataire = new String(ch, start, length).trim();
                currentMessage.setId_destinataire(Integer.parseInt(id_destinataire));
            } else if (contenuTag.equals("open")) {
                String contenu = new String(ch, start, length).trim();
                currentMessage.setContenu(contenu);
            } else if (objetTag.equals("open")) {
                String objet = new String(ch, start, length).trim();
                currentMessage.setObjet(objet);
            } else if (date_envoieTag.equals("open")) {
                String date_envoie = new String(ch, start, length).trim();
                currentMessage.setDate_envoie(date_envoie);
            } else if (luTag.equals("open")) {
                String lu = new String(ch, start, length).trim();
                currentMessage.setLu(Integer.parseInt(lu));
            }
        }
    }

}
