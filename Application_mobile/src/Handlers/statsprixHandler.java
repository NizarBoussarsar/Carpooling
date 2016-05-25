package Handlers;



import Entites.statsPrix;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Wael Mallek
 */
public class statsprixHandler extends DefaultHandler {

    private Vector statprix;
    String prixTag = "close";
    String dateTag = "close";
  

    public statsprixHandler() {
        statprix = new Vector();
    }

    public statsPrix[] getPersonne() {
        statsPrix[] statsprixx = new statsPrix[statprix.size()];
        statprix.copyInto(statsprixx);
        return statsprixx;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private statsPrix currentStats;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("statprix")) {

            if (currentStats != null) {
                throw new IllegalStateException("already processing a personnes");
            }

            currentStats = new statsPrix();
        } else if (qName.equals("price")) {
            prixTag = "open";

        } else if (qName.equals("datep")) {
            dateTag = "open";
        } 

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals("statprix")) {
            // we are no longer processing a <reg.../> tag
            statprix.addElement(currentStats);
            currentStats = null;
        } else if (qName.equals("price")) {
            prixTag = "close";
        } else if (qName.equals("datep")) {
            dateTag = "close";
        } 
    }
    // "characters" are the text inbetween tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentStats != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (dateTag.equals("open")) {
                String datep = new String(ch, start, length).trim();
                currentStats.setDatep(datep);
            } else if (prixTag.equals("open")) {
                String prix = new String(ch, start, length).trim();
                currentStats.setPrice(Integer.parseInt(prix));
     
            } 
        }
    }
}
