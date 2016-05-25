package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import team.esprit.Idao.IStatistiqueDAO;
import team.esprit.entities.Statistique;
import team.esprit.util.MyConnection;

public class StatistiqueDAO implements IStatistiqueDAO {

    public void ajouterStatistique(Statistique statistique) {
        String requete = "INSERT INTO statistiques (nom, type, chemin) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setString(1, statistique.getNom());
            preparedStatement.setString(2, statistique.getType());
            preparedStatement.setString(3, statistique.getChemin());
            preparedStatement.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }
}