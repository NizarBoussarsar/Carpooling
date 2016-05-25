package team.esprit.util;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import java.sql.SQLException;
import team.esprit.dao.CovoitureurDAO;
import team.esprit.entities.Covoitureur;

@SuppressWarnings("deprecation")
public class FacebookGraph {

    private final FacebookClient facebookClient;
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    Covoitureur covoitureur = new Covoitureur();
    User user;

    public static void main(String[] args) throws SQLException {
        new FacebookGraph("").fetchObject();
    }

    public FacebookGraph(String accessToken) {
        facebookClient = new DefaultFacebookClient(accessToken);
    }

    public Covoitureur fetchObject() throws SQLException {
        user = facebookClient.fetchObject("me", User.class);
        if (covoitureurDAO.authentifierCovoitureurFacebook(user.getId()) == true) {
            covoitureurDAO.afficherCovoitureur_IdFacebook(user.getId());
            Covoitureur covoitureurConnecte = covoitureurDAO.afficherCovoitureur_IdFacebook(user.getId());
            return covoitureurConnecte;
        } else {
            covoitureur.setNom(user.getLastName());
            covoitureur.setPrenom(user.getFirstName());
            covoitureur.setEmail(user.getEmail());
            covoitureur.setFacebook(user.getLink());
            covoitureur.setNomUtilisateur(user.getUsername());
            covoitureur.setIdFacebook(user.getId());
            try {
                java.util.Date dateUTIL = user.getBirthdayAsDate();
                java.sql.Date dateSQL = new java.sql.Date(dateUTIL.getTime());
                covoitureur.setDateNaissance(dateSQL);
            } catch (NullPointerException e) {
                e.getMessage();
            }
            if (user.getGender().equals("male")) {
                covoitureur.setSexe('H');
            } else {
                covoitureur.setSexe('F');
            }
            covoitureur.setEtat(2);
            covoitureur.setCleActivation("activé");
            covoitureurDAO.ajouterCovoitureur(covoitureur);
            return covoitureur;
        }
    }
}