package GUI;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import Entites.Covoiturage;
import Handlers.CovoiturageHandler;

/**
 *
 * @author Nizar
 */
public class CovoituragesRecents extends Form implements CommandListener, Runnable {

    public Alert alert;
    public Command cmdCovoiturages = new Command("Covoiturages", Command.SCREEN, 0);
    public Command cmdBack = new Command("Back", Command.BACK, 0);
    public Command cmdReserver = new Command("Réserver", Command.SCREEN, 0);
    public Covoiturage[] covoiturages;
    public List list = new List("Covoiturages", List.IMPLICIT);
    public Form accueilForm = new Form("Acceuil");
    public Form infoCovoiturageForm = new Form("Informations covoiturage");
    public Form loadingDialog = new Form("Please Wait");
    public StringBuffer stringBuffer = new StringBuffer();
    public int choix;

    public CovoituragesRecents() {
        super("");
        accueilForm.append("Afficher les 10 covoiturages les plus récents");
        accueilForm.addCommand(cmdCovoiturages);
        accueilForm.setCommandListener(this);
        list.addCommand(cmdBack);
        list.setCommandListener(this);
        infoCovoiturageForm.addCommand(cmdBack);
        infoCovoiturageForm.addCommand(cmdReserver);
        infoCovoiturageForm.setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdCovoiturages) {
            choix = 0;
            Thread th = new Thread(this);
            th.start();
            Midlet.getDisplay().setCurrent(loadingDialog);
        }
        if (c == List.SELECT_COMMAND) {
            infoCovoiturageForm.append("Détailles du covoiturage: \n");
            infoCovoiturageForm.append(showDetails(list.getSelectedIndex()));
            infoCovoiturageForm.addCommand(cmdReserver);
            Midlet.getDisplay().setCurrent(infoCovoiturageForm);
        }
        if (d == infoCovoiturageForm && c == cmdReserver) {
            choix = 1;
            showConfirmation("Confirmation", "Voulez vous vraiment réserver une place ?");

        }
        if (c == cmdBack) {
            infoCovoiturageForm.deleteAll();
            Midlet.getDisplay().setCurrent(list);
        }
        if (d == list & c == cmdBack) {
            Midlet.getDisplay().setCurrent(new Accueil("Accueil", List.IMPLICIT));
        }
    }

    public void run() {
        switch (choix) {
            case 0:
                try {
                    Image image = Image.createImage("/redcar.png");
                    // this will handle our XML
                    CovoiturageHandler covoituragesHandler = new CovoiturageHandler();
                    // get a parser object
                    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
                    // get an InputStream from somewhere (could be HttpConnection, for example)
                    HttpConnection hc = (HttpConnection) Connector.open("http://localhost/covoituragej2me/detailsCovoiturage.php");
                    DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                    parser.parse(dis, covoituragesHandler);
                    // display the result
                    covoiturages = covoituragesHandler.getCovoiturage();
                    if (covoiturages.length > 0) {
                        for (int i = 0; i < covoiturages.length; i++) {
                            list.append("Le " + String.valueOf(covoiturages[i].getDateDepart()) + " de " + covoiturages[i].getGouvernoratDepart() + "," + covoiturages[i].getDelegationDepart() + "," + covoiturages[i].getLocaliteDepart() + " à " + covoiturages[i].getGouvernoratArrivee() + "," + covoiturages[i].getDelegationArrivee() + "," + covoiturages[i].getLocaliteArrivee() + ".", image);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Exception: " + e.toString());
                }
                Midlet.getDisplay().setCurrent(list);
                break;
            case 1:
                Alert alerta = new Alert("Error", "Sorry", null, AlertType.ERROR);
                int idCovoiturage = showCovoiturageId(list.getSelectedIndex());
                int idCreateurCovoiturage = showCreateurCovoiturageId(list.getSelectedIndex());
                String contenu = "Vous%20avez%20une%20nouvelle%20demande%20de%20réservation%20de%20la%part%20%de%20Nizar%Boussarsar.";
                Reserver reserver = new Reserver(Midlet.covoitureurConnecte.getId(), idCovoiturage);
                Notifier notifier = new Notifier(Midlet.covoitureurConnecte.getId(), idCreateurCovoiturage, contenu);
                reserver.run();
                if (reserver.test = true) {
                    notifier.run();
                    if (notifier.test = true) {
                        Midlet.getDisplay().setCurrent(infoCovoiturageForm);
                    }
                } else {
                    Midlet.getDisplay().setCurrent(alerta);
                }
                break;
        }
    }

    public int showCreateurCovoiturageId(int i) {
        return covoiturages[i].getIdCreateur();
    }

    public int showCovoiturageId(int i) {
        return covoiturages[i].getId();
    }

    private String showDetails(int i) {
        String res = "";
        if (covoiturages.length > 0) {
            stringBuffer.append("Titre: ").append(covoiturages[i].getTitre());
            stringBuffer.append("\n");
            stringBuffer.append("Description: ").append(covoiturages[i].getDescription());
            stringBuffer.append("\n");
            stringBuffer.append("Conducteur: ").append(covoiturages[i].getNomUtilisateurCreateur());
            stringBuffer.append("\n");
            stringBuffer.append("Ville de départ: ").append(covoiturages[i].getGouvernoratDepart()).append(",").append(covoiturages[i].getDelegationDepart()).append(",").append(covoiturages[i].getLocaliteDepart());
            stringBuffer.append("\n");
            stringBuffer.append("Ville d'arrivée: ").append(covoiturages[i].getGouvernoratArrivee()).append(",").append(covoiturages[i].getDelegationArrivee()).append(",").append(covoiturages[i].getLocaliteArrivee());
            stringBuffer.append("\n");
            stringBuffer.append("Date de départ: ").append(covoiturages[i].getDateDepart());
            stringBuffer.append("\n");
            stringBuffer.append("Heure de départ: ").append(covoiturages[i].getHeureDepart());
            stringBuffer.append("\n");
            stringBuffer.append("Nombre de places restantes: ").append(covoiturages[i].getNombrePlaces());
            stringBuffer.append("\n");
            stringBuffer.append("Fumeur: ").append(covoiturages[i].isFumeur());
            stringBuffer.append("\n");
            stringBuffer.append("Réservé aux femmes: ").append(covoiturages[i].isReserveeFemmes());
            stringBuffer.append("\n");
        }
        res = stringBuffer.toString();
        stringBuffer = new StringBuffer("");
        return res;
    }

    private void closeAlert() {
        Midlet.getDisplay().setCurrent(infoCovoiturageForm);
        alert = null;
    }

    public void showConfirmation(String title, String text) {
        alert = new Alert(title, text, null, AlertType.CONFIRMATION);
        alert.addCommand(new Command("Yes", Command.OK, 1));
        alert.addCommand(new Command("No", Command.CANCEL, 1));
        final Thread th = new Thread(this);
        alert.setCommandListener(new CommandListener() {
            public void commandAction(Command c, Displayable d) {
                if (c.getLabel().equals("Yes")) {
                    th.start();
                    try {
                        th.join();
                        infoCovoiturageForm.deleteAll();
                        infoCovoiturageForm.removeCommand(cmdReserver);
                        infoCovoiturageForm.append("Votre demande de réservation a été ajoutée avec succés !");
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    closeAlert();
                } else {
                    closeAlert();
                }
            }
        });
        Midlet.getDisplay().setCurrent(alert, infoCovoiturageForm);
    }

    public class Reserver {

        int idCovoitureur, idCovoiturage;
        public boolean test = false;

        public Reserver(int idCovoitureur, int idCovoiturage) {
            this.idCovoitureur = idCovoitureur;
            this.idCovoiturage = idCovoiturage;
            Thread th = new Thread();
            th.start();
        }

        public void run() {
            HttpConnection hc;
            DataInputStream dis;
            String url = "http://localhost/covoituragej2me/ajouterReservation.php";
            StringBuffer sb = new StringBuffer();
            int ch;
            try {
                hc = (HttpConnection) Connector.open(url + "?idCovoitureur=" + idCovoitureur + "&idCovoiturage=" + idCovoiturage);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                    System.out.println("nizar : " + sb);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if ("successfully added".equalsIgnoreCase(sb.toString().trim())) {
                test = true;
            } else {
                test = false;
            }
        }
    }

    public class Notifier {

        int idExpediteur, idDestinataire;
        String contenu;
        public boolean test = false;

        public Notifier(int idExpediteur, int idDestinataire, String contenu) {
            this.idExpediteur = idExpediteur;
            this.idDestinataire = idDestinataire;
            this.contenu = contenu;
            Thread th = new Thread();
            th.start();
        }

        public void run() {
            HttpConnection hc;
            DataInputStream dis;
            String url = "http://localhost/covoituragej2me/envoyerNotificationReservation.php";
            StringBuffer sb = new StringBuffer();
            int ch;
            try {
                hc = (HttpConnection) Connector.open(url + "?idExpediteur=" + idExpediteur + "&idDestinataire=" + idDestinataire + "&contenu=" + contenu);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb.append((char) ch);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if ("successfully added".equalsIgnoreCase(sb.toString().trim())) {
                test = true;
            } else {
                test = false;
            }
        }
    }
}
