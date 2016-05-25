/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entites.Covoitureur;
import GUI.Midlet;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;

/**
 *
 * @author RayzerCoder
 */
public class ConsulterUnProfile extends Form implements Runnable, CommandListener {

    String basicURL = "http://localhost/covoituragej2me/";
    Covoitureur covoitureur;
    HttpConnection http;
    DataInputStream in;
    OutputStream out;
    Image avatar;
    ImageItem avatarItem;
    Command cmdEnvoyerMessage;
    EnvoyerUnMessage envMessage;
    public ConsulterUnProfile(String title, Covoitureur covoitureur) {
        super(title);
        cmdEnvoyerMessage = new Command("Envoyer Message", Command.SCREEN, 0);
        this.addCommand(cmdEnvoyerMessage);
        this.setCommandListener(this);
        this.covoitureur = covoitureur;
        this.append("Profile de " + covoitureur.getNom() + " " + covoitureur.getPrenom() + "");
        Thread thread = new Thread(this);
        thread.start();

        Midlet.getDisplay().setCurrent(this);

    }

    public void run() {
        try {
            String avatarUrl = "avatar/default.png";
            System.out.println("--->" + covoitureur.getAvatar() + "<<<<<-------");
            if (covoitureur.getAvatar() != null) {
                avatarUrl = covoitureur.getAvatar();

            } else {
                avatarUrl = "default.png";

            }
            http = (HttpConnection) Connector.open(basicURL + "/avatar/" + avatarUrl);
            in = new DataInputStream(http.openInputStream());
            int lengt = (int) http.getLength();
            byte[] data;
            if (lengt != -1) {
                data = new byte[lengt];
                in.readFully(data);
                avatar = Image.createImage(data, 0, lengt);
                avatarItem = new ImageItem("image", avatar, ImageItem.LAYOUT_CENTER, null);
            }
            this.append(avatarItem);

        } catch (Exception e) {
            System.out.println("66666" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdEnvoyerMessage) {
            envMessage= new EnvoyerUnMessage("Envoyer message", Midlet.covoitureurConnecte.getId(), covoitureur.getId());
            Midlet.getDisplay().setCurrent(envMessage);
        }
    }

}
