package GUI;

import Entites.notification;
import Handlers.NotificationHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author joe
 */
public class notificationForm extends Form implements CommandListener, Runnable {

    Command cmdRetour;
    Command cmdParse;
    Command cmdBack;
    notification[] notifications;
    List lst = new List("Notifications", List.IMPLICIT);
    Form f = new Form("Acceuil");
    Form form = new Form("Lire notification :");
    Form loadingDialog = new Form("Please Wait");
    StringBuffer sb = new StringBuffer();
    int id_co;

    public notificationForm(int id_co) {
        super("Notification");
        this.id_co = id_co;
        cmdRetour = new Command("Retour", Command.BACK, 0);
        cmdParse = new Command("Notifications", Command.SCREEN, 0);
        cmdBack = new Command("Back", Command.BACK, 0);
        lst = new List("Notifications", List.IMPLICIT);
        f = new Form("Acceuil");
        form = new Form("Lire notification :");
        loadingDialog = new Form("Please Wait");
        sb = new StringBuffer();
        this.addCommand(cmdParse);
        lst.addCommand(cmdRetour);
        this.setCommandListener(this);
        lst.setCommandListener(this);
        form.addCommand(cmdBack);
        form.setCommandListener(this);
        Midlet.getDisplay().setCurrent(loadingDialog);
        Thread th = new Thread(this);
        th.start();

    }

    public void commandAction(Command c, Displayable d) {

        if (c == List.SELECT_COMMAND) {

            form.append("Notification: \n");

            form.append(showPersonne(lst.getSelectedIndex()));

            Midlet.getDisplay().setCurrent(form);
        }

        if (c == cmdBack) {
            form.deleteAll();
            lst.deleteAll();
            Thread th = new Thread((Runnable) this);
            th.start();
        }
        
        if (c == cmdRetour) {
            Midlet.getDisplay().setCurrent(new Accueil("Accueil", List.IMPLICIT));
        }

    }
//1er affichage

    public void run() {
        try {
            System.out.println(id_co);
            // this will handle our XML
            NotificationHandler notificationsHandler = new NotificationHandler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/getXmlNotification.php?id=" + id_co);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, notificationsHandler);
            // display the result
            notifications = notificationsHandler.getPersonne();

            if (notifications.length > 0) {

                for (int i = 0; i < notifications.length; i++) {
                    System.out.println(notifications[i].toString());
                    lst.append("" + i + " - Une notification de " + notifications[i].getNom(), null);

                }
            } else {
                lst.append("Vous n'avez pas de notifications", null);
            }

        } catch (Exception e) {
            System.out.println("Exception:" + e.toString());
        }
        Midlet.getDisplay().setCurrent(lst);
    }
//2eme affichage

    private String showPersonne(int i) {
        String res = "";
        if (notifications.length > 0) {
            sb.append("* ");
            sb.append(notifications[i].getContenu());
            sb.append("\n");
            String url = "http://localhost/covoituragej2me/lireNotification.php?id=" + notifications[i].getId();
            System.out.println(url);
            try {
                HttpConnection hc = (HttpConnection) Connector.open(url);
                DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            } catch (IOException ex) {
            }
        }
        res = sb.toString();
        sb = new StringBuffer("");
        return res;
    }
}
