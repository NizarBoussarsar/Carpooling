package GUI;

import Entites.Covoitureur;
import Handlers.CovoitureurHandler;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.location.Coordinates;
import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationProvider;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Nizar
 */
public class CovoitureurConnecteList extends List implements CommandListener {

    Covoitureur[] covoitureurs;
    public List lst = new List("Examples", List.IMPLICIT);
    private String string;//="36.862499,10.195560";

    public CovoitureurConnecteList(String title, int listType) {
        super(null, listType);
        System.out.println("d5alt");
        lst.append("Trouver covoiturages", null);
        lst.setCommandListener(this);
        //Midlet.getDisplay().setCurrent(lst);
        Retriever ret = new Retriever();
        ret.start();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == List.SELECT_COMMAND) {
            switch (lst.getSelectedIndex()) {
                case 0:
                    //disp.setCurrent(new GoogleMapsMarkerCanvas(this, d, string));
                    Midlet.getDisplay().setCurrent(new GoogleMapsMoveCanvas(d, string, covoitureurs));
                    break;
            }

        }
    }

    class Retriever extends Thread {

        //private Midlet midlet;
        public Retriever() {
            //this.midlet = midlet;
        }

        public void run() {


            try {
                CovoitureurHandler covoitureurHandler = new CovoitureurHandler();
                // get a parser object
                SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                // get an InputStream from somewhere (could be HttpConnection, for example)

                HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getCovoitureurConnecte.php");
                DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                parser.parse(dis, covoitureurHandler);
                // display the result
                covoitureurs = covoitureurHandler.getCovoitureurs();
                System.out.println("LENGHNTTT" + covoitureurs.length);
                if (covoitureurs.length > 0) {


                    for (int i = 0; i < covoitureurs.length; i++) {

                        System.out.println(covoitureurs[i].getNom_utilisateur());

                    }

                }
                checkLocation();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }


        }

        public String checkLocation() throws Exception {
            //String string;
            Location l;
            LocationProvider lp;
            Coordinates c;
            // Set criteria for selecting a location provider:
            // accurate to 500 meters horizontally
            Criteria cr = new Criteria();
            cr.setHorizontalAccuracy(500);

            // Get an instance of the provider
            lp = LocationProvider.getInstance(cr);

            // Request the location, setting a one-minute timeout
            l = lp.getLocation(60);
            c = l.getQualifiedCoordinates();
            if (c != null) {
                // Use coordinate information
                double lat = c.getLatitude();
                double lon = c.getLongitude();
                string = lat + "," + lon;

            } else {
                string = "Location API failed";
            }



            System.out.println(string);
            String latitude, longitude;
            int pos = string.indexOf(",");
            latitude = string.substring(0, pos);
            longitude = string.substring(pos + 1, string.length());
            System.out.println(latitude + " jjjj " + longitude);

            return string;


        }
    }
}
