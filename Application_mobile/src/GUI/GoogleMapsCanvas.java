/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoiturage;
import Entites.Ville;
import Handlers.GetPath;
import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleMapsMarker;
import com.jappit.midmaps.googlemaps.GoogleMapsPath;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;
import java.util.Enumeration;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author Hhussein
 */
public class GoogleMapsCanvas extends Canvas implements GoogleStaticMapHandler, CommandListener {

    GoogleMaps gMaps = null;
    GoogleStaticMap map = null;
    Covoiturage covoiturage;
    Command zoomInCommand, zoomOutCommand;
    Command cmdParse = new Command("Reserver", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    GetPath f;
    Ville[] Villes;

    public GoogleMapsCanvas(Covoiturage covoiturage) {
        GoogleMapsPath path = new GoogleMapsPath();
      /*  System.out.println("  **************************************************");
         Villes = new Ville[2];
         f = new GetPath(covoiturage.getId(), Villes);
         f.run();
         covoiturage.setVilleDepart(f.getVilles(0));
         covoiturage.setVilleArrivee(f.getVilles(1));
       
         path.addPoint(new GoogleMapsCoordinates(covoiturage.getVilleDepart().getLongitude(), covoiturage.getVilleDepart().getLatitude()));
         path.addPoint(new GoogleMapsCoordinates(covoiturage.getVilleDepart().getLatitude(), covoiturage.getVilleDepart().getLatitude()));*/

        this.setCommandListener(this);
        gMaps = new GoogleMaps();
        map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
        map.setHandler(this);
        addCommand(zoomInCommand = new Command("Zoom in", Command.OK, 1));
        addCommand(zoomOutCommand = new Command("Zoom out", Command.OK, 2));
        // addCommand(cmdBack);
        addCommand(cmdParse);
        map.setCenter(new GoogleMapsCoordinates(covoiturage.getVilleDepart().getLongitude(), covoiturage.getVilleDepart().getLatitude()));
        GoogleMapsMarker redMarker = new GoogleMapsMarker(new GoogleMapsCoordinates(covoiturage.getVilleDepart().getLongitude(), covoiturage.getVilleDepart().getLatitude()));
        redMarker.setColor(GoogleStaticMap.COLOR_RED);
        redMarker.setSize(GoogleMapsMarker.SIZE_MID);
        redMarker.setLabel('D');
        map.addMarker(redMarker);

        if (covoiturage.getDetours() != null) {
            for (int i = 0; i < covoiturage.getDetours().size(); i = i + 2) {
                path.addPoint(new GoogleMapsCoordinates(Double.parseDouble(covoiturage.getDetours().elementAt(i).toString()), Double.parseDouble(covoiturage.getDetours().elementAt(i + 1).toString())));
                System.out.println("test path detours " + (Double.parseDouble(covoiturage.getDetours().elementAt(i).toString()) + "//" + Double.parseDouble(covoiturage.getDetours().elementAt(i + 1).toString())));
                GoogleMapsMarker Marker = new GoogleMapsMarker(new GoogleMapsCoordinates(Double.parseDouble(covoiturage.getDetours().elementAt(i).toString()), Double.parseDouble(covoiturage.getDetours().elementAt(i + 1).toString())));
                Marker.setColor(GoogleStaticMap.COLOR_GRAY);
                Marker.setSize(GoogleMapsMarker.SIZE_TINY);
                Marker.setLabel('d');
                map.addMarker(Marker);

            }
        }
        path.setColor(GoogleStaticMap.COLOR_RED);
        //path.setFillColor(GoogleStaticMap.COLOR_GREEN);
        path.setWeight(5);
        map.addPath(path);

        GoogleMapsMarker bleueMarker = new GoogleMapsMarker(new GoogleMapsCoordinates(covoiturage.getVilleArrivee().getLongitude(), covoiturage.getVilleArrivee().getLatitude()));
        bleueMarker.setColor(GoogleStaticMap.COLOR_BLUE);
        bleueMarker.setSize(GoogleMapsMarker.SIZE_MID);
        bleueMarker.setLabel('A');
        map.addMarker(bleueMarker);

        map.setZoom(15);
        map.update();

    }

    protected void paint(Graphics g) {
        map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
    }

    public void GoogleStaticMapUpdated(GoogleStaticMap gsm) {
        repaint();
    }

    public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage) {
        System.out.println("map error: " + errorCode + ", " + errorMessage);
    }

    protected void keyPressed(int key) {
        int gameAction = getGameAction(key);
        if (gameAction == Canvas.UP || gameAction == Canvas.RIGHT || gameAction == Canvas.DOWN || gameAction == Canvas.LEFT) {
            map.move(gameAction);
        }

    }

    public void commandAction(Command c, Displayable d) {
        if (c == zoomInCommand) {
            map.zoomIn();
        } else if (c == zoomOutCommand) {
            map.zoomOut();
        }
        if (c == cmdParse) {
            Midlet.getDisplay().setCurrent(new FormContact().list);
        }

    }
}
