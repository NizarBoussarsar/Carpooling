package team.esprit.entities;

import java.sql.Date;
import java.util.List;

public class Covoiturage {

    private int _id;
    private String _titre;
    private String _description;
    private Ville _villeDepart; //id_ville_depart
    private Ville _villeArrivee; //id_ville_arrivee
    private Covoitureur _createur; //id_createur
    private Date _dateCreation; //Current_TimeStamp
    private Date _dateMiseAJour;
    private Date _dateDepart;
    private String _HeureDepart;
    private int _nombrePlaces;
    private float _prix;
    private boolean _fumeur;
    private boolean _reserveeFemmes;
    private List<Ville> _detours; //Table détours
    private List<Covoitureur> _participants; //Table participants
    private List<Covoitureur> _reservateurs; //Table réservations

    public void setReservateurs(List<Covoitureur> _reservateurs) {
        this._reservateurs = _reservateurs;
    }

    public List<Covoitureur> getReservateurs() {
        return _reservateurs;
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

    public Ville getVilleDepart() {
        return _villeDepart;
    }

    public Ville getVilleArrivee() {
        return _villeArrivee;
    }

    public Covoitureur getCreateur() {
        return _createur;
    }

    public Date getDateCreation() {
        return _dateCreation;
    }

    public Date getDateMiseAJour() {
        return _dateMiseAJour;
    }

    public Date getDateDepart() {
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

    public List<Ville> getDetours() {
        return _detours;
    }

    public List<Covoitureur> getParticipants() {
        return _participants;
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

    public void setVilleDepart(Ville _villeDepart) {
        this._villeDepart = _villeDepart;
    }

    public void setVilleArrivee(Ville _villeArrivee) {
        this._villeArrivee = _villeArrivee;
    }

    public void setCreateur(Covoitureur _createur) {
        this._createur = _createur;
    }

    public void setDateCreation(Date _dateCreation) {
        this._dateCreation = _dateCreation;
    }

    public void setDateMiseAJour(Date _dateMiseAJour) {
        this._dateMiseAJour = _dateMiseAJour;
    }

    public void setDateDepart(Date _dateDepart) {
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

    public void setReserveeFemmes(boolean _reserveFemmes) {
        this._reserveeFemmes = _reserveFemmes;
    }

    public void setDetours(List<Ville> _detours) {
        this._detours = _detours;
    }

    public void setParticipants(List<Covoitureur> _participants) {
        this._participants = _participants;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "_id=" + _id + ", _titre=" + _titre + ", _description=" + _description + ", _villeDepart=" + _villeDepart + ", _villeArrivee=" + _villeArrivee + ", _createur=" + _createur + ", _dateCreation=" + _dateCreation + ", _dateMiseAJour=" + _dateMiseAJour + ", _dateDepart=" + _dateDepart + ", _HeureDepart=" + _HeureDepart + ", _nombrePlaces=" + _nombrePlaces + ", _prix=" + _prix + ", _fumeur=" + _fumeur + ", _reserveeFemmes=" + _reserveeFemmes + ", _detours=" + _detours + ", _participants=" + _participants + ", _reservateurs=" + _reservateurs + '}';
    }
}