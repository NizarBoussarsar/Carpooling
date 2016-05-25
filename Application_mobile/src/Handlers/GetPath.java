/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Entites.Covoiturage;
import Entites.Ville;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Hhussein
 */
//public class GetPath extends Form implements CommandListener, Runnable
public class GetPath implements Runnable {

//    Displayable testListScreen;
//    MIDlet midlet;
//    Command cmdParse = new Command("Personnes", Command.SCREEN, 0);
//    Command cmdBack = new Command("Back", Command.BACK, 0);
//    Covoiturage[] covoiturages;
//    List lst = new List("Covoiturages", List.IMPLICIT);
//    Form f = new Form("Acceuil");
//    Form form = new Form("Infos Covoiturages");
//    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    Covoiturage covoiturage;
    Ville villedepart;
    Ville villearrive;
    Ville[] Villes;
    int x;

    public GetPath(int x, Ville[] Villes) {
        //   super("");
        this.x = x;
//        this.testListScreen = testListScreen;
//        this.midlet = m;

        villedepart = new Ville();
        villearrive = new Ville();
        // this.setCommandListener(this);

//        cmdParse = new Command("Covoiturages", Command.SCREEN, 0);
//        cmdBack = new Command("Back", Command.BACK, 0);
//        Covoiturage[] covoiturages;
        this.Villes = Villes;
//        lst = new List("Covoiturages", List.IMPLICIT);
//        //lst.setCommandListener(this);
//        f = new Form("Acceuil");
//        form = new Form("Infos Covoiturages");
//        loadingDialog = new Form("Please Wait");
        sb = new StringBuffer();

        //addCommand(cmdParse);
        //  addCommand(cmdBack);
        // setCommandListener(this);
    }

//    public void pauseApp() {
//    }
//    
//    public void destroyApp(boolean unconditional) {
//    }
//    
//    public void commandAction(Command c, Displayable d) {
//         if (c == cmdParse) {
//
//            Midlet.get().setCurrent(loadingDialog);
//            Thread th = new Thread(this);
//            th.start();
//        }
//        
//   
//        
//        if (c == cmdBack) {
//            form.deleteAll();
//            Midlet.get().setCurrent(lst);
//        }
//        
//    }
    public void run() {
        try {
            // this will handle our XML
            PathHandler pathHandler = new PathHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getXmlPath.php" + "?id=" + x);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, pathHandler);
            // display the result
            Villes = pathHandler.getville();

            if (Villes.length > 0) {
                System.out.println(" \n covoiturages.length : " + Villes.length);
                for (int i = 0; i < Villes.length; i++) {
                    System.out.println("\n test id covoiturages " + Villes[i].getId() + "lon" + Villes[i].getLongitude() + "/" + Villes[i].getLatitude());

                    //  lst.append("" + Villes[i].getId(), null);
                }
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
//        Midlet.get().setCurrent(lst);
    }

    public Ville getVilles(int x) {

        //        Vector ville = new Vector();
//         for (int i = 0; i < Villes.length;  i = i + 2) {
//              ville.addElement(Villes[i].getLongitude());
//              ville.addElement(Villes[i+1].getLatitude());
//        }
        return Villes[x];
    }
}
