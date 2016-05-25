package GUI;

import Entites.Covoitureur;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.midlet.MIDlet;

import com.jappit.midmaps.googlemaps.GoogleMaps;
import com.jappit.midmaps.googlemaps.GoogleMapsCoordinates;
import com.jappit.midmaps.googlemaps.GoogleMapsMarker;
import com.jappit.midmaps.googlemaps.GoogleStaticMap;
import com.jappit.midmaps.googlemaps.GoogleStaticMapHandler;
import java.util.Vector;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;

public class GoogleMapsMoveCanvas extends GoogleMapsTestCanvas implements GoogleStaticMapHandler {

    GoogleMaps gMaps = null;
    GoogleStaticMap map = null;
    GoogleMapsMarker blueMarker;
    Vector blueMarkers;
    Command zoomInCommand, zoomOutCommand;

    public GoogleMapsMoveCanvas(Displayable testListScreen, String string, Covoitureur[] covoitureurs) {

        super(testListScreen);
        addCommand(zoomInCommand = new Command("Zoom in", Command.OK, 1));
        addCommand(zoomOutCommand = new Command("Zoom out", Command.OK, 2));
        String latitude, longitude;
        int pos = string.indexOf(",");
        latitude = string.substring(0, pos);
        longitude = string.substring(pos + 1, string.length());
        gMaps = new GoogleMaps();
        map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
        blueMarkers = new Vector();
        System.out.println("");
        for (int i = 0; i < covoitureurs.length; i++) {
            Covoitureur covoitureur = covoitureurs[i];
            System.out.println(covoitureur.getLatitude()+" hhh "+ covoitureur.getLongitude());
            blueMarker = new GoogleMapsMarker(new GoogleMapsCoordinates(covoitureur.getLatitude(), covoitureur.getLongitude()));
            blueMarker.setColor(GoogleStaticMap.COLOR_BLUE);
            blueMarker.setSize(GoogleMapsMarker.SIZE_MID);
            blueMarker.setLabel('A');
            blueMarkers.addElement(blueMarker);
            System.out.println(blueMarker);
        }

        //map.setHandler(this);
        //map.setCenter(new GoogleMapsCoordinates(Double.parseDouble(latitude), Double.parseDouble(longitude)));

        //map = gMaps.createMap(getWidth(), getHeight(), GoogleStaticMap.FORMAT_PNG);
        GoogleMapsMarker redMarker = new GoogleMapsMarker(new GoogleMapsCoordinates(Double.parseDouble(latitude), Double.parseDouble(longitude)));
        redMarker.setColor(GoogleStaticMap.COLOR_RED);
        redMarker.setSize(GoogleMapsMarker.SIZE_MID);
        redMarker.setLabel('E');
        blueMarkers.addElement(redMarker);

        for (int i = 0; i < blueMarkers.size(); i++) {

            map.addMarker((GoogleMapsMarker) blueMarkers.elementAt(i));
        }
        //map.addMarker(redMarker);


        map.setHandler(this);

        map.setCenter(new GoogleMapsCoordinates(Double.parseDouble(latitude), Double.parseDouble(longitude)));

        map.setZoom(9);

        map.update();
    }

    protected void paint(Graphics g) {
        map.draw(g, 0, 0, Graphics.TOP | Graphics.LEFT);
    }

    public void GoogleStaticMapUpdateError(GoogleStaticMap map, int errorCode, String errorMessage) {
        showError("map error: " + errorCode + ", " + errorMessage);
    }

    public void GoogleStaticMapUpdated(GoogleStaticMap map) {
        repaint();
    }

    protected void keyPressed(int key) {
        int gameAction = getGameAction(key);

        if (gameAction == Canvas.UP || gameAction == Canvas.RIGHT || gameAction == Canvas.DOWN || gameAction == Canvas.LEFT) {
            map.move(gameAction);
        }
    }

    public void commandAction(Command c, Displayable d) {
        super.commandAction(c, d);

        if (c == zoomInCommand) {
            map.zoomIn();
        } else if (c == zoomOutCommand) {
            map.zoomOut();
        }
    }
}