package team.esprit.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import team.esprit.Idao.IDetourDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Ville;
import team.esprit.util.MyConnection;

public class DetourDAO implements IDetourDAO {

    @Override
    public List<Ville> afficherDetours(Covoiturage covoiturage) {
        List<Ville> listVilles = new ArrayList<Ville>();
        String requete = "SELECT v.* FROM Detours d, Villes v WHERE id_covoiturage = "
                + covoiturage.getId() + " AND d.id_ville = v.id";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Ville ville = new Ville();
                ville.setId(resultat.getInt(1));
                ville.setCodePostal(resultat.getInt(2));
                ville.setLocalite(resultat.getString(3));
                ville.setDelegation(resultat.getString(4));
                ville.setGouvernorat(resultat.getString(5));
                ville.setLatitude(resultat.getFloat(6));
                ville.setLongitude(resultat.getFloat(7));
                listVilles.add(ville);
            }
            return listVilles;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }
}