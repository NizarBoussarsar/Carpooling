package team.esprit.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import team.esprit.Idao.IVilleDAO;
import team.esprit.entities.Ville;
import team.esprit.util.MyConnection;

public class VilleDAO implements IVilleDAO {

    public Ville afficherVille(String gouvernorat) {
        String requete = "SELECT * FROM villes WHERE gouvernorat = '" + gouvernorat + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Ville ville = new Ville();
            while (resultat.next()) {
                ville.setId(resultat.getInt(1));
                ville.setCodePostal(resultat.getInt(2));
                ville.setLocalite(resultat.getString(3));
                ville.setDelegation(resultat.getString(4));
                ville.setGouvernorat(resultat.getString(5));
                ville.setLatitude(resultat.getFloat(6));
                ville.setLongitude(resultat.getFloat(7));
                return ville;
            }
            return ville;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Ville> afficherVilles() {
        List<Ville> listeVille = new ArrayList<Ville>();
        String requete = "SELECT localite, delegation, gouvernorat FROM villes";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setLocalite(resultat.getString(1));
                ville.setDelegation(resultat.getString(2));
                ville.setGouvernorat(resultat.getString(3));
                listeVille.add(ville);
            }
            return listeVille;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Ville> afficheLocalite(String gouvernorat, String delegation) {
        List<Ville> listLocalites = new ArrayList<Ville>();
        String requete = "SELECT localite FROM villes WHERE gouvernorat = '" + gouvernorat + "' AND delegation = '" + delegation + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setLocalite(resultat.getString(1));
                listLocalites.add(ville);
            }
            return listLocalites;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Ville> afficheDelegation(String gouvernorat) {
        List<Ville> listDelegations = new ArrayList<Ville>();
        String requete = "SELECT DISTINCT delegation FROM villes WHERE gouvernorat = '" + gouvernorat + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setDelegation(resultat.getString(1));
                listDelegations.add(ville);
            }
            return listDelegations;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Ville> afficheGouvernorat() {
        List<Ville> listGouvernorats = new ArrayList<Ville>();
        String requete = "SELECT DISTINCT gouvernorat FROM villes ORDER BY gouvernorat";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setGouvernorat(resultat.getString(1));
                listGouvernorats.add(ville);
            }
            return listGouvernorats;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Ville afficheVille_ID(int id) {
        String requete = "SELECT * FROM villes WHERE id = " + id;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Ville ville = new Ville();
            while (resultat.next()) {
                ville.setId(resultat.getInt(1));
                ville.setCodePostal(resultat.getInt(2));
                ville.setLocalite(resultat.getString(3));
                ville.setDelegation(resultat.getString(4));
                ville.setGouvernorat(resultat.getString(5));
                ville.setLatitude(resultat.getFloat(6));
                ville.setLongitude(resultat.getFloat(7));
                return ville;
            }
            return ville;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Ville afficherVille_Localite(String localite) {
        String requete = "SELECT * FROM villes WHERE localite = '" + localite + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            Ville ville = new Ville();
            while (resultat.next()) {
                ville.setId(resultat.getInt(1));
                ville.setCodePostal(resultat.getInt(2));
                ville.setLocalite(resultat.getString(3));
                ville.setDelegation(resultat.getString(4));
                ville.setGouvernorat(resultat.getString(5));
                ville.setLatitude(resultat.getFloat(6));
                ville.setLongitude(resultat.getFloat(7));
            }
            return ville;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de la Ville " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Ville localiserVille_nom(String nom) {
        Ville ville = new Ville();
        String requete = "SELECT longitude,latitude FROM villes WHERE gouvernorat='"
                + nom + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                ville.setLongitude(resultat.getFloat(1));
                ville.setLatitude(resultat.getFloat(2));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des coordonées " + ex.getMessage());
        }
        return ville;
    }
}