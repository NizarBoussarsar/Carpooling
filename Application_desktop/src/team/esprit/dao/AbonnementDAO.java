package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import team.esprit.Idao.IAbonnementDAO;
import team.esprit.dao.CovoiturageDAO.Resultat;
import team.esprit.entities.Abonnement;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Ville;
import team.esprit.util.MyConnection;

public class AbonnementDAO implements IAbonnementDAO {

    @Override
    public boolean ajouterAbonnement(Covoitureur covoitureur, Resultat resultat) {
        VilleDAO villeDAO = new VilleDAO();
        String requete = "INSERT INTO abonnements (id_covoitureur, id_ville_depart, id_ville_arrivee, etat) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, covoitureur.getId());
            preparedStatement.setInt(2, villeDAO.afficheVille_ID(resultat.getVilleDepart().getId()).getId());
            preparedStatement.setInt(3, villeDAO.afficheVille_ID(resultat.getVilleArrivee().getId()).getId());
            preparedStatement.setInt(4, 0);

            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public List<Abonnement> afficherAbonnement(Covoitureur covoitureur) {
        String requete = "SELECT * FROM abonnements WHERE id_covoitureur= " + covoitureur.getId();
        CovoitureurDAO covoitureurADO = new CovoitureurDAO();
        VilleDAO villeDAO = new VilleDAO();
        List<Abonnement> listAbonnement = new ArrayList<Abonnement>();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Abonnement abonnement = new Abonnement();
                abonnement.setCovoitureur(covoitureurADO.afficherCovoitureur_ID(resultat.getInt(2)));
                abonnement.setVilleDepart(villeDAO.afficheVille_ID(resultat.getInt(3)));
                abonnement.setVilleArrivee(villeDAO.afficheVille_ID(resultat.getInt(4)));
                abonnement.setEtat(resultat.getBoolean(5));
                listAbonnement.add(abonnement);
            }
            return listAbonnement;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Abonnement> afficherAbonnementByVilleDepartArrivee(Ville villeDepart, Ville villeArrivee) {
        VilleDAO villeDAO = new VilleDAO();
        Ville villeD = villeDAO.afficherVille(villeDepart.getGouvernorat());
        System.out.println(villeDepart);
        System.out.println(villeD);
        Ville villeA = villeDAO.afficherVille(villeArrivee.getGouvernorat());
        String requete = "SELECT * FROM abonnements WHERE id_ville_depart= " + villeD.getId() + " And id_ville_arrivee=" + villeA.getId();
        CovoitureurDAO covoitureurADO = new CovoitureurDAO();

        List<Abonnement> listAbonnement = new ArrayList<Abonnement>();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Abonnement abonnement = new Abonnement();
                abonnement.setCovoitureur(covoitureurADO.afficherCovoitureur_ID(resultat.getInt(2)));
                abonnement.setVilleDepart(villeDAO.afficheVille_ID(resultat.getInt(3)));
                abonnement.setVilleArrivee(villeDAO.afficheVille_ID(resultat.getInt(4)));
                abonnement.setEtat(resultat.getBoolean(5));
                listAbonnement.add(abonnement);
            }
            return listAbonnement;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }
}