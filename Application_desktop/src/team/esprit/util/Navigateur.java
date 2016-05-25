package team.esprit.util;

import chrriis.dj.nativeswing.swtimpl.*;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import team.esprit.entities.Ville;

public class Navigateur {
//
//    public Navigateur(String url) {
//        initComponents(url);
//        setTitle("Localiser votre trajet");
//    }
//
//    public void initComponents(String url) {
//        JPanel PanelbrowserJPanel = new JPanel();
//        PanelbrowserJPanel.setLayout(new BorderLayout());
//        final JWebBrowser webBrowser = new JWebBrowser();
//        webBrowser.navigate(url);
//        PanelbrowserJPanel.add(webBrowser);
//        add(PanelbrowserJPanel);
//    }

    public static void main(final Ville villeDepart, final Ville villeArrivee) {
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                String url = "http://localhost/covoiturage/map3.php?dlat=" + villeDepart.getDelegation() + "&dlong=" + villeDepart.getGouvernorat() + "&alat=" + villeArrivee.getDelegation() + "&along=" + villeArrivee.getGouvernorat();
                url = url.replaceAll("\\s+", "");
                try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException | URISyntaxException ex) {
                    Logger.getLogger(Navigateur.class.getName()).log(Level.SEVERE, null, ex);
                }
//                Navigateur navigateur = new Navigateur(url);
//                navigateur.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                navigateur.setVisible(true);
//                navigateur.setResizable(true);
//                navigateur.pack();
//                navigateur.setSize(700, 700);
            }
        });
    }
}