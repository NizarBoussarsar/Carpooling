package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import team.esprit.Idao.IParticipantDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.util.MyConnection;

public class ParticipantDAO implements IParticipantDAO {

    public List<Covoitureur> afficherParticipants(Covoiturage covoiturage) {
        List<Covoitureur> listParticipants = new ArrayList<Covoitureur>();
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        String requete = "SELECT id_participant FROM participants WHERE participants.id_covoiturage = " + covoiturage.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur;
                covoitureur = covoitureurDAO.afficherCovoitureur_ID(resultat.getInt(1));
                listParticipants.add(covoitureur);
            }
            return listParticipants;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean ajouterParticipant(Covoitureur covoitureur, Covoiturage covoiturage) {
        String requete = "INSERT INTO participants (id_covoiturage, id_participant) VALUES (" + covoiturage.getId() + " ," + covoitureur.getId() + ") ";
        System.out.println(covoitureur.getNom());
        System.out.println(covoiturage);
        try {
            Statement statement = MyConnection.getInstance().createStatement();
//            preparedStatement.setInt(1, covoiturage.getId());
//            preparedStatement.setInt(2, covoitureur.getId());
            statement.executeUpdate(requete);
            System.out.println("participe");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout du Covoitureur " + ex.getMessage());
            return false;
        }
    }

    public boolean supprimerParticipant(Covoitureur covoitureur, Covoiturage covoiturage) {
        String requete = "DELETE FROM participants WHERE id_covoiturage = ? AND id_participant = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, covoiturage.getId());
            preparedStatement.setInt(2, covoitureur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la suppression du Covoitureur " + ex.getMessage());
            return false;
        }
    }
}