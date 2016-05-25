package GUI;

import Entites.Covoitureur;
import java.io.DataInputStream;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;

/**
 *
 * @author RayzerCoder
 */
public class ConsulterMonProfile extends Form implements Runnable, CommandListener {

    Covoitureur covoitureurConnecte = Midlet.covoitureurConnecte;
    Image avatar;
    ImageItem avatarItem;
    String basicURL = "http://localhost/covoituragej2me/";
    HttpConnection http;
    DataInputStream in;
    OutputStream out;
    TextField tfNom;
    TextField tfPrenom;
    TextField tfEmail;
    TextField tfNote;
    Form test;
    Command cmdModifier;
    Command cmdRetour;
    ModifierMonProfile modifierMonProfile;
    Accueil acceuil;

    public ConsulterMonProfile(String title) {
        super(title);
        cmdModifier = new Command("Modifier", Command.SCREEN, 0);
        cmdRetour = new Command("Menu", Command.BACK, 0);
        System.out.println("Votre profil - " + covoitureurConnecte.getNom() + " " + covoitureurConnecte.getPrenom());
        this.append("Votre profil - " + covoitureurConnecte.getNom() + " " + covoitureurConnecte.getPrenom());
        this.append("Votre note est: " + covoitureurConnecte.getNote());
        this.append("Date de naissance: " + covoitureurConnecte.getDate_naissance());
        Thread thread = new Thread(this);
        this.setCommandListener(this);
        this.addCommand(cmdRetour);
        this.addCommand(cmdModifier);
        thread.start();
        Midlet.getDisplay().setCurrent(this);

    }

    public void run() {
        try {
            System.out.println("le nom de l'utilisatateur est " + covoitureurConnecte.getNom_utilisateur());
            String avatarUrl = "default.png";
            System.out.println("--->" + covoitureurConnecte.getAvatar() + "<<<<<-------");
            if (covoitureurConnecte.getAvatar() != null) {
                avatarUrl = covoitureurConnecte.getAvatar();
            } else {
                avatarUrl = "rayzercoder.jpg";
            }
            http = (HttpConnection) Connector.open("http://localhost/covoituragej2me/avatar/" + avatarUrl);
            in = new DataInputStream(http.openInputStream());
            int lengt = (int) http.getLength();
            byte[] data;
            if (lengt != -1) {
                data = new byte[lengt];
                in.readFully(data);
                avatar = Image.createImage(data, 0, lengt);
                avatarItem = new ImageItem("Votre avatar", avatar, ImageItem.LAYOUT_CENTER, null);
            }
            this.append(avatarItem);

        } catch (Exception e) {
            System.out.println("image not found" + e.getMessage());
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdModifier) {
            modifierMonProfile = new ModifierMonProfile("Modifer votre profile");

        }
        if (c == cmdRetour) {
            acceuil = new Accueil("Acceuil", List.IMPLICIT);
            Midlet.getDisplay().setCurrent(acceuil);
        }
    }
}
