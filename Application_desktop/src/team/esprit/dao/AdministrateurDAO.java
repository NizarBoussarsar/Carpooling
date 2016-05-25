package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import team.esprit.Idao.IAdministrateurDAO;
import team.esprit.entities.Administrateur;
import team.esprit.util.MyConnection;

public class AdministrateurDAO implements IAdministrateurDAO {

    @Override
    public Administrateur afficherInformations() {
        Administrateur administrateur = new Administrateur();
        String requete = "SELECT * FROM administrateurs";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                administrateur.setId(resultat.getInt(1));
                administrateur.setEmail(resultat.getString(2));
                administrateur.setMdp(resultat.getString(3));
                administrateur.setNom(resultat.getString(4));
            }
            return administrateur;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean modifierMotPasse(Administrateur administrateur, String newPass) {
        String requete = "UPDATE administrateurs SET mdp = ? WHERE email = '" + administrateur.getEmail() + "'";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setString(1, newPass);
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour " + ex.getMessage());
            return false;
        }
    }
}