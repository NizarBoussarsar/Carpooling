package team.esprit.dao;

import java.sql.PreparedStatement;
import team.esprit.entities.Reclamation;
import team.esprit.util.MyConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import team.esprit.Idao.IReclamationDAO;
import team.esprit.entities.Covoitureur;

public class ReclamationDAO implements IReclamationDAO {

    Reclamation reclamation = new Reclamation();
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    Covoitureur covoitureur = new Covoitureur();
    List<Reclamation> listReclamations = new ArrayList<Reclamation>();

    public boolean envoyerReclamation(Covoitureur c, Reclamation reclamation) {
        try {
            if (covoitureurDAO.afficherCovoitureur_EMAIL(c.getEmail())) {
                covoitureur = covoitureurDAO.afficherCovoitureurEMAIL(c.getEmail());
            } else {
                covoitureur.setEmail(c.getEmail());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String requete = "INSERT INTO reclamations (email, nom_utilisateur, type, vu, message) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setString(1, reclamation.getEmail());
            if (covoitureur.getEmail().equals(reclamation.getEmail())) {
                preparedStatement.setString(2, covoitureur.getNomUtilisateur());
            } else {
                preparedStatement.setString(2, null);
            }
            preparedStatement.setString(3, reclamation.getType());
            preparedStatement.setBoolean(4, false);
            preparedStatement.setString(5, reclamation.getMessage());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de la Reclamation " + ex.getMessage());
            return false;
        }
    }

    public void modifierReclamation(int id) {
        String requete = "UPDATE reclamations SET vu = ? WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setBoolean(1, true);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de la Reclamation " + ex.getMessage());
        }
    }

    public List<Reclamation> afficherReclamations() {
        String requete = "SELECT id, email, type, vu, message FROM reclamations ORDER BY vu";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                reclamation.setId(resultat.getInt(1));
                reclamation.setEmail(resultat.getString(2));
                reclamation.setType(resultat.getString(3));
                reclamation.setVue(resultat.getBoolean(4));
                reclamation.setMessage(resultat.getString(5));
                listReclamations.add(reclamation);
            }
            return listReclamations;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Réclamations " + ex.getMessage());
            return null;
        }
    }

    public Reclamation afficherReclamation(int idReclamation) {
        String requete = "SELECT email, type, vu, message FROM reclamations WHERE id = " + idReclamation;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                reclamation.setEmail(resultat.getString(1));
                reclamation.setType(resultat.getString(2));
                reclamation.setVue(resultat.getBoolean(3));
                reclamation.setMessage(resultat.getString(4));
            }
            return reclamation;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Réclamations " + ex.getMessage());
            return null;
        }
    }
}