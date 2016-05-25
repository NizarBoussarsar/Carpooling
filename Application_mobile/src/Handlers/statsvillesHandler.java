package Handlers;



import Entites.statsVilles;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wael Mallek
 */
public class statsvillesHandler extends DefaultHandler {

    private Vector statvilles;
    String villeTag = "close";
    String nombreTag = "close";
  

    public statsvillesHandler() {
        statvilles = new Vector();
    }

    public statsVilles[] getPersonne() {
        statsVilles[] statsvilless = new statsVilles[statvilles.size()];
        statvilles.copyInto(statsvilless);
        System.out.println("longeur fi west el handler="+statsvilless.length);
        return statsvilless;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private statsVilles currentStats;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("notification")) {

            if (currentStats != null) {
                throw new IllegalStateException("already processing a personnes");
            }

            currentStats = new statsVilles();
        } else if (qName.equals("ville")) {
            villeTag = "open";

        } else if (qName.equals("nombre")) {
            nombreTag = "open";
        } 

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("notification")) {
            // we are no longer processing a <reg.../> tag
            statvilles.addElement(currentStats);
            currentStats = null;
        } else if (qName.equals("ville")) {
            villeTag = "close";
        } else if (qName.equals("nombre")) {
            nombreTag = "close";
        } 
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentStats != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (villeTag.equals("open")) {
                String ville = new String(ch, start, length).trim();
                currentStats.setVille(ville);
                System.out.println(currentStats.getVille());
            } else if (nombreTag.equals("open")) {
                String nombre = new String(ch, start, length).trim();
                currentStats.setNombre(Integer.parseInt(nombre));
                System.out.println(currentStats.getNombre());
            } 
        }
    }
}
