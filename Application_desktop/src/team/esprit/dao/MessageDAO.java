package team.esprit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import team.esprit.Idao.IMessageDAO;
import team.esprit.entities.Message;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;
import team.esprit.util.MyConnection;

public class MessageDAO implements IMessageDAO {

    Covoitureur covoitureurConnecte = Authentification.covoitureurConnecte;
    CovoitureurDAO covoitureurDAO = new CovoitureurDAO();
    List<Message> listMessages = new ArrayList<Message>();

    public boolean envoyerMessage(Covoitureur covoitureur, Message message) {
        try {
            if (covoitureurDAO.afficherCovoitureur_EMAIL(covoitureur.getEmail())) {
                covoitureurConnecte = covoitureurDAO.afficherCovoitureurEMAIL(covoitureur.getEmail());
            } else {
                covoitureurConnecte.setEmail(covoitureur.getEmail());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        String requete = "INSERT INTO messages (id_expediteur, id_destinataire, objet, contenu) Values (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, message.getExpediteur().getId());
            preparedStatement.setInt(2, message.getDestinataire().getId());
            preparedStatement.setString(3, "Bonjour");
            preparedStatement.setString(4, message.getContenu());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de l'ajout de la message " + ex.getMessage());
            return false;
        }
    }

    public List<Message> afficherMessage() {
        String requete = "SELECT * FROM messages WHERE id_destinataire=" + covoitureurConnecte.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Message message = new Message();
                message.setId(resultat.getInt(1));
                message.setExpediteur(covoitureurDAO.afficherCovoitureur_ID(resultat.getInt(2)));
                message.setObjet(resultat.getString(4));
                message.setContenu(resultat.getString(5));
                message.setDateEnvoie(resultat.getTime(6));
                listMessages.add(message);
            }
            return listMessages;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Message> afficherMessageNonLus() {
        String requete = "SELECT * FROM messages WHERE lu = 0 AND id_destinataire = " + covoitureurConnecte.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Message message = new Message();
                message.setId(resultat.getInt(1));
                message.setExpediteur(covoitureurDAO.afficherCovoitureur_ID(resultat.getInt(2)));
                //message.setDestinataire(covoitureurConnecte);
                message.setObjet(resultat.getString(4));
                message.setContenu(resultat.getString(5));
                message.setDateEnvoie(resultat.getTime(6));
                listMessages.add(message);
            }
            return listMessages;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Messages " + ex.getMessage());
            return null;
        }
    }

    public int afficherNombreMessagesNonLus(Covoitureur covoitureurConnecte) {
        int nombreMessages = 0;
        String requete = "SELECT COUNT(*) FROM messages WHERE lu = 0 AND id_destinataire = " + covoitureurConnecte.getId();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                nombreMessages = resultat.getInt(1);
            }
            return nombreMessages;
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
            return nombreMessages;
        }
    }

    public Message afficherUnMessage(int id) {
        String requete = "SELECT m.id,m.id_expediteur,c.nom_utilisateur,m.objet,m.contenu,m.date_envoie FROM messages m inner join covoitureurs c on m.id_expediteur=c.id where m.id=" + id;
        Message message = new Message();
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {;
                message.setId(resultat.getInt(1));
                message.setExpediteur(covoitureurDAO.afficherCovoitureur_ID(resultat.getInt(2)));
                message.setObjet(resultat.getString(4));
                message.setContenu(resultat.getString(5));
                message.setDateEnvoie(resultat.getTime(6));
            }
            return message;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de Messages " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void rendreLu(Message message) {
        String requete = "UPDATE messages SET lu = 1 WHERE id = " + message.getId();
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}