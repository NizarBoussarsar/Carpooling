package Entites;

/**
 *
 * @author Nizar
 */
import java.util.Vector;

public class Covoiturage {

    private int _id;
    private String _titre;
    private String _description;
    
    private String _gouvernoratDepart;
    private String _delegationDepart;
    private String _localiteDepart;
    
    private String _gouvernoratArrivee;
    private String _delegationArrivee;
    private String _localiteArrivee;
    
    private int _idCreateur;
    
    private String _nomUtilisateurCreateur;
    
    private String _dateCreation; //Current_TimeStamp
    private String _dateMiseAJour;
    private String _dateDepart;
    private String _HeureDepart;
    private int _nombrePlaces;
    private float _prix;
    private boolean _fumeur;
    private boolean _reserveeFemmes;
    private Vector _detours; //Table détours
    private Vector _participants; //Table participants
    private Vector _reservateurs; //Table réservations
    
    //hussein
    private Ville _villeDepart; //id_ville_depart
    private Ville _villeArrivee; //id_ville_arrivee

    public void setVilleDepart(Ville _villeDepart) {
        this._villeDepart = _villeDepart;
    }

    public void setVilleArrivee(Ville _villeArrivee) {
        this._villeArrivee = _villeArrivee;
    }

    public Ville getVilleDepart() {
        return _villeDepart;
    }

    public Ville getVilleArrivee() {
        return _villeArrivee;
    }
    

    public int getIdCreateur() {
        return _idCreateur;
    }
    
    public int getId() {
        return _id;
    }

    public String getTitre() {
        return _titre;
    }

    public String getDescription() {
        return _description;
    }

    public String getGouvernoratDepart() {
        return _gouvernoratDepart;
    }

    public String getDelegationDepart() {
        return _delegationDepart;
    }

    public String getLocaliteDepart() {
        return _localiteDepart;
    }

    public String getGouvernoratArrivee() {
        return _gouvernoratArrivee;
    }

    public String getDelegationArrivee() {
        return _delegationArrivee;
    }

    public String getLocaliteArrivee() {
        return _localiteArrivee;
    }

    public String getNomUtilisateurCreateur() {
        return _nomUtilisateurCreateur;
    }

    public String getDateCreation() {
        return _dateCreation;
    }

    public String getDateMiseAJour() {
        return _dateMiseAJour;
    }

    public String getDateDepart() {
        return _dateDepart;
    }

    public String getHeureDepart() {
        return _HeureDepart;
    }

    public int getNombrePlaces() {
        return _nombrePlaces;
    }

    public float getPrix() {
        return _prix;
    }

    public boolean isFumeur() {
        return _fumeur;
    }

    public boolean isReserveeFemmes() {
        return _reserveeFemmes;
    }

    public Vector getDetours() {
        return _detours;
    }

    public Vector getParticipants() {
        return _participants;
    }

    public Vector getReservateurs() {
        return _reservateurs;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public void setTitre(String _titre) {
        this._titre = _titre;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public void setGouvernoratDepart(String _gouvernoratDepart) {
        this._gouvernoratDepart = _gouvernoratDepart;
    }

    public void setDelegationDepart(String _delegationDepart) {
        this._delegationDepart = _delegationDepart;
    }

    public void setLocaliteDepart(String _localiteDepart) {
        this._localiteDepart = _localiteDepart;
    }

    public void setGouvernoratArrivee(String _gouvernoratArrivee) {
        this._gouvernoratArrivee = _gouvernoratArrivee;
    }

    public void setDelegationArrivee(String _delegationArrivee) {
        this._delegationArrivee = _delegationArrivee;
    }

    public void setLocaliteArrivee(String _localiteArrivee) {
        this._localiteArrivee = _localiteArrivee;
    }

    public void setNomUtilisateurCreateur(String _nomUtilisateurCreateur) {
        this._nomUtilisateurCreateur = _nomUtilisateurCreateur;
    }

    public void setDateCreation(String _dateCreation) {
        this._dateCreation = _dateCreation;
    }

    public void setDateMiseAJour(String _dateMiseAJour) {
        this._dateMiseAJour = _dateMiseAJour;
    }

    public void setDateDepart(String _dateDepart) {
        this._dateDepart = _dateDepart;
    }

    public void setHeureDepart(String _HeureDepart) {
        this._HeureDepart = _HeureDepart;
    }

    public void setNombrePlaces(int _nombrePlaces) {
        this._nombrePlaces = _nombrePlaces;
    }

    public void setPrix(float _prix) {
        this._prix = _prix;
    }

    public void setFumeur(boolean _fumeur) {
        this._fumeur = _fumeur;
    }

    public void setReserveeFemmes(boolean _reserveeFemmes) {
        this._reserveeFemmes = _reserveeFemmes;
    }

    public void setDetours(Vector _detours) {
        this._detours = _detours;
    }

    public void setParticipants(Vector _participants) {
        this._participants = _participants;
    }

    public void setReservateurs(Vector _reservateurs) {
        this._reservateurs = _reservateurs;
    }

    public void setIdCreateur(int _idCreateur) {
        this._idCreateur = _idCreateur;
    }

    public String toString() {
        return "Covoiturage{" + "_id=" + _id + ", _titre=" + _titre + ", _description=" + _description + ", _gouvernoratDepart=" + _gouvernoratDepart + ", _delegationDepart=" + _delegationDepart + ", _localiteDepart=" + _localiteDepart + ", _gouvernoratArrivee=" + _gouvernoratArrivee + ", _delegationArrivee=" + _delegationArrivee + ", _localiteArrivee=" + _localiteArrivee + ", _idCreateur=" + _idCreateur + ", _nomUtilisateurCreateur=" + _nomUtilisateurCreateur + ", _dateCreation=" + _dateCreation + ", _dateMiseAJour=" + _dateMiseAJour + ", _dateDepart=" + _dateDepart + ", _HeureDepart=" + _HeureDepart + ", _nombrePlaces=" + _nombrePlaces + ", _prix=" + _prix + ", _fumeur=" + _fumeur + ", _reserveeFemmes=" + _reserveeFemmes + ", _detours=" + _detours + ", _participants=" + _participants + ", _reservateurs=" + _reservateurs + ", _villeDepart=" + _villeDepart + ", _villeArrivee=" + _villeArrivee + '}';
    }
    
    Covoiturage getCovoiturage() {
        return null;
    }
}