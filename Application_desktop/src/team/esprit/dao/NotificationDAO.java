package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import team.esprit.Idao.INotificationDAO;
import team.esprit.entities.Covoitureur;
import team.esprit.entities.Notification;
import team.esprit.presentation.Authentification;
import team.esprit.util.MyConnection;

public class NotificationDAO implements INotificationDAO {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;

    public Notification afficherUneNotification(int id) {
        String requete = "SELECT * FROM notifications WHERE id = " + id;
        Notification notification = new Notification();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                notification.setId(resultat.getInt(1));
                notification.setExpediteur(new CovoitureurDAO().afficherCovoitureur_ID(resultat.getInt(2)));
                notification.setContenu(resultat.getString(5));
            }
            return notification;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de Messages " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Notification> afficherNotificationsNonLus() {
        List<Notification> listNotifications = new ArrayList<>();
        String requete = "SELECT id, contenu FROM notifications WHERE lu = 0 AND id_destinataire = " + covoitureurConnecte.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Notification notification = new Notification();
                notification.setId(resultat.getInt(1));
                notification.setContenu(resultat.getString(2));
                listNotifications.add(notification);
            }
            return listNotifications;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean envoyerNotification(Covoitureur covoitureur1, Covoitureur covoitureur2, String contenu, int type) {
        String requete = "INSERT INTO notifications(id_expediteur, id_destinataire, contenu, type) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, covoitureur1.getId());
            preparedStatement.setInt(2, covoitureur2.getId());
            preparedStatement.setString(3, contenu);
            preparedStatement.setInt(4, type);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    @Override
    public List<Notification> recupererNotification(int Id) {
        List<Notification> listNotification = new ArrayList<Notification>();
        String requete = "SELECT * FROM notifications WHERE id_destinataire = " + Id;
        CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Notification notification = new Notification();
                Covoitureur covoitureur = new Covoitureur();
                covoitureur = covoitureurDAO.afficherCovoitureur_ID(resultat.getInt(2));
                notification.setExpediteur(covoitureur);
                notification.setDateCreation(resultat.getTime(4));
                notification.setContenu(resultat.getString(5));
                notification.setType(resultat.getInt(6));
                listNotification.add(notification);
            }
            return listNotification;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Boolean notificationReservation(Covoitureur covoitureur1, Covoitureur covoitureur2) {
        String requete = "INSERT INTO  `covoiturage`.`notifications` ( "
                + "`id` , "
                + "`id_expediteur` , "
                + "`id_destinataire` , "
                + "`date_creation` , "
                + "`contenu` , "
                + "`type` "
                + ") "
                + "VALUES ( "
                + "NULL ,  '" + covoitureur1.getId() + "',  '" + covoitureur2.getId() + "', "
                + "CURRENT_TIMESTAMP ,  '" + covoitureur1.getNom() + " " + covoitureur1.getPrenom() + " demande de reserver une place dans votre covoiturage ',  '4' "
                + ");";

        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.executeUpdate();
            System.out.println("Notification ENVOYEE");
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'envoie de la notification " + ex.getMessage());
            return false;
        }
    }

    @Override
    public int afficherNombreNotificationsNonLus(Covoitureur covoitureurConnecte) {
        int nombreNotifications = 0;
        String requete = "SELECT COUNT(*) FROM notifications WHERE lu = 0 AND id_destinataire = " + covoitureurConnecte.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                nombreNotifications = resultat.getInt(1);
            }
            return nombreNotifications;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
            return nombreNotifications;
        }
    }

    @Override
    public void rendreLu(Notification notification) {
        String requete = "UPDATE notifications SET lu = 1 WHERE id = " + notification.getId();
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}