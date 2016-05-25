package team.esprit.dao;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import team.esprit.Idao.ICovoitureurDAO;
import team.esprit.entities.Covoiturage;
import team.esprit.entities.Covoitureur;
import team.esprit.presentation.Authentification;
import team.esprit.util.MyConnection;

public class CovoitureurDAO implements ICovoitureurDAO {

    @Override
    public Covoitureur afficherCovoitureur_IdFacebook(String IdFacebook) {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE id_facebook = '" + IdFacebook + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
             covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            return covoitureur;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String getAvatar(int id) {
        String requete = "SELECT avatar FROM covoitureurs WHERE id = ?";
        try {
            String res = null;
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, id);
            ResultSet resultat = preparedStatement.executeQuery();
            while (resultat.next()) {
                res = resultat.getString(1);
            }
            return res;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification de l'avatar : " + ex.getMessage());
            return null;
        }

    }

    @Override
    public void modifierAvatar(int id, FileInputStream fis, int len) {
        String requete = "UPDATE covoitureurs SET avatar = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setBinaryStream(1, fis, len);
            preparedStatement.setInt(2, id);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                System.out.println("Modification effectué avec succés !");
            } else {
                System.out.println("Pas de mise à jour");
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la modification de l'avatar : " + ex.getMessage());
        }
    }

    @Override
    public int IDCovoitureur_IDCovoiturage(int id) {
        String requete = "SELECT id FROM covoitureurs WHERE id IN (SELECT DISTINCT id_createur FROM covoiturages WHERE id =" + id + ")";
        try {
            int res = 0;
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                res = resultat.getInt(1);
            }
            return res;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement de l'id covoitureur from covoiturage " + ex.getMessage());
            return 0;
        }
    }

    @Override
    public Covoitureur afficherCovoitureur_ID(int id) {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT  id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE id = " + id;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            return covoitureur;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean afficherCovoitureur_EMAIL(String email) throws SQLException {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT  id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE email = '" + email + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            if (covoitureur.getId() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            throw new SQLException(ex);
        }
    }

    @Override
    public Covoitureur afficherCovoitureurEMAIL(String email) {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE email = '" + email + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            return covoitureur;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Covoitureur> afficherCovoitureurs() {
        List<Covoitureur> listCovoitureurs = new ArrayList<Covoitureur>();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur = new Covoitureur();
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
                listCovoitureurs.add(covoitureur);
            }
            return listCovoitureurs;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement des Covoitureurs " + ex.getMessage());
            return null;
        }
    }

    @Override
    public void ajouterCovoitureur(Covoitureur covoitureur) {
        String requete = "INSERT INTO covoitureurs (email, mdp, nom_utilisateur, nom, prenom, sexe, fumeur, date_naissance, note, etat, avatar, skype, facebook, date_derniere_visite, cle_activation, id_facebook) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            if (afficherCovoitureur_EMAIL(covoitureur.getEmail()) == false) {
                try {
                    PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
                    preparedStatement.setString(1, covoitureur.getEmail());
                    preparedStatement.setString(2, covoitureur.getMdp());
                    preparedStatement.setString(3, covoitureur.getNomUtilisateur());
                    preparedStatement.setString(4, covoitureur.getNom());
                    preparedStatement.setString(5, covoitureur.getPrenom());
                    preparedStatement.setString(6, "" + covoitureur.getSexe());
                    preparedStatement.setBoolean(7, covoitureur.isFumeur());
                    preparedStatement.setDate(8, covoitureur.getDateNaissance());
                    preparedStatement.setInt(9, covoitureur.getNote());
                    preparedStatement.setInt(10, covoitureur.getEtat());
                    preparedStatement.setString(11, covoitureur.getAvatar());
                    preparedStatement.setString(12, covoitureur.getSkype());
                    preparedStatement.setString(13, covoitureur.getFacebook());
                    preparedStatement.setDate(14, covoitureur.getDateDerniereVisite());
                    preparedStatement.setString(15, covoitureur.getCleActivation());
                    preparedStatement.setString(16, covoitureur.getIdFacebook());
                    preparedStatement.executeUpdate();
                    System.out.println("Ajout effectuée avec succès.");
                } catch (SQLException ex) {
                    System.out.println("Erreur lors de l'ajout du Covoitureur " + ex.getMessage());
                }
            } else {
                System.out.println("L'email existe déjà !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CovoitureurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouterCovoitureur1(Covoitureur covoitureur) {
        String requete = "INSERT INTO covoitureurs (email, mdp, nom_utilisateur, nom, prenom, sexe, fumeur, date_naissance, note, etat, avatar, skype, facebook, date_derniere_visite, cle_activation, id_facebook) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            if (afficherCovoitureur_EMAIL(covoitureur.getEmail()) == false) {
                try {
                    PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
                    preparedStatement.setString(1, covoitureur.getEmail());
                    preparedStatement.setString(2, covoitureur.getMdp());
                    preparedStatement.setString(3, covoitureur.getNomUtilisateur());
                    preparedStatement.setString(4, covoitureur.getNom());
                    preparedStatement.setString(5, covoitureur.getPrenom());
                    preparedStatement.setString(6, "" + covoitureur.getSexe());
                    preparedStatement.setBoolean(7, covoitureur.isFumeur());
                    preparedStatement.setDate(8, covoitureur.getDateNaissance());
                    preparedStatement.setInt(9, covoitureur.getNote());
                    preparedStatement.setInt(10, covoitureur.getEtat());
                    preparedStatement.setString(11, covoitureur.getAvatar());
                    preparedStatement.setString(12, covoitureur.getSkype());
                    preparedStatement.setString(13, covoitureur.getFacebook());
                    preparedStatement.setDate(14, covoitureur.getDateDerniereVisite());
                    preparedStatement.setString(15, covoitureur.getCleActivation());
                    preparedStatement.setString(16, covoitureur.getIdFacebook());
                    preparedStatement.executeUpdate();
                    System.out.println("Ajout effectuée avec succès.");
                    return true;
                } catch (SQLException ex) {
                    System.out.println("Erreur lors de l'ajout du Covoitureur " + ex.getMessage());
                }
            } else {
                System.out.println("L'email existe déjà !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CovoitureurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Covoitureur> afficherCovoitureurSexe(char sexe) {
        List<Covoitureur> listCovoitureurs = new ArrayList<Covoitureur>();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE sexe = '" + sexe + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur = new Covoitureur();
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
                listCovoitureurs.add(covoitureur);
            }
            return listCovoitureurs;
        } catch (SQLException ex) {
            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Covoitureur> afficherCovoitureurEtat(int etat) {
        List<Covoitureur> listCovoitureurs = new ArrayList<Covoitureur>();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE etat = " + etat;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur = new Covoitureur();
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
                listCovoitureurs.add(covoitureur);
            }
            return listCovoitureurs;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Covoitureur> afficherCovoitureurFumeur(boolean fumeur) {
        List<Covoitureur> listCovoitureurs = new ArrayList<Covoitureur>();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE fumeur = " + fumeur;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur = new Covoitureur();
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
                listCovoitureurs.add(covoitureur);
            }
            return listCovoitureurs;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean authentifierCovoitureur(String email, String mdp) throws SQLException {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE email = '" + email + "' AND mdp = '" + mdp + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            if (covoitureur.getId() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            throw new SQLException(ex);
        }
    }

    @Override
    public boolean authentifierCovoitureurFacebook(String id_facebook) throws SQLException {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE id_facebook = '" + id_facebook + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            if (covoitureur.getId() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            throw new SQLException(ex);
        }
    }

    @Override
    public boolean afficherCovoitureur_IDFACEBOOK(String id_facebook) throws SQLException {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE id_facebook = '" + id_facebook + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            if (covoitureur.getId() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors du chargement du Covoitureur " + ex.getMessage());
            throw new SQLException(ex);
        }
    }

    @Override
    public void ajouterCovoitureurFacebook(Covoitureur covoitureur) {
        String requete = "INSERT INTO covoitureurs (id_facebook, email, mdp) VALUES (?, ?, ?)";
        try {
            if (afficherCovoitureur_IDFACEBOOK(covoitureur.getIdFacebook()) == false) {
                try {
                    PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
                    preparedStatement.setString(1, covoitureur.getIdFacebook());
                    preparedStatement.setString(2, covoitureur.getEmail());
                    preparedStatement.setString(3, covoitureur.getMdp());
                    preparedStatement.executeUpdate();
                    System.out.println("Ajout effectuée avec succès.");
                } catch (SQLException ex) {
                    System.out.println("Erreur lors de l'ajout du Covoitureur " + ex.getMessage());
                }
            } else {
                System.out.println("L'email existe déjà !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CovoitureurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Map<Integer, Integer> afficherCovoitureurMois() {
        Map<Integer, Integer> mapCovoitureurParMois = new HashMap<Integer, Integer>();
        String requete = "SELECT COUNT( * ) , EXTRACT( YEAR_MONTH  FROM date_enregistrement ) AS enregistrer FROM covoitureurs GROUP BY EXTRACT( YEAR_MONTH  FROM date_enregistrement )";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                mapCovoitureurParMois.put(resultat.getInt(2), resultat.getInt(1));
            }
            return mapCovoitureurParMois;
        } catch (SQLException ex) {
            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Map<Integer, Integer> afficherCovoitureurAnnee() {
        Map<Integer, Integer> mapCovoitureurParAnnee = new HashMap<Integer, Integer>();
        String requete = "SELECT COUNT( * ) , EXTRACT( YEAR FROM date_enregistrement ) AS enregistrer FROM Covoitureurs GROUP BY EXTRACT( YEAR FROM date_enregistrement )";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                mapCovoitureurParAnnee.put(resultat.getInt(2), resultat.getInt(1));
            }
            return mapCovoitureurParAnnee;
        } catch (SQLException ex) {
            System.out.println("erreur  " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Covoitureur> rechercherCovoitureurs(String critere) {
        List<Covoitureur> listCovoitureurs = new ArrayList<Covoitureur>();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE nom LIKE '%" + critere + "%' or prenom LIKE '%" + critere + "%' or email LIKE '%" + critere + "%' or nom_utilisateur LIKE '%" + critere + "%'";
        try {
            Statement preparedStatement = MyConnection.getInstance().createStatement();
            ResultSet resultat = preparedStatement.executeQuery(requete);
            while (resultat.next()) {
                Covoitureur covoitureur = new Covoitureur();
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
                listCovoitureurs.add(covoitureur);
            }
            return listCovoitureurs;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean bloquerCovoitureur(int id) {
        String requete = "UPDATE covoitureurs SET etat = 0 WHERE id = " + id;
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean modifierCovoitureur(Covoitureur covoitureur) {
        String requete = "UPDATE covoitureurs SET email = ?, nom_utilisateur = ?, nom = ?, prenom = ?, sexe = ?, fumeur = ?, date_naissance = ?, note = ?, etat = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setString(1, covoitureur.getEmail());
            preparedStatement.setString(2, covoitureur.getNomUtilisateur());
            preparedStatement.setString(3, covoitureur.getNom());
            preparedStatement.setString(4, covoitureur.getPrenom());
            preparedStatement.setString(5, "" + covoitureur.getSexe());
            preparedStatement.setBoolean(6, covoitureur.isFumeur());
            preparedStatement.setDate(7, covoitureur.getDateNaissance());
            preparedStatement.setInt(8, covoitureur.getNote());
            preparedStatement.setInt(9, covoitureur.getEtat());
            preparedStatement.setInt(10, covoitureur.getId());
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Covoitureur afficherCovoitureur_NomUtilisateur(String nomUtilisateur) {
        Covoitureur covoitureur = new Covoitureur();
        String requete = "SELECT id,email,mdp,nom_utilisateur,nom,prenom,sexe,fumeur,date_naissance,date_enregistrement,note,etat,avatar,skype,facebook,date_derniere_visite,cle_activation,id_facebook FROM covoitureurs WHERE nom_utilisateur = '" + nomUtilisateur + "'";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                covoitureur.setId(resultat.getInt(1));
                covoitureur.setEmail(resultat.getString(2));
                covoitureur.setMdp(resultat.getString(3));
                covoitureur.setNomUtilisateur(resultat.getString(4));
                covoitureur.setNom(resultat.getString(5));
                covoitureur.setPrenom(resultat.getString(6));
                covoitureur.setSexe(resultat.getString(7).charAt(0));
                covoitureur.setFumeur(resultat.getBoolean(8));
                covoitureur.setDateNaissance(resultat.getDate(9));
                covoitureur.setDateEnregistrement(resultat.getDate(10));
                covoitureur.setNote(resultat.getInt(11));
                covoitureur.setEtat(resultat.getInt(12));
                covoitureur.setAvatar(resultat.getString(13));
                covoitureur.setSkype(resultat.getString(14));
                covoitureur.setFacebook(resultat.getString(15));
                covoitureur.setDateDerniereVisite(resultat.getDate(16));
                covoitureur.setCleActivation(resultat.getString(17));
                covoitureur.setIdFacebook(resultat.getString(18));
            }
            return covoitureur;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public void modifierEtat(Covoitureur covoitureur) {
        String requete = "UPDATE covoitureurs SET etat = ?, cle_activation = ? WHERE email = '" + covoitureur.getEmail() + "'";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "activé");
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour " + ex.getMessage());
        }
    }
        public void modifierConnecte(Covoitureur covoitureur) {
        String requete = "UPDATE covoitureurs SET connecte = ? WHERE id = " + Authentification.covoitureurConnecte.getId() + "";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, 1);
            
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour " + ex.getMessage());
        }
    }
        public void modifierConnecte1(Covoitureur covoitureur) {
        String requete = "UPDATE covoitureurs SET connecte = ? WHERE id = " + Authentification.covoitureurConnecte.getId() + "";
        try {
            PreparedStatement preparedStatement = MyConnection.getInstance().prepareStatement(requete);
            preparedStatement.setInt(1, 0);
            
            preparedStatement.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    @Override
    public boolean modifierMotPasse(Covoitureur covoitureur, String newPass) {
        String requete = "UPDATE covoitureurs SET mdp = ? WHERE email = '" + covoitureur.getEmail() + "'";
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

    @Override
    public boolean EvaluerCovoitureur(int note, int id) {
        String requete = "UPDATE covoitureurs SET note =note+? WHERE id = ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, Integer.toString(note));
            ps.setString(2, Integer.toString(id));

            ps.executeUpdate();
            System.out.println("Covoitureur Noté");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la notation " + ex.getMessage());
        }
        return true;
    }

    @Override
    public int participerEnsemble(Covoitureur covoitureur1, Covoitureur covoitureur2, Covoiturage covoiturage) {
        String requete = "select Count( DISTINCT id_participant) from participants where id_covoiturage="
                + covoiturage.getId()
                + " and (id_participant="
                + covoitureur1.getId()
                + " or id_participant="
                + covoitureur2.getId() + " )";
        int res = 0;
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);
            while (resultat.next()) {
                res = res + (resultat.getInt(1));
            }
            return res;
        } catch (SQLException ex) {
            System.out.println("Erreur lors du la verification de participation " + ex.getMessage());
            return res;
        }
    }
}