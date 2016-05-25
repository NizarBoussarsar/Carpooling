package team.esprit.entities;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;

public class Covoitureur implements Comparator<Covoitureur> {

    private int _id;
    private String _email;
    private String _mdp;
    private String _nomUtilisateur;
    private String _nom;
    private String _prenom;
    private char _sexe; // ou bien Type enumération
    private boolean _fumeur;
    private Date _dateNaissance;
    private Date _dateEnregistrement;
    private int _note; // Somme des champs de la table évaluation
    private int _etat; // 0: Est bloqué , 1: Attente d'activation du mail  2: Mail Vérifié et Pas bloqué,
    private String _avatar; // Un lien vers la photo de profil du Covoitureur
    private String _skype; // Nom d'utilisateur de son compte skype
    private String _facebook; // Nom d'utilisateur de son Facebook ou bien son Lien Facebook
    private Date _dateDerniereVisite;
    private String _cleActivation; // Un cle pour vérifier son mail
    private String _idFacebook;
    private List<Reservation> _reservations;
    private List<Notification> _notifications;

    public List<Reservation> getReservations() {
        return _reservations;
    }

    public List<Notification> getNotifications() {
        return _notifications;
    }

    public void setReservations(List<Reservation> _reservations) {
        this._reservations = _reservations;
    }

    public String getIdFacebook() {
        return _idFacebook;
    }

    public void setIdFacebook(String _idFacebook) {
        this._idFacebook = _idFacebook;
    }

    public void setFumeur(boolean _fumeur) {
        this._fumeur = _fumeur;
    }

    public boolean isFumeur() {
        return _fumeur;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public void setMdp(String _mdp) {
        this._mdp = _mdp;
    }

    public void setNomUtilisateur(String _nomUtilisateur) {
        this._nomUtilisateur = _nomUtilisateur;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }

    public void setSexe(char _sexe) {
        this._sexe = _sexe;
    }

    public void setDateNaissance(Date _dateNaissance) {
        this._dateNaissance = _dateNaissance;
    }

    public void setDateEnregistrement(Date _dateEnregistrement) {
        this._dateEnregistrement = _dateEnregistrement;
    }

    public void setNote(int _note) {
        this._note = _note;
    }

    public void setEtat(int _etat) {
        this._etat = _etat;
    }

    public void setAvatar(String _avatar) {
        this._avatar = _avatar;
    }

    public void setSkype(String _skype) {
        this._skype = _skype;
    }

    public void setFacebook(String _facebook) {
        this._facebook = _facebook;
    }

    public void setDateDerniereVisite(Date _dateDerniereVisite) {
        this._dateDerniereVisite = _dateDerniereVisite;
    }

    public void setCleActivation(String _cleActivation) {
        this._cleActivation = _cleActivation;
    }

    public int getId() {
        return _id;
    }

    public String getEmail() {
        return _email;
    }

    public String getMdp() {
        return _mdp;
    }

    public String getNomUtilisateur() {
        return _nomUtilisateur;
    }

    public String getNom() {
        return _nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public char getSexe() {
        return _sexe;
    }

    public Date getDateNaissance() {
        return _dateNaissance;
    }

    public Date getDateEnregistrement() {
        return _dateEnregistrement;
    }

    public int getNote() {
        return _note;
    }

    public int getEtat() {
        return _etat;
    }

    public String getAvatar() {
        return _avatar;
    }

    public String getSkype() {
        return _skype;
    }

    public String getFacebook() {
        return _facebook;
    }

    public Date getDateDerniereVisite() {
        return _dateDerniereVisite;
    }

    public String getCleActivation() {
        return _cleActivation;
    }

    @Override
    public int compare(Covoitureur o1, Covoitureur o2) {
        if (o1.getNote() > o2.getNote()) {
            return -1;
        } else if (o1.getNote() < o2.getNote()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Covoitureur{" + "_id=" + _id + ", _email=" + _email + ", _mdp=" + _mdp + ", _nomUtilisateur=" + _nomUtilisateur + ", _nom=" + _nom + ", _prenom=" + _prenom + ", _sexe=" + _sexe + ", _fumeur=" + _fumeur + ", _dateNaissance=" + _dateNaissance + ", _dateEnregistrement=" + _dateEnregistrement + ", _note=" + _note + ", _etat=" + _etat + ", _avatar=" + _avatar + ", _skype=" + _skype + ", _facebook=" + _facebook + ", _dateDerniereVisite=" + _dateDerniereVisite + ", _cleActivation=" + _cleActivation + ", _idFacebook=" + _idFacebook + '}';
    }
}