package GUI;

import Entites.Covoiturage;
import Entites.Ville;
import Handlers.CovoiturageHandler_R;
import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Vector;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Hhussein
 */
public class RechercherCovoiturage extends Form implements CommandListener, Runnable {

    Displayable testListScreen;
    MIDlet midlet;
    Command afficher;
    Command exit;
    Covoiturage covoiturage;
    public static Covoiturage covoiturageStatic;
    Ville villedepart;
    Ville villearrive;
    Vector detours;
    Command cmdParse;
    Command cmdBack;
    static List lst;
    Form f;
    Form form;
    Form loadingDialog;
    StringBuffer sb;
    static Covoiturage[] covoiturages;
    TextBox tb1;
    TextBox tb2;
    String critere1;
    String critere2;

    public RechercherCovoiturage(MIDlet m, Displayable testListScreen, String critere1, String critere2) {
        super("test");
        this.testListScreen = testListScreen;
        this.midlet = m;
        this.critere1 = critere1;
        this.critere2 = critere2;
        detours = new Vector();
        cmdParse = new Command("Covoiturages", Command.SCREEN, 0);
        cmdBack = new Command("Back", Command.BACK, 0);
        Covoiturage[] covoiturages;
        lst = new List("Covoiturages", List.IMPLICIT);
        lst.setCommandListener(this);
        f = new Form("Acceuil");
        form = new Form("Infos Covoiturages");
        loadingDialog = new Form("Please Wait");
        sb = new StringBuffer();

        addCommand(cmdParse);
        addCommand(cmdBack);
        setCommandListener(this);

        this.setdetours();
    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdParse) {

            Midlet.getDisplay().setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }

        if (c == List.SELECT_COMMAND) {
            form.append("Informations Covoiturages: \n");
            form.append(showCovoiturage(lst.getSelectedIndex()));

            System.out.println("test index " + lst.getSelectedIndex());
            Midlet.getDisplay().setCurrent(form);
            covoiturageStatic = covoiturages[lst.getSelectedIndex()];
            System.out.println("id : " + covoiturageStatic.toString());
            covoiturages[lst.getSelectedIndex()] = covoiturage;
            System.out.println("testid" + covoiturages[lst.getSelectedIndex()].getId());
            System.out.println("cov : " + covoiturages[lst.getSelectedIndex()]);
            Midlet.getDisplay().setCurrent(new Splashscreen(covoiturages[lst.getSelectedIndex()]));
            //Midlet.get().setCurrent(new GoogleMapsCanvas(covoiturages[lst.getSelectedIndex()]));
        }

        if (c == cmdBack) {
            form.deleteAll();
            //disp.setCurrent(lst);
            System.out.println(" retour");
            Midlet.getDisplay().setCurrent(lst);
        }

    }

    public void run() {
        try {
            // this will handle our XML
            CovoiturageHandler_R covoiturageHandler = new CovoiturageHandler_R();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getXmlCovoiturages.php" + "?critere=" + critere1 + "&criteree=" + critere2);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, covoiturageHandler);
            // display the result
            covoiturages = covoiturageHandler.getCovoiturage();

            if (covoiturages.length > 0) {
                System.out.println(" \n covoiturages.length : " + covoiturages.length);
                for (int i = 0; i < covoiturages.length; i++) {
                    System.out.println("\n test id covoiturages " + covoiturages[i].getId());
                    lst.append(" " + covoiturages[i].getId() + " " + covoiturages[i].getTitre() + " " + covoiturages[i].getDescription(), null);
                }

            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.getDisplay().setCurrent(lst);

    }
    
    public static Covoiturage getCovoiturage() {
        System.out.println("e5er test : " + covoiturageStatic.toString());
        return covoiturageStatic;
    }

    public void setdetours() {
        covoiturage = new Covoiturage();
        villedepart = new Ville();
        villearrive = new Ville();

        villedepart.setLongitude(36.899816);
        villedepart.setLatitude(10.189129);
        covoiturage.setVilleDepart(villedepart);
        villearrive.setLongitude(36.889613);
        villearrive.setLatitude(10.177344);
        covoiturage.setVilleArrivee(villearrive);

        detours.addElement(new Double(36.899816));
        detours.addElement(new Double(10.189129));
        detours.addElement(new Double(36.901335));
        detours.addElement(new Double(10.189944));
        detours.addElement(new Double(36.901841));
        detours.addElement(new Double(10.189558));
        detours.addElement(new Double(36.902227));
        detours.addElement(new Double(10.188818));
        detours.addElement(new Double(36.900777));
        detours.addElement(new Double(10.186543));
        detours.addElement(new Double(36.899833));
        detours.addElement(new Double(10.185138));
        detours.addElement(new Double(36.899181));
        detours.addElement(new Double(10.183507));

        detours.addElement(new Double(36.898898));
        detours.addElement(new Double(10.182692));
        detours.addElement(new Double(36.898452));
        detours.addElement(new Double(10.180685));
        detours.addElement(new Double(36.896084));
        detours.addElement(new Double(10.180664));
        detours.addElement(new Double(36.892136));
        detours.addElement(new Double(10.181152));
        detours.addElement(new Double(36.890583));
        detours.addElement(new Double(10.181485));
        detours.addElement(new Double(36.889613));
        detours.addElement(new Double(10.177344));

        Enumeration vEnum = detours.elements();
        System.out.println("\\nElements in vector:");
        while (vEnum.hasMoreElements()) {
            System.out.print(vEnum.nextElement() + " **");
        }

        covoiturage.setDetours(detours);

    }

    private String showCovoiturage(int i) {
        String res = "";
        if (covoiturages.length > 0) {
            System.out.println("test 2 " + covoiturages.length);
            sb.append("* ");
            sb.append(covoiturages[i].getDescription());
            sb.append("\n");
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}
